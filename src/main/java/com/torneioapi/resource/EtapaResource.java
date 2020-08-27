package com.torneioapi.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.torneioapi.model.Etapa;
import com.torneioapi.repository.EtapaRepository;
import com.torneioapi.service.EtapaService;

@RestController
@RequestMapping("/etapas")
public class EtapaResource {
	
	@Autowired
	private EtapaRepository etapaRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@Autowired
	private EtapaService etapaService;
	
	@GetMapping
	public List<Etapa> listar(){
		return etapaRepository.findAll();
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Etapa> buscarPeloCodigo(@PathVariable Long codigo){
		Optional<Etapa> retorno = etapaRepository.findById(codigo);
		
		return !retorno.isEmpty() ? ResponseEntity.ok(retorno.get()) : ResponseEntity.notFound().build();
	}

}
