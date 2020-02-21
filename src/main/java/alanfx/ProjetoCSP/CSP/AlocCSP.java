package alanfx.ProjetoCSP.csp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import aima.core.search.csp.Assignment;
import aima.core.search.csp.CSP;
import aima.core.search.csp.Domain;
import aima.core.search.csp.Variable;
import alanfx.ProjetoCSP.restricoes.HorarioDiferente;
import alanfx.ProjetoCSP.restricoes.HorarioFixo;
import alanfx.ProjetoCSP.restricoes.PreferenciaDisciplina;
import alanfx.ProjetoCSP.restricoes.ProfessorDiferente;
import alanfx.ProjetoCSP.restricoes.util.PriorizarProfessores;
import alanfx.ProjetoCSP.restricoes.util.UnicoProfessor;

public class AlocCSP extends CSP<Variable, List<String>> {
	public static final Variable IA1 = new Variable("IA1"); 	//	INTELIGENCIA ARTIFICIAL 4cr
	public static final Variable IA2 = new Variable("IA2"); 		
	public static final Variable ESII1 = new Variable("ESII1"); // ENGENHARIA DE SOFTWARE II 4cr
	public static final Variable ESII2 = new Variable("ESII2"); 	
	public static final Variable SAD1 = new Variable("SAD1");  	//	SISTEMAS DE APOIO A DECISAO 4cr
	public static final Variable SAD2 = new Variable("SAD2");  
	public static final Variable SD1 = new Variable("SD1");    	//	SISTEMAS DISTRIBUIDOS 4cr
	public static final Variable SD2 = new Variable("SD2");    		
	public static final Variable LR1 = new Variable("LR1");   	// LABORATORIO DE REDES DE COMPUTADORES 2cr
	public static List<Variable> variaveis = new ArrayList<>(Arrays.asList(IA1,IA2,ESII1,ESII2,SAD1,SAD2,SD1,SD2,LR1));
	public static List<Variable> variaveisUnicas = new ArrayList<>(Arrays.asList(IA1,ESII1,SAD1,SD1,LR1));
	
	public static final List<String> aulas = new ArrayList<>(
		Arrays.asList("SEG17","TER17","QUA17","QUI17","SEX17",
					  "SEG19","TER19","QUA19","QUI19","SEX19",
					  "SEG21","TER21","QUA21","QUI21","SEX21"));;
	public List<String> profs;
	public Map<String, List<Variable>> preferencias;

	public AlocCSP() {
		super(variaveis);
		profs = new ArrayList<>(Arrays.asList("Prof1","Prof2","Prof3","Prof4","semProf")); 

		Domain<List<String>> domain = new Domain<>(createValues(profs, aulas));
		for (Variable var : getVariables())
			setDomain(var, domain);
		
		preferencias = new HashMap<>();
		preferencias.put("Prof1", Arrays.asList(SD1, SD2, IA1, IA2));
		preferencias.put("Prof2", Arrays.asList(SD1, SD2));
		preferencias.put("Prof3", Arrays.asList(SD1, SD2, ESII1, ESII2, LR1));
//		preferencias.put("Prof4", Arrays.asList(SD1, SD2));
		
		addAllHorarioDiferente(variaveis, 0); //add "HorarioDiferenteConstraint"
		addAllProfessorDiferente(variaveisUnicas, 0); //add "ProfessorDiferenteConstraint"
		
		addConstraint(new HorarioFixo<>(ESII1, "QUI17"));
		addConstraint(new HorarioFixo<>(ESII2, "QUI19"));
		
		addConstraint(new PreferenciaDisciplina<>(IA1, preferencias));
		addConstraint(new PreferenciaDisciplina<>(IA2, preferencias));
		addConstraint(new PreferenciaDisciplina<>(ESII1, preferencias));
		addConstraint(new PreferenciaDisciplina<>(ESII2, preferencias));
		addConstraint(new PreferenciaDisciplina<>(SAD1, preferencias));
		addConstraint(new PreferenciaDisciplina<>(SAD2, preferencias));
		addConstraint(new PreferenciaDisciplina<>(SD1, preferencias));
		addConstraint(new PreferenciaDisciplina<>(SD2, preferencias));
		addConstraint(new PreferenciaDisciplina<>(LR1, preferencias));
		
		addConstraint(new UnicoProfessor<>(IA1, IA2));
		addConstraint(new UnicoProfessor<>(ESII1, ESII2));
		addConstraint(new UnicoProfessor<>(SAD1, SAD2));
		addConstraint(new UnicoProfessor<>(SD1, SD2));
		
		addAllPriorizarProfessores(variaveis, profs, preferencias);
	}
	
	//Associa Todos os professores a cada um dos horarios
	private List<List<String>> createValues(List<String> profs, List<String> aulas) {
		List<List<String>> values = new ArrayList<>();
		for(String prof : profs) {
			for(String aula : aulas) {
				values.add(Arrays.asList(aula, prof));
			}
		}
		return values;
	}
	
	//Adiciona todas as restricoes do tipo "HorarioDiferenteConstraint"
	private void addAllHorarioDiferente(List<Variable> var, int j) {
		for(int i = j+1; i < var.size(); i++){
			addConstraint(new HorarioDiferente<>(var.get(j), var.get(i)));
		}
		if(j+1 < var.size()) addAllHorarioDiferente(var, j+1);
	}
	//Adiciona todas as restricoes do tipo "ProfessorDiferenteConstraint"
	private void addAllProfessorDiferente(List<Variable> var, int j) {
		for(int i = j+1; i < var.size(); i++){
			addConstraint(new ProfessorDiferente<>(var.get(j), var.get(i)));
		}
		if(j+1 < var.size()) addAllProfessorDiferente(var, j+1);
	}
	//Adiciona todas as restricoes do tipo "PriorizarProfessores"
	private void addAllPriorizarProfessores(List<Variable> vars, List<String> profs, Map<String, List<Variable>> preferencias) {
		List<String> profs2 = new ArrayList<>(profs);
		profs2.remove("semProf");
		for(Variable var : vars) {
			addConstraint(new PriorizarProfessores<>(var, profs2, preferencias));
		}
	}
	
    public static void imprimir(Assignment<Variable, List<String>> solution) {
    	LinkedHashMap<Variable, List<String>> assignment = solution.getVariableToValueMap();
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
    	System.out.println(result.toString());
    }
}