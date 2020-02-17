package alanfx.ProjetoCSP.CSP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import aima.core.search.csp.CSP;
import aima.core.search.csp.Domain;
import aima.core.search.csp.Variable;
import alanfx.ProjetoCSP.Restricoes.HorarioFixoConstraint;
import alanfx.ProjetoCSP.Restricoes.NotEqualConstraint;
import alanfx.ProjetoCSP.Restricoes.PreferenciaDisciplinaConstraint;

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
	
	public List<String> aulas = new ArrayList<>(
			Arrays.asList("SEG17","TER17","QUA17","QUI17","SEX17",
						  "SEG19","TER19","QUA19","QUI19","SEX19",
						  "SEG21","TER21","QUA21","QUI21","SEX21"));
	
	public List<String> profs = new ArrayList<>(Arrays.asList("Prof1","Prof2","Prof3","Prof4", "[N/A]"));
	
	public Map<String, List<Variable>> preferencias;

	public AlocCSP() {
		super(variaveis);

		Domain<List<String>> domain = new Domain<>(createValues(profs, aulas));
		for (Variable var : getVariables())
			setDomain(var, domain);

		addAll(variaveis, 0); 
		
		addConstraint(new HorarioFixoConstraint<>(ESII1, "QUI17"));
		addConstraint(new HorarioFixoConstraint<>(ESII2, "QUI19"));
		
		preferencias = new HashMap<>();
		preferencias.put("Prof1", Arrays.asList(SD1, SD2, LR1));
		preferencias.put("Prof2", Arrays.asList(SD1, SD2, LR1));
		preferencias.put("Prof3", Arrays.asList(SD1, SD2, LR1, ESII1, ESII2));
		preferencias.put("Prof4", Arrays.asList(SD1, SD2, LR1));
		
		
		addConstraint(new PreferenciaDisciplinaConstraint<>(IA1, preferencias));
		addConstraint(new PreferenciaDisciplinaConstraint<>(IA2, preferencias));
		addConstraint(new PreferenciaDisciplinaConstraint<>(ESII1, preferencias));
		addConstraint(new PreferenciaDisciplinaConstraint<>(ESII2, preferencias));
		addConstraint(new PreferenciaDisciplinaConstraint<>(SAD1, preferencias));
		addConstraint(new PreferenciaDisciplinaConstraint<>(SAD2, preferencias));
		addConstraint(new PreferenciaDisciplinaConstraint<>(SD1, preferencias));
		addConstraint(new PreferenciaDisciplinaConstraint<>(SD2, preferencias));
		addConstraint(new PreferenciaDisciplinaConstraint<>(LR1, preferencias));
		
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
	
	//Adiciona totas as restricoes do tipo "NotEqualConstraint"
	private void addAll(List<Variable> var, int j) {
		for(int i = j+1; i < var.size(); i++){
			addConstraint(new NotEqualConstraint<>(var.get(j), var.get(i)));
		}
		if(j+1 < var.size()) addAll(var, j+1);
	}
}