package edu.uiowa.icr.implementation;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import edu.uiowa.icr.implementation.inter.UserRepo;
import edu.uiowa.icr.models.Evaluator;
import edu.uiowa.icr.models.Hospital;
import edu.uiowa.icr.models.User;

import javax.sql.DataSource;

import java.sql.Connection; 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 * 
 * @author David
 * This class represents the InMemoryAddUser class that uses CRUD actions (methods) to manipulate data in the database
 */
@Repository
public class InMemoryAddUser implements UserRepo{

	private DataSource dataSource;	// Instantiation of the datasource object
	private JdbcTemplate jdbcTemplateObject;	// Instantiation of the JdbcTemplate object
	private List<User> listOfUsers = new ArrayList<User>();	// Creation of a new list of users
	
	// JDBCTemplate subclass DataSource sets up the environment to allow data to be manipulated in this Spring app
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;	// Sets the current object this of the class's attribute dataSource eqal to the object of datasource
		this.jdbcTemplateObject = new JdbcTemplate(dataSource); // Instantiation of the JDBCTemplateObject class which takes in the object of datasource to set up data synchronization
		
	}
	
	public InMemoryAddUser() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// This method effectively adds data that was saved to the model to the MySQL instance of the database
	public void addUser(User user) {
		listOfUsers.add(user);	// Adds the object of the model "user" to the list created above
		int id = user.getId();	// Gets the integer value of the user id
		String login = user.getUserName(); // Gets the user name from the model
		String email = user.getEmail();	// Gets the email from the model
		Set<Integer> hospitalIds = user.getHospitalIds();	// Gets the hospital id
		int roleId = user.getRoleId();	// Gets the user role id

		email ="smeold@eng.uiowa.edu";
		roleId = 5;
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");	// Sets up the date format for data to be properly synchronized to the database
		Date date = new Date();	// Instantiation of the Date class
		Connection connection = null;	// Instantiation of the database connection
		
		/**
		 * The following contains a set of prepared statements to be prepared to be synchronized to the MySql database.
		 * The prepared statements pull information that was saved to the model via the form submission.
		 */
		try {
			connection = dataSource.getConnection();	// Connection of the dataSource with the MySql sever
			
			String apsql = "Insert into abstract_person (id, created) values (?, ?)";	// First sql statement that contains the information to query into abstract_person
			PreparedStatement ps = connection.prepareStatement(apsql); // Instantiation of the class "PreparedStatement" of how the query statements are prepared to be added to the database with an instantiation of the database connection
            int nextPersonId = this.getMaxPersonID() + 1;
            try {
               ps.setInt(1, nextPersonId);	
			   ps.setString(2, dateFormat.format(date));
			   ps.executeUpdate();
			   ps.close();
            } catch (Exception nestede1) {
	        	System.out.println("BBROWN FIRST");
        	    System.out.println(nestede1);
            }
	        try {		
			String usql = "Insert into user (id, login, email, role_id) values (?, ?, ?, ?)"; // First sql statement that contains the information to query into user
			PreparedStatement ps2 = connection.prepareStatement(usql);
			ps2.setInt(1, nextPersonId);
			ps2.setString(2, login);
			ps2.setString(3, email);
			ps2.setInt(4, roleId);
			ps2.executeUpdate();
			ps2.close();
	        } catch (Exception nestede) {
	        	System.out.println("BBROWN SECOND");
	        	System.out.println(nestede);
	        }
	        try {
	        	String hsql = "Insert into user_hospital (user_id, hospital_id) values (?, ?)"; // First sql statement that contains the information to query into hospital
		        
			    for (Integer hospId: hospitalIds)
			    {
			       System.out.println("ITERATING THR HOSPI ID IN INSERT USER.  Hpsit id is " +hospId+ "  and user id is "+nextPersonId);
			       PreparedStatement ps3 = connection.prepareStatement(hsql);
			       ps3.setInt(1, nextPersonId);
			       ps3.setInt(2, hospId);
			       ps3.executeUpdate();
		           ps3.close();   	    
			    }
			
			    //ps3.close();
	        } catch (Exception nested3) {
	        	System.out.println("BBROWN THIRD");
	        	System.out.println(nested3);
	        }
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

	public User getUser(int id) {
		Connection conn = null;	// Resets the connection to the database
		User user = null;	// Resets the model
		
		/**
		 * Reseting the database connection to retrieve information that's stored in the mysql database
		 * via queries that are sent through the open connection. The results of the data received by this class
		 * is saved in a result set to be displayed in the jsp view. 
		 */
		try {
			conn = dataSource.getConnection();
			//a.login was a.login
			String sql = "Select u.id, u.login, u.email, r.id as role_id, r.name as role_name " +
						 "from user u " +
					     "inner join abstract_person ap on u.id = ap.id " +
					    
					     "inner join role r on u.role_id = r.id " +
					     "where u.id = ?"; 
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				user = new User(
					rs.getInt("id"),
					rs.getString("login"),
					rs.getString("email"),
					rs.getInt("role_id"),
					rs.getString("role_name")
				);
			}
			rs.close();
			ps.close();
			return user;
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
		listOfUsers.add(user);	// Adds the object of the model "user" to the list created above
		int id = user.getId();	// Gets the integer value of the user id
		String login = user.getUserName(); // Gets the user name from the model
		String email = user.getEmail();	// Gets the email from the model
		Set<Integer> hospitalIds = user.getHospitalIds();	// Gets the hospital id
		int roleId = user.getRoleId();	// Gets the user role id

		Connection connection = null;	// Instantiation of the database connection
		
		/**
		 * The following contains a set of prepared statements to be prepared to be synchronized to the MySql database.
		 * The prepared statements pull information that was saved to the model via the form submission.
		 */
		try {
			connection = dataSource.getConnection();	// Connection of the dataSource with the MySql sever
			
			String sql = "Update user set login = ?, email = ?, role_id = ? where id = ?"; // First sql statement that contains the information to query into user
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, login);
			ps.setString(2, email);
			ps.setInt(3, roleId);
			ps.setInt(4, id);
			ps.executeUpdate();
			ps.close();
			
			//sql = "Update user_hospital set hospital_id = ? where user_id = ?"; // First sql statement that contains the information to query into hospital
			//PreparedStatement ps2 = connection.prepareStatement(sql);
			//ps2.setInt(1, hospitalId);
			//ps2.setInt(2, id);
			//ps2.executeUpdate();
			//ps2.close();
			
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
	 * Method that retrieves all Users data from a series of sql queries to the database, and puts it into a result set
	 * to be viewed in the "view" pages
	 */
	@Override
	public List<User> getAllUsers() {
		Connection conn = null;	// Resets the connection to the database
		User user = null;	// Resets the model
		List<User> users = null; // Resets the List
		
		/**
		 * Reseting the database connection to retrieve information that's stored in the mysql database
		 * via queries that are sent through the open connection. The results of the data received by this class
		 * is saved in a result set to be displayed in the jsp view. 
		 */
		try {
			conn = dataSource.getConnection();
			
			String sql = "select u.id as user_id, u.login, u.email, r.id as role_id, r.name as role_name " +
						 "from user u " +
					     "inner join abstract_person ap on u.id = ap.id " +
					    
					     "inner join role r on u.role_id = r.id " +
					     "order by u.id";
			PreparedStatement ps = conn.prepareStatement(sql);	
			ResultSet rs = ps.executeQuery();
			
			if (rs.last()) {
			  users = new ArrayList<>(rs.getRow());
			  rs.beforeFirst(); 
			}
			
			while (rs.next()) {
				user = new User(
					rs.getInt("user_id"),
					rs.getString("login"),
					rs.getString("email"),
					rs.getInt("role_id"),
					rs.getString("role_name")
				);
				users.add(user);
			}

			String getHospitals = "select uh.hospital_id " +
					 " from user_hospital uh " +
					 " where uh.user_id = ? ";
			PreparedStatement psh = conn.prepareStatement(getHospitals);
			for (User u: users) {
				
				psh.setInt(1,u.getId());
                ResultSet hrs = psh.executeQuery();
                Set<Integer> userHospitals = new HashSet<Integer>();
                while (hrs.next()) {
                	//userHospitals.add(Integer.getInteger(""+hrs.getInt(1)));
                	int h_id  = hrs.getInt("hospital_id");
                	System.out.println("HHHHHOSPITLA ID "+h_id);
                    userHospitals.add(new Integer(h_id));	
                }
                u.setHospitalIds(userHospitals);
                hrs.close();
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

	/**
	 * Method that retrieves the max person id
	 */
	@Override
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
	
	public Map<Integer, String> getAllRoles() {
		Connection conn = null; // Resets the connection to the database
		Map<Integer, String> roles = new LinkedHashMap<Integer,String>();
		
		try {
			conn = dataSource.getConnection();
			
			String sql = "Select * from role";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				roles.put(rs.getInt("id"), rs.getString("name"));
			}
			
			rs.close();
			ps.close();
			return roles;
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
