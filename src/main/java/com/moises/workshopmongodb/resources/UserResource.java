package com.moises.workshopmongodb.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.moises.workshopmongodb.domain.User;
import com.moises.workshopmongodb.dto.UserDTO;
import com.moises.workshopmongodb.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(method = RequestMethod.GET)
	private ResponseEntity<List<UserDTO>> findAll() {
		
		List<User> list = userService.findAll();
		
		List<UserDTO> listDTO = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDTO);
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	private ResponseEntity<UserDTO> findById(@PathVariable String id) {
		
		User user = userService.findById(id);
		
		return ResponseEntity.ok().body(new UserDTO(user));
	}
}
