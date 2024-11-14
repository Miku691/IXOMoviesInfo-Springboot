package com.ixo.movieinfo.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ixo.movieinfo.entities.Users;
import com.ixo.movieinfo.repositories.UsersRepo;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UsersRepo usersRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = Optional.of(usersRepo.findByUsername(username)).orElseThrow(() -> new UsernameNotFoundException("Not"));
		
		return new UserPrinciple(user);
	}

}
