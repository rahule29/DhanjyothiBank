package com.dhanjyothi.dao.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dhanjyothi.dao.LoginDao;
import com.dhanjyothi.dao.RegisterDao;
import com.dhanjyothi.database.CustomHibernateDaoSupport;
import com.dhanjyothi.exception.UserException;
import com.dhanjyothi.model.User;

@Repository
@Transactional
public class LoginDaoImpl extends CustomHibernateDaoSupport implements LoginDao {
	
	@Autowired
	RegisterDao registerDao;

	@Override
	public int validateUser(User user) {
		try {
			User dbUser = registerDao.getUserByUserName(user.getUserName());
			return user.equals(dbUser) ? 1 : 0;
		} catch (UserException e) {
			logger.error("Error while getting user by username: "+user.getUserName());
			return 0;
		}
	}

}
