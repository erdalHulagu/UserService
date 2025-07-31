package com.erdal.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.erdal.model.User;
import com.erdal.modelDTO.UserDTO;
import com.erdal.repository.UserRepository;
import com.erdal.requests.UserUpdateRequest;
import com.erdal.responseMessages.Response;
import com.erdal.responseMessages.ResponseMessage;
import com.erdal.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequestMapping("/api/users")
@RestController
@RequiredArgsConstructor
public class UserController {

	
	private final UserRepository userRepository;
	
	
	private final UserService userService;
	
	
	
	
	
	
//----------get all users-------------
	@GetMapping("/getAll")
	public ResponseEntity< List<UserDTO> >getUsers() {

		List<UserDTO> users= userService.getAllUsers();
		
		return ResponseEntity.ok(users);

	}

	
	//----------save  user------------
	@PostMapping("/save")
	public ResponseEntity<UserDTO>  createUser(@RequestBody @Valid User user) {
		
		 UserDTO usr =userService.createUser(user);
		 return new ResponseEntity<>(usr,HttpStatus.CREATED);
		 
	}
	
	
	//----------update  user------------
	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> getUserById(@PathVariable Long id  )  {
		
		UserDTO userDTO= userService.getUserById(id);
		return new ResponseEntity<>(userDTO,HttpStatus.OK);
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<UserDTO > updateUser(@PathVariable Long id ,@RequestBody UserUpdateRequest userUpdateRequest ) {
		
	UserDTO userDto=userService.updateUser(id,userUpdateRequest);
	return ResponseEntity.ok(userDto);
	}
	
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<Response> deleteUser(@PathVariable Long id) {
		
	String msg=	userService.deleteUser(id);
		Response response=new Response();
		response.setMessage(msg);
		
		return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
		
		
		
	}

}
