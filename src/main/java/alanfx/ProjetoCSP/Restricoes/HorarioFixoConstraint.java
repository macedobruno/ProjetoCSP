package alanfx.ProjetoCSP.Restricoes;

import java.util.ArrayList;
import java.util.List;

import aima.core.search.csp.Assignment;
import aima.core.search.csp.Constraint;
import aima.core.search.csp.Variable;

/**
 * Representa uma restrição unária que associa uma variável a um horário.
 * 
 * @author Ruediger Lunde
 */
public class HorarioFixoConstraint<VAR extends Variable, VAL> implements Constraint<VAR, List<String>> {

	private VAR var;
	private String val;
	private List<VAR> scope;

	public HorarioFixoConstraint(VAR var, String val) {
		this.var = var;
		this.val = val;
		scope = new ArrayList<>(1);
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
