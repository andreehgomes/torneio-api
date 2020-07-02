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
import com.torneioapi.model.Endereco;
import com.torneioapi.repository.EnderecoRepository;
import com.torneioapi.service.EnderecoService;

@RestController
@RequestMapping("/enderecos")
public class EnderecoResource {
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private EnderecoService enderecoService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	public List<Endereco> listar(){
		return enderecoRepository.findAll();
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Endereco> buscarPeloCodigo(@PathVariable Long codigo){
		Optional<Endereco> retorno = enderecoRepository.findById(codigo);
		return !retorno.isEmpty() ? ResponseEntity.ok(retorno.get()) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<Endereco> incluir(@Valid @RequestBody Endereco endereco, HttpServletResponse response){
		Endereco enderecoSalvo = enderecoRepository.save(endereco);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, enderecoSalvo.getId()));
		
		return ResponseEntity.status(HttpStatus.OK).body(enderecoSalvo);
	}
	
	@PutMapping("/{codigo}")
	public ResponseEntity<Endereco> atualizar(@PathVariable Long codigo, @Valid @RequestBody Endereco endereco){
		Endereco enderecoSalvo = enderecoService.atualizar(codigo, endereco);
		return ResponseEntity.status(HttpStatus.OK).body(enderecoSalvo);
	}

}
