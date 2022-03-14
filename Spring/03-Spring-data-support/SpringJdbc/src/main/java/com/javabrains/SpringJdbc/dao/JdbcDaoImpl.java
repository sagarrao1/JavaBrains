package com.javabrains.SpringJdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import com.javabrains.SpringJdbc.model.Circle;

@Component
public class JdbcDaoImpl {

	// private DataSource dataSource;

	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParamJdbcTemplate;

	/*
	 * public JdbcTemplate getJdbcTemplate() { return jdbcTemplate; }
	 */

	/*
	 * public void setJdbcTemplate(JdbcTemplate jdbcTemplate) { this.jdbcTemplate =
	 * jdbcTemplate; }
	 */
//	public DataSource getDataSource() {
//		return dataSource;
//	}

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.namedParamJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	public int getCircleCount() {
		String sql = "select count(*) from circle";
		// jdbcTemplate.setDataSource(dataSource);
		return jdbcTemplate.queryForObject(sql, Integer.class);

	}

	public String getCircleName(int circleId) {
		String sql = "select name from circle where id=?";
		return jdbcTemplate.queryForObject(sql, new Object[] { circleId }, String.class);
	}

	private static final class CircleMapper implements RowMapper<Circle> {

		public Circle mapRow(ResultSet rs, int rowNum) throws SQLException {
			Circle circle = new Circle();
			circle.setId(rs.getInt("id"));
			circle.setName(rs.getString("name"));
			return circle;
		}

	}

	public Circle getCircleforId(int circleId) {
		String sql = "select * from circle where id=?";
		return jdbcTemplate.queryForObject(sql, new Object[] { circleId }, new CircleMapper());

	}

	public List<Circle> getAllCircles() {
		String sql = "select * from circle";
		return jdbcTemplate.query(sql, new CircleMapper());

	}

	public void insertCircle(Circle circle) {
		 String sql = "insert into circle(ID,NAME) values(?,?)";
		 jdbcTemplate.update(sql, new Object[] {circle.getId(), circle.getName()});	
	}
	
	public void insertCircleUsingNamedJdbctemplate(Circle circle) {
		// String sql = "insert into circle(ID,NAME) values(?,?)";
		// jdbcTemplate.update(sql, new Object[] {circle.getId(), circle.getName()});
		
		String sql = "insert into circle(ID,NAME) values(:id, :name)";
		SqlParameterSource namedParameters = new MapSqlParameterSource("id", circle.getId())
														    .addValue("name", circle.getName());
		System.out.println(namedParameters.getValue("id"));
		namedParamJdbcTemplate.update(sql, namedParameters);
		System.out.println(" record inserted in circle table");
	}

	public void createTrianlgeTable() {
		String sql = "create table triangle(id int(11), name varchar(30))";
		jdbcTemplate.execute(sql);
		System.out.println("table created");
	}
}