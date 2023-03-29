package com.riding.world.domain;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Lisencia implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public Lisencia() {
	}
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	
	@NotBlank
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
	public Lisencia(int id,  String nombreLisencia) {
		super();
		this.id = id;
		this.nombreLisencia = nombreLisencia;
	}
	
	
}
