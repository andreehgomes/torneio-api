package com.torneioapi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
<<<<<<< HEAD
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
=======
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
>>>>>>> 7e63d9755112d1d0697f5b39d01b00c5dcf1f828
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
<<<<<<< HEAD
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		clients.inMemory()
			.withClient("torneio")
			.secret(passwordEncoder.encode("torneio"))
			.scopes("read", "write")
			.authorizedGrantTypes("password")
			.accessTokenValiditySeconds(9000);
=======
		clients.inMemory()
			.withClient("angular")
			.secret("angular")
			.scopes("read", "wirte")
			.authorizedGrantTypes("passord")
			.accessTokenValiditySeconds(1800);
>>>>>>> 7e63d9755112d1d0697f5b39d01b00c5dcf1f828
	}
	
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints
			.tokenStore(tokenStore())
			.authenticationManager(authenticationManager);
	}
	
	@Bean
	public TokenStore tokenStore() {
		return new InMemoryTokenStore();
	}
	
<<<<<<< HEAD
=======
	@Bean 
	public AuthenticationManager anthenticationManager() {
		return new AuthenticationManager() {
			
			@Override
			public Authentication authenticate(Authentication authentication) throws AuthenticationException {
				// TODO Auto-generated method stub
				return null;
			}
		};
	}
	
>>>>>>> 7e63d9755112d1d0697f5b39d01b00c5dcf1f828
}
