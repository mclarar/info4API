package com.info4.getVagas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.info4.getVagas.entities.Vaga;
import com.info4.getVagas.exceptions.NoSuchElementFoundException;
import com.info4.getVagas.services.VagaService;



@RestController
@RequestMapping("/vaga")
@Validated 
public class VagaController {
	@Autowired
	VagaService VagaService;
	
	
	
	@GetMapping
	public ResponseEntity<List<Vaga>> findAll(){
		List<Vaga> vagaList = VagaService.findAll();
		return new ResponseEntity<>(VagaService.findAll(), HttpStatus.OK);
		
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Vaga> findById(@PathVariable Integer id) {
		Vaga vaga = VagaService.findById(id);
		if(null == vaga)
			throw new NoSuchElementFoundException("ih! não foi encontrado o " + id + " tem certeza que ele existe?");
		else
			return new ResponseEntity<>(VagaService.findById(id), HttpStatus.OK);
	}
	
	 @PostMapping("/criarVaga")
	    public ResponseEntity<Vaga> save(@RequestBody Vaga vaga){
	        return new ResponseEntity<> (VagaService.save(vaga), HttpStatus.CREATED);
	    }
	 

	 
	  @PutMapping
	    ResponseEntity<Vaga> update(@RequestBody Vaga vaga) {
	    	return new ResponseEntity<>(VagaService.update (vaga), HttpStatus.OK);
	  }

	  
	  @DeleteMapping("/{id}")
	    public ResponseEntity<String> deletePorId(@PathVariable Integer id){
		  Vaga vaga = VagaService.findById(id);
			if(null == vaga)
				throw new NoSuchElementFoundException("Não tem como deletar algo que não existe. Tente outro id");
			else
		  
		  
		  VagaService.deletePorId(id);
		  
	      return new ResponseEntity<>("", HttpStatus.OK);
	    }
}