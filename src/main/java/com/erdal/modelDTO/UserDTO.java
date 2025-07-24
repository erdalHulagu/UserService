package com.erdal.modelDTO;

	import java.time.LocalDateTime;

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
		
		private String role;
		
		private LocalDateTime creatAt;
		
		private LocalDateTime updateAt;
		
		
		

		
	}
	

