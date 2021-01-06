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
import com.moises.workshopmongodb.dto.CommentDTO;
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
		User izzie = new User(null, "Isobel Estivens", "izzie@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, cristina, george, izzie));
		
		Post post1 = new Post(null, sdf.parse("04/01/2021"), "Partiu viagem!", "Vou viajar para SP. Abraços!", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("05/01/2021"), "Bom dia!", "Acordei feliz hoje!", new AuthorDTO(maria));
		
		CommentDTO c1 = new CommentDTO("Boa viagem mano!", sdf.parse("04/01/2021"), new AuthorDTO(alex));
		CommentDTO c2 = new CommentDTO("Aproveite!", sdf.parse("04/01/2021"), new AuthorDTO(george));
		CommentDTO c3 = new CommentDTO("Tenha um ótimo dia!", sdf.parse("05/01/2021"), new AuthorDTO(izzie));
		
		post1.getComments().addAll(Arrays.asList(c1, c2));
		post2.getComments().addAll(Arrays.asList(c3));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		
		userRepository.save(maria);
	}
}
