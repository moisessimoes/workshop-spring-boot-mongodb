package com.moises.workshopmongodb.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.moises.workshopmongodb.domain.User;
import com.moises.workshopmongodb.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		
		User maria = new User(null, "Meredith Grey", "grey@gmail.com");
		User alex = new User(null, "Alex Karev", "alex@gmail.com");
		User cristina = new User(null, "Cristina Yang", "cristina@gmail.com");
		User george = new User(null, "George Omalley", "george@gmail.com");
		User izzie = new User(null, "Isobel Instivens", "izzie@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, cristina, george, izzie));
		
	}
}
