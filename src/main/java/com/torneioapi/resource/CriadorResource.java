package com.torneioapi.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.torneioapi.model.Criador;
import com.torneioapi.repository.CriadorRepository;

@RestController
@RequestMapping("/criadores")
public class CriadorResource {

	@Autowired
	private CriadorRepository criadorRepository;
	
	@GetMapping
	public List<Criador> listar(){
		return criadorRepository.findAll();
	}
	
}
