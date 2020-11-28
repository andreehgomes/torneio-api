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
import com.torneioapi.model.AssociacaoCriador;
import com.torneioapi.repository.AssociacaoCriadorRepository;
import com.torneioapi.service.AssociacaoCriadorService;

@RestController
@RequestMapping("/associacao-criador")
public class AssociacaoCriadorResource {
	
	@Autowired
	private AssociacaoCriadorRepository associacaoCriadorRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@Autowired
	private AssociacaoCriadorService associacaoCriadorService;
	
	@GetMapping
	public List<AssociacaoCriador> listar(){
		return associacaoCriadorRepository.findAll();
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<AssociacaoCriador> buscarPeloCodigo(@PathVariable Long codigo){
		Optional<AssociacaoCriador> retorno = associacaoCriadorRepository.findById(codigo);
		
		return !retorno.isEmpty() ? ResponseEntity.ok(retorno.get()) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<AssociacaoCriador> incluir(@Valid @RequestBody AssociacaoCriador associacaoCriador, HttpServletResponse response){
		AssociacaoCriador associacaoCriadorSalvo = associacaoCriadorRepository.save(associacaoCriadorService.incluir(associacaoCriador));
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, associacaoCriadorSalvo.getId()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(associacaoCriadorSalvo);
	}
	
	@PutMapping("/{codigo}")
	public ResponseEntity<AssociacaoCriador> atualizar(@PathVariable Long codigo, @Valid @RequestBody AssociacaoCriador associacaoCriador){
		AssociacaoCriador associacaoCriadorSalvo = associacaoCriadorService.atualizar(codigo, associacaoCriador);
		return ResponseEntity.status(HttpStatus.OK).body(associacaoCriadorSalvo);
	}
	
	@GetMapping("/adm/ativo")
	public List<AssociacaoCriador> buscar(){
		return associacaoCriadorRepository.findByAdmTrueAndAtivoTrue();
	}
	
	@GetMapping("/admins")
	public List<AssociacaoCriador> buscarAdminsAtivos(){
		return associacaoCriadorRepository.findAllAdmAtivos();
	}
	
	@GetMapping("/admins-ativos")
	public List<AssociacaoCriador> buscarAdminsAtivosSegundo(){
		return associacaoCriadorService.buscarAdminsAtivos();
	}

}
