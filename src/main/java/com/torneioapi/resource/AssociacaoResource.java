package com.torneioapi.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.torneioapi.model.Associacao;
import com.torneioapi.repository.AssociacaoRepository;

@RestController
@RequestMapping("/associacao")
public class AssociacaoResource {

	@Autowired
	private AssociacaoRepository associacaoRepository;

	@GetMapping
	public List<Associacao> listar() {
		return associacaoRepository.findAll();
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<Associacao> buscarPeloCodigo(@PathVariable Long codigo) {
		Optional<Associacao> retorno = associacaoRepository.findById(codigo);

		return !retorno.isEmpty() ? ResponseEntity.ok(retorno.get()) : ResponseEntity.notFound().build();
	}

}
