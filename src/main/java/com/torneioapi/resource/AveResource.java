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
import com.torneioapi.model.Ave;
import com.torneioapi.repository.AveRepository;
import com.torneioapi.service.AveService;

@RestController
@RequestMapping("/aves")
public class AveResource {

	@Autowired
	private AveRepository aveRepository;

	@Autowired
	private AveService aveService;

	@Autowired
	ApplicationEventPublisher publisher;

	@GetMapping
	public List<Ave> listar() {
		return aveRepository.findAll();
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<Ave> buscarAvePeloCodigo(@PathVariable Long codigo) {
		Optional<Ave> retorno = aveRepository.findById(codigo);
		return !retorno.isEmpty() ? ResponseEntity.ok(retorno.get()) : ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<Ave> incluir(@Valid @RequestBody Ave ave, HttpServletResponse response) {
		Ave aveSalva = aveRepository.save(aveService.incluir(ave));

		publisher.publishEvent(new RecursoCriadoEvent(this, response, aveSalva.getId()));

		return ResponseEntity.status(HttpStatus.CREATED).body(aveSalva);

	}
	
	@PutMapping("/{codigo")
	public ResponseEntity<Ave> atualizar(@PathVariable Long codigo, @Valid @RequestBody Ave ave){
		Ave aveSalva = aveService.atualizar(codigo, ave);
		return ResponseEntity.status(HttpStatus.OK).body(aveSalva);
	}
}
