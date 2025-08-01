package com.erdal.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.erdal.enums.UserRole;
import com.erdal.exeptions.ErrorMessages;
import com.erdal.exeptions.UserNotFoundExeption;
import com.erdal.mapper.UserMapper;
import com.erdal.model.User;
import com.erdal.modelDTO.UserDTO;
import com.erdal.repository.UserRepository;
import com.erdal.requests.UserRequest;
import com.erdal.responseMessages.ResponseMessage;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	
	private final PasswordEncoder passwordEncoder;
	
	

	@Override
	public List<UserDTO> getAllUsers() {

		List<User> users = userRepository.findAll();

		return UserMapper.userToUserDtoList(users);
	}

	// ------------ save user ---------------------

	@Override
	public UserDTO createUser(UserRequest userRequest) {
		User user = new User();
		user.setFullName(userRequest.getFullName());
		user.setPhone(userRequest.getPhone());
		user.setEmail(userRequest.getEmail());
		user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
		user.setUserName(userRequest.getUserName());
		user.setRoles(Set.of(UserRole.CUSTOMER)); // default role
		user.setCreatAt(LocalDateTime.now());

		User savedUser = userRepository.save(user);
		return UserMapper.userToUserDto(savedUser);
	}

	// ---------------- get user by id --------------------
	@Override
	public UserDTO getUserById(Long id) {
		User user = findUserById(id);
		return UserMapper.userToUserDto(user);

	}

	// ---------------- up date user --------------------
	@Override
	public UserDTO updateUser(Long id, UserRequest userRequest) {

		User user = findUserById(id);

		user.setFullName(userRequest.getFullName());
		user.setEmail(userRequest.getEmail());
		user.setPassword(userRequest.getPassword());
		user.setPhone(userRequest.getPhone());
		user.setUserName(userRequest.getUserName());
		user.setUpdateAt(LocalDateTime.now());

		return UserMapper.userToUserDto(user);
	}

	// ---------------- delete user --------------------
	@Override
	public String deleteUser(Long id) {

		User user = findUserById(id);

		userRepository.deleteById(user.getId());

		return String.format(ResponseMessage.USER_DELETED_MESSAGE, id);

	}

	// ------------ METODS OF THIS CLASS --------------

	// ------------ find user by id -----------------
	public User findUserById(Long id) {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new UserNotFoundExeption(String.format(ErrorMessages.USER_ID_NOT_FOUND, id)));

		return user;

	}

	

}
