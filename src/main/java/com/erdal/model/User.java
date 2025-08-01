package com.erdal.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.erdal.enums.UserRole;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "t_user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotBlank(message = "User name is mandatory")
	private String fullName;
	
	@NonNull
	@NotBlank(message = "email is mandatory")
	@Email(message = "email should be valid")
	private String email;
	
	@NonNull
	@NotBlank(message = "password is mandatory")
	private String password;
	
	@NonNull
	@NotBlank(message = "password is mandatory")
	private String userName;
	
	private String phone;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@Enumerated(EnumType.STRING)
	private Set<UserRole> roles = new HashSet<>();
	
	@CreationTimestamp
	private LocalDateTime creatAt;
	
	@UpdateTimestamp
	private LocalDateTime updateAt;
	
	
	

}
