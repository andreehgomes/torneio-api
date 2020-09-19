package com.torneioapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "participacao")
public class Participacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String marcacao;
	private int pontos;
	
	@ManyToOne
	@JoinColumn(name = "fk_id_inscricao")
	private Inscricao inscricao;
	
	@ManyToOne
	@JoinColumn(name = "fk_id_etapa")
	private Etapa etapa;
	
	@ManyToOne
	@JoinColumn(name = "fk_id_ave")
	private Ave ave;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMarcacao() {
		return marcacao;
	}

	public void setMarcacao(String marcacao) {
		this.marcacao = marcacao;
	}

	public int getPontos() {
		return pontos;
	}

	public void setPontos(int pontos) {
		this.pontos = pontos;
	}

	public Inscricao getInscricao() {
		return inscricao;
	}

	public void setInscricao(Inscricao inscricao) {
		this.inscricao = inscricao;
	}

	public Etapa getEtapa() {
		return etapa;
	}

	public void setEtapa(Etapa etapa) {
		this.etapa = etapa;
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
		result = prime * result + ((etapa == null) ? 0 : etapa.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((inscricao == null) ? 0 : inscricao.hashCode());
		result = prime * result + ((marcacao == null) ? 0 : marcacao.hashCode());
		result = prime * result + pontos;
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
		Participacao other = (Participacao) obj;
		if (ave == null) {
			if (other.ave != null)
				return false;
		} else if (!ave.equals(other.ave))
			return false;
		if (etapa == null) {
			if (other.etapa != null)
				return false;
		} else if (!etapa.equals(other.etapa))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (inscricao == null) {
			if (other.inscricao != null)
				return false;
		} else if (!inscricao.equals(other.inscricao))
			return false;
		if (marcacao == null) {
			if (other.marcacao != null)
				return false;
		} else if (!marcacao.equals(other.marcacao))
			return false;
		if (pontos != other.pontos)
			return false;
		return true;
	}
	
	

}
