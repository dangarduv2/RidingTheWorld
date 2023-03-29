package com.riding.world.domain;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Bike implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	private Marca marca;
	private int cc;
	private Lisencia lisencia;
	private String nombreModelo;

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

}
