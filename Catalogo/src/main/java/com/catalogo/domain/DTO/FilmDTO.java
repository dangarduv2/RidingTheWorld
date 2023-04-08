package com.catalogo.domain.DTO;

import java.io.Serializable;
import java.sql.Timestamp;

import lombok.Value;
import java.util.Date;

import java.util.List;
import com.catalogo.domain.Language;
import com.catalogo.domain.Film;
import com.catalogo.domain.FilmActor;
import com.catalogo.domain.FilmCategory;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;

@Value
public class FilmDTO  {


	@NotNull
	private int filmId;

	
	private String description;

	
	private int length;

	
	private String rating;

	
	private int releaseYear;

	
	private String specialFeatures;

	
	private String title;

	
	private LanguageDTO language1;

	
	private LanguageDTO language2;


	
	
	public static FilmDTO from(Film target) {
		LanguageDTO lan1 =LanguageDTO.from(target.getLanguage1());
		LanguageDTO lan2 =LanguageDTO.from(target.getLanguage2());
		if(lan1.getLanguageId()==null)lan1=null;
		if(lan2.getLanguageId()==null)lan2=null;
		return new FilmDTO(
				target.getFilmId(),
				target.getDescription(),
				target.getLength(),
				target.getRating(),
				target.getReleaseYear(),
				target.getSpecialFeatures(),
				target.getTitle(),
				lan1,
				lan2
);
	}
	
	public static Film from(FilmDTO target) {
		Language lan1 =LanguageDTO.from(target.getLanguage1());
		Language lan2 =LanguageDTO.from(target.getLanguage2());
		if(lan1.getLanguageId()==null)lan1=null;
		if(lan2.getLanguageId()==null)lan2=null;
		return new Film(
				target.getFilmId(),
				target.getDescription(),
				target.getLength(),
				target.getRating(),
				target.getReleaseYear(),
				target.getSpecialFeatures(),
				target.getTitle(),
				
				lan1,
				lan2,
				new Timestamp(System.currentTimeMillis())
		);
	}

}