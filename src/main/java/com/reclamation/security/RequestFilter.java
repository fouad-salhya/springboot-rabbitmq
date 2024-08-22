package com.reclamation.security;

import java.io.IOException;
import java.util.Date;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class RequestFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 

	private static final String SECRET_KEY = "sL2xtKbCmK8G5+QwDkj+9zPdLbQlDTKvHg7u9aQY93k=";

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkIjoiYjI0M2Q0NjEtMTUyOC00OGVhLWJmMDItOTA2OWRmZWVkMDI4Iiwicm9sZSI6IkFETUlOIiwiaWF0IjoxNzIzNzgyOTk0LCJleHAiOjE3MjM3ODY1OTR9.8cRKyzjQ7hfSCivoNW8mQ5JaaCkRjVEQttuhBjdtM7Q";

		if (token != null) {
			if (isTokenExpired(token)) {
				response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				return;
			}

			else {
				filterChain.doFilter(request, response);
				return;
			}

		}
	}

	public String extractUsername(String jwt) {

		return extractClaim(jwt, Claims::getSubject);

	}

	public boolean isTokenExpired(String token) {
		return extractExpiration(token).before(new Date());
	}

	private Date extractExpiration(String token) {
		return extractClaim(token, Claims::getExpiration);
	}

	public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {

		final Claims claims = extractAllClaims(token);
		return claimsResolver.apply(claims);
	}

	private Claims extractAllClaims(String token) {

		return Jwts
				  .parser()
				  .verifyWith(getSignKey())
				  .build()
				  .parseSignedClaims(token)
				  .getPayload();
	}

	private SecretKey getSignKey() {

		byte[] KeyBytes = Decoders.BASE64.decode(SECRET_KEY);
		return Keys.hmacShaKeyFor(KeyBytes);
	}
	
		 */

}
