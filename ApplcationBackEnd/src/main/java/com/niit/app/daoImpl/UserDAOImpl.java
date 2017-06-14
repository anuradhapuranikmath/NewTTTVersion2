package com.niit.app.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.app.domain.User;
import com.nnit.app.dao.UserDAO;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {

	@Autowired
	SessionFactory sessionFactory;

	public UserDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public User insert(User user) {

		sessionFactory.getCurrentSession().save(user);
		return user;

	}

	public User getUserById(int id) {
		User user = (User) sessionFactory.getCurrentSession().get(User.class, id);
		return user;

	}

	public List<User> getAllUsers() {
		List<User> user = sessionFactory.getCurrentSession().createQuery("from User").list();
		return user;
	}

	public User login(User user) {
		Query query=sessionFactory.getCurrentSession().createQuery("from User where userName=? and password=?");
		query.setString(0,user.getUserName());
		query.setString(1,user.getPassword());
		
		User validUser=(User) query.uniqueResult();
		return validUser;
	}

}
