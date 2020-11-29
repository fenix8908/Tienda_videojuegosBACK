package com.juegos.backend.security.jwt;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import com.juegos.backend.security.entity.UsuarioPrincipal;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtProvider {// clase usada para crear unicamente el token

	private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);

	@Value("${jwt.secret}")
	private String secret;

	@Value("${jwt.expiration}")
	private int expiration;

	// Metodo para generar el token,tipo de algoritmo, expiration y fecha de
	// creación
	public String generatedToken(Authentication authentication) {
		UsuarioPrincipal usuarioPrincipal = (UsuarioPrincipal) authentication.getPrincipal();
		List<String> roles = usuarioPrincipal.getAuthorities().stream().map(GrantedAuthority::getAuthority)
				.collect(Collectors.toList());
		
		return Jwts.builder()
				.setSubject(usuarioPrincipal.getUsername()).setIssuedAt(new Date())
				.claim("roles", roles)
				.setExpiration(new Date(new Date().getTime() + expiration * 1000))
				.signWith(SignatureAlgorithm.HS512, secret.getBytes()).compact();
	}

	public String getNombreUsuarioFromToken(String token) {
		return Jwts.parser().setSigningKey(secret.getBytes()).parseClaimsJws(token).getBody().getSubject();
	}

	public boolean validateToken(String token) {
		try {

			Jwts.parser().setSigningKey(secret.getBytes()).parseClaimsJws(token);
			return true;

		} catch (MalformedJwtException e) {
			logger.error("Token mal formado");
		} catch (UnsupportedJwtException e) {
			logger.error("Token no soportado");
		} catch (ExpiredJwtException e) {
			logger.error("Token ha expirado");
		} catch (IllegalArgumentException e) {
			logger.error("Token vacio");
		} catch (SignatureException e) {
			logger.error("fallo con la firma del token");
		}
		return false;
	}

}
