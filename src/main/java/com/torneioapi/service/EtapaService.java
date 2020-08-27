package com.torneioapi.service;

import java.util.NoSuchElementException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.BeanDefinitionDsl.BeanSupplierContext;
import org.springframework.stereotype.Service;

import com.torneioapi.model.Etapa;
import com.torneioapi.repository.EtapaRepository;

@Service
public class EtapaService {
	
	@Autowired	
	private EtapaRepository etapaRepository;
	
	public Etapa atualizar(Long codigo, Etapa etapa) {
		Etapa etapaSalvo = buscarEtapaPeloCodigo(codigo);
		
		BeanUtils.copyProperties(etapa, etapaSalvo, "id");
		return etapaRepository.save(etapaSalvo);
	}
	
	public Etapa buscarEtapaPeloCodigo(Long codigo) {
		Etapa etapaSalvo = etapaRepository.findById(codigo).get();
		
		if(etapaSalvo == null) {
			throw new NoSuchElementException();
		}
		
		return etapaSalvo;
	}

}
