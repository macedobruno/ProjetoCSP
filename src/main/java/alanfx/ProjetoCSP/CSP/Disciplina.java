package alanfx.ProjetoCSP.csp;

import java.util.ArrayList;
import java.util.List;

import aima.core.search.csp.Variable;

public class Disciplina {
	private String nome;
	private Integer cred;
	private List<Variable> vars;
	private List<String> horarios;
	
	public Disciplina(String nome, Integer cred) {
		this.nome = nome;
		this.cred = cred;
		this.vars = criarVariaveis();
		this.horarios = new ArrayList<>();
	}
	
	private List<Variable> criarVariaveis() {
		List<Variable> vars = new ArrayList<>();
		if(cred == 2) {
			vars.add(new Variable(nome+"01"));
		}else if(cred == 4) {
			vars.add(new Variable(nome+"01"));
			vars.add(new Variable(nome+"02"));
		}else {
			vars.add(new Variable(nome+"01"));
			vars.add(new Variable(nome+"02"));
			vars.add(new Variable(nome+"03"));
		}
		return vars;
	}
	
	public List<Variable> getVars() {
		return vars;
	}

	public List<String> getHorarios() {
		return horarios;
	}

	public void setHorarios(List<String> horarios) {
		this.horarios = horarios;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getCred() {
		return cred;
	}

	public void setCred(Integer cred) {
		this.cred = cred;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cred == null) ? 0 : cred.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Disciplina other = (Disciplina) obj;
		if (cred == null) {
			if (other.cred != null)
				return false;
		} else if (!cred.equals(other.cred))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
}
