package com.niit.SocialMediaBackEnd.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Entity
@Component
public class User {
	@Id
	@GeneratedValue
	int userId;
	@Size(min = 3, max = 30, message = "Size can be between 3 and 8")
	@NotEmpty(message = "User full name can not be empty.")
	String userName;
	@Pattern(regexp = "^([a-zA-Z+]+[0-9+]+[&@!#+]+)$", message = "password should have 8 characters, at least 1 letter, 1 number and 1 special character")
	String password;
	@Pattern(regexp = ".+@.+\\.[a-z]+", message = "email format abc@xyz.com")
	@NotEmpty(message = "Email can not be empty.")

	String userEmail;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", userEmail="
				+ userEmail + "]";
	}
	
	

}
