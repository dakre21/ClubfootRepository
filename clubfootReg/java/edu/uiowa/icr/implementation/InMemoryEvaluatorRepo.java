package edu.uiowa.icr.implementation;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

//import org.apache.log4j.Logger;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import edu.uiowa.icr.implementation.inter.EvaluatorRepo;
import edu.uiowa.icr.models.Evaluator;

import java.sql.Connection; 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 
 * @author David
 * This class represents the InMemoryEvaluatorRepo class that uses CRUD actions (methods) to manipulate data in the database
 */
@Repository
public class InMemoryEvaluatorRepo implements EvaluatorRepo{
	//static Logger log = Logger.getLogger(InMemoryEvaluatorRepo.class.getName());

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
		String firstName = evaluator.getFirstName(); // Gets the String first_name from the evaluator model
		String middleName = evaluator.getMiddleName(); // Gets the String middle_name from the evaluator model
		String lastName = evaluator.getLastName(); // Gets the String last_name from the evaluator model
		String title = evaluator.getTitle(); // Gets the String title from the evaluator model
		int hospitalId = evaluator.getHospitalId(); // Gets the integer value of the evaluator id
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); // Sets up the date format for data to be properly synchronized to the database
		Date date = new Date(); // Instantiation of the Date class
		Connection connection = null; // Instantiation of the connection to the database
		
		/**
		 * The following contains a set of prepared statements to be prepared to be synchronized to the MySql database.
		 * The prepared statements pull information that was saved to the model via the form submission.
		 */
		try {
			connection = dataSource.getConnection(); // Connection of the dataSource with the MySql sever
			//log.info("MaxPersonID+1: "+this.getMaxPersonID()+1);
			//log.info("DATE: "+ dateFormat.format(date));
			//log.info("Firstname: "+firstName);
			//log.info("lastname: "+lastName);
			//log.info("middleName: "+middleName);
			
			String sql = "Insert into abstract_person (created, first_name, last_name, middle_name) values(?, ?, ?, ?)"; // First sql statement that contains the information to query into abstract_person
			PreparedStatement ps = connection.prepareStatement(sql); // Instantiation of the class "PreparedStatement" of how the query statements are prepared to be added to the database and connection to the database with the sql query
			//ps.setInt(1, this.getMaxPersonID()+1);
			ps.setString(1, dateFormat.format(date));
			ps.setString(2, firstName);
			ps.setString(3, lastName);
			ps.setString(4, middleName);
			ps.executeUpdate();
		
			ResultSet rs = ps.executeQuery("select last_insert_id() as last_id from abstract_person");
			rs.next();
			int returnedId = rs.getInt("last_id");
			System.out.println("RETURNED ID :"+returnedId);
			rs.close();
			ps.close();
				
			String sql2 = "Insert into evaluator (id, title, hospital_id) values(?, ?, ?)"; // First sql statement that contains the information to query into evaluator
			PreparedStatement ps2 = connection.prepareStatement(sql2);
            //log.info("MaxPersonId: "+ this.getMaxPersonID());
			//ps2.setInt(1, this.getMaxPersonID());
			ps2.setInt(1, returnedId);
			System.out.println("Hospital Title: " +title);
			System.out.println("Hospital ID: "+ hospitalId);
			ps2.setString(2, title);
			ps2.setInt(3, hospitalId);
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
		Connection conn = null; // Resets the connection to the database
		Evaluator evaluator = null; // Resets the model
		
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
		Connection conn = null; // Resets the connection to the database
		Evaluator evaluator = null; // Resets the model
		List<Evaluator> evaluators = null; // Resets the list
		
		/**
		 * Reseting the database connection to retrieve information that's stored in the mysql database
		 * via queries that are sent through the open connection. The results of the data received by this class
		 * is saved in a result set to be displayed in the jsp view. 
		 */
		
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

	/**
	 * Method the effectively deletes evaluator information stored in the database
	 */
	public void deleteEvaluator(int id) {
		String sql = "Delete from evaluator where id = ?";
		jdbcTemplateObject.update(sql, id);
		System.out.println("Deleted patient with id = " + id);	
	}

	/**
	 * Method that updates the evaluator model
	 */
	public void updateEvaluator(Evaluator evaluator) {
		listOfEvaluators.add(evaluator);
		int id = evaluator.getId();
		String firstName = evaluator.getFirstName();
		String middleName = evaluator.getMiddleName();
		String lastName = evaluator.getLastName();
		String title = evaluator.getTitle();
		int hospitalId = evaluator.getHospitalId();
		
	
		String sqlAbstractPerson = "Update abstract_person set first_name = ?, last_name = ?, middle_name = ? where id = ?";
		String sqlEvaluator = "Update evaluator set title = ?, hospital_id = ? where id = ?";
		
		Connection connection = null;
		PreparedStatement ps = null;
		
		try {
			connection = dataSource.getConnection();
			
			// Abstract Person
			ps = connection.prepareStatement(sqlAbstractPerson);
			ps.setString(1, firstName);
			ps.setString(2, lastName);
			ps.setString(3, middleName);
			ps.setInt(4, id);
			ps.executeUpdate();
			ps.close();
			
			// Evaluator
			ps = connection.prepareStatement(sqlEvaluator);
			ps.setString(1, title);
			ps.setInt(2, hospitalId);
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
		Connection conn = null; // Resets the connection to the database
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
		Connection conn = null; // Resets the connection to the database
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
