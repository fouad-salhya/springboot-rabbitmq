package com.reclamation.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	private final RequestFilter jwtFilter = new RequestFilter();

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

		return httpSecurity
				          .csrf(cf -> cf.disable()).cors(c -> c.disable())
				          .authorizeHttpRequests((req) -> req.anyRequest().permitAll())
				          .sessionManagement(s -> s.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				        //  .addFilterBefore(jwtFilter,BasicAuthenticationFilter.class)
				          .build();

	}

}