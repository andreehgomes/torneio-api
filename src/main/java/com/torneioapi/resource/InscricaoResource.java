package com.torneioapi.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.torneioapi.model.Inscricao;
import com.torneioapi.repository.InscricaoRepository;

@RestController
@RequestMapping("/inscricoes")
public class InscricaoResource {

	@Autowired
	private InscricaoRepository inscricaoRepository;

	@GetMapping
	public List<Inscricao> listar() {
		return inscricaoRepository.findAll();
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<Inscricao> buscarPeloCodigo(@PathVariable Long codigo) {
		Optional<Inscricao> retorno = inscricaoRepository.findById(codigo);

		return !retorno.isEmpty() ? ResponseEntity.ok(retorno.get()) : ResponseEntity.notFound().build();
	}

}
