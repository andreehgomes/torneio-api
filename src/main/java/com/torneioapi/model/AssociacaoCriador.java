package com.torneioapi.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "associacao_criador")
public class AssociacaoCriador {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private boolean adm;
	
	@NotNull
	private boolean ativo;
	
	@NotNull
	private Date data;
	
	@ManyToOne
	@JoinColumn(name = "fk_id_associacao")
	private Associacao associacao;
	
	@ManyToOne
	@JoinColumn(name = "fk_id_criador")
	private Criador criador;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isAdm() {
		return adm;
	}

	public void setAdm(boolean adm) {
		this.adm = adm;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Associacao getAssociacao() {
		return associacao;
	}

	public void setAssociacao(Associacao associacao) {
		this.associacao = associacao;
	}

	public Criador getCriador() {
		return criador;
	}

	public void setCriador(Criador criador) {
		this.criador = criador;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (adm ? 1231 : 1237);
		result = prime * result + ((associacao == null) ? 0 : associacao.hashCode());
		result = prime * result + (ativo ? 1231 : 1237);
		result = prime * result + ((criador == null) ? 0 : criador.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		AssociacaoCriador other = (AssociacaoCriador) obj;
		if (adm != other.adm)
			return false;
		if (associacao == null) {
			if (other.associacao != null)
				return false;
		} else if (!associacao.equals(other.associacao))
			return false;
		if (ativo != other.ativo)
			return false;
		if (criador == null) {
			if (other.criador != null)
				return false;
		} else if (!criador.equals(other.criador))
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
