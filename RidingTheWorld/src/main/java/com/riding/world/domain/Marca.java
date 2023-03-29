package com.riding.world.domain;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Marca implements Serializable {
		private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy= GenerationType.AUTO)
		private int id;
		private String nombreMarca;
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getNombreMarca() {
			return nombreMarca;
		}
		public void setNombreMarca(String nombreMarca) {
			this.nombreMarca = nombreMarca;
		}

}
