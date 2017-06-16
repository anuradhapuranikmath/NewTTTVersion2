package com.niit.SocialMediaBackEnd.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.SocialMediaBackEnd.Dao.UserDao;
import com.niit.SocialMediaBackEnd.domain.User;

@RestController
public class UserController {
	@Autowired
	private UserDao userDao;
	@RequestMapping(value="/addUser", method=RequestMethod.POST,headers="Accept=application/json")
	public void addUser(@RequestBody User user)
	{
	
		userDao.addUser(user);
	
	}
	 @RequestMapping(value = "/getUsers", method = RequestMethod.GET, headers = "Accept=application/json")  
	 public List<User> getUsers()
	 {
		 List<User> users=userDao.listUsers();
		return users;
	 }
	 
}