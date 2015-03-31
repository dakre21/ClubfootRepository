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

import com.packt.clubfootReg.domain.Evaluator;
import com.packt.clubfootReg.domain.Hospital;
import com.packt.clubfootReg.domain.ReportsHospital;
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
	
	/**
	 * Reseting the database connection to retrieve information that's stored in the mysql database
	 * via queries that are sent through the open connection. The results of the data received by this class
	 * is saved in a result set to be displayed in the jsp view. 
	 */
	public Hospital getHospital(int id) {
		Connection conn = null; // Resets the connection to the database
		Hospital hospital = null; // Resets the model
		
		try {
			conn = dataSource.getConnection();
			
			String sql = "Select a.*, b.name as region_name " +
						 "from hospital a " +
						 "inner join region b on a.region_id = b.id " +
						 "where a.id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				hospital = new Hospital(
					rs.getInt("id"),
					rs.getString("name"),
					rs.getInt("region_id"),
					rs.getString("region_name")
				);
			}
			rs.close();
			ps.close();
			return hospital;
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
	
	public List<Hospital> getAllHospitals() {
		Connection conn = null; // Resets the connection to the database
		Hospital hospital = null; // Resets the model
		List<Hospital> hospitals = null; // Resets the list
		
		/**
		 * Reseting the database connection to retrieve information that's stored in the mysql database
		 * via queries that are sent through the open connection. The results of the data received by this class
		 * is saved in a result set to be displayed in the jsp view. 
		 */
		
		try {
			conn = dataSource.getConnection();
			
			String sql = "Select a.*, b.name as region_name " +
						 "from hospital a " +
						 "inner join region b on a.region_id = b.id " +
						 "order by a.name";
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
					rs.getInt("region_id"),
					rs.getString("region_name")
				);
				hospitals.add(hospital);
				System.out.println(hospital.getName());
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

	/**
	 * Method the effectively deletes hospital information stored in the database
	 */
	public void deleteHospital(int id) {
		// TODO Auto-generated method stub
		
	}
	public void updateHospital(Hospital hospital) {
		listOfHospitals.add(hospital);
		int id = hospital.getId();
		String name = hospital.getName();
		int region_id = hospital.getRegion_id();
	
		String sql = "Update hospital set name = ?, region_id = ? where id = ?";
		
		Connection connection = null;
		PreparedStatement ps = null;
		
		try {
			connection = dataSource.getConnection();
			
			ps = connection.prepareStatement(sql);
			ps.setString(1, name);
			ps.setInt(2, region_id);
			ps.setInt(3, id);
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
	
	/**
	 * Method that retrieves the max hospital id
	 */
	public int getMaxHospitalID() {
		Connection conn = null; // Resets the connection to the database
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

	public Map<Integer, String> getAllRegions() {
		Connection conn = null; // Resets the connection to the database
		Map<Integer, String> regions = new LinkedHashMap<Integer,String>();
		
		try {
			conn = dataSource.getConnection();
			
			String sql = "Select * from region order by name";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				regions.put(rs.getInt("id"), rs.getString("name"));
			}
			
			rs.close();
			ps.close();
			return regions;
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
	public List<ReportsHospital> getAllHospitalsReports() {
		Connection conn = null; // Resets the connection to the database
		ReportsHospital hospital = null; // Resets the model
		List<ReportsHospital> rh = null; // Resets the list
		
		/**
		 * Reseting the database connection to retrieve information that's stored in the mysql database
		 * via queries that are sent through the open connection. The results of the data received by this class
		 * is saved in a result set to be displayed in the jsp view. 
		 */
		
		try {
			conn = dataSource.getConnection();
			
		   String sql = "Select a.name as hospitalName, c.name as regionName, count(*) as numOfPatients, " +
				   			"(select count(*) from patient where a.id = hospital_id and sex = 'male') as numOfMales, " +
				   			"(select count(*) from patient where a.id = hospital_id and sex = 'female') as numOfFemales, " +
				   			"(select count(*) from patient where a.id = hospital_id and feet_affected = 'Left') as latLeft, " +
				   			"(select count(*) from patient where a.id = hospital_id and feet_affected = 'Right') as latRight, " +
				   			"(select count(*) from patient where a.id = hospital_id and (feet_affected = 'Left' or feet_affected = 'Right')) as latUni, " +
				   			"(select count(*) from patient where a.id = hospital_id and feet_affected = 'Both') as latBi, " +
				   			"(select count(*) from patient where a.id = hospital_id and affected_relatives > 0) as affectedRels, " +
				   			"(select count(*) from patient where a.id = hospital_id and affected_relatives = 0) as affectedRelsNot, " +
				   			"(select count(*) from patient where a.id = hospital_id and affected_relatives is null) as affectedRelsIDK, " +
				   			"(select count(*) from visit where a.id = hospital_id) as numOfVisits " +
				   		"from hospital a " +
				   		"inner join patient b on a.id = b.hospital_id " +
				   		"inner join region c on a.region_id = c.id " +
				   		"group by a.name, c.name";
		   
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			if (rs.last()) {
			  rh = new ArrayList<>(rs.getRow());
			  rs.beforeFirst(); 
			}
			
			while (rs.next()) {
				hospital = new ReportsHospital(
					rs.getString("hospitalName"),
					rs.getString("regionName"),
					rs.getInt("numOfPatients")
				);
				hospital.setNumOfMales(rs.getInt("numOfMales"));
				hospital.setNumOfFemales(rs.getInt("numOfFemales"));
				hospital.setLatLeft(rs.getInt("latLeft"));
				hospital.setLatRight(rs.getInt("latRight"));
				hospital.setLatUni(rs.getInt("latUni"));
				hospital.setLatBi(rs.getInt("latBi"));
				hospital.setAffectedRels(rs.getInt("affectedRels"));
				hospital.setAffectedRelsNot(rs.getInt("affectedRelsNot"));
				hospital.setAffectedRelsIDK(rs.getInt("affectedRelsIDK"));
				hospital.setNumOfVisits(rs.getInt("numOfVisits"));
				rh.add(hospital);
			}
			
			ps.close();
			rs.close();
			return rh;
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
