package com.packt.clubfootReg.domain.repository.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.mysql.jdbc.CallableStatement;
import com.packt.clubfootReg.domain.Hospital;
import com.packt.clubfootReg.domain.ReportsHospital;
import com.packt.clubfootReg.domain.ReportsVisits;
import com.packt.clubfootReg.domain.Visit;
import com.packt.clubfootReg.domain.newPatient;
import com.packt.clubfootReg.domain.repository.VisitRepo;

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
 * This class represents the InMemoryVisitrepo class that uses CRUD actions (methods) to manipulate data in the database
 */
@Repository
public class InMemoryVisitRepo implements VisitRepo{

	public InMemoryVisitRepo() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private DataSource dataSource; // Instantiation of the datasource object
	private JdbcTemplate jdbcTemplateObject; // Instantiation of the JdbcTemplate object
	private List<Visit> listOfVisits = new ArrayList<Visit>(); // Creation of a new list of users
	
	// JDBCTemplate subclass DataSource sets up the environment to allow data to be manipulated in this Spring app
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource; // Sets the current object this of the class's attribute dataSource eqal to the object of datasource
		this.jdbcTemplateObject = new JdbcTemplate(dataSource); // Instantiation of the JDBCTemplateObject class which takes in the object of datasource to set up data synchronization
	}

	// This method effectively adds data that was saved to the model to the MySQL instance of the database
	public void addVisit(Visit visit) {
		listOfVisits.add(visit); // Adds the object of the model "visit" to the list created above
		
		// The visit model has around 60 fields that are being retrieved in this instance of the repo class
		// There are integers, strings, and date formatted information that is saved from the form to the model 
		// That is going to be synchronized to the database
		int visitId = this.getMaxVisitId() + 1;	// Gets the max integer value of the visit id
		int patientId = visit.getPatientId(); // Gets the integer value of the visit id
		Integer hospitalId = visit.getHospitalId();
		Integer evaluatorId = visit.getEvaluatorId();
		String dateOfVisit = visit.getDateOfVisit();
		String isLastVisit = visit.getIsLastVisit();
		String nextVisitDate = visit.getNextVisitDate();
		String relapse = visit.getRelapse();
		
		Integer hindfootLeftVarus = visit.getHindfootLeftVarus();
		Integer hindfootLeftCavus = visit.getHindfootLeftCavus();
		Integer hindfootLeftAbductus = visit.getHindfootLeftAbductus();
		Integer hindfootLeftEquinus = visit.getHindfootLeftEquinus();
		Integer leftPC = visit.getLeftPC();
		Integer leftEH = visit.getLeftEH();
		Integer leftRE = visit.getLeftRE();
		Integer leftMC = visit.getLeftMC();
		Integer leftTHC = visit.getLeftTHC();
		Integer leftCLB = visit.getLeftCLB();
		String leftTreatment = visit.getLeftTreatment();
		
		Integer casterLeft = visit.getCasterLeft();
		Integer castLeftNum = visit.getCastLeftNum();
		Integer abductionLeft = visit.getAbductionLeft();
		Integer dorsiflexionLeft = visit.getDorsiflexionLeft();
		String braceLeft = visit.getBraceLeft();
		String problemsLeft = visit.getProblemsLeft();
		String actionsLeft = visit.getActionsLeft();
		String surgeryLeft = visit.getSurgeryLeft();
		String leftSurgeryComments = visit.getLeftSurgeryComments();
		String otherLeft = visit.getOtherLeft();
		
		Integer hindfootRightVarus = visit.getHindfootRightVarus();
		Integer hindfootRightCavus = visit.getHindfootRightCavus();
		Integer hindfootRightAbductus = visit.getHindfootRightAbductus();
		Integer hindfootRightEquinus = visit.getHindfootRightEquinus();
		Integer rightPC = visit.getRightPC();
		Integer rightEH = visit.getRightEH();
		Integer rightRE = visit.getRightRE();
		Integer rightMC = visit.getRightMC();
		Integer rightTHC = visit.getRightTHC();
		Integer rightCLB = visit.getRightCLB();
		String rightTreatment = visit.getRightTreatment();
		
		Integer casterRight = visit.getCasterRight();
		Integer castRightNum = visit.getCastRightNum();
		Integer abductionRight = visit.getAbductionRight();
		Integer dorsiflexionRight = visit.getDorsiflexionRight();
		String braceRight = visit.getBraceRight();
		String problemsRight = visit.getProblemsRight();
		String actionsRight = visit.getActionsRight();
		String surgeryRight = visit.getSurgeryRight();
		String rightSurgeryComments = visit.getRightSurgeryComments();
		String otherRight = visit.getOtherRight();
		
		String complications = visit.getComplications();
		String description = visit.getDescription();
		String treatmentComplications = visit.getTreatmentComplications();
		String results = visit.getResults();
		String comments = visit.getComments();
		
		String sql_visit = "Insert into visit (id, evaluator_id, patient_id, hospital_id, visit_date, is_last_visit, " +
					   	   "next_visit_date, relapse, complications, complications_description, complications_treatment, " +
					   	   "complications_results, general_comments) " +
		                   "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"; // First sql statement that contains the information to query into visit
		
		//String sql_left_foot = "Insert into foot (id, visit_id, laterality, varus, cavus, abductus, equinus, pc, eh, re, mc, thc, clb, " +
		//					   "cast_number, abduction, dorsiflexion, brace_compliance, brace_problems, brace_action, surgery_other, " +
		//					   "surgery_comment, other_details) " +
		//					   "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		String sql_left_foot = "Insert into foot (id, visit_id, laterality, varus, cavus, abductus, equinus, pc, eh, re, mc, thc, treatment, clb) " +
   				               "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"; // First sql statement that contains the information to query into left foot
		
		String sql_right_foot = "Insert into foot (id, visit_id, laterality, varus, cavus, abductus, equinus, pc, eh, re, mc, thc, treatment, clb) " +
				   				"values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"; // First sql statement that contains the information to query into right foot
		
		Connection connection = null;	// Instantiation of the connection to the database
		PreparedStatement ps = null; // Instantiation of the class "PreparedStatement" of how the query statements are prepared to be added to the database
		
		/**
		 * The following contains a set of prepared statements to be prepared to be synchronized to the MySql database.
		 * The prepared statements pull information that was saved to the model via the form submission.
		 */
		try {
			connection = dataSource.getConnection(); // Connection of the dataSource with the MySql sever
			
			// VISIT
			ps = connection.prepareStatement(sql_visit);
			ps.setInt(1, visitId);
			/*
			ps.setInt(2, 0);
			ps.setInt(3, patientId);
			ps.setInt(4, 1);
			ps.setString(5, "No");
			ps.setString(6, "2015-03-26");
			ps.setString(7, "No");
			ps.setString(8, "test");
			ps.setString(9, "test");
			ps.setString(10, "test");
			ps.setString(11, "test");
			*/
			ps.setInt(2, evaluatorId);
			ps.setInt(3, patientId);
			ps.setInt(4, hospitalId);
			ps.setString(5, dateOfVisit);
			ps.setString(6, isLastVisit);
			ps.setString(7, nextVisitDate);
			ps.setString(8, relapse);
			ps.setString(9, complications);
			ps.setString(10, description);
			ps.setString(11, treatmentComplications);
			ps.setString(12, results);
			ps.setString(13, comments);
			ps.executeUpdate();
			ps.close();
			
			// LEFT FOOT
			ps = connection.prepareStatement(sql_left_foot);
			ps.setInt(1, this.getMaxFootId() + 1);
			ps.setInt(2, visitId);
			ps.setString(3, "Left");
			/*
			ps.setInt(4, 1);
			ps.setInt(5, 1);
			ps.setInt(6, 20);
			ps.setInt(7, 20);
			ps.setInt(8, 1);
			ps.setInt(9, 1);
			ps.setInt(10, 1);
			ps.setInt(11, 1);
			ps.setInt(12, 1);
			ps.setInt(13, 1);
			*/
			/*
			ps.setInt(14, castLeftNum);
			ps.setInt(15, abductionLeft);
			ps.setInt(16, dorsiflexionLeft);
			ps.setString(17, braceLeft);
			ps.setString(18, problemsLeft);
			ps.setString(19, actionsLeft);
			ps.setString(20, surgeryLeft);
			ps.setString(21, leftSurgeryComments);
			ps.setString(22, otherLeft);
			*/
			ps.setInt(4, hindfootLeftVarus);
			ps.setInt(5, hindfootLeftCavus);
			ps.setInt(6, hindfootLeftAbductus);
			ps.setInt(7, hindfootLeftEquinus);
			ps.setInt(8, leftPC);
			ps.setInt(9, leftEH);
			ps.setInt(10, leftRE);
			ps.setInt(11, leftMC);
			ps.setInt(12, leftTHC);
			ps.setString(13, leftTreatment);
			ps.setInt(14, leftCLB);
			ps.executeUpdate();
			ps.close();
			
			
			// RIGHT FOOT
			ps = connection.prepareStatement(sql_right_foot);
			ps.setInt(1, this.getMaxFootId() + 1);
			ps.setInt(2, visitId);
			ps.setString(3, "Right");
			/*
			ps.setInt(4, 1);
			ps.setInt(5, 1);
			ps.setInt(6, 20);
			ps.setInt(7, 20);
			ps.setInt(8, 1);
			ps.setInt(9, 1);
			ps.setInt(10, 1);
			ps.setInt(11, 1);
			ps.setInt(12, 1);
			ps.setInt(13, 1);
			*/
			ps.setInt(4, hindfootRightVarus);
			ps.setInt(5, hindfootRightCavus);
			ps.setInt(6, hindfootRightAbductus);
			ps.setInt(7, hindfootRightEquinus);
			ps.setInt(8, rightPC);
			ps.setInt(9, rightEH);
			ps.setInt(10, rightRE);
			ps.setInt(11, rightMC);
			ps.setInt(12, rightTHC);
			ps.setString(13, rightTreatment);
			ps.setInt(14, rightCLB);
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
	 * Method the effectively deletes visit information stored in the database
	 */
	public void deleteVisit(int id) {
		String query = "delete from visit where id = ?";
		jdbcTemplateObject.update(query, id);
		System.out.println("Deleted visit with id = " + id);
		
	}

	public void updateVisit(Visit visit) {
		listOfVisits.add(visit); // Adds the object of the model "visit" to the list created above
		
		// The visit model has around 60 fields that are being retrieved in this instance of the repo class
		// There are integers, strings, and date formatted information that is saved from the form to the model 
		// That is going to be synchronized to the database
		int visitId = visit.getId();	// Gets the max integer value of the visit id
		int patientId = visit.getPatientId(); // Gets the integer value of the visit id
		Integer hospitalId = visit.getHospitalId();
		Integer evaluatorId = visit.getEvaluatorId();
		String dateOfVisit = visit.getDateOfVisit();
		String isLastVisit = visit.getIsLastVisit();
		String nextVisitDate = visit.getNextVisitDate();
		String relapse = visit.getRelapse();
		
		Integer hindfootLeftVarus = visit.getHindfootLeftVarus();
		Integer hindfootLeftCavus = visit.getHindfootLeftCavus();
		Integer hindfootLeftAbductus = visit.getHindfootLeftAbductus();
		Integer hindfootLeftEquinus = visit.getHindfootLeftEquinus();
		Integer leftPC = visit.getLeftPC();
		Integer leftEH = visit.getLeftEH();
		Integer leftRE = visit.getLeftRE();
		Integer leftMC = visit.getLeftPC();
		Integer leftTHC = visit.getLeftEH();
		Integer leftCLB = visit.getLeftRE();
		String leftTreatment = visit.getLeftTreatment();
		
		Integer casterLeft = visit.getCasterLeft();
		Integer castLeftNum = visit.getCastLeftNum();
		Integer abductionLeft = visit.getAbductionLeft();
		Integer dorsiflexionLeft = visit.getDorsiflexionLeft();
		String braceLeft = visit.getBraceLeft();
		String problemsLeft = visit.getProblemsLeft();
		String actionsLeft = visit.getActionsLeft();
		String surgeryLeft = visit.getSurgeryLeft();
		String leftSurgeryComments = visit.getLeftSurgeryComments();
		String otherLeft = visit.getOtherLeft();
		
		Integer hindfootRightVarus = visit.getHindfootRightVarus();
		Integer hindfootRightCavus = visit.getHindfootRightCavus();
		Integer hindfootRightAbductus = visit.getHindfootRightAbductus();
		Integer hindfootRightEquinus = visit.getHindfootRightEquinus();
		Integer rightPC = visit.getRightPC();
		Integer rightEH = visit.getRightEH();
		Integer rightRE = visit.getRightRE();
		Integer rightMC = visit.getRightPC();
		Integer rightTHC = visit.getRightEH();
		Integer rightCLB = visit.getRightRE();
		String rightTreatment = visit.getRightTreatment();
		
		Integer casterRight = visit.getCasterRight();
		Integer castRightNum = visit.getCastRightNum();
		Integer abductionRight = visit.getAbductionRight();
		Integer dorsiflexionRight = visit.getDorsiflexionRight();
		String braceRight = visit.getBraceRight();
		String problemsRight = visit.getProblemsRight();
		String actionsRight = visit.getActionsRight();
		String surgeryRight = visit.getSurgeryRight();
		String rightSurgeryComments = visit.getRightSurgeryComments();
		String otherRight = visit.getOtherRight();
		
		String complications = visit.getComplications();
		String description = visit.getDescription();
		String treatmentComplications = visit.getTreatmentComplications();
		String results = visit.getResults();
		String comments = visit.getComments();
		
		String sql_visit = "Update visit set evaluator_id = ?, hospital_id = ?, visit_date = ?, is_last_visit = ?, " +
			   	   			  "next_visit_date = ?, relapse = ?, complications = ?, complications_description = ?, " +
			   	   			  "complications_treatment = ?, complications_results = ?, general_comments = ? " +
			   	   			  "where id = ?";
		
		String sql_left_foot = "Update foot set varus = ?, cavus = ?, abductus = ?, equinus = ?, " +
						       	  "pc = ?, eh = ?, re = ?, mc = ?, thc = ?, clb = ?, treatment = ? " +
						       "Where visit_id = ? and laterality = 'left'";
		
		String sql_right_foot = "Update foot set varus = ?, cavus = ?, abductus = ?, equinus = ?, " +
				                   "pc = ?, eh = ?, re = ?, mc = ?, thc = ?, clb = ?, treatment = ? " +
				                "Where visit_id = ? and laterality = 'right'";

		Connection connection = null;
		PreparedStatement ps = null;
		
		try {
			connection = dataSource.getConnection(); // Connection of the dataSource with the MySql sever
			
			// VISIT
			ps = connection.prepareStatement(sql_visit);
			ps.setInt(1, evaluatorId);
			ps.setInt(2, hospitalId);
			ps.setString(3, dateOfVisit);
			ps.setString(4, isLastVisit);
			ps.setString(5, nextVisitDate);
			ps.setString(6, relapse);
			ps.setString(7, complications);
			ps.setString(8, description);
			ps.setString(9, treatmentComplications);
			ps.setString(10, results);
			ps.setString(11, comments);
			ps.setInt(12, visitId);
			ps.executeUpdate();
			ps.close();
			
			// LEFT FOOT
			ps = connection.prepareStatement(sql_left_foot);
			ps.setInt(1, hindfootLeftVarus);
			ps.setInt(2, hindfootLeftCavus);
			ps.setInt(3, hindfootLeftAbductus);
			ps.setInt(4, hindfootLeftEquinus);
			ps.setInt(5, leftPC);
			ps.setInt(6, leftEH);
			ps.setInt(7, leftRE);
			ps.setInt(8, leftMC);
			ps.setInt(9, leftTHC);
			ps.setInt(10, leftCLB);
			ps.setString(11, leftTreatment);
			ps.setInt(12, visitId);
			ps.executeUpdate();
			ps.close();
			
			// RIGHT FOOT
			ps = connection.prepareStatement(sql_right_foot);
			ps.setInt(1, hindfootRightVarus);
			ps.setInt(2, hindfootRightCavus);
			ps.setInt(3, hindfootRightAbductus);
			ps.setInt(4, hindfootRightEquinus);
			ps.setInt(5, rightPC);
			ps.setInt(6, rightEH);
			ps.setInt(7, rightRE);
			ps.setInt(8, rightMC);
			ps.setInt(9, rightTHC);
			ps.setInt(10, rightCLB);
			ps.setString(11, rightTreatment);
			ps.setInt(12, visitId);
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
	 * Method that retrieves all Users data from a series of sql queries to the database, and puts it into a result set
	 * to be viewed in the "view" pages
	 */
	@Override
	public List<Visit> getAllVisits() {
		Connection conn = null; // Resets the connection to the database
		Visit visit = null; // Resets the model
		List<Visit> visits = null; // Resets the list
		
		/**
		 * Reseting the database connection to retrieve information that's stored in the mysql database
		 * via queries that are sent through the open connection. The results of the data received by this class
		 * is saved in a result set to be displayed in the jsp view. 
		 */
		try {
			conn = dataSource.getConnection();
			
			String sql = "Select * from visit order by id";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			PreparedStatement ps2 = null;
			ResultSet rs2 = null;
			PreparedStatement ps3 = null;
			ResultSet rs3 = null;
			
			if (rs.last()) {
			  visits = new ArrayList<>(rs.getRow());
			  rs.beforeFirst(); 
			}
			
			while (rs.next()) {
				visit = new Visit(
					rs.getInt("patient_id")
				);
				visit.setId(rs.getInt("id"));
				visit.setPatientId(rs.getInt("patient_id"));
				visit.setHospitalId(rs.getInt("hospital_id"));
				
				String sql2 = "Select * from foot where visit_id = ? and laterality = 'Left'";
				ps2 = conn.prepareStatement(sql2);
				ps2.setInt(1, rs.getInt("id"));
				rs2 = ps2.executeQuery();
				
				if (rs2.next()) {
					visit.setLeftTreatment(rs2.getString("treatment"));
				}
				
				String sql3 = "Select * from foot where visit_id = ? and laterality = 'Right'";
				ps3 = conn.prepareStatement(sql3);
				ps3.setInt(1, rs.getInt("id"));
				rs3 = ps3.executeQuery();
				
				if (rs3.next()) {
					visit.setRightTreatment(rs3.getString("treatment"));
				}
				
				visits.add(visit);
			}
			rs.close();
			ps.close();
			rs2.close();
			ps2.close();
			rs3.close();
			ps3.close();
			return visits;
		} catch (SQLException e) { // Catches SQL exception errors
			throw new RuntimeException(e);
		} finally {
			if (conn != null) { // Closes SQL connection 
				try {
				conn.close();
				} catch (SQLException e) {}
			}
		}
	}

	/**
	 * Method that retrieves the max visit id
	 */
	@Override
	public int getMaxVisitId() {
		Connection conn = null; // Resets the connection to the database
		int max = 0;
		
		try {
			conn = dataSource.getConnection();
			
			String sql = "Select max(id) from visit";
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

	/**
	 * Method that receives the max foot id from the database
	 */
	@Override
	public int getMaxFootId() {
		Connection conn = null; // Resets the connection to the database
		int max = 0;
		
		try {
			conn = dataSource.getConnection();
			
			String sql = "Select max(id) from foot";
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
	
	public List<Visit> getVisitsForPatient(int patient_id) {
		Connection conn = null; // Resets the connection to the database
		Visit visit = null; // Resets the model
		List<Visit> visits = null; // Resets the list
		
		/**
		 * Reseting the database connection to retrieve information that's stored in the mysql database
		 * via queries that are sent through the open connection. The results of the data received by this class
		 * is saved in a result set to be displayed in the jsp view. 
		 */
		try {
			conn = dataSource.getConnection();
			
			String sql = "select a.id, a.visit_date, " +
					     "(select treatment from foot b join visit d on b.visit_id = d.id where b.visit_id = a.id and laterality = 'Left') as leftTreatment, " +
					     "(select sum(if(pc=2,0.5,pc)+if(eh=2,0.5,eh)+if(re=2,0.5,re)+if(mc=2,0.5,mc)+if(thc=2,0.5,thc)+if(clb=2,0.5,clb)) " +
					     "from foot z join visit y on z.visit_id = y.id where z.visit_id = a.id and laterality = 'Left') as leftScore, " +
					     "(select treatment from foot c join visit e on c.visit_id = e.id where c.visit_id = a.id and laterality = 'Right') as rightTreatment, " +
					     "(select sum(if(pc=2,0.5,pc)+if(eh=2,0.5,eh)+if(re=2,0.5,re)+if(mc=2,0.5,mc)+if(thc=2,0.5,thc)+if(clb=2,0.5,clb)) " +
					     "from foot z join visit y on z.visit_id = y.id where z.visit_id = a.id and laterality = 'Right') as rightScore " +
					     "from visit a " +
					     "where patient_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, patient_id);
			ResultSet rs = ps.executeQuery();
			
			if (rs.last()) {
			  visits = new ArrayList<>(rs.getRow());
			  rs.beforeFirst(); 
			}
			
			while (rs.next()) {
				visit = new Visit(patient_id);
				visit.setId(rs.getInt("id"));
				visit.setDateOfVisit(rs.getString("visit_date"));
				visit.setLeftTreatment(rs.getString("leftTreatment"));
				visit.setLeftScore(rs.getInt("leftScore"));
				visit.setRightTreatment(rs.getString("rightTreatment"));
				visit.setRightScore(rs.getInt("rightScore"));
				visits.add(visit);
			}
			
			rs.close();
			ps.close();
			return visits;
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
	
	public String getLateralityForPatient(int id) {
		Connection conn = null; // Resets the connection to the database
		String lat = "";
		
		try {
			conn = dataSource.getConnection();
			
			String sql = "Select feet_affected from patient where id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				lat = rs.getString(1);
			} 
			
			rs.close();
			ps.close();
			return lat;
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
	 * 
	 * Method that returns a mapped vector of int and string values for all hosptials
	 */
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
	
	public Map<Integer, String> getAllEvaluators() {
		Connection conn = null; // Resets the connection to the database
		Map<Integer, String> evaluators = new LinkedHashMap<Integer,String>();
		
		try {
			conn = dataSource.getConnection();
			
			String sql = "Select a.id, concat(b.last_name, ', ', b.first_name, ' ', left(b.middle_name, 1)) as name " + 
						 "From evaluator a inner join abstract_person b on a.id = b.id " +
						 "Order by b.last_name";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				evaluators.put(rs.getInt("id"), rs.getString("name"));
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

	@Override
	public Visit getVisit(int id) {
		Connection conn = null; // Resets the connection to the database
		Visit visit = null; // Resets the model
		
		try {
			conn = dataSource.getConnection();
			String sql = "select * from visit where id = ?";	
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				visit = new Visit(rs.getInt("patient_id"));
				visit.setEvaluatorId(rs.getInt("evaluator_id"));
				visit.setCasterLeft(rs.getInt("primary_caster_left_id"));
				visit.setCasterRight(rs.getInt("primary_caster_right_id"));
				visit.setPatientId(rs.getInt("patient_id"));
				visit.setHospitalId(rs.getInt("hospital_id"));
				visit.setDateOfVisit(rs.getString("visit_date"));
				visit.setIsLastVisit(rs.getString("is_last_visit"));
				visit.setNextVisitDate(rs.getString("next_visit_date"));
				visit.setRelapse(rs.getString("relapse"));
				visit.setComplications(rs.getString("complications"));
				visit.setComments(rs.getString("general_comments"));
				visit.setDescription(rs.getString("complications_description"));
				visit.setTreatmentComplications(rs.getString("complications_treatment"));
				visit.setResults(rs.getString("complications_results"));
				
				//visit.setCasterLeft(rs.getInt("casterLeft"));
				visit.setCastLeftNum(rs.getInt("primary_caster_left_id"));
				//visit.setCasterRight(rs.getInt("casterRight"));
				visit.setCastRightNum(rs.getInt("primary_caster_right_id"));
				
			}
			
			ps.close();
			rs.close();
			
			String sql1 = "select * from foot where visit_id = ? and laterality = 'left'";	
			PreparedStatement ps1 = conn.prepareStatement(sql1);
			ps1.setInt(1, id);
			ResultSet rs1 = ps1.executeQuery();
			
			if(rs1.next()){
				visit.setHindfootLeftVarus(rs1.getInt("varus"));
				visit.setHindfootLeftCavus(rs1.getInt("cavus"));
				visit.setHindfootLeftAbductus(rs1.getInt("abductus"));
				visit.setHindfootLeftEquinus(rs1.getInt("equinus"));
				visit.setLeftPC(rs1.getInt("pc"));
				visit.setLeftEH(rs1.getInt("eh"));
				visit.setLeftRE(rs1.getInt("re"));
				visit.setLeftMC(rs1.getInt("mc"));
				visit.setLeftTHC(rs1.getInt("thc"));
				visit.setLeftCLB(rs1.getInt("clb"));
				visit.setLeftTreatment(rs1.getString("treatment"));
				visit.setAbductionLeft(rs1.getInt("abduction"));
				visit.setDorsiflexionLeft(rs1.getInt("dorsiflexion"));
				visit.setBraceLeft(rs1.getString("brace_compliance"));
				//visit.setProblemsLeft(rs1.getString("problemsLeft"));
				//visit.setActionsLeft(rs1.getString("actionsLeft"));
				visit.setSurgeryLeft(rs1.getString("surgery_other"));
				//visit.setMidfootLeftTalar(rs1.getString("talar"));
				//visit.setMidfootLeftMedial(rs1.getString("medial"));
				visit.setMidfootLeftEquinus(rs1.getString("equinus"));
				//visit.setMidfootLeftHeel(rs1.getString("heel"));
				//visit.setMidfootLeftLateral(rs1.getString("lateral"));
				visit.setOtherLeft(rs1.getString("other_details"));
				//visit.setMidfootLeftPosterior(rs1.getString("posterior"));
				visit.setLeftSurgeryComments(rs1.getString("surgery_comment"));
			}
			
			ps1.close();
			rs1.close();
			
			String sql2 = "select * from foot where visit_id = ? and laterality = 'right'";	
			PreparedStatement ps2 = conn.prepareStatement(sql2);
			ps2.setInt(1, id);
			ResultSet rs2 = ps2.executeQuery();
			
			if(rs2.next()){
				visit.setHindfootRightVarus(rs2.getInt("varus"));
				visit.setHindfootRightCavus(rs2.getInt("cavus"));
				visit.setHindfootRightAbductus(rs2.getInt("abductus"));
				visit.setHindfootRightEquinus(rs2.getInt("equinus"));
				visit.setRightPC(rs2.getInt("pc"));
				visit.setRightEH(rs2.getInt("eh"));
				visit.setRightRE(rs2.getInt("re"));
				visit.setRightMC(rs2.getInt("mc"));
				visit.setRightTHC(rs2.getInt("thc"));
				visit.setRightCLB(rs2.getInt("clb"));
				visit.setRightTreatment(rs2.getString("treatment"));
				visit.setAbductionRight(rs2.getInt("abduction"));
				visit.setDorsiflexionRight(rs2.getInt("dorsiflexion"));
				visit.setBraceRight(rs2.getString("brace_compliance"));
				//visit.setProblemsRight(rs2.getString("problemsRight"));
				//visit.setActionsRight(rs2.getString("actionsRight"));
				visit.setSurgeryRight(rs2.getString("surgery_other"));
				//visit.setMidfootRightTalar(rs2.getString("talar"));
				//visit.setMidfootRightMedial(rs2.getString("medial"));
				visit.setMidfootRightEquinus(rs2.getString("equinus"));
				//visit.setMidfootRightHeel(rs2.getString("heel"));
				//visit.setMidfootRightLateral(rs2.getString("lateral"));
				visit.setOtherRight(rs2.getString("other_details"));
				//visit.setMidfootRightPosterior(rs2.getString("posterior"));
				visit.setRightSurgeryComments(rs2.getString("surgery_comment"));
			}
			
			ps2.close();
			rs2.close();
			
			return visit;
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
	public List<Visit> getAllVisitsReports(ReportsVisits filter) {
		Connection conn = null; // Resets the connection to the database
		Visit visit = null; // Resets the model
		List<Visit> rv = null; // Resets the list
		
		/**
		 * Reseting the database connection to retrieve information that's stored in the mysql database
		 * via queries that are sent through the open connection. The results of the data received by this class
		 * is saved in a result set to be displayed in the jsp view. 
		 */
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = dataSource.getConnection();
			
			if (filter == null) {
				String sql = "select a.id, a.hospital_id, a.patient_id, " +
							   "(select treatment from foot b join visit d on b.visit_id = d.id where b.visit_id = a.id and laterality = 'Left') as leftTreatment, " +
							   "(select treatment from foot c join visit e on c.visit_id = e.id where c.visit_id = a.id and laterality = 'Right') as rightTreatment " +
							 "from visit a";
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
			}
			else {
				CallableStatement cs = (CallableStatement) conn.prepareCall("{call filterVisitReport(?, ?, ?, ?, ?)}");
				
				Integer hospital_id = filter.getHospital_id();
				String complications = filter.getComplications();
				String relapse = filter.getRelapse();
				String leftTreatment = filter.getLeftTreatment();
				String rightTreatment = filter.getRightTreatment();
				
				if(hospital_id != null){
					cs.setInt(1, hospital_id);
				}
				else{
					cs.setInt(1, 0);
				}
				
				if(complications != null){
					cs.setString(2, complications);
				}
				else{
					cs.setString(2, "null");
				}
				
				if (relapse != null) {
					if (relapse.equalsIgnoreCase("yes")) {
						cs.setString(3, "yes");
					}
					else if (relapse.equalsIgnoreCase("no")) {
						cs.setString(3, "no");
					}
					else {
						cs.setString(3, "unspecified");
					}
				}
				else { 
					cs.setString(3, "null"); 
				}
				
				if(leftTreatment != null){
					cs.setString(4, leftTreatment);
				}
				else{
					cs.setString(4, "null");
				}
				
				if(rightTreatment != null){
					cs.setString(5, rightTreatment);
				}
				else{
					cs.setString(5, "null");
				}
				
				cs.execute();
				rs = cs.getResultSet();
			}
				
				if (rs.last()) {
					rv = new ArrayList<>(rs.getRow());
					rs.beforeFirst(); 
				}
				
				while (rs.next()) {
					visit = new Visit();
					visit.setId(rs.getInt("id"));
					visit.setPatientId(rs.getInt("patient_id"));
					visit.setHospitalId(rs.getInt("hospital_id"));
				 	visit.setLeftTreatment(rs.getString("leftTreatment"));
					visit.setRightTreatment(rs.getString("rightTreatment"));
					rv.add(visit);
				}
			
				if (ps != null)
					ps.close();
			
				rs.close();
				return rv;
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
	
	public List<newPatient> getAllPatients() {
		Connection conn = null; // Resets the connection to the database
		newPatient patient = null; // Resets the model
		List<newPatient> patients = null; // Resets the list
		
		/**
		 * Reseting the database connection to retrieve information that's stored in the mysql database
		 * via queries that are sent through the open connection. The results of the data received by this class
		 * is saved in a result set to be displayed in the jsp view. 
		 */
		try {
			conn = dataSource.getConnection();
			
			String sql = "select a.id, a.consent_inclusion, a.consent_photos, a.hospital_id, b.first_name, b.last_name, " +
		    		            "b.middle_name, a.dob, a.evaluator_id, a.evaluation_date, a.feet_affected, a.diagnosis, " +
		    		            "a.sex, a.race " +
		    		     "from patient a " +
		    		     "inner join abstract_person b on a.id = b.id " +
		    		     "order by a.id";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			if (rs.last()) {
			  patients = new ArrayList<>(rs.getRow());
			  rs.beforeFirst(); 
			}
			
			while (rs.next()) {
				patient = new newPatient(
					rs.getInt("id"),
					rs.getInt("consent_inclusion"),
					rs.getInt("consent_photos"),
					rs.getInt("hospital_id"),
					rs.getString("first_name"),
					rs.getString("last_name"),
					rs.getString("middle_name"),
					rs.getString("dob"),
					rs.getInt("evaluator_id"),
					rs.getString("evaluation_date"),
					rs.getString("feet_affected"),
					rs.getString("diagnosis")
				);
				patients.add(patient);
			}
			rs.close();
			ps.close();
			return patients;
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
	
	public newPatient getPatient(int id) {
		Connection conn = null; // Resets the connection to the database
		newPatient patient = null; // Resets the model
		
		try {
			conn = dataSource.getConnection();
			
			// Required Patient Info
			String sql = "select a.id, a.consent_inclusion, a.consent_photos, a.hospital_id, b.first_name, b.last_name, " +
					    		"b.middle_name, a.dob, a.evaluator_id, a.evaluation_date, a.feet_affected, a.diagnosis " +
					    		"from patient a " +
					    		"inner join abstract_person b on a.id = b.id " +
					    		"where a.id = ?";	
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				patient = new newPatient(
					rs.getInt("id"),
					rs.getInt("consent_inclusion"),
					rs.getInt("consent_photos"),
					rs.getInt("hospital_id"),
					rs.getString("first_name"),
					rs.getString("last_name"),
					rs.getString("middle_name"),
					rs.getString("dob"),
					rs.getInt("evaluator_id"),
					rs.getString("evaluation_date"),
					rs.getString("feet_affected"),
					rs.getString("diagnosis")
				);
			}
			
			rs.close();
			ps.close();
			
			
			// Rest of the Patient info
			sql = "select * from patient where id = ?";
			PreparedStatement ps2 = conn.prepareStatement(sql);
			ps2.setInt(1, id);
			ResultSet rs2 = ps2.executeQuery();
			
			if (rs2.next()) {
				patient.setTribe(rs2.getString("tribe"));
				patient.setDeformityAtBirth(rs2.getString("deformity_at_birth"));
				patient.setDiagnosisPrenatallyWeek(rs2.getInt("prenatal_week"));
				patient.setPrenatallyDiagConfirmation(rs2.getString("prenatal_confirmed"));
				patient.setDiagnosisComments(rs2.getString("diagnosis_comment"));
				patient.setReferral(rs2.getString("referral_source"));
				patient.setReferralDocName(rs2.getString("referral_doctor_name"));
				patient.setReferralHospitalName(rs2.getString("referral_hospital_name"));
				patient.setReferralOther(rs2.getString("referral_other"));
				patient.setDeformityHistoryNum(rs2.getInt("affected_relatives"));
				patient.setPregnancy(rs2.getInt("pregency_length"));
				patient.setPregnancyComplicationsExplained(rs2.getString("pregnancy_complications"));
				patient.setPregnancyAlc(rs2.getString("pregnancy_drinking"));
				patient.setPregnancySmoke(rs2.getString("pregnancy_smoking"));
				patient.setComplications(rs2.getString("birth_complications"));
				patient.setPlaceBirth(rs2.getInt("birth_place"));
				patient.setSex(rs2.getString("sex"));
				patient.setRace(rs2.getString("race"));
			}
			
			rs2.close();
			ps2.close();
			
			
			// Guardian/Emergency Contact Info
			sql = "select a.id, b.relationship_to_patient, b.phone1, b.phone2, b.is_emergency_contact, c.is_affected, d.first_name, d.last_name, d.middle_name " +
				  "from patient a " +
				  "inner join patient_associates b on a.id = b.patient_id " +
				  "inner join associate c on b.associate_id = c.id " +
				  "inner join abstract_person d on c.id = d.id " +
				  "where a.id = ?";
			PreparedStatement ps3 = conn.prepareStatement(sql);
			ps3.setInt(1, id);
			ResultSet rs3 = ps3.executeQuery();
			
			int count = 0;
			while (rs3.next()) {
				if (count == 0) {
					patient.setGuardianRelationship(rs3.getString("relationship_to_patient"));
					patient.setGuardianPhone1(rs3.getString("phone1"));
					patient.setGuardianPhone2(rs3.getString("phone2"));
					patient.setGuardianFirstName(rs3.getString("first_Name"));
					patient.setGuardianLastName(rs3.getString("last_name"));
					patient.setGuardianMiddleName(rs3.getString("middle_name"));
					if (rs3.getInt("is_emergency_contact") == 1) {
						patient.setEmergencyContact("primary");
					}
				}
				else if (count == 1) {
					patient.setSecondGuardianRelationship(rs3.getString("relationship_to_patient"));
					patient.setSecondGuardianPhone1(rs3.getString("phone1"));
					patient.setSecondGuardianPhone2(rs3.getString("phone2"));
					patient.setSecondGuardianFirst(rs3.getString("first_Name"));
					patient.setSecondGuardianLast(rs3.getString("last_name"));
					patient.setSecondGuardianMiddle(rs3.getString("middle_name"));
					if (rs3.getInt("is_emergency_contact") == 1) {
						patient.setEmergencyContact("secondary");
					}
				}
				else {
					patient.setOtherGuardianRelationship(rs3.getString("relationship_to_patient"));
					patient.setOtherGuardianPhone1(rs3.getString("phone1"));
					patient.setOtherGuardianPhone2(rs3.getString("phone2"));
					patient.setOtherGuardianFirst(rs3.getString("first_Name"));
					patient.setOtherGuardianLast(rs3.getString("last_name"));
					patient.setOtherGuardianMiddle(rs3.getString("middle_name"));
					if (rs3.getInt("is_emergency_contact") == 1) {
						patient.setEmergencyContact("other");
					}
				}
				count++;
			}
			
			rs3.close();
			ps3.close();
			
			
			// Patient Address info
			sql = "select c.* " +
				  "from patient a " +
				  "inner join abstract_person b on a.id = b.id " +
				  "inner join address c on b.address_id = c.id " +
				  "where a.id = ?";
			PreparedStatement ps4 = conn.prepareStatement(sql);
			ps4.setInt(1, id);
			ResultSet rs4 = ps4.executeQuery();
			
			if (rs4.next()) {
				patient.setAddr1(rs4.getString("street"));
				patient.setVillage(rs4.getString("city"));
				patient.setProvince(rs4.getString("state"));
				patient.setCountry(rs4.getString("country"));
			}
			
			rs4.close();
			ps4.close();
			
			return patient;
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