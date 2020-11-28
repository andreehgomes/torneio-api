<<<<<<< HEAD
 package com.torneioapi.config;
=======
package com.torneioapi.config;
>>>>>>> 7e63d9755112d1d0697f5b39d01b00c5dcf1f828

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
<<<<<<< HEAD
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
=======
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
>>>>>>> 7e63d9755112d1d0697f5b39d01b00c5dcf1f828
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

<<<<<<< HEAD
=======
import com.torneioapi.service.CriadorUserDetailService;

>>>>>>> 7e63d9755112d1d0697f5b39d01b00c5dcf1f828
@EnableWebSecurity
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	@Autowired
<<<<<<< HEAD
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		auth.inMemoryAuthentication()
			.withUser("admin").password(passwordEncoder.encode("admin")).roles("ROLE");
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
=======
	private CriadorUserDetailService CriadorUserDetailService;		
	
	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(CriadorUserDetailService).passwordEncoder(new BCryptPasswordEncoder());
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {		
>>>>>>> 7e63d9755112d1d0697f5b39d01b00c5dcf1f828
		http.authorizeRequests()
			.anyRequest().authenticated()
			.and()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
			.csrf().disable();
	}
	
	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.stateless(true);
	}
<<<<<<< HEAD
=======

>>>>>>> 7e63d9755112d1d0697f5b39d01b00c5dcf1f828
}
