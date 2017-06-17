package com.niit.SocialMediaBackEnd.DaoImpl;



import java.util.List;

import org.hibernate.Query;
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
		user.setRole("ROLE_USER");

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
	
	
	public int validateUser(String name, String password) {
		System.out.println(" insicde validte dao");
		int res = 0;
		Session session = sessionFactory.getCurrentSession();
		Query result = session.createQuery("from User u where u.name='" + name + "'");

		List<User> users = result.list();
		System.out.println("users:" + users);
		if (users.size() == 0) {
			res = 0;
		} else {
			for (int i = 0; i < users.size(); i++) {
				System.out.println("inside for loop");
				String dbname = users.get(i).getUserName();
				String dbpassword = users.get(i).getPassword();
				String dbrole = users.get(i).getRole();
				if (dbname.equals(name) && dbpassword.equals(password) && dbrole.equals("ROLE_USER")) {
					res = 1;
					System.out.println("the result is:" + res);
				} else if (dbname.equals(name) && dbpassword.equals(password) && dbrole.equals("ROLE_ADMIN")) {
					res = 2;
					System.out.println("the result  is:" + res);
				}
			}
		}
		return res;
	}
	
	

}
