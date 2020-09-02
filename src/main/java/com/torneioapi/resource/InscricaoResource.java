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
import com.torneioapi.model.Inscricao;
import com.torneioapi.repository.InscricaoRepository;

@RestController
@RequestMapping("/inscricoes")
public class InscricaoResource {

	@Autowired
	private InscricaoRepository inscricaoRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;

	@GetMapping
	public List<Inscricao> listar() {
		return inscricaoRepository.findAll();
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<Inscricao> buscarPeloCodigo(@PathVariable Long codigo) {
		Optional<Inscricao> retorno = inscricaoRepository.findById(codigo);

		return !retorno.isEmpty() ? ResponseEntity.ok(retorno.get()) : ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<Inscricao> incluir(@Valid @RequestBody Inscricao inscricao, HttpServletResponse response){
		Inscricao inscricaoSalva = inscricaoRepository.save(inscricao);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, inscricaoSalva.getId()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(inscricaoSalva);
	}
}
