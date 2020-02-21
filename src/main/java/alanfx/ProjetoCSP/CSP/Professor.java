package alanfx.ProjetoCSP.csp;

import java.util.ArrayList;
import java.util.List;

import aima.core.search.csp.Variable;

public class Professor {
	private String nome;
	private List<Variable> preferencias;
	
	public Professor(String nome) {
		this.nome = nome;
		this.preferencias = new ArrayList<>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Variable> getPreferencias() {
		return preferencias;
	}
	
	public void addPreferencia(Disciplina disc) {
		for(Variable var : disc.getVars()) {
			this.preferencias.add(var);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		Professor other = (Professor) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
}
