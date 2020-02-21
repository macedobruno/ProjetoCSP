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
import alanfx.ProjetoCSP.restricoes.util.ValorAtribuido;

public class Main {
	
	private static List<Disciplina> disciplinas = new ArrayList<>();
	private static List<Professor> professores = new ArrayList<>();
	
	//Lista de algoritmos que poderao ser selecionados pelo usuario (apenas um sera selecionado por vez)
	private static final List<String> algoritmos = new ArrayList<>(
		Arrays.asList("MinConflictsSolver",
					  "Backtracking + MRV & DEG + LCV + AC3",
					  "Backtracking + MRV & DEG",
					  "Backtracking"));
	
	private static List<String> restricoesList;
	
	//Lista de restricoes que poderao ser selecionadas pelo usuario
	private static final List<String> restricoesPossiveis = new ArrayList<>( 
		Arrays.asList("HorarioDiferente", "ProfessorDiferente", "PreferenciaDisciplina", "HorarioFixo"));
	
	private static List<Variable> variaveis;
	private static List<List<String>> valores;
	
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
		
		//Exemplo de instanciacao da lista de restricoes
		restricoesList = new ArrayList<>(
			Arrays.asList("HorarioDiferente", "ProfessorDiferente", "PreferenciaDisciplina", "HorarioFixo"));
		
		disciplinas.add(fisica);
		disciplinas.add(calculo);
		disciplinas.add(biologia);
		
		professores.add(leonardo);
		professores.add(estombelo);
		professores.add(maria);
		professores.add(ana);
		
		String algorit = "MinConflictsSolver"; //Exemplo algoritmo selecionado
		
		variaveis = AlocCSP.criarVariaveis(disciplinas);
		valores = AlocCSP.createValues(AlocCSP.criarProfessores(professores), AlocCSP.aulas);
		CspListener.StepCounter<Variable, List<String>> stepCounter = new CspListener.StepCounter<>();
		Set<Optional<Assignment<Variable, List<String>>>> solucoesList = //usar essa lista pra exibir os resultados na interface
				usarAlgoritmo(algorit, stepCounter);
		
		
		//==============================================================
		//ESSA PARTE SERÁ DESCARTADA DEPOIS DE CRIAR A INTERFACE GRÁFICA
			System.out.println("Alocar Professores ("+algorit+")");
			for (Optional<Assignment<Variable, List<String>>> soluc : solucoesList) {
				soluc.ifPresent(AlocCSP::imprimir);
				System.out.println("------------------------------");
			}
			System.out.println(stepCounter.getResults() + "\n");
		//==============================================================
	}

	private static Set<Optional<Assignment<Variable, List<String>>>> usarAlgoritmo(String algorit,
			StepCounter<Variable, List<String>> stepCounter) {
		CspSolver<Variable, List<String>> solver;
		switch(algorit) {
			case "MinConflictsSolver":
				solver = new MinConflictsSolver<>(1000);
				solver.addCspListener(stepCounter);
				stepCounter.reset();
				
				return getSolucoes(solver);
			case "Backtracking + MRV & DEG + LCV + AC3":
				solver = new FlexibleBacktrackingSolver<Variable, List<String>>().setAll();
				solver.addCspListener(stepCounter);
				stepCounter.reset();
				
				return getSolucoes(solver);
			case "Backtracking + MRV & DEG":
				solver = new FlexibleBacktrackingSolver<Variable, List<String>>().set(CspHeuristics.mrvDeg());
				solver.addCspListener(stepCounter);
				stepCounter.reset();
				
				return getSolucoes(solver);
			case "Backtracking":
				solver = new FlexibleBacktrackingSolver<>();
				solver.addCspListener(stepCounter);
				stepCounter.reset();
				
				return getSolucoes(solver);
			default:
				return new HashSet<>();
		}
	}

	private static Set<Optional<Assignment<Variable, List<String>>>> getSolucoes(CspSolver<Variable, List<String>> solver) {
		Optional<Assignment<Variable, List<String>>> solution;
		Set<Optional<Assignment<Variable, List<String>>>> set = new HashSet<>();
		for (Variable var : variaveis) {
			for (List<String> val : valores) {
				CSP<Variable, List<String>> csp = new AlocCSP(disciplinas, professores, restricoesList, new ValorAtribuido<>(var, val));
				solution = solver.solve(csp);
				set.add(solution);
			}
		}
		return set;
	}
}