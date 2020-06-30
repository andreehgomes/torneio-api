package com.torneioapi.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.torneioapi.model.Associacao;
import com.torneioapi.repository.AssociacaoRepository;

@RestController
@RequestMapping("/associacao")
public class AssociacaoResource {

	@Autowired
	private AssociacaoRepository associacaoRepository;

	@GetMapping
	public List<Associacao> listar() {
		return associacaoRepository.findAll();
	}

}
