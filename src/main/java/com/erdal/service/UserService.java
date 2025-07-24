package com.erdal.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erdal.exeptions.ConfirmMessage;
import com.erdal.exeptions.ErrorMessages;
import com.erdal.exeptions.ResourceNotFoundExeption;
import com.erdal.model.User;
import com.erdal.modelDTO.UserDTO;
import com.erdal.repository.UserRepository;
import com.erdal.requests.UserUpdateRequest;

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
		user.setCreatAt(LocalDateTime.now());
		User savedUser = userRepository.save(user);

		return userToUserDto(savedUser);
	}

	// ---------------- get user by id --------------------
	public UserDTO getUserById(Long id) {
		User user = findUserById(id);
		return userToUserDto(user);

	}

	// ---------------- up date user --------------------
	public UserDTO upDateUser(Long id, UserUpdateRequest userUpdateRequest) {

		User user = findUserById(id);

		user.setFullName(userUpdateRequest.getFullName());
		user.setEmail(userUpdateRequest.getEmail());
		user.setPassword(userUpdateRequest.getPassword());
		user.setPhone(userUpdateRequest.getPhone());
		user.setUpdateAt(LocalDateTime.now());

		return userToUserDto(user);
	}

	
	// ---------------- delete user --------------------
	public String deleteUserById(Long id) {

		User user = findUserById(id);

		userRepository.deleteById(user.getId());

		return String.format(ConfirmMessage.USER_DELETED_MESSAGE, id);

	}

	// ------------ METODS OF THIS CLASS --------------

	// ------------ find user by id -----------------
	public User findUserById(Long id) {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundExeption(String.format(ErrorMessages.USER_ID_NOT_FOUND, id)));

		return user;

	}

	// ------------ map User To User Dto ------------------
	public UserDTO userToUserDto(User user) {

		UserDTO dto = new UserDTO();

		dto.setFullName(user.getFullName());
		dto.setEmail(user.getEmail());
		dto.setPhone(user.getPhone());
		dto.setRole(user.getRole());
		dto.setPassword(user.getPassword());
		dto.setCreatAt(user.getCreatAt());
		dto.setUpdateAt(user.getUpdateAt());

		return dto;

	}

	// ------------ map userDto To User ------------------
	public User userDtoToUser(UserDTO userDTO) {

		User user = new User();

		user.setFullName(userDTO.getFullName());
		user.setEmail(userDTO.getEmail());
		user.setPhone(userDTO.getRole());
		user.setRole(userDTO.getRole());
		user.setPassword(userDTO.getPassword());
		user.setCreatAt(userDTO.getCreatAt());
		user.setUpdateAt(userDTO.getUpdateAt());
		return user;

	}

	// ------------ map user To UserDto List ------------------
	public List<UserDTO> userToUserDtoList(List<User> users) {

		List<UserDTO> userDTOs = new ArrayList<>();

		for (User user : users) {
			UserDTO dto = userToUserDto(user);
			userDTOs.add(dto);
		}

		return userDTOs;
	}

	// ------------ map userDto To User List ------------------
	public List<User> userDtoToUserList(List<UserDTO> userDtos) {

		List<User> users = new ArrayList<>();

		for (UserDTO userDTO : userDtos) {
			User user = userDtoToUser(userDTO);
			users.add(user);
		}

		return users;
	}

}
