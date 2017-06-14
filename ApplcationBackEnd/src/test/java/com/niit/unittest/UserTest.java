package com.niit.unittest;
import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.app.domain.User;
import com.nnit.app.dao.UserDAO;

public class UserTest {
	@Autowired
	static AnnotationConfigApplicationContext context;
	
	@Autowired
	static User user;
	
	@Autowired
	static UserDAO userDAO;
	
	@BeforeClass
	static public void initalize()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.app");
		context.refresh();
		
		user=context.getBean(User.class);
		
		userDAO=(UserDAO)context.getBean("userDAO");
		
	}
	
	@Test
	public void insertPositiveTestCase()
	{
		// positive testing for insert user
		user.setUserId(0);
		user.setUserName("anuradha");
		user.setUserEmail("anuradha123");
		
		userDAO.insert(user);
		assertEquals("Record Inserted!!","anuradha",user.getUserName());		
		
	}
		
	@Test
	public void getAllUserPositiveTestCase()
	{
		int usersCount=userDAO.getAllUsers().size();
		assertEquals("Fetched data!!",usersCount,userDAO.getAllUsers().size());
	}
	
	@Test
	public void getAllUsersNegativeTestCase()
	{
		assertFalse("Empty",userDAO.getAllUsers().isEmpty() );
		
	
	}

}