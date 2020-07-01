package com.torneioapi.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.NoSuchElementException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.torneioapi.model.Associacao;
import com.torneioapi.repository.AssociacaoRepository;

@Service
public class AssociacaoService {
	
	@Autowired
	private AssociacaoRepository associacaoRepository;
	
	public Associacao incluir(Associacao associacao) {
		Associacao associacaoNova = associacao;
		associacaoNova.setData_cadastro( new Timestamp(System.currentTimeMillis()) );
		return associacao;
	}
	
	public Associacao atualizar(Long codigo, Associacao associacao) {
		Associacao associacaoSalva = buscarAssociacaoPeloCodigo(codigo);
		
		BeanUtils.copyProperties(associacao, associacaoSalva, "id");
		return associacaoRepository.save(associacaoSalva);
	}
	
	private Associacao buscarAssociacaoPeloCodigo(Long codigo) {
		Associacao associacaoSalva = associacaoRepository.findById(codigo).get();
		
		if(associacaoSalva == null) {
			throw new NoSuchElementException();
		}
		
		return associacaoSalva;
	}

}
