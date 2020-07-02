package com.torneioapi.service;

import java.util.NoSuchElementException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.torneioapi.model.Endereco;
import com.torneioapi.repository.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public Endereco atualizar(Long codigo, Endereco endereco) {
		Endereco enderecoSalvo = buscaEnderecoPeloCodigo(codigo);
		
		BeanUtils.copyProperties(endereco, enderecoSalvo, "id");
		return enderecoRepository.save(enderecoSalvo);
	}
	
	private Endereco buscaEnderecoPeloCodigo(Long codigo) {
		Endereco enderecoSalvo = enderecoRepository.findById(codigo).get();
		
		if(enderecoSalvo == null) {
			throw new NoSuchElementException();
		}
		
		return enderecoSalvo;
	}
}
