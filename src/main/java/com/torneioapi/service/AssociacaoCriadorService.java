package com.torneioapi.service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.torneioapi.model.AssociacaoCriador;
import com.torneioapi.repository.AssociacaoCriadorRepository;

@Service
public class AssociacaoCriadorService {

	@Autowired
	private AssociacaoCriadorRepository associacaoCriadorRepository;
	
	public AssociacaoCriador incluir(AssociacaoCriador associaoCriador) {
		AssociacaoCriador associacaoCriadorNova = associaoCriador;
		associacaoCriadorNova.setData(new Date(System.currentTimeMillis()));
		return associacaoCriadorNova;
	}
	
	public AssociacaoCriador atualizar(Long codigo, AssociacaoCriador associacaoCriador) {
		AssociacaoCriador associacaoCriadorSalva = buscarAssociacaoCriadorPeloCodigo(codigo);
		
		BeanUtils.copyProperties(associacaoCriador, associacaoCriadorSalva, "id");
		return associacaoCriadorRepository.save(associacaoCriadorSalva);
	}
	
	private AssociacaoCriador buscarAssociacaoCriadorPeloCodigo(Long codigo) {
		AssociacaoCriador associacaoCriadorSalva = associacaoCriadorRepository.findById(codigo).get();
		
		if(associacaoCriadorSalva == null) {
			throw new NoSuchElementException();
		}
		
		return associacaoCriadorSalva;
	}
	
	public List<AssociacaoCriador> buscarAdminsAtivos(){
		boolean adm = true;
		boolean ativo = true;		
		List<AssociacaoCriador> associacaoCriador = associacaoCriadorRepository.findByAdmAtivo(adm, ativo);
		return associacaoCriador;
	}
	
}
