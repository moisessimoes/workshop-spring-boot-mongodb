package com.moises.workshopmongodb.services;

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
	
	
}
