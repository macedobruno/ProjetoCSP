package aima.core.search.csp.examples;

import java.util.ArrayList;
import java.util.List;

import aima.core.search.csp.Assignment;
import aima.core.search.csp.Constraint;
import aima.core.search.csp.Variable;

/**
 * Represents a binary constraint which forbids equal values.
 * 
 * @author Ruediger Lunde
 */
public class HoarioFixoConstraint<VAR extends Variable, VAL> implements Constraint<VAR, List<String>> {

	private VAR var;
	private String val;
	private List<VAR> scope;

	public HoarioFixoConstraint(VAR var, String val) {
		this.var = var;
		this.val = val;
		scope = new ArrayList<>(2);
		scope.add(var);
	}

	@Override
	public List<VAR> getScope() {
		return scope;
	}

	@Override
	public boolean isSatisfiedWith(Assignment<VAR, List<String>> assignment) {
		List<String> value = assignment.getValue(var);
		return value.get(0) == val;
	}
}
