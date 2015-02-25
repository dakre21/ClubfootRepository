package com.packt.clubfootReg.domain.repository.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.packt.clubfootReg.domain.Evaluator;
import com.packt.clubfootReg.domain.Hospital;
import com.packt.clubfootReg.domain.User;
import com.packt.clubfootReg.domain.repository.UserRepo;

import javax.sql.DataSource;

import java.sql.Connection; 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

@Repository
public class InMemoryAddUser implements UserRepo{

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	private List<User> listOfUsers = new ArrayList<User>();
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
		
	}
	
	public InMemoryAddUser() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void addUser(User user) {
		listOfUsers.add(user);
		int id = user.getId();
		String userName = user.getUser_name();
		String email = user.getEmail();
		int hospital_id = user.getHospital_id();
		int role_id = user.getRole_id();

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		Connection connection = null;
		
		try {
			connection = dataSource.getConnection();
			
			String sql = "Insert into abstract_person (id, created) values (?, ?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, this.getMaxPersonID()+1);
			ps.setString(2, dateFormat.format(date));
			ps.executeUpdate();
			ps.close();
			
			sql = "Insert into user (id, login, email, role_id) values (?, ?, ?, ?)";
			PreparedStatement ps2 = connection.prepareStatement(sql);
			ps2.setInt(1, this.getMaxPersonID());
			ps2.setString(2, userName);
			ps2.setString(3, email);
			ps2.setInt(4, role_id);
			ps2.executeUpdate();
			ps2.close();
			
			sql = "Insert into user_hospital (user_id, hospital_id) values (?, ?)";
			PreparedStatement ps3 = connection.prepareStatement(sql);
			ps3.setInt(1, this.getMaxPersonID());
			ps3.setInt(2, hospital_id);
			ps3.executeUpdate();
			ps3.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
 
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {}
			}
		}
		
		return;
		
	}

	public List<User> getUser(int id) {
		
		return null;
	}

	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		
	}

	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> getAllUsers() {
		Connection conn = null;
		User user = null;
		List<User> users = null;
		
		try {
			conn = dataSource.getConnection();
			
			String sql = "select a.id, a.login, a.email, d.id as hospital_id, e.id as role_id " +
						 "from user a " +
					     "inner join abstract_person b on a.id = b.id " +
					     "inner join user_hospital c on a.id = c.user_id " +
					     "inner join hospital d on c.hospital_id = d.id " +
					     "inner join role e on a.role_id = e.id " +
					     "order by a.id";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			if (rs.last()) {
			  users = new ArrayList<>(rs.getRow());
			  rs.beforeFirst(); 
			}
			
			while (rs.next()) {
				user = new User(
					rs.getInt("id"),
					rs.getString("login"),
					rs.getString("email"),
					rs.getInt("hospital_id"),
					rs.getInt("role_id")
				);
				users.add(user);
			}
			rs.close();
			ps.close();
			return users;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {}
			}
		}
	}

	@Override
	public int getMaxPersonID() {
		Connection conn = null;
		int max = 0;
		
		try {
			conn = dataSource.getConnection();
			
			String sql = "Select max(id) from abstract_person";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				max = rs.getInt(1);
			}
			
			rs.close();
			ps.close();
			return max;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {}
			}
		}
		
	}

}
