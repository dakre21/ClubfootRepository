package com.packt.clubfootReg.domain.repository.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
		String name = hospital.getName();
		int region_id = hospital.getRegion_id();
		
		Connection connection = null;
		
		try {
			connection = dataSource.getConnection();
			
			String sql = "Insert into hospital values(?, ?, ?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, this.getMaxHospitalID()+1);
			ps.setString(2, name);
			ps.setInt(3, region_id);
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
	
	public int getMaxHospitalID() {
		Connection conn = null;
		int max = 0;
		
		try {
			conn = dataSource.getConnection();
			
			String sql = "Select max(id) from hospital";
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
