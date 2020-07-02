package com.torneioapi.service;

import java.sql.Timestamp;
import java.util.NoSuchElementException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.torneioapi.model.Ave;
import com.torneioapi.repository.AveRepository;

@Service
public class AveService {

	@Autowired
	private AveRepository aveRepository;
	
	
	public Ave incluir(Ave ave) {
		Ave aveSalva = ave;
		aveSalva.setData_cadastro(new Timestamp(System.currentTimeMillis()));
		return aveSalva;
	}
	
	public Ave atualizar(Long codigo, Ave ave) {
		Ave aveSalva = buscarAvePeloCodigo(codigo);
		
		BeanUtils.copyProperties(ave, aveSalva, "id");
		return aveRepository.save(aveSalva);
	}
	
	private Ave buscarAvePeloCodigo(Long codigo) {
		Ave aveSalva = aveRepository.findById(codigo).get();
		
		if(aveSalva == null) {
			throw new NoSuchElementException();
		}
		
		return aveSalva;
	}
}
