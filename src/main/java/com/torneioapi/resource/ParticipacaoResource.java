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
import com.torneioapi.model.Participacao;
import com.torneioapi.repository.ParticipacaoRepository;
import com.torneioapi.service.ParticipacaoService;

@RestController
@RequestMapping("/participacoes")
public class ParticipacaoResource {
	
	@Autowired
	private ParticipacaoRepository participacaoRepository;
	
	@Autowired
	private ParticipacaoService participacaoService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	public List<Participacao> listar() {
		return participacaoRepository.findAll();
	}
	
	@RequestMapping("/{codigo}")
	public ResponseEntity<Participacao> buscarPeloCodigo(@PathVariable Long codigo){
		Optional<Participacao> retorno = participacaoRepository.findById(codigo);
		
		return !retorno.isEmpty() ? ResponseEntity.ok(retorno.get()) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<Participacao> incluir(@Valid @RequestBody Participacao participacao, HttpServletResponse response){
		Participacao participacaoSalva = participacaoRepository.save(participacao);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, participacaoSalva.getId()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(participacaoSalva);
	}
	
	@PutMapping
	public ResponseEntity<Participacao> atualizar (@PathVariable Long codigo, @Valid @RequestBody Participacao participacao){
		Participacao participacaoSalva = participacaoService.atualizar(codigo, participacao);
		return ResponseEntity.status(HttpStatus.OK).body(participacaoSalva);
	}

}
