package com.torneioapi.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "inscricao")
public class Inscricao {

	@Id
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
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "fk_id_ave")
	private Ave ave;

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

	public Ave getAve() {
		return ave;
	}

	public void setAve(Ave ave) {
		this.ave = ave;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ave == null) ? 0 : ave.hashCode());
		result = prime * result + ((criador == null) ? 0 : criador.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		if (ave == null) {
			if (other.ave != null)
				return false;
		} else if (!ave.equals(other.ave))
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
		if (torneio == null) {
			if (other.torneio != null)
				return false;
		} else if (!torneio.equals(other.torneio))
			return false;
		return true;
	}
	
	
	
}
