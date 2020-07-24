package com.torneioapi.resource;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.torneioapi.event.RecursoCriadoEvent;
import com.torneioapi.model.Criador;
import com.torneioapi.repository.CriadorRepository;
import com.torneioapi.service.CriadorService;

//@CrossOrigin(origins = "*", allowedHeaders = "*", methods = { RequestMethod.PUT, RequestMethod.POST, RequestMethod.GET,
//		RequestMethod.DELETE, RequestMethod.HEAD, RequestMethod.PATCH })
@RestController
@RequestMapping("/criadores")
public class CriadorResource {

	@Autowired
	private CriadorRepository criadorRepository;

	@Autowired
	private CriadorService criadorService;

	@Autowired
	private ApplicationEventPublisher publisher;

	@GetMapping
	public List<Criador> listar() {
		return criadorRepository.findAll();
	}

	@GetMapping("/{cpf}")
	public ResponseEntity<Criador> buscaPeloCpf(@PathVariable String cpf) {
		Optional<Criador> retorno = criadorRepository.findById(cpf);

		return !retorno.isEmpty() ? ResponseEntity.ok(retorno.get()) : ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<Criador> incluir(@Valid @RequestBody Criador criador, HttpServletResponse response) {
		Criador criadorSalvo = criadorRepository.save(criadorService.incluir(criador));

		publisher.publishEvent(new RecursoCriadoEvent(this, response, criadorSalvo.getCpf()));

		return ResponseEntity.status(HttpStatus.CREATED).body(criadorSalvo);
	}

	@PutMapping("/{cpf}")
	public ResponseEntity<Criador> atualizar(@PathVariable String cpf, @Valid @RequestBody Criador criador) {
		Criador criadorSalvo = criadorService.atualizar(cpf, criador);
		return ResponseEntity.status(HttpStatus.OK).body(criadorSalvo);
	}

}
