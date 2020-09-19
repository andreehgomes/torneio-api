package com.torneioapi.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "inscricao")
public class Inscricao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDateTime data;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "fk_id_torneio")
	private Torneio torneio;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "fk_id_criador")
	private Criador criador;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "inscricao")
	private List<Participacao> participacoes;	
	

	public List<Participacao> getParticipacoes() {
		return participacoes;
	}

	public void setParticipacoes(List<Participacao> participacoes) {
		this.participacoes = participacoes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public Torneio getTorneio() {
		return torneio;
	}

	public void setTorneio(Torneio torneio) {
		this.torneio = torneio;
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
		result = prime * result + ((criador == null) ? 0 : criador.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((participacoes == null) ? 0 : participacoes.hashCode());
		result = prime * result + ((torneio == null) ? 0 : torneio.hashCode());
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
		Inscricao other = (Inscricao) obj;
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
		if (participacoes == null) {
			if (other.participacoes != null)
				return false;
		} else if (!participacoes.equals(other.participacoes))
			return false;
		if (torneio == null) {
			if (other.torneio != null)
				return false;
		} else if (!torneio.equals(other.torneio))
			return false;
		return true;
	}

	
	
	
}
