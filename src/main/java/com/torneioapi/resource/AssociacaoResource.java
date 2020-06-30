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
import com.torneioapi.model.Associacao;
import com.torneioapi.repository.AssociacaoRepository;

@RestController
@RequestMapping("/associacao")
public class AssociacaoResource {

	@Autowired
	private AssociacaoRepository associacaoRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;

	@GetMapping
	public List<Associacao> listar() {
		return associacaoRepository.findAll();
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<Associacao> buscarPeloCodigo(@PathVariable Long codigo) {
		Optional<Associacao> retorno = associacaoRepository.findById(codigo);

		return !retorno.isEmpty() ? ResponseEntity.ok(retorno.get()) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<Associacao> incluir (@Valid @RequestBody Associacao associacao, HttpServletResponse response){
		Associacao associacaoSalva = associacaoRepository.save(associacao);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, associacaoSalva.getId()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(associacaoSalva);
	}

}
