package com.erdal.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erdal.model.User;
import com.erdal.repository.UserRepository;

@RequestMapping("/api/users")
@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/get")
	public User getUser() {

		User user = new User();

		user.setFullName("Erdal Hulagu");
		user.setEmail("erdalHulagu23@gmail.com");
		user.setPhone("+447586654863");
		user.setCreatAt(LocalDateTime.now());
		user.setRole("Costumer");
		return user;

	}

	@PostMapping("/save")
	public User createUser(User user) {
		return userRepository.save(user);
	}

}
