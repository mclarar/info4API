package com.info4.getVagas.security;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.info4.getVagas.entities.Usuario;
import com.info4.getVagas.repositories.UsuarioRepository;
import com.info4.getVagas.services.TokenService;

public class TokenAuthenticationFilter extends OncePerRequestFilter {
	
	private final TokenService tokenService;
	private final UsuarioRepository repository;
	
	public TokenAuthenticationFilter(TokenService tokenService, UsuarioRepository repository) {
		this.tokenService = tokenService;
		this.repository = repository;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String tokenFromHeader = getTokenFromHeader(request);
		boolean tokenValid = tokenService.isTokenValid(tokenFromHeader);
		if(tokenValid) {
			this.authenticate(tokenFromHeader);
		}

		filterChain.doFilter(request, response);
	}

	private void authenticate(String tokenFromHeader) {
		Integer id = tokenService.getTokenId(tokenFromHeader);

		Optional<Usuario> optionalUser = repository.findById(id);

		if (optionalUser.isPresent()) {

			Usuario user = optionalUser.get();

			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
					user, null, user.getPerfis());
			SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
		}
	}

	private String getTokenFromHeader(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		if (token == null || token.isEmpty() || !token.startsWith("Bearer ")) {
			return null;
		}

		return token.substring(7, token.length());
	}

}
