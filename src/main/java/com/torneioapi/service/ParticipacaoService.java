package com.torneioapi.service;

import java.util.NoSuchElementException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.torneioapi.model.Participacao;
import com.torneioapi.repository.ParticipacaoRepository;

@Service
public class ParticipacaoService {
	
	@Autowired
	private ParticipacaoRepository participacaoRepository;
	
	public Participacao atualizar (Long codigo, Participacao participacao) {
		Participacao participacaoSalva = buscarParticipacaoPeloCodigo(codigo);
		
		BeanUtils.copyProperties(participacao, participacaoSalva);
		return participacaoRepository.save(participacaoSalva);
	}
	
	public Participacao buscarParticipacaoPeloCodigo(Long codigo) {
		Participacao participacaoRetorno = participacaoRepository.findById(codigo).get();
		
		if(participacaoRetorno == null) {
			throw new NoSuchElementException();
		}
		
		return participacaoRetorno;
	}

}
