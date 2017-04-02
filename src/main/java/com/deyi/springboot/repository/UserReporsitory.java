package com.deyi.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deyi.springboot.entity.User;

public interface UserReporsitory extends JpaRepository<User, Long> {
	
	User findByUserName(String userName);

}
