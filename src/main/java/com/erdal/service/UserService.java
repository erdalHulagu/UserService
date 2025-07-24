package com.erdal.service;

import java.util.List;

import com.erdal.model.User;
import com.erdal.modelDTO.UserDTO;
import com.erdal.requests.UserUpdateRequest;

public interface UserService  {
	
	UserDTO createUser(User user);
	
	UserDTO getUserById(Long id);
	
	List<UserDTO> getAllUsers();
	
	String deleteUser(Long id);
	
	UserDTO updateUser(Long id,UserUpdateRequest userUpdateRequest);

	
	

}
