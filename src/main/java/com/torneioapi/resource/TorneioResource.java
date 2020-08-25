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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.torneioapi.event.RecursoCriadoEvent;
import com.torneioapi.model.Torneio;
import com.torneioapi.repository.TorneioRepository;
import com.torneioapi.service.TorneioService;

@RestController
@RequestMapping("/torneios")
public class TorneioResource {

	@Autowired
	private TorneioRepository torneioRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;	
	
	@Autowired
	private TorneioService torneioService;
	
	@GetMapping
	public List<Torneio> listar(){
		return torneioRepository.findAll();
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Torneio> buscarPeloCodigo(@PathVariable Long codigo){
		Optional<Torneio> retorno = torneioRepository.findById(codigo);
		
		return !retorno.isEmpty() ? ResponseEntity.ok(retorno.get()) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<Torneio> incluir(@Valid @RequestBody Torneio torneio, HttpServletResponse response){
		Torneio torneioSalvo = torneioRepository.save(torneio);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, torneioSalvo.getId()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(torneioSalvo);
	}
	
	@PutMapping("/{codigo}")
	public ResponseEntity<Torneio> atualizar(@PathVariable Long codigo, @Valid @RequestBody Torneio torneio){
		Torneio torneioSalvo = torneioService.atualizar(codigo, torneio);
		return ResponseEntity.status(HttpStatus.OK).body(torneioSalvo);
	}
}
