package com.javabrains.SpringJdbc.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

public class SimpleJdbcDaoImpl extends SimpleJdbcCall {

//	if we want to use datasource constructor use datasource constructor in spring.xml for this DAOImpla
	
	/*
	 * public SimpleJdbcDaoImpl(DataSource dataSource) { super(dataSource); }
	 */

	
	public SimpleJdbcDaoImpl(JdbcTemplate jdbcTemplate) {
		super(jdbcTemplate);
	}

	public int getCircleCount() {
		String sql = "select count(*) from circle";
		// jdbcTemplate.setDataSource(dataSource);
		return this.getJdbcTemplate().queryForObject(sql, Integer.class);

	}
	

}
