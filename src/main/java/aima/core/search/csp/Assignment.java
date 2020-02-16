package aima.core.search.csp;

import java.util.*;

/**
 * An assignment assigns values to some or all variables of a CSP.
 *
 * @author Ruediger Lunde
 */
public class Assignment<VAR extends Variable, VAL> implements Cloneable {
    /**
     * Maps variables to their assigned values.
     */
    private LinkedHashMap<VAR, List<String>> variableToValueMap = new LinkedHashMap<>();

    public List<VAR> getVariables() {
        return new ArrayList<>(variableToValueMap.keySet());
    }

    public List<String> getValue(VAR var) {
        return variableToValueMap.get(var);
    }

    public List<String> add(VAR var, List<String> value) {
        assert value != null;
        return variableToValueMap.put(var, value);
    }

    public List<String> remove(VAR var) {
        return variableToValueMap.remove(var);
    }

    public boolean contains(VAR var) {
        return variableToValueMap.containsKey(var);
    }

    /**
     * Returns true if this assignment does not violate any constraints of
     * <code>constraints</code>.
     */
    public boolean isConsistent(List<Constraint<VAR, VAL>> constraints) {
        return constraints.stream().allMatch(cons -> cons.isSatisfiedWith(this));
    }

    /**
     * Returns true if this assignment assigns values to every variable of
     * <code>vars</code>.
     */
    public boolean isComplete(List<VAR> vars) {
        return vars.stream().allMatch(this::contains);
    }

    /**
     * Returns true if this assignment is consistent as well as complete with
     * respect to the given CSP.
     */
    public boolean isSolution(CSP<VAR, VAL> csp) {
        return isConsistent(csp.getConstraints()) && isComplete(csp.getVariables());
    }

    @SuppressWarnings("unchecked")
    @Override
    public Assignment<VAR, List<String>> clone() {
        Assignment<VAR, List<String>> result;
        try {
            result = (Assignment<VAR, List<String>>) super.clone();
            result.variableToValueMap = new LinkedHashMap<>(variableToValueMap);
        } catch (CloneNotSupportedException e) {
            throw new UnsupportedOperationException("Could not clone assignment."); // should never happen!
        }
        return result;
    }

//    @Override
//    public String toString() {
//        StringBuilder result = new StringBuilder("{");
//        for (Map.Entry<VAR, VAL> entry : variableToValueMap.entrySet()) {
//            if (result.length() > 1)
//                result.append(", ");
//            result.append(entry.getKey()).append("=").append(entry.getValue());
//        }
//        result.append("}");
//        return result.toString();
//    }
    @Override
    public String toString() {
    	List<String> aulas = new ArrayList<>(
    			Arrays.asList("SEG17","TER17","QUA17","QUI17","SEX17",
    						  "SEG19","TER19","QUA19","QUI19","SEX19",
    						  "SEG21","TER21","QUA21","QUI21","SEX21"));
    	StringBuilder result = new StringBuilder("");
    	int cont = 0;
    	for( String aula : aulas) {
    		cont++;
    		Map.Entry<VAR, List<String>> map = null;
    		for (Map.Entry<VAR, List<String>> entry : variableToValueMap.entrySet()) {
    			if(aula.equals(entry.getValue().get(0))) {
    				map = entry;
    			}
    		}
    		if(map != null) {
    			result.append(map+"\t");
    		}else {
    			result.append("         ||         \t");
    		}
    		if(cont == 5 || cont == 10 || cont == 15) {
    			result.append("\n");
    		}
    	}
    	return result.toString();
    }
    
    public String getAula(Map<String,List<String>> m, String aula) {
        for (String s : m.keySet())
                if (m.get(s).get(0).equals(aula))
                        return s;
        return null;
    }
}