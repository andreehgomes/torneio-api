package com.torneioapi.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.torneioapi.model.Ave;
import com.torneioapi.repository.AveRepository;

@RestController
@RequestMapping("/aves")
public class AveResource {

	@Autowired
	private AveRepository aveRepository;
	
	@GetMapping
	public List<Ave> listar(){
		return aveRepository.findAll();
	}
	
}
