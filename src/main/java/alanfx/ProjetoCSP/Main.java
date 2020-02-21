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
import aima.core.search.csp.CspListener.StepCounter;
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
	private static final List<String> algoritmos = new ArrayList<>(
			Arrays.asList("MinConflictsSolver",
						  "Backtracking + MRV & DEG + LCV + AC3",
						  "Backtracking + MRV & DEG",
						  "Backtracking"));
	
	public static void main(String[] args) {
		
		Disciplina fisica = new Disciplina("Fisica", 4);
		Disciplina calculo = new Disciplina("Calculo", 6);
		Disciplina biologia = new Disciplina("Biologia", 4);
		
		fisica.setHorarios(Arrays.asList("SEG17", "SEG19"));
		
		Professor leonardo = new Professor("Leonardo");
		Professor estombelo = new Professor("Estombelo");
		Professor maria = new Professor("Maria");
		Professor ana = new Professor("Ana");
		
		estombelo.addPreferencia(calculo);
		
		disciplinas.add(fisica);
		disciplinas.add(calculo);
		disciplinas.add(biologia);
		
		professores.add(leonardo);
		professores.add(estombelo);
		professores.add(maria);
		professores.add(ana);
		
		CSP<Variable, List<String>> csp = new AlocCSP(disciplinas, professores);
		CspListener.StepCounter<Variable, List<String>> stepCounter = new CspListener.StepCounter<>();

		String algorit = "MinConflictsSolver"; //Exemplo algoritmo selecionado
		
		Set<Optional<Assignment<Variable, List<String>>>> solucoesList = //usar essa lista pra exibir os resultados na interface
				usarAlgoritmo(algorit, csp, stepCounter);

		System.out.println("Alocar Professores ("+algorit+")");
		for (Optional<Assignment<Variable, List<String>>> soluc : solucoesList) {
			soluc.ifPresent(AlocCSP::imprimir);
			System.out.println("------------------------------");
		}
		System.out.println(stepCounter.getResults() + "\n");
	}

	private static Set<Optional<Assignment<Variable, List<String>>>> usarAlgoritmo(String algorit,
			CSP<Variable, List<String>> csp, StepCounter<Variable, List<String>> stepCounter) {
		CspSolver<Variable, List<String>> solver;
		switch(algorit) {
			case "MinConflictsSolver":
				solver = new MinConflictsSolver<>(1000);
				solver.addCspListener(stepCounter);
				stepCounter.reset();
				
				return getSolucoes(csp, solver);
			case "Backtracking + MRV & DEG + LCV + AC3":
				solver = new FlexibleBacktrackingSolver<Variable, List<String>>().setAll();
				solver.addCspListener(stepCounter);
				stepCounter.reset();
				
				return getSolucoes(csp, solver);
			case "Backtracking + MRV & DEG":
				solver = new FlexibleBacktrackingSolver<Variable, List<String>>().set(CspHeuristics.mrvDeg());
				solver.addCspListener(stepCounter);
				stepCounter.reset();
				
				return getSolucoes(csp, solver);
			case "Backtracking":
				solver = new FlexibleBacktrackingSolver<>();
				solver.addCspListener(stepCounter);
				stepCounter.reset();
				
				return getSolucoes(csp, solver);
			default:
				return new HashSet<>();
		}
	}

	private static Set<Optional<Assignment<Variable, List<String>>>> getSolucoes(CSP<Variable, List<String>> csp, CspSolver<Variable, List<String>> solver) {
		int n = 4; // Número de resultados
		Optional<Assignment<Variable, List<String>>> solution;
		Set<Optional<Assignment<Variable, List<String>>>> set = new HashSet<>();
		for (int i = 0; i < n; i++) {
			solution = solver.solve(csp);
			set.add(solution);
		}
		return set;
	}
}