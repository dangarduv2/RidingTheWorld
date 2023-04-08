package com.catalogo.domain;

import java.io.Serializable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.sql.Timestamp;
import java.util.List;


@Entity
@Table(name="language")
public class Language implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="language_id", unique=true, nullable=false)
	@NotNull
	private int languageId;

	@Column(name="last_update", nullable=false)
	@NotNull
	private Timestamp lastUpdate;

	@Column(nullable=false, length=20)
	@NotBlank
	private String name;


	@OneToMany(mappedBy="language1")
	private List<Film> films1;


	@OneToMany(mappedBy="language2")
	private List<Film> films2;

	public Language() {
	}
	
	
	public Language(int languageId, String name, Timestamp lastUpdate) {
		this.languageId = languageId;
		this.name = name;
		this.lastUpdate = lastUpdate;
	}
	

	public Language(int languageId, String name, List<Film> films1, List<Film> films2) {
		super();
		this.languageId = languageId;
		this.name = name;
		this.films1 = films1;
		this.films2 = films2;
	}



	public int getLanguageId() {
		return this.languageId;
	}

	public void setLanguageId(byte languageId) {
		this.languageId = languageId;
	}

	public Timestamp getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Film> getFilms1() {
		return this.films1;
	}

	public void setFilms1(List<Film> films1) {
		this.films1 = films1;
	}

	public Film addFilms1(Film films1) {
		getFilms1().add(films1);
		films1.setLanguage1(this);

		return films1;
	}

	public Film removeFilms1(Film films1) {
		getFilms1().remove(films1);
		films1.setLanguage1(null);

		return films1;
	}

	public List<Film> getFilms2() {
		return this.films2;
	}

	public void setFilms2(List<Film> films2) {
		this.films2 = films2;
	}

	public Film addFilms2(Film films2) {
		getFilms2().add(films2);
		films2.setLanguage2(this);

		return films2;
	}

	public Film removeFilms2(Film films2) {
		getFilms2().remove(films2);
		films2.setLanguage2(null);

		return films2;
	}

}