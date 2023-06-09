package com.catalogo.domain;

import java.io.Serializable;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="actor")
public class Actor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="actor_id", unique=true, nullable=false)
	private int actorId;

	@Column(name="first_name", nullable=false, length=45)
	@NotBlank
	private String firstName;

	@Column(name="last_name", nullable=false, length=45)
	@NotBlank
	private String lastName;

	@Column(name="last_update", nullable=false)
	@NotNull
	private Timestamp lastUpdate;

	@OneToMany(mappedBy="actor", fetch = FetchType.LAZY, cascade= CascadeType.ALL)
	private List<FilmActor> filmActors;

	public Actor() {
	}
	
	

	public Actor(int actorId, String firstName, String lastName, Timestamp update) {
		this.actorId = actorId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.setLastUpdate(update);
	}



	public int getActorId() {
		return this.actorId;
	}

	public void setActorId(int actorId) {
		this.actorId = actorId;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Timestamp getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public List<FilmActor> getFilmActors() {
		return this.filmActors;
	}

	public void setFilmActors(List<FilmActor> filmActors) {
		this.filmActors = filmActors;
	}

	public FilmActor addFilmActor(FilmActor filmActor) {
		getFilmActors().add(filmActor);
		filmActor.setActor(this);

		return filmActor;
	}

	public FilmActor removeFilmActor(FilmActor filmActor) {
		getFilmActors().remove(filmActor);
		filmActor.setActor(null);

		return filmActor;
	}





	
	
	



	
	
	

}