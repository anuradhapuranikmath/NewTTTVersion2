package com.niit.SocialMediaBackEnd;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.SocialMediaBackEnd.Dao.UserDao;
import com.niit.SocialMediaBackEnd.domain.User;

public class UserTest {
	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.SocialMediaBackEnd");
		context.refresh();

		User user = (User)context.getBean("user");
		UserDao userdao = (UserDao)context.getBean("userDAO");
		
		user.setUserName("preeti");
		user.setPassword("passwO1@");
		user.setUserEmail("preeti.one@gmail.com");
		userdao.addUser(user);
		
		List<User> listuser=userdao.listUsers();
		for(User u:listuser)
		{
			System.out.println(" the aviliable users are : "+u);
		}
		

	}
}

