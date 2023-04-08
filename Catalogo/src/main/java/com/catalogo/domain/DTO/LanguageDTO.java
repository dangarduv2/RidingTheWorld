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


	private int languageId;


	private String name;

	public static LanguageDTO from(Language target) {
		return new LanguageDTO(
				target.getLanguageId(),
				target.getName());
	}
	
	public static Language from(LanguageDTO target) {
		return new Language(
				target.getLanguageId(),
				target.getName());
	}

	

}