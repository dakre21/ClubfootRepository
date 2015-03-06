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

@Repository
public class InMemoryEvaluatorRepo implements EvaluatorRepo{

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	private List<Evaluator> listOfEvaluators = new ArrayList<Evaluator>();
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
		
	}
	
	public InMemoryEvaluatorRepo() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

	public void addEvaluator(Evaluator evaluator) {
		listOfEvaluators.add(evaluator);
		String first_name = evaluator.getFirst_name();
		String middle_name = evaluator.getMiddle_name();
		String last_name = evaluator.getLast_name();
		String title = evaluator.getTitle();
		int hospital = evaluator.getHospital_id();
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		Connection connection = null;
		
		try {
			connection = dataSource.getConnection();
			
			String sql = "Insert into abstract_person (id, created, first_name, last_name, middle_name) values(?, ?, ?, ?, ?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, this.getMaxPersonID()+1);
			ps.setString(2, dateFormat.format(date));
			ps.setString(3, first_name);
			ps.setString(4, last_name);
			ps.setString(5, middle_name);
			ps.executeUpdate();
			ps.close();
			
			String sql2 = "Insert into evaluator values(?, ?, ?, ?, ?, ?)";
			PreparedStatement ps2 = connection.prepareStatement(sql2);
			ps2.setInt(1, this.getMaxPersonID());
			ps2.setString(2, first_name);
			ps2.setString(3, last_name);
			ps2.setString(4, middle_name);
			ps2.setString(5, title);
			ps2.setInt(6, hospital);
			ps2.executeUpdate();
			ps2.close();
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

	public Evaluator getEvaluator(int id) {
		Connection conn = null;
		Evaluator evaluator = null;
		
		try {
			conn = dataSource.getConnection();
			
			String sql = "Select a.*, b.name from evaluator a inner join hospital b on a.hospital_id = b.id where a.id = ?";
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
	
	public List<Evaluator> getAllEvaluators() {
		Connection conn = null;
		Evaluator evaluator = null;
		List<Evaluator> evaluators = null;
		
		try {
			conn = dataSource.getConnection();
			
			String sql = "Select a.*, b.name from evaluator a inner join hospital b on a.hospital_id = b.id order by last_name";
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
		String sql_evaluator = "Update evaluator set first_name = ?, last_name = ?, middle_name = ?, title = ?, hospital_id = ? " +
							   "where id = ?";
		
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
			ps.setString(1, first_name);
			ps.setString(2, last_name);
			ps.setString(3, middle_name);
			ps.setString(4, title);
			ps.setInt(5, hospital);
			ps.setInt(6, id);
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
