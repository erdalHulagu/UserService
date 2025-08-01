package com.erdal.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import com.erdal.enums.UserRole;
import com.erdal.model.User;
import com.erdal.modelDTO.UserDTO;

public class UserMapper {
	
	
	// ------------ map User To User Dto ------------------
		public static UserDTO userToUserDto(User user) {

			UserDTO dto = new UserDTO();

			Set<String> roleStr = user.getRoles().stream().map(UserRole::name) // veya toString()
					.collect(Collectors.toSet());

			dto.setFullName(user.getFullName());
			dto.setEmail(user.getEmail());
			dto.setPhone(user.getPhone());
			dto.setRoles(roleStr);
			dto.setPassword(user.getPassword());
			dto.setUserName(user.getUserName());
			dto.setCreatAt(user.getCreatAt());
			dto.setUpdateAt(user.getUpdateAt());

			return dto;
		

		}

		// ------------ map userDto To User ------------------
		public static User userDtoToUser(UserDTO userDTO) {
		    User user = new User();

		    // userDTO.getRoles() --> Set<String>
		    Set<UserRole> roles = userDTO.getRoles().stream()
		        .map(roleStr -> {
		            try {
		                return UserRole.valueOf(roleStr);
		            } catch (IllegalArgumentException e) {
		                return null; // Geçersiz string geldiyse null döner
		            }
		        })
		        .filter(Objects::nonNull) // null olanları at
		        .collect(Collectors.toSet());

		    user.setFullName(userDTO.getFullName());
		    user.setEmail(userDTO.getEmail());
		    user.setPhone(userDTO.getPhone());
		    user.setRoles(roles);
		    user.setPassword(userDTO.getPassword());
		    user.setUserName(userDTO.getUserName());
		    user.setCreatAt(userDTO.getCreatAt());
		    user.setUpdateAt(userDTO.getUpdateAt());

		    return user;
		}

		// ------------ map user To UserDto List ------------------
		public static List<UserDTO> userToUserDtoList(List<User> users) {

			List<UserDTO> userDTOs = new ArrayList<>();

			for (User user : users) {
				UserDTO dto = userToUserDto(user);
				userDTOs.add(dto);
			}

			return userDTOs;
		}

		// ------------ map userDto To User List ------------------
		public static List<User> userDtoToUserList(List<UserDTO> userDtos) {

			List<User> users = new ArrayList<>();

			for (UserDTO userDTO : userDtos) {
				User user = userDtoToUser(userDTO);
				users.add(user);
			}

			return users;
		}


}
