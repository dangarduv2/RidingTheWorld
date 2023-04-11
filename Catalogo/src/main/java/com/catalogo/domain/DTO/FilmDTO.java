package com.catalogo.domain.DTO;


import java.math.BigDecimal;
import java.sql.Timestamp;

import lombok.Value;


import org.hibernate.validator.constraints.Length;

import com.catalogo.domain.Language;
import com.catalogo.IServices.ILanguageService;
import com.catalogo.domain.Film;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Value
public class FilmDTO  {


	@NotNull
	private int filmId;

	@NotBlank
	private String description;

	@NotNull
	private int length;

	@NotBlank
	private String rating;

	@NotNull
	private Integer releaseYear;

	@NotNull
	private Integer rentalDuration;
	
	@NotNull
	private BigDecimal rentalRate;
	
	@NotNull
	private BigDecimal replacementCost;
	
	@NotBlank
	private String title;

	
	private Integer language1;

	
	private Integer language2;


	
	
	public static FilmDTO from(Film target) {
		Integer lan1=null;
		Integer lan2=null;
		if(target.getLanguage1()!=null)lan1=target.getLanguage1().getLanguageId();
		if(target.getLanguage2()!=null)lan2=target.getLanguage2().getLanguageId();
		return new FilmDTO(
				target.getFilmId(),
				target.getDescription(),
				target.getLength(),
				target.getRating(),
				target.getReleaseYear(),
				target.getRentalDuration(),
				target.getRentalRate(),
				target.getReplacementCost(),
				target.getTitle(),
				lan1,
				lan2
);
	}
	
	public static Film from(FilmDTO target, ILanguageService servicio) {
		Language lan1 =servicio.getById(target.getLanguage1());
		Language lan2 =servicio.getById(target.getLanguage2());
		if(lan1.getLanguageId()==null)lan1=null;
		if(lan2.getLanguageId()==null)lan2=null;
		return new Film(
				target.getFilmId(),
				target.getDescription(),
				target.getLength(),
				target.getRating(),
				target.getReleaseYear(),
				target.getRentalDuration(),
				target.getRentalRate(),
				target.getReplacementCost(),
				target.getTitle(),
				
				lan1,
				lan2,
				new Timestamp(System.currentTimeMillis())
		);
	}

}