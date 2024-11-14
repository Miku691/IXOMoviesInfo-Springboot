package com.ixo.movieinfo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ixo.movieinfo.entities.IxoMovies;

public interface IxoMoviesRepo extends JpaRepository<IxoMovies, Long>{

}
