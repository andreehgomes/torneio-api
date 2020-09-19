package com.torneioapi.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.torneioapi.model.Participacao;
import com.torneioapi.repository.ParticipacaoRepository;

@RestController
@RequestMapping("/participacoes")
public class ParticipacaoResource {
	
	@Autowired
	private ParticipacaoRepository participacaoRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	public List<Participacao> listar() {
		return participacaoRepository.findAll();
	}

}
