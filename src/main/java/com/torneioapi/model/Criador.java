package com.torneioapi.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	private boolean adm;

	@ManyToOne
	@JoinColumn(name = "fk_id_associacao")
	private Associacao associacao;
	private Long fk_id_endereco;
	private Timestamp data_cadastro;
	
	@JsonIgnore
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
	public boolean isAdm() {
		return adm;
	}
	public void setAdm(boolean adm) {
		this.adm = adm;
	}
	public Associacao getAssociacao() {
		return associacao;
	}
	public void setAssociacao(Associacao associacao) {
		this.associacao = associacao;
	}
	public Long getFk_id_endereco() {
		return fk_id_endereco;
	}
	public void setFk_id_endereco(Long fk_id_endereco) {
		this.fk_id_endereco = fk_id_endereco;
	}
	public Timestamp getData_cadastro() {
		return data_cadastro;
	}
	public void setData_cadastro(Timestamp data_cadastro) {
		this.data_cadastro = data_cadastro;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (adm ? 1231 : 1237);
		result = prime * result + ((associacao == null) ? 0 : associacao.hashCode());
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((data_cadastro == null) ? 0 : data_cadastro.hashCode());
		result = prime * result + ((fk_id_endereco == null) ? 0 : fk_id_endereco.hashCode());
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
		if (adm != other.adm)
			return false;
		if (associacao == null) {
			if (other.associacao != null)
				return false;
		} else if (!associacao.equals(other.associacao))
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
		if (fk_id_endereco == null) {
			if (other.fk_id_endereco != null)
				return false;
		} else if (!fk_id_endereco.equals(other.fk_id_endereco))
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
