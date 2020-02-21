package alanfx.ProjetoCSP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import aima.core.search.csp.Assignment;
import aima.core.search.csp.CSP;
import aima.core.search.csp.CspHeuristics;
import aima.core.search.csp.CspListener;
import aima.core.search.csp.CspSolver;
import aima.core.search.csp.FlexibleBacktrackingSolver;
import aima.core.search.csp.MinConflictsSolver;
import aima.core.search.csp.Variable;
import alanfx.ProjetoCSP.csp.AlocCSP;

import alanfx.ProjetoCSP.csp.Disciplina;
import alanfx.ProjetoCSP.csp.Professor;

public class Main {

	private static List<Disciplina> disciplinas = new ArrayList<>();
	private static List<Professor> professores = new ArrayList<>();
	
	public static void main(String[] args) {
		
		Disciplina fisica = new Disciplina("Fisica", 4);
		Disciplina calculo = new Disciplina("Calculo", 6);
		
		fisica.setHorarios(Arrays.asList("SEG17", "SEG19"));
		
		Professor leonardo = new Professor("Leonardo");
		Professor estombelo = new Professor("Estombelo");
		
		estombelo.addPreferencia(calculo);
		
		disciplinas.add(fisica);
		disciplinas.add(calculo);
		professores.add(leonardo);
		professores.add(estombelo);
		
		CSP<Variable, List<String>> csp = new AlocCSP(disciplinas, professores);
		CspListener.StepCounter<Variable, List<String>> stepCounter = new CspListener.StepCounter<>();
		CspSolver<Variable, List<String>> solver;

		solver = new MinConflictsSolver<>(1000);
		solver.addCspListener(stepCounter);
		stepCounter.reset();
		System.out.println("Alocar Professores (Minimum Conflicts)");
		mostrarSolucoes(csp, solver);
		System.out.println(stepCounter.getResults() + "\n");

		solver = new FlexibleBacktrackingSolver<Variable, List<String>>().setAll();
		solver.addCspListener(stepCounter);
		stepCounter.reset();
		System.out.println("Alocar Professores (Backtracking + MRV & DEG + LCV + AC3)");
		mostrarSolucoes(csp, solver);
		System.out.println(stepCounter.getResults() + "\n");
		
		solver = new FlexibleBacktrackingSolver<Variable, List<String>>().set(CspHeuristics.mrvDeg());
		solver.addCspListener(stepCounter);
		stepCounter.reset();
		System.out.println("Alocar Professores (Backtracking + MRV & DEG)");
		mostrarSolucoes(csp, solver);
		System.out.println(stepCounter.getResults() + "\n");

		solver = new FlexibleBacktrackingSolver<>();
		solver.addCspListener(stepCounter);
		stepCounter.reset();
		System.out.println("Alocar Professores (Backtracking)");
		mostrarSolucoes(csp, solver);
		System.out.println(stepCounter.getResults() + "\n");

	}

	private static void mostrarSolucoes(CSP<Variable, List<String>> csp, CspSolver<Variable, List<String>> solver) {
		int n = 4; // Número de resultados
		Optional<Assignment<Variable, List<String>>> solution;
		Set<Optional<Assignment<Variable, List<String>>>> set = new HashSet<>();
		for (int i = 0; i < n; i++) {
			solution = solver.solve(csp);
			set.add(solution);
		}
		for (Optional<Assignment<Variable, List<String>>> soluc : set) {
			soluc.ifPresent(AlocCSP::imprimir);
			System.out.println("------------------------------");
		}
	}
}