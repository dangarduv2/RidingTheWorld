package com.catalogo.domain.DTO;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.Value;

import java.sql.Timestamp;
import java.util.List;

import com.catalogo.domain.Film;
import com.catalogo.domain.Language;
import com.fasterxml.jackson.annotation.JsonProperty;


@Value
public class LanguageDTO {

	@JsonProperty("id")
	private byte languageId;

	@JsonProperty("id")
	private String name;

	@JsonProperty("id")
	private List<Film> films1;

	@JsonProperty("id")
	private List<Film> films2;

	public static LanguageDTO from(Language target) {
		return new LanguageDTO(target.getLanguageId(),
				target.getName(),
				target.getFilms1(),
				target.getFilms2());
	}
	
	public static Language from(LanguageDTO target) {
		return new Language(target.getLanguageId(),
				target.getName(),
				target.getFilms1(),
				target.getFilms2());
	}

	

}