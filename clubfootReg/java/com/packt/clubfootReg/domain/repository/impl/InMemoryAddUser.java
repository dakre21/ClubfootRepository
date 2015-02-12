package com.packt.clubfootReg.domain.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

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

	public User getUser1(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void addUser(User user) {
		listOfUsers.add(user);
		int id = user.getId();
		String userName = user.getUserName();
		String hospitalName = user.getHospitalName();
		int user_id = user.getUser_id();
		//String query = "Insert into user (id, hospital, name) values (?, ?, ?)";

		Connection connection = null;
		
		try {
			connection = dataSource.getConnection();
			
			String sql = "Insert into user values(?, ?, ?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, this.getMaxUserID()+1);
			ps.setString(2, userName);
			ps.setInt(3, user_id);
			ps.executeUpdate();
			ps.close();
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
		Connection conn = null;
		User user = null;
		List<User> users = null;
		
		try {
			conn = dataSource.getConnection();
			
			String sql = "Select * from user order by name";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			if (rs.last()) {
			  users = new ArrayList<>(rs.getRow());
			  rs.beforeFirst(); 
			}
			
			while (rs.next()) {
				user = new User(
					rs.getInt("id"),
					rs.getString("userName"),
					rs.getString("hospitalName"),
					rs.getInt("user_id")
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

	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		
	}

	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getMaxUserID() {
		Connection conn = null;
		int max = 0;
		
		try {
			conn = dataSource.getConnection();
			
			String sql = "Select max(id) from user";
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
