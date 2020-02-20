package alanfx.ProjetoCSP.restricoes.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import aima.core.search.csp.Assignment;
import aima.core.search.csp.Constraint;
import aima.core.search.csp.Variable;

/**
 * Representa uma restrição unária que proibe uma disciplina de atribuir "sem professor" 
 * quando ainda houver professor disponível para ser atribuido.
 * 
 */
public class PriorizarProfessores<VAR extends Variable, VAL> implements Constraint<VAR, List<String>> {

	private VAR var;
	List<String> profs;
	private List<VAR> scope;

	public PriorizarProfessores(VAR var, List<String> profs) {
		this.var = var;
		this.profs = profs;
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
		if(!value.get(1).equals("semProf")){
			return true;
		}else {//conferir se algum professor não foi atribuido
			boolean contem = false;
    		for(String prof : profs) {
    			for (Map.Entry<VAR, List<String>> entry : assignment.getVariableToValueMap().entrySet()) {
    				if(prof.equals(entry.getValue().get(1))) {
    					contem=true;
    				}
    			}
    			if(!contem) return false;
    			contem = false;
    		}
    		return true;//todos os professores foram atribuidos, então usar "sem professor" para as demais atribuições
		}
	}
}