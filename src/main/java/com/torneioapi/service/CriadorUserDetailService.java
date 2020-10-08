package com.torneioapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.torneioapi.model.Criador;
import com.torneioapi.repository.CriadorRepository;

@Component
public class CriadorUserDetailService implements UserDetailsService {

	private final CriadorRepository criadorRepository;
	
	@Autowired
	public CriadorUserDetailService(CriadorRepository criadorRepository) {
		this.criadorRepository = criadorRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String cpf) throws UsernameNotFoundException {
		Criador criador = Optional.ofNullable(criadorRepository.findByCpf(cpf))
				.orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
		
		List<GrantedAuthority> authorityListAdmin = AuthorityUtils.createAuthorityList("ROLE_USER", "ROLE_ADMIN");
//		List<GrantedAuthority> authorityListUser = AuthorityUtils.createAuthorityList("ROLE_USER");
		
		return new User(criador.getCpf(), criador.getPassword(), authorityListAdmin);
	}

}
