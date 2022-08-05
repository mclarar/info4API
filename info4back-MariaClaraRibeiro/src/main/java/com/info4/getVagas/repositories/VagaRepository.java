package com.info4.getVagas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.info4.getVagas.entities.Vaga;

public interface VagaRepository extends JpaRepository<Vaga, Integer> {

}