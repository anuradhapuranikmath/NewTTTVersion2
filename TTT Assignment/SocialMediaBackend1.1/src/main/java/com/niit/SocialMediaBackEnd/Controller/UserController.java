package com.niit.SocialMediaBackEnd.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	
	@Autowired
	User users;
	
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
	 
	 
	 
	 @RequestMapping(value = "/authenticate", method = RequestMethod.POST, headers = "Accept=application/json")
		public int authenticateUser(@RequestBody User users, HttpSession httpSession) {
			System.out.println("in authenticate");
			System.out.println("name:" + users.getUserName());
			System.out.println("password:" + users.getPassword());

			int result = 0;
			httpSession.setAttribute("loggedInUser", users);
			 httpSession.setAttribute("loggedInUserID", users.getUserId());
			result = userDao.validateUser(users.getUserName(), users.getPassword());
			System.out.println("result is:" + result);
			return result;
		}
	 
	 
	 
	 @RequestMapping(value="/user/logout/" , method = RequestMethod.GET)
	   public  ResponseEntity<User> logout(HttpSession session) 
	   {
		
		   String loggedInUserID = (String) session.getAttribute("loggedInUserID");
		   
		   session.invalidate();
		  
		  return new ResponseEntity<User>(users, HttpStatus.OK);
	   }
	 
	 
}