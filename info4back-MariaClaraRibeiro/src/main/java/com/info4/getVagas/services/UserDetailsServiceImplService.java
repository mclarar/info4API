package com.info4.getVagas.services;

import java.util.Collections;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.info4.getVagas.entities.Usuario;
import com.info4.getVagas.repositories.UsuarioRepository;

@Service
public class UserDetailsServiceImplService implements UserDetailsService {
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<Usuario> usuario = usuarioRepository.findByEmail(email);

		if (usuario.isPresent()) {
			return usuario.get();
		}

		throw new UsernameNotFoundException("Usuário Não Encontrado");
	}
}
