package com.dhanjyothi.database;

import javax.annotation.PostConstruct;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

@Component
public abstract class CustomHibernateDaoSupport extends HibernateDaoSupport {

	@Autowired
	@Qualifier("sessionFactory")
	private LocalSessionFactoryBean sessionFactory;

	@PostConstruct
	public void setCustomSessionFactory() {
		setSessionFactory((SessionFactory)sessionFactory.getObject());
	}

	protected Session getCurrentSession() {
		return getSessionFactory().getCurrentSession();
	}
	
	protected void save(Object obj) {
		getCurrentSession().saveOrUpdate(obj);
	}
	
	protected void update(Object obj) {
		getCurrentSession().update(obj);
	}

}