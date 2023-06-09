package com.catalogo.domain;

import java.io.Serializable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name="film")
public class Film implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="film_id", unique=true, nullable=false)
	@NotNull
	private int filmId;

	@Lob
	//Permite nulo
	private String description;

	@Column(name="last_update", nullable=true)
	@NotNull
	private Timestamp lastUpdate;

	//Permite nulo
	private Integer length;

	@Column(length=2)
	//Permite nulo
	private String rating;

	@Temporal(TemporalType.DATE)
	@Column(name="release_year", nullable=true)
	//Permite nulo
	private int releaseYear;

	@Column(name="rental_duration", nullable=false)
	@NotNull
	private Integer rentalDuration;

	@Column(name="rental_rate", nullable=false, precision=10, scale=2)
	@NotNull
	private BigDecimal rentalRate;

	@Column(name="replacement_cost", nullable=false, precision=10, scale=2)
	@NotNull
	private BigDecimal replacementCost;

	@Column(nullable=false, length=128)
	//@NotBlank
	private String title;

	
	@ManyToOne
	@JoinColumn(name="language_id", nullable=true)
	//@NotNull
	private Language language1;

	
	@ManyToOne
	@JoinColumn(name="original_language_id", nullable=true)
	//Permite nulo
	private Language language2;

	
	@OneToMany(mappedBy="film",fetch = FetchType.LAZY)
	private List<FilmActor> filmActors;

	
	@OneToMany(mappedBy="film", fetch = FetchType.LAZY)
	private List<FilmCategory> filmCategories;

	public Film() {
	}

	
	
	public Film(int filmId, String description, Integer length, String rating, Integer releaseYear,
			Integer rentalDuration,BigDecimal rentalRate,BigDecimal replacementCost,
		 String title, Language language1, Language language2, Timestamp lastUpdate) {

		 Language lan2= (language2!=null) ? language2: null;
		 String descriptionv= (description!=null)? description: null;
		 Integer lengthv= (length!=null)? length: null;
		 String ratingv= (rating!=null)? rating: null;
		 Integer releaseYearv= (releaseYear!=null)? releaseYear: null; 
		
		this.filmId = filmId;
		this.description = descriptionv;
		this.length = lengthv;
		this.rating = ratingv;
		this.releaseYear = releaseYearv;
		this.rentalDuration=rentalDuration;
		this.rentalRate=rentalRate;
		this.replacementCost=replacementCost;

		this.title = title;
		this.language1 = language1;
		this.language2 = lan2;
		this.lastUpdate= lastUpdate;
	}
	
	public int getFilmId() {
		return this.filmId;
	}

	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public Integer getLength() {
		return this.length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getRating() {
		return this.rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public Integer getReleaseYear() {
		return this.releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public Integer getRentalDuration() {
		return this.rentalDuration;
	}

	public void setRentalDuration(Integer rentalDuration) {
		this.rentalDuration = rentalDuration;
	}

	public BigDecimal getRentalRate() {
		return this.rentalRate;
	}

	public void setRentalRate(BigDecimal rentalRate) {
		this.rentalRate = rentalRate;
	}

	public BigDecimal getReplacementCost() {
		return this.replacementCost;
	}

	public void setReplacementCost(BigDecimal replacementCost) {
		this.replacementCost = replacementCost;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Language getLanguage1() {
		return this.language1;
	}

	public void setLanguage1(Language language1) {
		this.language1 = language1;
	}

	public Language getLanguage2() {
		return this.language2;
	}

	public void setLanguage2(Language language2) {
		this.language2 = language2;
	}

	public List<FilmActor> getFilmActors() {
		return this.filmActors;
	}

	public void setFilmActors(List<FilmActor> filmActors) {
		this.filmActors = filmActors;
	}

	public FilmActor addFilmActor(FilmActor filmActor) {
		getFilmActors().add(filmActor);
		filmActor.setFilm(this);

		return filmActor;
	}

	public FilmActor removeFilmActor(FilmActor filmActor) {
		getFilmActors().remove(filmActor);
		filmActor.setFilm(null);

		return filmActor;
	}

	public List<FilmCategory> getFilmCategories() {
		return this.filmCategories;
	}

	public void setFilmCategories(List<FilmCategory> filmCategories) {
		this.filmCategories = filmCategories;
	}

	public FilmCategory addFilmCategory(FilmCategory filmCategory) {
		getFilmCategories().add(filmCategory);
		filmCategory.setFilm(this);

		return filmCategory;
	}

	public FilmCategory removeFilmCategory(FilmCategory filmCategory) {
		getFilmCategories().remove(filmCategory);
		filmCategory.setFilm(null);

		return filmCategory;
	}

}