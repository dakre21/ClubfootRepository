package edu.uiowa.icr.implementation;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import edu.uiowa.icr.implementation.inter.HospitalRepo;
//import edu.uiowa.icr.models.Evaluator;
import edu.uiowa.icr.models.Hospital;
import edu.uiowa.icr.models.ReportsHospital;
import edu.uiowa.icr.models.Region;
import edu.uiowa.icr.util.*;
import org.hibernate.*;

import java.sql.Connection; 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;

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
	
	public Hospital getHospital1(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	// This method effectively adds data that was saved to the model to the MySQL instance of the database
	public void addHospital(Hospital hospital) {
		listOfHospitals.add(hospital); // Adds the object of the model "hospital" to the list created above
		String hospitalName = hospital.getHospitalName();	// Gets the String name from the hospital model
		Long regionId = hospital.getRegionId(); // Gets the integer value of the region id
        System.out.println("regionId from GUI hospital object: "+regionId);
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		  
        session.beginTransaction();
        
        Query regquery = session.createQuery("from Region where id= :id");
        regquery.setLong("id", regionId);
        Region region = (Region) regquery.uniqueResult();
        session.save(new Hospital(hospital.getHospitalName(), region));
        //session.save(hospital);
        session.getTransaction().commit();
        session.close();
        
		//Connection connection = null;	// Instantiation of the connection to the database
		
		/**
		 * The following contains a set of prepared statements to be prepared to be synchronized to the MySql database.
		 * The prepared statements pull information that was saved to the model via the form submission.
		 */
        /*
		try {
			connection = dataSource.getConnection(); // Connection of the dataSource with the MySql sever
			
			String sql = "Insert into hospital (id, name, region_id) values(?, ?, ?)"; // First sql statement that contains the information to query into hospital
			PreparedStatement ps = connection.prepareStatement(sql); // Instantiation of the class "PreparedStatement" of how the query statements are prepared to be added to the database and establishment of the sql query
			
			ps.setInt(1, this.getMaxHospitalID()+1);
			ps.setString(2, hospitalName);
			ps.setInt(3, regionId);
			
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
		*/
		return;
	}
	
	/**
	 * Reseting the database connection to retrieve information that's stored in the mysql database
	 * via queries that are sent through the open connection. The results of the data received by this class
	 * is saved in a result set to be displayed in the jsp view. 
	 */
	public Hospital getHospital(Long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		  
        session.beginTransaction();
        Query query = session.createQuery("from Hospital where id= :id");
        query.setLong("id", id);
        Hospital hospital = (Hospital) query.uniqueResult();
        session.getTransaction().commit();
        session.close();
		return hospital;
		/*
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
		*/
	}
	
	public List<Hospital> getAllHospitals() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		  
        session.beginTransaction();
        Query q = session.createQuery("From Hospital ");
        
        List<Hospital> resultList = q.list();
        session.getTransaction().commit();
        session.close();
        return resultList;
        
		//Connection conn = null; // Resets the connection to the database
		//Hospital hospital = null; // Resets the model
		//List<Hospital> hospitals = null; // Resets the list
		
		/**
		 * Reseting the database connection to retrieve information that's stored in the mysql database
		 * via queries that are sent through the open connection. The results of the data received by this class
		 * is saved in a result set to be displayed in the jsp view. 
		 */
		/*
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
				System.out.println(hospital.getHospitalName());
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
		*/
	}

	/**
	 * Method the effectively deletes hospital information stored in the database
	 */
	public void deleteHospital(Long id) {
		// TODO Auto-generated method stub
		
	}
	public void updateHospital(Hospital hospital) {
		listOfHospitals.add(hospital);
		Long id = hospital.getId();
		Long regionId = hospital.getRegionId(); // Gets the integer value of the region id
		Session session = HibernateUtil.getSessionFactory().openSession();
		  
        session.beginTransaction();
    	 Query regquery = session.createQuery("from Hospital where id= :id");
	        regquery.setLong("id", id);
	        Hospital hosp = (Hospital) regquery.uniqueResult();
	     Query rQuery = session.createQuery("from Region where id = :id");
	        rQuery.setLong("id", regionId);
	        Region reg = (Region) rQuery.uniqueResult();
            hosp.setHospitalName(hospital.getHospitalName());
            hosp.setRegion(reg);
            session.update(hosp);
	        session.getTransaction().commit();
	        session.close();
		
		/*
		listOfHospitals.add(hospital);
		Long id = hospital.getId();
		Session session = HibernateUtil.getSessionFactory().openSession();
		System.out.println("IN updateHospital");  
		System.out.println("REGION ID FOR GUI HOSPITAL: "+hospital.getRegionId());
		System.out.println("REGION NAME FOR GUI HOSPITAL: "+hospital.getRegionName());
        session.beginTransaction();
    	Query regquery = session.createQuery("from Hospital where id= :id");
	    regquery.setLong("id", id);
	    Hospital existingHosp = (Hospital) regquery.uniqueResult();
        existingHosp.setHospitalName(hospital.getHospitalName());
        existingHosp.setRegion(hospital.getRegion());
        //session.update(hospital);
        session.update(existingHosp);
	    session.getTransaction().commit();
	    session.close();
	     */  
/*
	        String hospitalName = hospital.getHospitalName();
		int regionId = hospital.getRegionId();
	
		String sql = "Update hospital set name = ?, region_id = ? where id = ?";
		
        session.getTransaction().commit();
        
		
		Connection connection = null;
		PreparedStatement ps = null;
		
		try {
			connection = dataSource.getConnection();
			
			ps = connection.prepareStatement(sql);
			ps.setString(1, hospitalName);
			ps.setInt(2, regionId);
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
    */		
	}
	
	/**
	 * Method that retrieves the max hospital id
	 */
	public Long getMaxHospitalID() {
		Connection conn = null; // Resets the connection to the database
		Long max = new Long(0);
		
		try {
			conn = dataSource.getConnection();
			
			String sql = "Select max(id) from hospital";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				max = rs.getLong(1);
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

	public Map<Long, String> getAllRegions() {
		Session session = edu.uiowa.icr.util.HibernateUtil.getSessionFactory().openSession();
		  
        session.beginTransaction();
        Query q = session.createQuery("From Region ");

        List<Region> resultList = q.list();
        //session.getTransaction().commit();
      //  session.close();
		Map<Long, String> regions = new LinkedHashMap<Long, String>();
        for (Region next : resultList) {
            //System.out.println("next region: " + next.getName());
            regions.put(next.getId(), next.getName());
        }
        return regions;
        /*
        
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
	   */	
	}

	@Override
	public List<ReportsHospital> getAllHospitalsReports(Long hospitalId) {
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
				   			"(select count(*) from visit where a.id = hospital_id) as numOfVisits, " +
				   			"(select count(*) from foot d inner join visit e on d.visit_id = e.id where a.id = e.hospital_id and left(treatment, 1) = 'C') as treatmentC, " +
				   		    "(select count(*) from foot d inner join visit e on d.visit_id = e.id where a.id = e.hospital_id and left(treatment, 1) = 'B') as treatmentB, " +
				   		    "(select count(*) from foot d inner join visit e on d.visit_id = e.id where a.id = e.hospital_id and left(treatment, 1) = 'T') as treatmentT " +
				   		 "from hospital a " +
				   		 "inner join patient b on a.id = b.hospital_id " +
				   		 "inner join region c on a.region_id = c.id ";
		    
		    if (hospitalId != 0) {
		    	sql = sql + "where a.id = " + hospitalId + " group by a.name, c.name";
		    } 
		    else {
		    	sql = sql + "group by a.name, c.name";
		    }
				   		 
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
				hospital.setTreatmentC(rs.getInt("treatmentC"));
				hospital.setTreatmentB(rs.getInt("treatmentB"));
				hospital.setTreatmentT(rs.getInt("treatmentT"));
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
