package com.ixo.movieinfo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ixo.movieinfo.entities.Users;

@Repository
public interface UsersRepo extends JpaRepository<Users, Integer>{
	Users findByUsername(String username);
}
