package com.catalogo.domain.DTO;


import java.sql.Timestamp;

import com.catalogo.domain.Actor;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Value;


@Value 
public class ActorDTO {
	
	@NotNull
	private int actorId;

	@NotBlank
	private String firstName;

	@NotBlank
	private String lastName;

	public static ActorDTO from(Actor target) {
		return new ActorDTO(target.getActorId(), target.getFirstName(), target.getLastName());
	}

	public static Actor from(ActorDTO target) {
		return new Actor(
				target.getActorId(), 
				target.getFirstName(), 
				target.getLastName(),
				new Timestamp(System.currentTimeMillis())
				);
				
	}
	

}