package com.javabrains.SpringJdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.javabrains.SpringJdbc.model.Circle;


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

	
	public List<Circle> getAllCircles() {
		String sql = "select * from circle";		 				 
		 //jdbcTemplate.setDataSource(dataSource);
		return this.getJdbcTemplate().query(sql, new CircleMapper());
	}

	private static final class CircleMapper implements RowMapper<Circle> {

		public Circle mapRow(ResultSet rs, int rowNum) throws SQLException {
			Circle circle = new Circle();
			circle.setId(rs.getInt("id"));
			circle.setName(rs.getString("name"));
			return circle;
		}

	}
}
