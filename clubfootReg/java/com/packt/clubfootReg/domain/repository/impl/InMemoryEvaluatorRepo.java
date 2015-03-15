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
import com.packt.clubfootReg.domain.repository.EvaluatorRepo;

import java.sql.Connection; 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 
 * @author David
 * This class represents the InMemoryEvaluatorRepo class that uses CRUD actions (methods) to manipulate data in the database
 */
@Repository
public class InMemoryEvaluatorRepo implements EvaluatorRepo{

	private DataSource dataSource; // Instantiation of the datasource object
	private JdbcTemplate jdbcTemplateObject; // Instantiation of the JdbcTemplate object
	private List<Evaluator> listOfEvaluators = new ArrayList<Evaluator>(); // Creation of a new list of users
	
	// JDBCTemplate subclass DataSource sets up the environment to allow data to be manipulated in this Spring app
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource; // Sets the current object this of the class's attribute dataSource eqal to the object of datasource
		this.jdbcTemplateObject = new JdbcTemplate(dataSource); // Instantiation of the JDBCTemplateObject class which takes in the object of datasource to set up data synchronization
		
	}
	
	public InMemoryEvaluatorRepo() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

	// This method effectively adds data that was saved to the model to the MySQL instance of the database
	public void addEvaluator(Evaluator evaluator) {
		listOfEvaluators.add(evaluator); // Adds the object of the model "evaluator" to the list created above
		String first_name = evaluator.getFirst_name(); // Gets the String first_name from the evaluator model
		String middle_name = evaluator.getMiddle_name(); // Gets the String middle_name from the evaluator model
		String last_name = evaluator.getLast_name(); // Gets the String last_name from the evaluator model
		String title = evaluator.getTitle(); // Gets the String title from the evaluator model
		int hospital = evaluator.getHospital_id(); // Gets the integer value of the evaluator id
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); // Sets up the date format for data to be properly synchronized to the database
		Date date = new Date(); // Instantiation of the Date class
		Connection connection = null; // Instantiation of the connection to the database
		
		/**
		 * The following contains a set of prepared statements to be prepared to be synchronized to the MySql database.
		 * The prepared statements pull information that was saved to the model via the form submission.
		 */
		try {
			connection = dataSource.getConnection(); // Connection of the dataSource with the MySql sever
			
			String sql = "Insert into abstract_person (id, created, first_name, last_name, middle_name) values(?, ?, ?, ?, ?)"; // First sql statement that contains the information to query into abstract_person
			PreparedStatement ps = connection.prepareStatement(sql); // Instantiation of the class "PreparedStatement" of how the query statements are prepared to be added to the database and connection to the database with the sql query
			ps.setInt(1, this.getMaxPersonID()+1);
			ps.setString(2, dateFormat.format(date));
			ps.setString(3, first_name);
			ps.setString(4, last_name);
			ps.setString(5, middle_name);
			ps.executeUpdate();
			ps.close();
			
			String sql2 = "Insert into evaluator values(?, ?, ?)"; // First sql statement that contains the information to query into evaluator
			PreparedStatement ps2 = connection.prepareStatement(sql2);
			ps2.setInt(1, this.getMaxPersonID());
			ps2.setString(2, title);
			ps2.setInt(3, hospital);
			ps2.executeUpdate();
			ps2.close();
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

	public Evaluator getEvaluator(int id) {
		Connection conn = null;
		Evaluator evaluator = null;
		
		try {
			conn = dataSource.getConnection();
			
			String sql = "Select a.*, b.first_name, b.last_name, b.middle_name, c.name " +
						 "from evaluator a " +
						 "inner join abstract_person b on a.id = b.id " +
						 "inner join hospital c on a.hospital_id = c.id " +
						 "where a.id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				System.out.println("evaluator exists");
				evaluator = new Evaluator(
					rs.getInt("id"),
					rs.getString("first_name"),
					rs.getString("last_name"),
					rs.getString("middle_name"),
					rs.getString("title"),
					rs.getString("name"),
					rs.getInt("hospital_id")
				);
			}
			rs.close();
			ps.close();
			return evaluator;
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
	 * Method that retrieves all Users data from a series of sql queries to the database, and puts it into a result set
	 * to be viewed in the "view" pages
	 */
	public List<Evaluator> getAllEvaluators() {
		Connection conn = null;
		Evaluator evaluator = null;
		List<Evaluator> evaluators = null;
		
		try {
			conn = dataSource.getConnection();
			
			String sql = "Select a.*, b.first_name, b.last_name, b.middle_name, c.name " +
					     "from evaluator a " +
					     "inner join abstract_person b on a.id = b.id " +
					     "inner join hospital c on a.hospital_id = c.id " +
					     "order by b.last_name";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			if (rs.last()) {
			  evaluators = new ArrayList<>(rs.getRow());
			  rs.beforeFirst(); 
			}
			
			while (rs.next()) {
				evaluator = new Evaluator(
					rs.getInt("id"),
					rs.getString("first_name"),
					rs.getString("last_name"),
					rs.getString("middle_name"),
					rs.getString("title"),
					rs.getString("name"),
					rs.getInt("hospital_id")
				);
				evaluators.add(evaluator);
			}
			rs.close();
			ps.close();
			return evaluators;
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

	public void deleteEvaluator(int id) {
		String sql = "Delete from evaluator where id = ?";
		jdbcTemplateObject.update(sql, id);
		System.out.println("Deleted patient with id = " + id);	
	}

	public void updateEvaluator(Evaluator evaluator) {
		listOfEvaluators.add(evaluator);
		int id = evaluator.getId();
		String first_name = evaluator.getFirst_name();
		String middle_name = evaluator.getMiddle_name();
		String last_name = evaluator.getLast_name();
		String title = evaluator.getTitle();
		int hospital = evaluator.getHospital_id();
	
		String sql_abstract_person = "Update abstract_person set first_name = ?, last_name = ?, middle_name = ? where id = ?";
		String sql_evaluator = "Update evaluator set title = ?, hospital_id = ? where id = ?";
		
		Connection connection = null;
		PreparedStatement ps = null;
		
		try {
			connection = dataSource.getConnection();
			
			// Abstract Person
			ps = connection.prepareStatement(sql_abstract_person);
			ps.setString(1, first_name);
			ps.setString(2, last_name);
			ps.setString(3, middle_name);
			ps.setInt(4, id);
			ps.executeUpdate();
			ps.close();
			
			// Evaluator
			ps = connection.prepareStatement(sql_evaluator);
			ps.setString(1, title);
			ps.setInt(2, hospital);
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
	 * Method that retrieves the max person id
	 */
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
}
