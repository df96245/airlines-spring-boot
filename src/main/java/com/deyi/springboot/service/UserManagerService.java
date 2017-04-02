package com.deyi.springboot.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deyi.springboot.entity.User;
import com.deyi.springboot.exception.BussineException;
import com.deyi.springboot.repository.UserReporsitory;

@Service
public class UserManagerService {
	
	private static Logger logger =LoggerFactory.getLogger(UserManagerService.class);
	private static UserManagerService service;
	
	@Autowired
	private UserReporsitory userReporsitory;
	
	public static UserManagerService getInstance(){
		if (null==service) {
			service=new UserManagerService();
		}
		return service;
	}
	private UserManagerService(){
		
	}
	
	public User AddUser(User user) throws BussineException{
		if (user==null) {
			throw new BussineException("Insert user is empty");
		}
		User userDb = userReporsitory.save(user);
		return userDb;
	}
	
	public void deleteUser(User user) throws BussineException{
		if (user==null||0==user.getId()) {
			throw new BussineException("deleteUser user is empty");
		}
		userReporsitory.delete(user.getId());
	}
	
	public User updateUserInfo(User user) throws BussineException{
		if (user==null||0==user.getId()) {
			throw new BussineException("updateUserInfo but user is empty");
		}
		User dbUser =userReporsitory.findOne(user.getId());
		if (dbUser==null) {
			throw new BussineException("User not found from db, id="+user.getId());
		}
		User userDb = userReporsitory.save(user);
		return userDb;
		
	}
}
