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
		String query = "Insert into user (id, hospital, name) values (?, ?, ?)";
/*		Connection connection = null;
		
		try {
			connection = dataSource.getConnection();
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ps.setString(2, hospitalName);
			ps.setString(3, userName);
			ps.executeUpdate();
			ps.close();
		}catch (SQLException e) {
			throw new RuntimeException(e);
 
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {}
			}
		}*/
		
		return;
		
	}

	public List<User> getUser(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		
	}

	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
	}

}
