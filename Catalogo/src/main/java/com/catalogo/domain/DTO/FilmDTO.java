package com.catalogo.domain.DTO;


import java.math.BigDecimal;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import lombok.Value;



import com.catalogo.domain.Language;
import com.catalogo.utils.Rating;
import com.catalogo.IServices.ILanguageService;
import com.catalogo.domain.Film;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Value
public class FilmDTO  {


	@NotNull			
	private int filmId;

	//Permite nulo
	private String description;

	//Permite nulo
	private Integer length;

	@Rating
	private String rating;

	//Permite nulo
	private Integer releaseYear;

	@NotNull()
	private Integer rentalDuration;
	
	@NotNull
	private BigDecimal rentalRate;
	
	@NotNull
	private BigDecimal replacementCost;
	
	@NotBlank
	private String title;

	@NotNull
	private Integer language1;

	//Permite nulo	
	private Integer language2;
	
	
	public static FilmDTO from(Film target) {
		
		 Integer lan2= (target.getLanguage2()!=null) ? target.getLanguage2().getLanguageId(): 0;
		 String descriptionv= (target.getDescription()!=null)? target.getDescription(): null;
		 Integer lengthv= (target.getLength()!=null)? target.getLength(): 0;
		 String ratingv= (target.getRating()!=null)? target.getRating(): null;
		 Integer releaseYearv= (target.getReleaseYear()!=null)? target.getReleaseYear(): 0;
		
		return new FilmDTO(
				target.getFilmId(),
				descriptionv,
				lengthv,
				ratingv,
				releaseYearv,
				target.getRentalDuration(),
				target.getRentalRate(),
				target.getReplacementCost(),
				target.getTitle(),
				target.getLanguage1().getLanguageId(),
				lan2
);
	}
	
	public static Film from(FilmDTO target, ILanguageService servicio) {

		Language lan2 =(target.getLanguage2()!=null) ? servicio.getById(target.getLanguage2()):null;
		 String descriptionv= (target.getDescription()!=null)? target.getDescription(): null;
		 Integer lengthv= (target.getLength()!=null)? target.getLength(): 0;
		 String ratingv= (target.getRating()!=null)? target.getRating(): null;
		 Integer releaseYearv= (target.getReleaseYear()!=null)? target.getReleaseYear(): 0;


		
		return new Film(
				target.getFilmId(),
				descriptionv,
				lengthv,
				ratingv,
				releaseYearv,
				target.getRentalDuration(),
				target.getRentalRate(),
				target.getReplacementCost(),
				target.getTitle(),
				servicio.getById(target.getLanguage1()),
				lan2,
				new Timestamp(System.currentTimeMillis())
		);
	}

}