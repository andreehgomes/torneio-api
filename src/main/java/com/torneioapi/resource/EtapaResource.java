package com.torneioapi.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.torneioapi.model.Etapa;
import com.torneioapi.repository.EtapaRepository;

@RestController
@RequestMapping("/etapas")
public class EtapaResource {
	
	@Autowired
	private EtapaRepository etapaRepository;
	
	@GetMapping
	public List<Etapa> listar(){
		return etapaRepository.findAll();
	}

}
