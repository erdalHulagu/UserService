package com.erdal.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erdal.model.User;
import com.erdal.repository.UserRepository;

@RequestMapping("/api/users")
@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	
	
	
	
	
//----------get all users-------------
	@GetMapping("/getAll")
	public List<User> getUsers() {

		return userRepository.findAll();

	}

	
	//----------save  user------------
	@PostMapping("/save")
	public User createUser(@RequestBody User user) {
		
		return userRepository.save(user);
	}
	
	
	//----------update  user------------
	@GetMapping("/{id}")
	public User getUserById(@PathVariable Long id  ) throws Exception {
		
		 User user=	userRepository.findById(id).orElseThrow(() -> new Exception(String.format("User not Found ", "with",id)));
	
		return user;
	}
//	@PutMapping("/{id}")
//	public User updateUser(@PathVariable Long id  ) 
//		
//	getUserById
//		return user;
//	}

}
