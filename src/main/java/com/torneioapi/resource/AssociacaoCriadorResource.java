package com.torneioapi.resource;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.torneioapi.model.AssociacaoCriador;
import com.torneioapi.repository.AssociacaoCriadorRepository;

@RestController
@RequestMapping("/associacao-criador")
public class AssociacaoCriadorResource {
	
	@Autowired
	private AssociacaoCriadorRepository associacaoCriadorRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	public List<AssociacaoCriador> listar(){
		return associacaoCriadorRepository.findAll();
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<AssociacaoCriador> buscarPeloCodigo(@PathVariable Long codigo){
		Optional<AssociacaoCriador> retorno = associacaoCriadorRepository.findById(codigo);
		
		return !retorno.isEmpty() ? ResponseEntity.ok(retorno.get()) : ResponseEntity.notFound().build();
	}	

}
