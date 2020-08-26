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
	
}
