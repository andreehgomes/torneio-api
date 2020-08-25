package com.torneioapi.service;

import java.util.NoSuchElementException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.torneioapi.model.Torneio;
import com.torneioapi.repository.TorneioRepository;

@Service
public class TorneioService {

	@Autowired
	private TorneioRepository torneioRepository;
	
	public Torneio atualizar(Long codigo, Torneio torneio) {
		Torneio torneioSalvo = buscarTorneioPeloCodigo(codigo);
		
		BeanUtils.copyProperties(torneio, torneioSalvo, "id");
		return torneioRepository.save(torneioSalvo);
	}
	
	public Torneio buscarTorneioPeloCodigo(Long codigo) {
		Torneio torneioSalvo = torneioRepository.findById(codigo).get();
		
		if(torneioSalvo == null) {
			throw new NoSuchElementException();
		}
		
		return torneioSalvo;
	}
	
}
