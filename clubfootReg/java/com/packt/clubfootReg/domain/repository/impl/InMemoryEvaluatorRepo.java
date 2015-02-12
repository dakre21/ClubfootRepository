package com.packt.clubfootReg.domain.repository.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
			
			String sql = "Insert into abstract_person values(?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, this.getMaxPersonID()+1);
			ps.setInt(2, 1);
			ps.setString(3, dateFormat.format(date));
			ps.setString(4, first_name);
			ps.setString(5, last_name);
			ps.setString(6, middle_name);
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
			
			String sql = "Select * from evaluator where id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				evaluator = new Evaluator(
					rs.getInt("id"),
					rs.getString("first_name"),
					rs.getString("last_name"),
					rs.getString("middle_name"),
					rs.getString("title"),
					rs.getInt(6)
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
			
			String sql = "Select * from evaluator order by last_name";
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
					rs.getInt(6)
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
		// TODO Auto-generated method stub
		
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
}
