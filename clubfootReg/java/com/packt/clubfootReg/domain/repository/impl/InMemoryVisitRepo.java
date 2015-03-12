package com.packt.clubfootReg.domain.repository.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.packt.clubfootReg.domain.Hospital;
import com.packt.clubfootReg.domain.Visit;
import com.packt.clubfootReg.domain.repository.VisitRepo;

import javax.sql.DataSource;

import java.sql.Connection; 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

@Repository
public class InMemoryVisitRepo implements VisitRepo{

	public InMemoryVisitRepo() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	private List<Visit> listOfVisits = new ArrayList<Visit>();
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public void addVisit(Visit visit) {
		listOfVisits.add(visit);
		
		int visitId = this.getMaxVisitId() + 1;
		int patientId = visit.getPatientId();
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
		
		String sql_visit = "Insert into visit (id, evaluator_id, patient_id, hospital_id, is_last_visit, " +
					   	   "next_visit_date, relapse, complications, complications_description, " +
					   	   "complications_results, general_comments) " +
		                   "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		//String sql_left_foot = "Insert into foot (id, visit_id, laterality, varus, cavus, abductus, equinus, pc, eh, re, mc, thc, clb, " +
		//					   "cast_number, abduction, dorsiflexion, brace_compliance, brace_problems, brace_action, surgery_other, " +
		//					   "surgery_comment, other_details) " +
		//					   "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		String sql_left_foot = "Insert into foot (id, visit_id, laterality, varus, cavus, abductus, equinus, pc, eh, re, mc, thc, clb) " +
   				               "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		String sql_right_foot = "Insert into foot (id, visit_id, laterality, varus, cavus, abductus, equinus, pc, eh, re, mc, thc, clb) " +
				   				"values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		Connection connection = null;
		PreparedStatement ps = null;
		
		try {
			connection = dataSource.getConnection();
			
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
			ps.setString(5, isLastVisit);
			ps.setString(6, nextVisitDate);
			ps.setString(7, relapse);
			ps.setString(8, complications);
			ps.setString(9, description);
			ps.setString(10, results);
			ps.setString(11, comments);
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
			ps.setInt(13, leftCLB);
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
			ps.setInt(13, rightCLB);
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

	
	public List<Visit> getVisit(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteVisit(int id) {
		String query = "delete from visit where id = ?";
		jdbcTemplateObject.update(query, id);
		System.out.println("Deleted visit with id = " + id);
		
	}

	public void updateVisit(Visit visit) {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public List<Visit> getAllVisits() {
		Connection conn = null;
		Visit visit = null;
		List<Visit> visits = null;
		
		try {
			conn = dataSource.getConnection();
			
			String sql = "Select * from visit order by id";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			if (rs.last()) {
			  visits = new ArrayList<>(rs.getRow());
			  rs.beforeFirst(); 
			}
			
			while (rs.next()) {
				visit = new Visit(
					rs.getInt("id")
				);
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

	
	@Override
	public int getMaxVisitId() {
		Connection conn = null;
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

	
	@Override
	public int getMaxFootId() {
		Connection conn = null;
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
