package com.erdal.requests;

public class UserUpdateRequest {

	private String fullName;

	private String email;

	private String phone;

	private String role;

	public UserUpdateRequest(String fullName, String email, String phone, String role) {
		super();
		this.fullName = fullName;
		this.email = email;
		this.phone = phone;
		this.role = role;
	}

	public UserUpdateRequest() {

	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	

}
