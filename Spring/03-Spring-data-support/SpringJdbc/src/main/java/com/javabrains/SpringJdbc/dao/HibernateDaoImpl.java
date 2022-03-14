package com.javabrains.SpringJdbc.dao;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HibernateDaoImpl {
	
	@Autowired
	private SessionFactory sessionFactory; 
		
	public int getCircleCount() {
		String hql= "select count(*) from Circle";
		Query query = sessionFactory.openSession().createQuery(hql);
//		System.out.println("HibernateDaoImpl getCircleCount() method");		
		return ((Long) query.uniqueResult()).intValue();
		
	}

	/* setters and getters of session factory */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	

}
