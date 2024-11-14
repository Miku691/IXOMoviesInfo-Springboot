package com.ixo.movieinfo.entities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "IXO_MOVIES")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IxoMovies {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private LocalDate releaseDate;
	private String genere;
	private LocalTime duretion;
	private String budget;
	private String writer;
	private String director;
	private String producer;
	private String boxOfficeCollection;
	private double imdbRating;
	private String posterUrl;
	private String trailerUrl;
	private String musicBy;
	private String availableOn;
	
	//these two column to track record inserted by whom and when
	private LocalDate createdOn;
	private String creaedBy;
	
	@ManyToMany
	@JoinTable(
		name="ixo_movies_actor",
		joinColumns = @JoinColumn(name = "movie_id"),
		inverseJoinColumns = @JoinColumn(name = "actor_id")
	)
	private Set<IxoUserEntity> ixoUser = new HashSet<IxoUserEntity>();

}
