package com.erdal.service;

import java.util.List;

import com.erdal.modelDTO.UserDTO;
import com.erdal.requests.UserRequest;

public interface UserService  {
	
	UserDTO createUser(UserRequest userRequest);
	
	UserDTO getUserById(Long id);
	
	List<UserDTO> getAllUsers();
	
	String deleteUser(Long id);
	
	UserDTO updateUser(Long id,UserRequest userRequest);

	void register(UserDTO userDTO);

	String login(String username, String password);

	
	

}
