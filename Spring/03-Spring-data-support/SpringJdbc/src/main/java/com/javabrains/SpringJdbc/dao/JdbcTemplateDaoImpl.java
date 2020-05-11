package com.javabrains.SpringJdbc.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;


public class JdbcTemplateDaoImpl extends JdbcDaoSupport {	
	
	
	/* Normal JdbcDaoImpl method */
//	public int getCircleCount() {
//		String sql = "select count(*) from circle";		 				 
//		return jdbcTemplate.queryForObject(sql, Integer.class);
//	}

	
	public int getCircleCount() {
		String sql = "select count(*) from circle";		 				 
		 //jdbcTemplate.setDataSource(dataSource);
		return this.getJdbcTemplate().queryForObject(sql, Integer.class);

	}


}
