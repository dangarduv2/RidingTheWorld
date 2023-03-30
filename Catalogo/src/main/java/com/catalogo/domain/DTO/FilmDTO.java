package com.catalogo.domain.DTO;

import java.io.Serializable;
import lombok.Value;
import java.util.Date;

import java.util.List;
import com.catalogo.domain.Language;
import com.catalogo.domain.Film;
import com.catalogo.domain.FilmActor;
import com.catalogo.domain.FilmCategory;
import com.fasterxml.jackson.annotation.JsonProperty;

@Value
public class FilmDTO  {


	@JsonProperty("id")
	private int filmId;

	@JsonProperty("descripcion")
	private String description;

	@JsonProperty("duracion")
	private int length;

	@JsonProperty("rate")
	private String rating;

	@JsonProperty("realesed")
	private Date releaseYear;

	@JsonProperty("features")
	private Object specialFeatures;

	@JsonProperty("titulo")
	private String title;

	@JsonProperty("idioma_1")
	private Language language1;

	@JsonProperty("idioma_2")
	private Language language2;

	@JsonProperty("listaActores")
	private List<FilmActor> filmActors;

	@JsonProperty("listaCategorias")
	private List<FilmCategory> filmCategories;

	
	
	public static FilmDTO from(Film target) {
		return new FilmDTO(
				target.getFilmId(),
				target.getDescription(),
				target.getLength(),
				target.getRating(),
				target.getReleaseYear(),
				target.getSpecialFeatures(),
				target.getTitle(),
				target.getLanguage1(),
				target.getLanguage2(),
				target.getFilmActors(),
				target.getFilmCategories());
	}
	
	public static Film from(FilmDTO target) {
		return new Film(
				target.getFilmId(),
				target.getDescription(),
				target.getLength(),
				target.getRating(),
				target.getReleaseYear(),
				target.getSpecialFeatures(),
				target.getTitle(),
				target.getLanguage1(),
				target.getLanguage2(),
				target.getFilmActors(),
				target.getFilmCategories());
	}

}