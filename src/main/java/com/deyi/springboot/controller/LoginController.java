package com.deyi.springboot.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deyi.springboot.entity.User;
import com.deyi.springboot.exception.BussineException;
import com.deyi.springboot.repository.UserReporsitory;
import com.deyi.springboot.service.LoginManagerService;
import com.deyi.springboot.service.UserManagerService;

@RestController("/")
public class LoginController {
	
	private static Logger logger =LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	UserReporsitory userReporsitory;
	
	@Autowired
	UserManagerService userManagerService;
	
	@Autowired
	LoginManagerService loginManagerService;
	
	@GetMapping("/login")
	public String login(Map<String, Object> model, HttpServletRequest request) throws BussineException{
		User user= new User();
		user.setId(1);
		user.setPassWord("1");
		user.setUserName("1");
		if (loginManagerService.verifyLogin(user)) {
			//TODO loginSuccess page
			return "loginSuccess";
		}
		//TODO loginFail page
		return "loginFail";
	}
	
	@GetMapping("/add")
	public String add(Map<String, Object> model, HttpServletRequest request) throws BussineException{
		User user= new User();
		user.setId(3);
		user.setPassWord("3");
		user.setUserName("3");
		userManagerService.AddUser(user);
		return "add success";
	}
	
	@RequestMapping("/hello")
    public String hello(Map<String,Object> map){
       map.put("name", "[Angel -- 守护天使]");
       return "hello";
    }
	
	@RequestMapping("/findUser/{userId}")
	public User findUser(@PathVariable(name="userId")String userId){
		User users =userReporsitory.findByUserName(userId);
		if (null!=users) {
			return users;
		}else{
			return null;
		}
	}
	
}
