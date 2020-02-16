package aima.core.search.csp;

import aima.core.util.datastructure.Pair;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Defines variable and value selection heuristics for CSP backtracking strategies.
 * @author Ruediger Lunde
 */
public class CspHeuristics {


    public interface VariableSelectionStrategy<VAR extends Variable, VAL> {
        List<VAR> apply(CSP<VAR, List<String>> csp, List<VAR> vars);
    }

    public interface ValueOrderingStrategy<VAR extends Variable, VAL> {
        List<List<String>> apply(CSP<VAR, List<String>> csp, Assignment<VAR, List<String>> assignment, VAR var);
    }

    public static <VAR extends Variable, VAL> VariableSelectionStrategy<VAR, List<String>> mrv() { return new MrvHeuristic<>(); }
    public static <VAR extends Variable, VAL> VariableSelectionStrategy<VAR, List<String>> deg() { return new DegHeuristic<>(); }
    public static <VAR extends Variable, VAL> VariableSelectionStrategy<VAR, List<String>> mrvDeg() {
        return (csp, vars) -> new DegHeuristic<VAR, List<String>>().apply(csp, new MrvHeuristic<VAR, List<String>>().apply(csp, vars));
    }

    public static <VAR extends Variable, VAL> ValueOrderingStrategy<VAR, List<String>> lcv() { return new LcvHeuristic<>();}

    /**
     * Implements the minimum-remaining-values heuristic.
     */
    public static class MrvHeuristic<VAR extends Variable, VAL> implements VariableSelectionStrategy<VAR, List<String>> {

        /** Returns variables from <code>vars</code> which are the best with respect to MRV. */
        public List<VAR> apply(CSP<VAR, List<String>> csp, List<VAR> vars) {
            List<VAR> result = new ArrayList<>();
            int minValues = Integer.MAX_VALUE;
            for (VAR var : vars) {
                int values = csp.getDomain(var).size();
                if (values < minValues) {
                    result.clear();
                    minValues = values;
                }
                if (values == minValues)
                    result.add(var);
            }
            return result;
        }
    }

    /**
     * Implements the degree heuristic. Constraints with arbitrary scope size are supported.
     */
    public static class DegHeuristic<VAR extends Variable, VAL> implements VariableSelectionStrategy<VAR, List<String>> {

        /** Returns variables from <code>vars</code> which are the best with respect to DEG. */
        public List<VAR> apply(CSP<VAR, List<String>> csp, List<VAR> vars) {
            List<VAR> result = new ArrayList<>();
            int maxDegree = -1;
            for (VAR var : vars) {
                int degree = csp.getConstraints(var).size();
                if (degree > maxDegree) {
                    result.clear();
                    maxDegree = degree;
                }
                if (degree == maxDegree)
                    result.add(var);
            }
            return result;
        }
    }

    /**
     * Implements the least constraining value heuristic.
     */
    public static class LcvHeuristic<VAR extends Variable, VAL> implements ValueOrderingStrategy<VAR, List<String>> {

        /** Returns the values of Dom(var) in a special order. The least constraining value comes first. */
        public List<List<String>> apply(CSP<VAR, List<String>> csp, Assignment<VAR, List<String>> assignment, VAR var) {
            List<Pair<List<String>, Integer>> pairs = new ArrayList<>();
            for (List<String> value : csp.getDomain(var)) {
                int num = countLostValues(csp, assignment, var, value);
                pairs.add(new Pair<>(value, num));
            }
            return pairs.stream().sorted(Comparator.comparing(Pair::getSecond)).map(Pair::getFirst)
                    .collect(Collectors.toList());
        }

        /**
         * Ignores constraints which are not binary.
         */
        private int countLostValues(CSP<VAR, List<String>> csp, Assignment<VAR, List<String>> assignment, VAR var, List<String> value) {
            int result = 0;
            Assignment<VAR, List<String>> assign = new Assignment<>();
            assign.add(var, value);
            for (Constraint<VAR, List<String>> constraint : csp.getConstraints(var)) {
                if (constraint.getScope().size() == 2) {
                    VAR neighbor = csp.getNeighbor(var, constraint);
                    if (!assignment.contains(neighbor))
                        for (List<String> nValue : csp.getDomain(neighbor)) {
                            assign.add(neighbor, nValue);
                            if (!constraint.isSatisfiedWith(assign))
                                ++result;
                        }
                }
            }
            return result;
        }
    }
}
