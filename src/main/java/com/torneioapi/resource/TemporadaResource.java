package com.torneioapi.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.torneioapi.model.Temporada;
import com.torneioapi.repository.TemporadaRepository;

@RestController
@RequestMapping("/temporadas")
public class TemporadaResource {

	@Autowired
	private TemporadaRepository temporadaRepository;

	@GetMapping
	public List<Temporada> listar() {
		return temporadaRepository.findAll();
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Temporada> buscarPeloCodigo(@PathVariable Long codigo){
		Optional<Temporada> retorno = temporadaRepository.findById(codigo);
		
		return !retorno.isEmpty() ? ResponseEntity.ok(retorno.get()) : ResponseEntity.notFound().build();
	}

}
