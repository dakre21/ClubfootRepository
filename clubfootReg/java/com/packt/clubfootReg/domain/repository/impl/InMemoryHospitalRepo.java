package com.packt.clubfootReg.domain.repository.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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

/**
 * 
 * @author David
 * This class represents the InMemoryHospitalRepo class that uses CRUD actions (methods) to manipulate data in the database
 */
@Repository
public class InMemoryHospitalRepo implements HospitalRepo{

	private DataSource dataSource; // Instantiation of the datasource object
	private JdbcTemplate jdbcTemplateObject; // Instantiation of the JdbcTemplate object
	private List<Hospital> listOfHospitals = new ArrayList<Hospital>(); // Creation of a new list of users
	
	// JDBCTemplate subclass DataSource sets up the environment to allow data to be manipulated in this Spring app
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource; // Sets the current object this of the class's attribute dataSource eqal to the object of datasource
		this.jdbcTemplateObject = new JdbcTemplate(dataSource); // Instantiation of the JDBCTemplateObject class which takes in the object of datasource to set up data synchronization
		
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
	
	// This method effectively adds data that was saved to the model to the MySQL instance of the database
	public void addHospital(Hospital hospital) {
		listOfHospitals.add(hospital); // Adds the object of the model "hospital" to the list created above
		String name = hospital.getName();	// Gets the String name from the hospital model
		int region_id = hospital.getRegion_id(); // Gets the integer value of the region id
		
		Connection connection = null;	// Instantiation of the connection to the database
		
		/**
		 * The following contains a set of prepared statements to be prepared to be synchronized to the MySql database.
		 * The prepared statements pull information that was saved to the model via the form submission.
		 */
		try {
			connection = dataSource.getConnection(); // Connection of the dataSource with the MySql sever
			
			String sql = "Insert into hospital values(?, ?, ?)"; // First sql statement that contains the information to query into hospital
			PreparedStatement ps = connection.prepareStatement(sql); // Instantiation of the class "PreparedStatement" of how the query statements are prepared to be added to the database and establishment of the sql query
			
			ps.setInt(1, this.getMaxHospitalID()+1);
			ps.setString(2, name);
			ps.setInt(3, region_id);
			
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) { // Catches SQL exception errors
			throw new RuntimeException(e);
 
		} finally {
			if (connection != null) { // Closes SQL connection 
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
	
	public Map<Integer, String> getAllHospitals() {
		Connection conn = null;
		Map<Integer, String> hospitals = new LinkedHashMap<Integer,String>();
		
		try {
			conn = dataSource.getConnection();
			
			String sql = "Select id, name from hospital";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				hospitals.put(rs.getInt("id"), rs.getString("name"));
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
	
	/**
	 * Method that retrieves the max hospital id
	 */
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
