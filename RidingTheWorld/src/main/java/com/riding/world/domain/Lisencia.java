package com.riding.world.domain;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Lisencia implements Serializable {

	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	private String nombreLisencia;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombreLisencia() {
		return nombreLisencia;
	}
	public void setNombreLisencia(String nombreLisencia) {
		this.nombreLisencia = nombreLisencia;
	}
}
