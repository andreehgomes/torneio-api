package com.torneioapi.resource;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.torneioapi.event.RecursoCriadoEvent;
import com.torneioapi.model.Temporada;
import com.torneioapi.repository.TemporadaRepository;

@RestController
@RequestMapping("/temporadas")
public class TemporadaResource {

	@Autowired
	private TemporadaRepository temporadaRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;

	@GetMapping
	public List<Temporada> listar() {
		return temporadaRepository.findAll();
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Temporada> buscarPeloCodigo(@PathVariable Long codigo){
		Optional<Temporada> retorno = temporadaRepository.findById(codigo);
		
		return !retorno.isEmpty() ? ResponseEntity.ok(retorno.get()) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<Temporada> incluir(@Valid @RequestBody Temporada temporada, HttpServletResponse response){
		Temporada temporadaSalva = temporadaRepository.save(temporada);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, temporadaSalva.getId()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(temporadaSalva);
	}

}













