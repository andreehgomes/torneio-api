package com.torneioapi.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.torneioapi.model.Endereco;
import com.torneioapi.repository.EnderecoRepository;

@RestController
@RequestMapping("/enderecos")
public class EnderecoResource {
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@GetMapping
	public List<Endereco> listar(){
		return enderecoRepository.findAll();
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Endereco> buscarPeloCodigo(@PathVariable Long codigo){
		Optional<Endereco> retorno = enderecoRepository.findById(codigo);
		return !retorno.isEmpty() ? ResponseEntity.ok(retorno.get()) : ResponseEntity.notFound().build();
	}

}
