package com.torneioapi.service;

import java.util.NoSuchElementException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.torneioapi.model.Especie;
import com.torneioapi.repository.EspecieRepository;

@Service
public class EspecieService {
	
	@Autowired
	private EspecieRepository especieRepository;
	
	public Especie atualizar(Long codigo, Especie especie) {
		Especie especieSalva = buscarEspeciePeloCodigo(codigo);
		
		BeanUtils.copyProperties(especie, especieSalva, "id");
		return especieRepository.save(especieSalva);
	}

	private Especie buscarEspeciePeloCodigo(Long codigo) {
		Especie especieSalva = especieRepository.findById(codigo).get();
		
		if(especieSalva == null) {
			throw new NoSuchElementException();
		}
		
		return especieSalva;
	}
	
}
