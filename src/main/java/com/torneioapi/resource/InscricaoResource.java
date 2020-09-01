package com.torneioapi.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.torneioapi.model.Inscricao;
import com.torneioapi.repository.InscricaoRepository;

@RestController
@RequestMapping("/incricoes")
public class InscricaoResource {

	@Autowired
	private InscricaoRepository inscricaoRepository;
	
	@GetMapping
	public List<Inscricao> listar(){
		return inscricaoRepository.findAll();
	}
	
}
