package com.info4.getVagas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.info4.getVagas.dtos.TokenDTO;
import com.info4.getVagas.entities.Usuario;
import com.info4.getVagas.services.TokenService;

@RestController
@RequestMapping("/autenticacao")
public class AutenticacaoController {
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private TokenService tokenService;
	
	@PostMapping
	public ResponseEntity<TokenDTO> auth(@RequestBody Usuario usuario){
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = 
				new UsernamePasswordAuthenticationToken(usuario.getEmail(), usuario.getSenha());
		
		Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
		
		String token = tokenService.generateToken(authentication);

		TokenDTO tokenDTO = new TokenDTO("Bearer", token);
		return new ResponseEntity<>(tokenDTO, HttpStatus.OK);
	}
	
}
