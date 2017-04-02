package com.deyi.springboot.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deyi.springboot.entity.User;
import com.deyi.springboot.repository.UserReporsitory;

@Service
public class LoginManagerService {
	private static Logger logger =LoggerFactory.getLogger(LoginManagerService.class);
	
	@Autowired
	private UserReporsitory userReporsitory;
	
	
	public boolean verifyLogin(User userToVerify){
		Long useId=userToVerify.getId();
		User userDb=userReporsitory.findOne(useId);
		logger.info("userDb="+userDb);
		if (userDb==null) {
			return false;
		}
		boolean userNameIsMatch=userDb.getUserName().equals(userToVerify.getUserName());
		boolean passWordIsMatch=userDb.getPassWord().equals(userToVerify.getPassWord());
		logger.info("userNameIsMatch="+userNameIsMatch+" passWordIsMatch="+passWordIsMatch);
		if (userNameIsMatch&&passWordIsMatch) {
			return true;
		}
		return false;
	}
}
