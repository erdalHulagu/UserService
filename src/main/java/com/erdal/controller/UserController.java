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
import com.erdal.modelDTO.UserDTO;
import com.erdal.repository.UserRepository;
import com.erdal.service.UserService;

@RequestMapping("/api/users")
@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserService userService;
	
	
	
	
	
	
//----------get all users-------------
	@GetMapping("/getAll")
	public List<UserDTO> getUsers() {

		return userService.getAllUsers();

	}

	
	//----------save  user------------
	@PostMapping("/save")
	public UserDTO createUser(@RequestBody User user) {
		
		return userService.saveUser(user);
	}
	
	
	//----------update  user------------
	@GetMapping("/{id}")
	public UserDTO getUserById(@PathVariable Long id  ) throws Exception  {
		
		UserDTO userDTO= userService.getUserById(id);
		return userDTO;
	}
//	@PutMapping("/{id}")
//	public User updateUser(@PathVariable Long id  ) 
//		
//	getUserById
//		return user;
//	}

}
