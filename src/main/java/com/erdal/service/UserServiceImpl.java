package com.erdal.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.erdal.enums.UserRole;
import com.erdal.exeptions.ErrorMessages;
import com.erdal.exeptions.UserBadRequestException;
import com.erdal.exeptions.UserNotFoundException;
import com.erdal.mapper.UserMapper;
import com.erdal.model.User;
import com.erdal.modelDTO.UserDTO;
import com.erdal.repository.UserRepository;
import com.erdal.requests.UserRequest;
import com.erdal.responseMessages.ResponseMessage;
import com.erdal.security.jwt.JwtUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository; 
    
    private final PasswordEncoder passwordEncoder;
    
    private final AuthenticationManager authenticationManager;
    
    private final JwtUtil jwtUtil;
	
	

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
	    user.setPassword(passwordEncoder.encode(userRequest.getPassword()));  // şifre encode edildi
	    user.setPhone(userRequest.getPhone());
	    user.setUserName(userRequest.getUserName());
	    user.setUpdateAt(LocalDateTime.now());

	    User updatedUser = userRepository.save(user);  // değişiklikleri kaydet

	    return UserMapper.userToUserDto(updatedUser);
	}

	// ---------------- delete user --------------------
	@Override
	public String deleteUser(Long id) {

		User user = findUserById(id);

		userRepository.deleteById(user.getId());

		return String.format(ResponseMessage.USER_DELETED_MESSAGE, id);

	}
	// Register
    public void register(UserDTO userDTO) {
        if(userRepository.existsByUserName(userDTO.getUserName())) {
            throw new UserBadRequestException(String.format(ErrorMessages.WRONG_ACCES,userDTO.getFullName()));
        }

        User user = new User();
        user.setUserName(userDTO.getUserName());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword())); // şifre hash’lendi
        user.setFullName(userDTO.getFullName());
        user.setEmail(userDTO.getEmail());
        user.setRoles(Set.of(UserRole.CUSTOMER)); // default rol CUSTOMER ver

        userRepository.save(user);
    }

    // Login
    public String login(String username, String password) {
        try {
            authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
            );
        } catch (Exception e) {
        	 throw new UserBadRequestException(String.format(ErrorMessages.WRONG_ACCES));
        }
        return jwtUtil.generateToken(username);
    }


	// ------------ METODS OF THIS CLASS --------------

	// ------------ find user by id -----------------
	public User findUserById(Long id) {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new UserNotFoundException(String.format(ErrorMessages.USER_ID_NOT_FOUND, id)));

		return user;

	}

	
	

}
