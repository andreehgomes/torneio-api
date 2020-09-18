package com.torneioapi.service;

import java.util.NoSuchElementException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.torneioapi.model.Inscricao;
import com.torneioapi.repository.InscricaoRepository;

@Service
public class InscricaoService {

	@Autowired
	private InscricaoRepository inscricaoRepository;

	public Inscricao atualizar(Long codigo, Inscricao inscricao) {
		Inscricao inscricaoSalva = buscarInscricaoPeloCodigo(codigo);

		BeanUtils.copyProperties(inscricao, inscricaoSalva);
		return inscricaoRepository.save(inscricaoSalva);
	}

	public Inscricao buscarInscricaoPeloCodigo(Long codigo) {
		Inscricao inscricaoSalva = inscricaoRepository.findById(codigo).get();

		if (inscricaoSalva == null) {
			throw new NoSuchElementException();
		}

		return inscricaoSalva;
	}

}
