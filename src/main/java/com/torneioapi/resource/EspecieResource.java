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
import com.torneioapi.model.Especie;
import com.torneioapi.repository.EspecieRepository;
import com.torneioapi.service.EspecieService;

@CrossOrigin(origins = "*", allowedHeaders = "*", methods = { RequestMethod.PUT, RequestMethod.POST, RequestMethod.GET,
		RequestMethod.DELETE, RequestMethod.HEAD, RequestMethod.PATCH })
@RestController
@RequestMapping("/especies")
public class EspecieResource {

	@Autowired
	private EspecieRepository especieRepository;

	@Autowired
	private EspecieService especieService;

	@Autowired
	private ApplicationEventPublisher publisher;

	@GetMapping
	public List<Especie> listar() {
		return especieRepository.findAll();
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<Especie> buscarPeloCodigo(@PathVariable Long codigo) {
		Optional<Especie> retorno = especieRepository.findById(codigo);

		return !retorno.isEmpty() ? ResponseEntity.ok(retorno.get()) : ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<Especie> incluir(@Valid @RequestBody Especie especie, HttpServletResponse response) {
		Especie especieSalva = especieRepository.save(especie);

		publisher.publishEvent(new RecursoCriadoEvent(this, response, especieSalva.getId()));

		return ResponseEntity.status(HttpStatus.CREATED).body(especieSalva);
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<Especie> atualizar(@PathVariable Long codigo, @Valid @RequestBody Especie especie) {
		Especie especieSalva = especieService.atualizar(codigo, especie);
		return ResponseEntity.status(HttpStatus.OK).body(especieSalva);
	}
}
