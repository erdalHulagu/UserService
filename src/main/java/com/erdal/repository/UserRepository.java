package com.erdal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erdal.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	boolean existsByUserName(String userName);
	
	Optional<User> findByUserName(String userName);

}
