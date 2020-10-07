package com.torneioapi.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name ="ave")
public class Ave {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String nome;
	
	@ManyToOne
	@JoinColumn(name = "fk_id_especie")
	private Especie especie;
	//private Orgao orgao;
	private String  medida_anilha;
	private String numero_anilha;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "fk_id_criador")
	private Criador criador;
	private boolean ativo;
	private Timestamp data_cadastro;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ave")
	private List<Participacao> participacoes;	
	

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Especie getEspecie() {
		return especie;
	}
	public void setEspecie(Especie especie) {
		this.especie = especie;
	}
	public String getMedida_anilha() {
		return medida_anilha;
	}
	public void setMedida_anilha(String medida_anilha) {
		this.medida_anilha = medida_anilha;
	}
	public String getNumero_anilha() {
		return numero_anilha;
	}
	public void setNumero_anilha(String numero_anilha) {
		this.numero_anilha = numero_anilha;
	}
	public Criador getCriador() {
		return criador;
	}
	public void setCriador(Criador criador) {
		this.criador = criador;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
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
		result = prime * result + (ativo ? 1231 : 1237);
		result = prime * result + ((criador == null) ? 0 : criador.hashCode());
		result = prime * result + ((data_cadastro == null) ? 0 : data_cadastro.hashCode());
		result = prime * result + ((especie == null) ? 0 : especie.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((medida_anilha == null) ? 0 : medida_anilha.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((numero_anilha == null) ? 0 : numero_anilha.hashCode());
		result = prime * result + ((participacoes == null) ? 0 : participacoes.hashCode());
		return result;
	}
	public List<Participacao> getParticipacoes() {
		return participacoes;
	}
	public void setParticipacoes(List<Participacao> participacoes) {
		this.participacoes = participacoes;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ave other = (Ave) obj;
		if (ativo != other.ativo)
			return false;
		if (criador == null) {
			if (other.criador != null)
				return false;
		} else if (!criador.equals(other.criador))
			return false;
		if (data_cadastro == null) {
			if (other.data_cadastro != null)
				return false;
		} else if (!data_cadastro.equals(other.data_cadastro))
			return false;
		if (especie == null) {
			if (other.especie != null)
				return false;
		} else if (!especie.equals(other.especie))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (medida_anilha == null) {
			if (other.medida_anilha != null)
				return false;
		} else if (!medida_anilha.equals(other.medida_anilha))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (numero_anilha == null) {
			if (other.numero_anilha != null)
				return false;
		} else if (!numero_anilha.equals(other.numero_anilha))
			return false;
		if (participacoes == null) {
			if (other.participacoes != null)
				return false;
		} else if (!participacoes.equals(other.participacoes))
			return false;
		return true;
	}
	
	
	
	
}
