package com.info4.getVagas.services;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.info4.getVagas.entities.Vaga;
import com.info4.getVagas.repositories.VagaRepository;

@Service
public class VagaService {
	@Autowired
	VagaRepository VagaRepository;
	

	
	public List<Vaga> findAll(){
		return VagaRepository.findAll();
	}
	
	public Vaga findById(Integer id) {
		return VagaRepository.findById(id).isPresent() ?
				VagaRepository.findById(id).get() : null;
	}
	
	public Vaga save(Vaga vaga) {
		return VagaRepository.save(vaga);
	}
	
	public Vaga update(Vaga vaga) {
		return VagaRepository.save(vaga);
	}

	
	
	public void delete(Vaga vaga) {
		VagaRepository.delete(vaga);
	}
	
	public void deletePorId(Integer id) {
		VagaRepository.deleteById(id);
	}
	
	
	

}
