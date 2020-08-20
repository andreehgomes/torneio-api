package com.torneioapi.service;

import java.util.NoSuchElementException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.torneioapi.model.Temporada;
import com.torneioapi.repository.TemporadaRepository;

@Service
public class TemporadaService {

	@Autowired
	private TemporadaRepository temporadaRepository;
	
	public Temporada atualizar(Long codigo, Temporada temporada) {
		Temporada temporadaSalva = buscarTemporadaPeloCodigo(codigo);
		
		BeanUtils.copyProperties(temporada, temporadaSalva, "id");
		return temporadaRepository.save(temporadaSalva);
	}
	
	private Temporada buscarTemporadaPeloCodigo(Long codigo) {
		Temporada temporadaSalva = temporadaRepository.findById(codigo).get();
		
		if(temporadaSalva == null) {
			throw new NoSuchElementException();
		}
		
		return temporadaSalva;
	}
	
}
