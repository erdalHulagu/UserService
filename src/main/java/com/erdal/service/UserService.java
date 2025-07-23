package com.erdal.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erdal.model.User;
import com.erdal.modelDTO.UserDTO;
import com.erdal.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	// ------------ get all users -----------
	public List<UserDTO> getAllUsers() {

		List<User> users = userRepository.findAll();

		return userToUserDtoList(users);
	}

	// ------------ save user ---------------------
	public UserDTO saveUser(User user) {

		User savedUser = userRepository.save(user);

		return userToUserDto(savedUser);
	}

	// ---------------- get user by id --------------------
	public UserDTO getUserById(Long id) throws Exception {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new Exception(String.format("User not Found ", "with", id)));

		return userToUserDto(user);

	}

	// ------------ METODS OF THIS CLASS --------------
	// ------------ map User To User Dto ------------------
	public UserDTO userToUserDto(User user) {

		UserDTO dto = new UserDTO();

		dto.setFullName(user.getFullName());
		dto.setEmail(user.getEmail());
		dto.setPhone(user.getRole());
		dto.setRole(user.getRole());

		return dto;

	}

	// ------------ map userDto To User ------------------
	public User userDtoToUser(UserDTO userDTO) {

		User user = new User();

		user.setFullName(userDTO.getFullName());
		user.setEmail(userDTO.getEmail());
		user.setPhone(userDTO.getRole());
		user.setRole(userDTO.getRole());

		return user;

	}

	// ------------ map user To UserDto List ------------------
	public List<UserDTO> userToUserDtoList(List<User> users) {

		List<UserDTO> userDTOs = new ArrayList<>();

		for (User user : users) {
			 UserDTO dto =userToUserDto(user);
			userDTOs.add(dto);
		}

		return userDTOs;
	}
	
	// ------------ map userDto To User List ------------------
		public List<User> userDtoToUserList(List<UserDTO> userDtos) {

			List<User> users = new ArrayList<>();

			for (UserDTO userDTO : userDtos) {
				User user =userDtoToUser(userDTO);
				users.add(user);
			}

			return users;
		}

}
