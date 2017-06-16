package com.niit.SocialMediaBackEnd.Dao;

import java.util.List;

import com.niit.SocialMediaBackEnd.domain.User;

public interface UserDao {

	public void addUser(User user);
	public List<User> listUsers() ;

}
