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
	
	@PostMapping
	public ResponseEntity<Etapa> incluir(@Valid @RequestBody Etapa etapa, HttpServletResponse response){
		Etapa etapaSalvo = etapaRepository.save(etapa);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, etapaSalvo.getId()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(etapaSalvo);
	}
	
	@PutMapping("/{codigo}")
	public ResponseEntity<Etapa> atualizar(@PathVariable Long codigo, @Valid @RequestBody Etapa etapa){
		Etapa etapaSalvo = etapaService.atualizar(codigo, etapa);
		return ResponseEntity.status(HttpStatus.OK).body(etapaSalvo);
	}
}
