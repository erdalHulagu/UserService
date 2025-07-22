package com.erdal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erdal.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
