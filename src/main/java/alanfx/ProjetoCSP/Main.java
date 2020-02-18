package alanfx.ProjetoCSP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import aima.core.search.csp.Assignment;
import aima.core.search.csp.CSP;
import aima.core.search.csp.CspHeuristics;
import aima.core.search.csp.CspListener;
import aima.core.search.csp.CspSolver;
import aima.core.search.csp.FlexibleBacktrackingSolver;
import aima.core.search.csp.MinConflictsSolver;
import aima.core.search.csp.Variable;
import alanfx.ProjetoCSP.CSP.AlocCSP;

public class Main {

	public static void main(String[] args) {
		CSP<Variable, List<String>> csp = new AlocCSP();
		CspListener.StepCounter<Variable, List<String>> stepCounter = new CspListener.StepCounter<>();
		CspSolver<Variable, List<String>> solver;
		Optional<Assignment<Variable, List<String>>> solution;
		
		solver = new MinConflictsSolver<>(1000);
		solver.addCspListener(stepCounter);
		stepCounter.reset();
		System.out.println("Alocar Professores (Minimum Conflicts)");
		solution = solver.solve(csp);
		System.out.println(toString(solution.get().getVariableToValueMap())); //TA LANÇANDO EXCEÇÃO QUANDO N TEM RESULTADOS
		System.out.println(stepCounter.getResults() + "\n");
		
		solver = new FlexibleBacktrackingSolver<Variable, List<String>>().setAll();
		solver.addCspListener(stepCounter);
		stepCounter.reset();
		System.out.println("Alocar Professores (Backtracking + MRV & DEG + LCV + AC3)");
		solution = solver.solve(csp);
		System.out.println(toString(solution.get().getVariableToValueMap()));
		System.out.println(stepCounter.getResults() + "\n");

		solver = new FlexibleBacktrackingSolver<Variable, List<String>>().set(CspHeuristics.mrvDeg());
		solver.addCspListener(stepCounter);
		stepCounter.reset();
		System.out.println("Alocar Professores (Backtracking + MRV & DEG)");
		solution = solver.solve(csp);
		System.out.println(toString(solution.get().getVariableToValueMap()));
		System.out.println(stepCounter.getResults() + "\n");
		
		solver = new FlexibleBacktrackingSolver<>();
		solver.addCspListener(stepCounter);
		stepCounter.reset();
		System.out.println("Alocar Professores (Backtracking)");
		solution = solver.solve(csp);
		System.out.println(toString(solution.get().getVariableToValueMap()));
		System.out.println(stepCounter.getResults() + "\n");
	}
	
    public static String toString(LinkedHashMap<Variable, List<String>> assignment) {
    	List<String> aulas = new ArrayList<>(
    			Arrays.asList("SEG17","TER17","QUA17","QUI17","SEX17",
    						  "SEG19","TER19","QUA19","QUI19","SEX19",
    						  "SEG21","TER21","QUA21","QUI21","SEX21"));
    	StringBuilder result = new StringBuilder("");
    	int cont = 0;
    	for( String aula : aulas) {
    		cont++;
    		Map.Entry<Variable, List<String>> map = null;
    		for (Map.Entry<Variable, List<String>> entry : assignment.entrySet()) {
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
}