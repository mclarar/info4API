package com.info4.getVagas.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "vaga")
@JsonIdentityInfo(scope = Vaga.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "idVaga")
public class Vaga {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_vaga")
	
	private Integer idVaga;
	
	@Column(name = "empresa")
	private String empresa;

	@NotBlank(message = "O cargo não pode estar em branco")
	@Column(name = "cargo_vaga")
	private String cargoVaga;

	@Column(name = "localidade")
	private String localidade;
	
	@Column(name = "salario")
	private String salario;
	
	@Column(name = "hora_trabalho")
	private String horaTrabalho;

	public Integer getIdVaga() {
		return idVaga;
	}

	public void setIdVaga(Integer idVaga) {
		this.idVaga = idVaga;
	}

	public String getCargoVaga() {
		return cargoVaga;
	}

	public void setCargoVaga(String cargoVaga) {
		this.cargoVaga = cargoVaga;
	}

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public String getSalario() {
		return salario;
	}

	public void setSalario(String salario) {
		this.salario = salario;
	}

	public String getHoraTrabalho() {
		return horaTrabalho;
	}

	public void setHoraTrabalho(String horaTrabalho) {
		this.horaTrabalho = horaTrabalho;
	}




	

	

}