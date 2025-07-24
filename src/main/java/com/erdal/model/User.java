package com.erdal.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "t_user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String fullName;
	
	private String email;
	
	private String password;
	
	private String phone;
	
	private String role;
	
	private LocalDateTime creatAt;
	
	private LocalDateTime updateAt;
	
	
	

	public User(Long id,String fullName, String email,String password, String phone, String role, LocalDateTime creatAt,
			LocalDateTime updateAt) {
		
		this.id=id;
		this.fullName = fullName;
		this.email = email;
		this.password=password;
		this.phone = phone;
		this.role = role;
		this.creatAt = creatAt;
		this.updateAt = updateAt;
		
	}

	

	public User () {}
	
	public Long getId() {
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
