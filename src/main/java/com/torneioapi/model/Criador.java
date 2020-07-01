package com.torneioapi.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

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
	/* private Long fk_id_associacao; */
	@ManyToOne
	@JoinColumn(name = "fk_id_associacao")
	private Associacao associacao;
	private Long fk_id_endereco;
	private Timestamp data_cadastro;

}
