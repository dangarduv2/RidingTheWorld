package com.riding.world.domain;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
public class Bike implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	
	
	private Marca marca;
	
	@NotNull
	@Max(1500)
	private int cc;
	
	
	private Lisencia lisencia;
	
	@NotBlank
	@Pattern(regexp="[A-Z]+", message="Tiene que estar en mayúsculas")
	private String nombreModelo;

	public Bike() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCc() {
		return cc;
	}


	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public Lisencia getLisencia() {
		return lisencia;
	}

	public void setLisencia(Lisencia lisencia) {
		this.lisencia = lisencia;
	}

	public void setCc(int cc) {
		this.cc = cc;
	}

	public String getNombreModelo() {
		return nombreModelo;
	}

	public void setNombreModelo(String modelo) {
		this.nombreModelo = modelo;
	}

	
	
	public Bike(Marca marca,int cc, Lisencia lisencia,String nombreModelo) {
		this.marca = marca;
		this.cc = cc;
		this.lisencia = lisencia;
		this.nombreModelo = nombreModelo;
	}

	@Override
	public String toString() {
		return "Bike [id=" + id + ", marca=" + marca + ", cc=" + cc + ", lisencia=" + lisencia + ", nombreModelo="
				+ nombreModelo + "]";
	}
	
		

}
