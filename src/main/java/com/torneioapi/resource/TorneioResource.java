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

import com.torneioapi.model.Torneio;
import com.torneioapi.repository.TorneioRepository;

@RestController
@RequestMapping("/torneios")
public class TorneioResource {

	@Autowired
	private TorneioRepository torneioRepository;
	
	private ApplicationEventPublisher publisher;	
	
	@GetMapping
	public List<Torneio> listar(){
		return torneioRepository.findAll();
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Torneio> buscarPeloCodigo(@PathVariable Long codigo){
		Optional<Torneio> retorno = torneioRepository.findById(codigo);
		
		return !retorno.isEmpty() ? ResponseEntity.ok(retorno.get()) : ResponseEntity.notFound().build();
	}
}
