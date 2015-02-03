package com.packt.clubfootReg.domain.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.packt.clubfootReg.domain.Hospital;
import com.packt.clubfootReg.domain.Visit;
import com.packt.clubfootReg.domain.repository.VisitRepo;

import javax.sql.DataSource;

import java.sql.Connection; 
import java.sql.SQLException;
import java.sql.PreparedStatement;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

@Repository
public class InMemoryVisitRepo implements VisitRepo{

	public InMemoryVisitRepo() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	private List<Visit> listOfVisits = new ArrayList<Visit>();
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
		
	}

	public Visit getVisit1(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void addVisit(Visit visit) {
		listOfVisits.add(visit);
		int id = visit.getId();
/*		Connection connection = null;
		
		try {
			connection = dataSource.getConnection();
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ps.setString(2, hospitalName);
			ps.setString(3, hospitalRegion);
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

	public List<Visit> getVisit(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteVisit(int id) {
		// TODO Auto-generated method stub
		
	}

	public void updateVisit(Visit visit) {
		// TODO Auto-generated method stub
		
	}

}
