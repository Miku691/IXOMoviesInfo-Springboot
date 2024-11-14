package com.ixo.movieinfo.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IxoMoviesDto {
	
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
	
	
}
