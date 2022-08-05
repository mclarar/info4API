package com.info4.getVagas.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.info4.getVagas.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	Optional<Usuario> findByEmail(String email);
}
