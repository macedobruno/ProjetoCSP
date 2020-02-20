package alanfx.ProjetoCSP;

import java.util.List;
import java.util.Optional;

import aima.core.search.csp.Assignment;
import aima.core.search.csp.CSP;
import aima.core.search.csp.CspHeuristics;
import aima.core.search.csp.CspListener;
import aima.core.search.csp.CspSolver;
import aima.core.search.csp.FlexibleBacktrackingSolver;
import aima.core.search.csp.MinConflictsSolver;
import aima.core.search.csp.Variable;
import alanfx.ProjetoCSP.csp.AlocCSP;

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
		solution.ifPresent(AlocCSP::imprimir);
		System.out.println(stepCounter.getResults() + "\n");
		
		solver = new FlexibleBacktrackingSolver<Variable, List<String>>().setAll();
		solver.addCspListener(stepCounter);
		stepCounter.reset();
		System.out.println("Alocar Professores (Backtracking + MRV & DEG + LCV + AC3)");
		solution = solver.solve(csp);
		solution.ifPresent(AlocCSP::imprimir);
		System.out.println(stepCounter.getResults() + "\n");

		solver = new FlexibleBacktrackingSolver<Variable, List<String>>().set(CspHeuristics.mrvDeg());
		solver.addCspListener(stepCounter);
		stepCounter.reset();
		System.out.println("Alocar Professores (Backtracking + MRV & DEG)");
		solution = solver.solve(csp);
		solution.ifPresent(AlocCSP::imprimir);
		System.out.println(stepCounter.getResults() + "\n");
		
		solver = new FlexibleBacktrackingSolver<>();
		solver.addCspListener(stepCounter);
		stepCounter.reset();
		System.out.println("Alocar Professores (Backtracking)");
		solution = solver.solve(csp);
		solution.ifPresent(AlocCSP::imprimir);
		System.out.println(stepCounter.getResults() + "\n");
	}
}