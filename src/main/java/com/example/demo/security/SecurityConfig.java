package com.example.demo.security;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		//consulter tous les produits
		http.authorizeRequests().antMatchers("myproject/cinema/all/**").hasAnyAuthority("ADMIN","USER");
		//consulter un produit par son id
		http.authorizeRequests().antMatchers(HttpMethod.GET,"cinema/**").hasAnyAuthority("ADMIN","USER");
		//ajouter un nouveau produit
		http.authorizeRequests().antMatchers(HttpMethod.POST,"/cinema/**").hasAuthority("ADMIN");
		//modifier un produit
		http.authorizeRequests().antMatchers(HttpMethod.PUT,"cinema/delete/**").hasAuthority("ADMIN");
		//supprimer un produit
		http.authorizeRequests().antMatchers(HttpMethod.DELETE,"cinema/**").hasAuthority("ADMIN");
		http.authorizeRequests().anyRequest().authenticated();
		http.addFilterBefore(new JWTAuthorizationFilter(),
		UsernamePasswordAuthenticationFilter.class);
	}
}