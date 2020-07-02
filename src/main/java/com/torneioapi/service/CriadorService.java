package com.torneioapi.service;

import java.sql.Timestamp;
import java.util.NoSuchElementException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.torneioapi.model.Criador;
import com.torneioapi.repository.CriadorRepository;

@Service
public class CriadorService {

	@Autowired
	private CriadorRepository criadorRepository;
	
	public Criador incluir(Criador criador) {
		Criador criadorSalvo = criador;
		criadorSalvo.setData_cadastro(new Timestamp(System.currentTimeMillis()));
		return criadorSalvo;
	}
	
	public Criador atualizar(String cpf, Criador criador) {
		Criador criadorSalvo = buscarCriadorPeloCpf(cpf);
		
		BeanUtils.copyProperties(criador, criadorSalvo, "cpf");
		return criadorRepository.save(criadorSalvo);
	}
	
	private Criador buscarCriadorPeloCpf(String cpf) {
		Criador criadorSalvo = criadorRepository.findById(cpf).get();
		
		if(criadorSalvo == null) {
			throw new NoSuchElementException();
		}
		
		return criadorSalvo;
	}
}
