package com.ixo.movieinfo.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ixo.movieinfo.dto.IxoMoviesDto;
import com.ixo.movieinfo.entities.IxoMovies;
import com.ixo.movieinfo.entities.IxoUserEntity;
import com.ixo.movieinfo.exception.ResourceNotFoundException;
import com.ixo.movieinfo.repositories.IxoMoviesRepo;
import com.ixo.movieinfo.repositories.IxoUserRepo;
import com.ixo.movieinfo.services.IxoMoviesService;

@Service
public class IxoMoviesServiceImpl implements IxoMoviesService {

	@Autowired
	IxoMoviesRepo ixoMoviesRepo;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	IxoUserRepo ixoUserRepo;
	
	@Override
	public IxoMoviesDto createMovies(IxoMoviesDto ixoMoviesDto, Integer userId) {
		IxoUserEntity ixoUser = this.ixoUserRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId));
		
		IxoMovies ixoMovies = this.modelMapper.map(ixoMoviesDto, IxoMovies.class);
		//associate the user with the movie.
		ixoMovies.getIxoUser().add(ixoUser);
		//saving the movie
		
		IxoMovies savedMovies = ixoMoviesRepo.save(ixoMovies);
		
		ixoUser.getIxoMovies().add(savedMovies);
		ixoUserRepo.save(ixoUser);
		
		return this.modelMapper.map(savedMovies, IxoMoviesDto.class);
	}

	@Override
	public IxoMoviesDto getMovie(Long movieId) {
		//get movie by id
		return this.modelMapper.map(ixoMoviesRepo.findById(movieId), IxoMoviesDto.class);
	}

}
