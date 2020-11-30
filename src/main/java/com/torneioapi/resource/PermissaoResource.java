package com.torneioapi.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.torneioapi.repository.PermissaoRepository;

@RestController
@RequestMapping("/permissoes")
public class PermissaoResource {

	@Autowired
	private PermissaoRepository permissaoRepository;
	
	@Autowired
	ApplicationEventPublisher publisher;
	
	
}
