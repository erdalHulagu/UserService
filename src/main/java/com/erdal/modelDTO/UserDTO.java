package com.erdal.modelDTO;

	import java.time.LocalDateTime;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

	

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
	public class UserDTO {
		
		
		private String fullName;
		
		private String email;
		
		private String password;
		
		private String userName;
		
		private String phone;
		
		private Set<String> roles;
		
		private LocalDateTime creatAt;
		
		private LocalDateTime updateAt;
		
		
		

		
	}
	

