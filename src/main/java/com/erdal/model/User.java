package com.erdal.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "t_user")
public class User {

	@Id
	private Long id;
	
	private String fullName;
	
	private String email;
	
	private String phone;
	
	private String role;
	
	private LocalDateTime creatAt;
	
	private LocalDateTime updateAt;
	
	
	

	public User(Long id,String fullName, String email, String phone, String role, LocalDateTime creatAt,
			LocalDateTime updateAt) {
		this.fullName = fullName;
		this.email = email;
		this.phone = phone;
		this.role = role;
		this.creatAt = creatAt;
		this.updateAt = updateAt;
		this.id=id;
	}

	public User () {}
	
	public Long id() {
		return id;
	}
	
	public void id(Long id) {
		this.id=id;
		
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

	public LocalDateTime getCreatAt() {
		return creatAt;
	}

	public void setCreatAt(LocalDateTime creatAt) {
		this.creatAt = creatAt;
	}

	public LocalDateTime getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(LocalDateTime updateAt) {
		this.updateAt = updateAt;
	}
	
}
