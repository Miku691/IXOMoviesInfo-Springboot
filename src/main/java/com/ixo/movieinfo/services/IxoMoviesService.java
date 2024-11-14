package com.ixo.movieinfo.services;

import com.ixo.movieinfo.dto.IxoMoviesDto;

public interface IxoMoviesService {
	
	//create new movie
	IxoMoviesDto createMovies(IxoMoviesDto ixoMoviesDto, Integer userId);
	
	//fetch movie by id
	IxoMoviesDto getMovie(Long movieId);
}
