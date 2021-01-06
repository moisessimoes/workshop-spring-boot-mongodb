package com.moises.workshopmongodb.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moises.workshopmongodb.domain.Post;
import com.moises.workshopmongodb.repository.PostRepository;
import com.moises.workshopmongodb.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	
	@Autowired
	private PostRepository postRepository;
	
	
	//====================================================================================================================
	
	public Post findById(String id) {
		
		Optional<Post> obj = postRepository.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	
	//====================================================================================================================
	
	public List<Post> findByTitle(String title) { //Consulta simples com query methods e Consulta simples com @Query
		
		//return postRepository.findByTitleContainingIgnoreCase(title);
		return postRepository.searchTitle(title);
	}
	
	
	//====================================================================================================================
	
	
	public List<Post> fullSearch(String text, Date minDate, Date maxDate) { //Consulta com vários critérios
		
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
		
		return postRepository.fullSearch(text, minDate, maxDate);
	}
}
