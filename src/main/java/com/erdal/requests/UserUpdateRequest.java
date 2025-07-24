package com.erdal.requests;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdateRequest {

	private String fullName;

	private String email;
	
	public String password;

	private String userName;
	
	private String phone;

	private String role;

	

}
