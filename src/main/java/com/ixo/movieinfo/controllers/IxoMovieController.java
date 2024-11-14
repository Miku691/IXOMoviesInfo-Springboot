package com.ixo.movieinfo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ixo.movieinfo.dto.IxoMoviesDto;
import com.ixo.movieinfo.services.IxoMoviesService;

@RestController
@RequestMapping(path = "api/movies")
public class IxoMovieController {

	@Autowired
	IxoMoviesService ixoMoviesSevice;
	
	@PostMapping(path = "/userId/{id}")
	public ResponseEntity<IxoMoviesDto> createMovie(
			@RequestBody IxoMoviesDto ixoMovieDto,
			@PathVariable("id") Integer usedId
			){
		IxoMoviesDto movieDto = ixoMoviesSevice.createMovies(ixoMovieDto, usedId);
		
		return new ResponseEntity<IxoMoviesDto>(movieDto, HttpStatus.CREATED);
	}
	
	@GetMapping(path = "/movieId/{id}")
	public ResponseEntity<IxoMoviesDto> getMovieById(@PathVariable("id") Long movieId){
		return new ResponseEntity<IxoMoviesDto>(ixoMoviesSevice.getMovie(movieId), HttpStatus.OK);
	}
}
