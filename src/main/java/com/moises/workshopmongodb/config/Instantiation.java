package com.moises.workshopmongodb.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.moises.workshopmongodb.domain.Post;
import com.moises.workshopmongodb.domain.User;
import com.moises.workshopmongodb.dto.AuthorDTO;
import com.moises.workshopmongodb.repository.PostRepository;
import com.moises.workshopmongodb.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Meredith Grey", "grey@gmail.com");
		User alex = new User(null, "Alex Karev", "alex@gmail.com");
		User cristina = new User(null, "Cristina Yang", "cristina@gmail.com");
		User george = new User(null, "George Omalley", "george@gmail.com");
		User izzie = new User(null, "Isobel Instivens", "izzie@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, cristina, george, izzie));
		
		Post post1 = new Post(null, sdf.parse("04/01/2021"), "Partiu viagem!", "Vou viajar para SP. Abraços!", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("05/01/2021"), "Bom dia!", "Acordei feliz hoje!", new AuthorDTO(maria));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
	}
}
