package com.moises.workshopmongodb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moises.workshopmongodb.domain.User;
import com.moises.workshopmongodb.repository.UserRepository;

@Service
public class UserService {
	
	
	@Autowired
	private UserRepository userRepository;
	
	
	public List<User> findAll() {
		
		return userRepository.findAll();
	}
}
