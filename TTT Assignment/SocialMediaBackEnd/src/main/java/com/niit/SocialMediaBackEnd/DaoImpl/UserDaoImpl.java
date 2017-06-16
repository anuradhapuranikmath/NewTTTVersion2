package com.niit.SocialMediaBackEnd.DaoImpl;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.SocialMediaBackEnd.Dao.UserDao;
import com.niit.SocialMediaBackEnd.domain.User;

@Repository("userDAO")
@Transactional
public class UserDaoImpl implements UserDao {

	
	@Autowired
	private SessionFactory sessionFactory;

	
	public UserDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Transactional
	public void addUser(User user) {

		Session session = sessionFactory.openSession();

		session.saveOrUpdate(user);
	}
	
	@Transactional
	public List<User> listUsers() {
		Session session = sessionFactory.getCurrentSession();

		List<User> userList = session.createQuery("from User").list();
		for (User u : userList) {
			
		}

		return userList;
	}
	

}
