package com.dhanjyothi.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.dhanjyothi.dao.RegisterDao;
import com.dhanjyothi.database.CustomHibernateDaoSupport;
import com.dhanjyothi.exception.UserException;
import com.dhanjyothi.model.User;

@Repository
@Transactional
@SuppressWarnings({ "deprecation", "unchecked" })
public class RegisterDaoImpl extends CustomHibernateDaoSupport implements RegisterDao {
	
	
	@Override
	@Transactional
	public void saveRegister(User user) {
		save(user);
	}
	
	
	@Override 
	public User getUserByUserName(String userName) throws UserException {
		
		List<User> users = getCurrentSession().createCriteria(User.class).add(Restrictions.eq("userName", userName)).list();
		if(users.isEmpty()) {
			throw new UserException("User not found with username: " + userName);
		}
		return users.get(0);
	}
	 

	@Override
	public List<User> getAllUsers() {
		return getCurrentSession().createCriteria(User.class).list();
	}

}
