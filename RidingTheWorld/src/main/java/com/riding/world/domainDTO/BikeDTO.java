package com.riding.world.domainDTO;

import com.riding.world.domain.Bike;
import com.riding.world.domain.Lisencia;
import com.riding.world.domain.Marca;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class BikeDTO {

	private Marca marca;
	private int cc;
	private Lisencia lisencia;
	private String nombreModelo;
	
	public static BikeDTO from(Bike target) {
		return new BikeDTO(target.getMarca(), target.getCc(), target.getLisencia(), target.getNombreModelo());
	}
	
	public static Bike from(BikeDTO target) {
		return new Bike(target.getMarca(), target.getCc(), target.getLisencia(), target.getNombreModelo());
	}
}
