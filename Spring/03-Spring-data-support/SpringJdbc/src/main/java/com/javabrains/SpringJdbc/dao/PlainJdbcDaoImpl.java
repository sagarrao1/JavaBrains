package com.javabrains.SpringJdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.javabrains.SpringJdbc.model.Circle;

@Component
public class PlainJdbcDaoImpl {

	@Autowired
	private DataSource dataSource;

	public Circle getCircle(int circleId) {

		Connection con = null;
		PreparedStatement ps;
		ResultSet rs;
		Circle circle = null;
		try {

//			Moved below connection to xml as it is same for every connection
			
//			String driver = "com.mysql.cj.jdbc.Driver";
//			Class.forName(driver).newInstance();
//			String url = "jdbc:mysql://localhost:3306/hibdb";
//			String user = "root";
//			String pwd = "admin";
//			con = DriverManager.getConnection(url, user, pwd);

			con = dataSource.getConnection();
			ps = con.prepareStatement("Select * from circle where id=?");
			ps.setInt(1, circleId);
			rs = ps.executeQuery();
			while (rs.next()) {
				circle = new Circle();
				circle.setId(rs.getInt("id"));
				circle.setName(rs.getString("name"));
			}
			rs.close();
			ps.close();
			System.out.println("This is from using plain jdbc and from PlainJdbcDaoImpl");
			return circle;
		} catch (Exception e) {
			System.out.println(e);
			throw new RuntimeException(e);
		} finally {
			try {
				con.close();
			} catch (SQLException e) { // TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}