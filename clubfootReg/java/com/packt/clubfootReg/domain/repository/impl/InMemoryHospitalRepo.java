package com.packt.clubfootReg.domain.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.packt.clubfootReg.domain.Hospital;
import com.packt.clubfootReg.domain.repository.HospitalRepo;

import javax.sql.DataSource;
import java.sql.Connection; 
import java.sql.SQLException;
import java.sql.PreparedStatement;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

@Repository
public class InMemoryHospitalRepo implements HospitalRepo{

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	private List<Hospital> listOfHospitals = new ArrayList<Hospital>();
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
		
	}
	public InMemoryHospitalRepo() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public Hospital getHospital1(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	public void addHospital(Hospital hospital) {
		listOfHospitals.add(hospital);
		int id = hospital.getId();
		String hospitalName = hospital.getHospitalName();
		String hospitalRegion = hospital.getHospitalRegion();
		String query = "Insert into hospital (id, hospital, region) values (?, ?, ?)";
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
	public List<Hospital> getHospital(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	public void deleteHospital(int id) {
		// TODO Auto-generated method stub
		
	}
	public void updateHospital(Hospital hospital) {
		// TODO Auto-generated method stub
		
	}

}
