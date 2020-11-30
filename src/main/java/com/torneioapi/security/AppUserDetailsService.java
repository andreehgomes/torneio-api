package com.torneioapi.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.torneioapi.model.Criador;
import com.torneioapi.repository.CriadorRepository;

@Service
public class AppUserDetailsService implements UserDetailsService {

	@Autowired
	private CriadorRepository criadorRepository;
	
	@Override
	public UserDetails loadUserByUsername(String cpf) throws UsernameNotFoundException {
		Optional<Criador> criadorOptional = criadorRepository.findById(cpf);
		Criador criador = criadorOptional.orElseThrow(() -> new UsernameNotFoundException("Usuário e/ou senha incorretos"));
		return new User(cpf, criador.getSenha(), getPermissoes(criador));
	}

	private Collection<? extends GrantedAuthority> getPermissoes(Criador criador) {
		Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		
		criador.getPermissoes().forEach(p -> authorities.add(new SimpleGrantedAuthority(p.getDescricao().toUpperCase())));
		return authorities;
	}
	
	

}
