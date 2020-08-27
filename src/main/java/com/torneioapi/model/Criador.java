package com.torneioapi.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "criador")
public class Criador {
	
	@Id
	@NotNull
	private String cpf;
	private String ibama;
	
	@NotNull
	private String nome;
	private String sobrenome;
	private String telefone;
	private Timestamp data_cadastro;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "criador")	
	private List<AssociacaoCriador> associacaoCriador;
	
	@OneToOne
	@JoinColumn(name = "fk_id_endereco")
	private Endereco endereco;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "criador")
	private List<Ave> aves;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getIbama() {
		return ibama;
	}

	public void setIbama(String ibama) {
		this.ibama = ibama;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Timestamp getData_cadastro() {
		return data_cadastro;
	}

	public void setData_cadastro(Timestamp data_cadastro) {
		this.data_cadastro = data_cadastro;
	}

	public List<AssociacaoCriador> getAssociacaoCriador() {
		return associacaoCriador;
	}

	public void setAssociacaoCriador(List<AssociacaoCriador> associacaoCriador) {
		this.associacaoCriador = associacaoCriador;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Ave> getAves() {
		return aves;
	}

	public void setAves(List<Ave> aves) {
		this.aves = aves;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((associacaoCriador == null) ? 0 : associacaoCriador.hashCode());
		result = prime * result + ((aves == null) ? 0 : aves.hashCode());
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((data_cadastro == null) ? 0 : data_cadastro.hashCode());
		result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + ((ibama == null) ? 0 : ibama.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((sobrenome == null) ? 0 : sobrenome.hashCode());
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
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
		Criador other = (Criador) obj;
		if (associacaoCriador == null) {
			if (other.associacaoCriador != null)
				return false;
		} else if (!associacaoCriador.equals(other.associacaoCriador))
			return false;
		if (aves == null) {
			if (other.aves != null)
				return false;
		} else if (!aves.equals(other.aves))
			return false;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (data_cadastro == null) {
			if (other.data_cadastro != null)
				return false;
		} else if (!data_cadastro.equals(other.data_cadastro))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (ibama == null) {
			if (other.ibama != null)
				return false;
		} else if (!ibama.equals(other.ibama))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (sobrenome == null) {
			if (other.sobrenome != null)
				return false;
		} else if (!sobrenome.equals(other.sobrenome))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		return true;
	}
	
		

}
