package com.catalogo.domain;

import java.io.Serializable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the category database table.
 * 
 */
@Entity
@Table(name="category")
@NamedQuery(name="Category.findAll", query="SELECT c FROM Category c")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="category_id", unique=true, nullable=false)
	@NotNull
	private int categoryId;

	@Column(name="last_update", nullable=false)
	@NotNull
	private Timestamp lastUpdate;

	@Column(nullable=false, length=25)
	@NotBlank
	private String name;


	@OneToMany(mappedBy="category", cascade = CascadeType.ALL)
	private List<FilmCategory> filmCategories;

	public Category() {
	}

	
	
	public Category(int categoryId, String name) {
		this.categoryId = categoryId;
		this.name = name;
	}
	
	public Category(int categoryId, String name, Timestamp lastUpdate) {
		this.categoryId = categoryId;
		this.name = name;
		this.lastUpdate= lastUpdate;
	}



	public int getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(byte categoryId) {
		this.categoryId = categoryId;
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

	public List<FilmCategory> getFilmCategories() {
		return this.filmCategories;
	}

	public void setFilmCategories(List<FilmCategory> filmCategories) {
		this.filmCategories = filmCategories;
	}

	public FilmCategory addFilmCategory(FilmCategory filmCategory) {
		getFilmCategories().add(filmCategory);
		filmCategory.setCategory(this);

		return filmCategory;
	}

	public FilmCategory removeFilmCategory(FilmCategory filmCategory) {
		getFilmCategories().remove(filmCategory);
		filmCategory.setCategory(null);

		return filmCategory;
	}

}