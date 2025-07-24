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

	private String phone;

	private String role;

	public String password;

	

}
