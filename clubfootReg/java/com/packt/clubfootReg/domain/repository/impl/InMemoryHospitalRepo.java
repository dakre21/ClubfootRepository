package com.packt.clubfootReg.domain.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.packt.clubfootReg.domain.Hospital;
import com.packt.clubfootReg.domain.repository.HospitalRepo;

import java.sql.Connection; 
import java.sql.ResultSet;
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
		int hospitalRegionId = hospital.getHospitalRegionId();
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
	public List<Hospital> getAllHospitals() {
		Connection conn = null;
		Hospital hospital = null;
		List<Hospital> hospitals = null;
		
		try {
			conn = dataSource.getConnection();
			
			String sql = "Select * from hospital order by name";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			if (rs.last()) {
			  hospitals = new ArrayList<>(rs.getRow());
			  rs.beforeFirst(); 
			}
			
			while (rs.next()) {
				hospital = new Hospital(
					rs.getInt("id"),
					rs.getString("name"),
					rs.getInt("region_id")
				);
				hospitals.add(hospital);
			}
			rs.close();
			ps.close();
			return hospitals;
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
	public void deleteHospital(int id) {
		// TODO Auto-generated method stub
		
	}
	public void updateHospital(Hospital hospital) {
		// TODO Auto-generated method stub
		
	}

}
