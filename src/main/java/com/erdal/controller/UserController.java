package com.erdal.controller;


import org.springframework.beans.factory.annotation.Autowired;
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

//	@GetMapping("/get")
//	public User getUser() {
//
//		User user = new User();
//
//		user.setFullName("Erdal Hulagu");
//		user.setEmail("erdalHulagu23@gmail.com");
//		user.setPhone("+447586654863");
//		user.setCreatAt(LocalDateTime.now());
//		user.setRole("Costumer");
//		return user;
//
//	}

	@PostMapping("/save")
	public User createUser(@RequestBody User user) {
		
//		User user2=new User();
//		
//		user2.setFullName(user.getFullName());
//		user2.setEmail(user.getEmail());
//		user2.setRole(user.getRole());
//		user2.setPhone(user.getPhone());
		
		return userRepository.save(user);
	}

}
