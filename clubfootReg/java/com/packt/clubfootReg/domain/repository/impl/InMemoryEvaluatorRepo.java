package com.packt.clubfootReg.domain.repository.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.packt.clubfootReg.domain.Evaluator;
import com.packt.clubfootReg.domain.newPatient;
import com.packt.clubfootReg.domain.repository.EvaluatorRepo;

import java.sql.Connection; 
import java.sql.SQLException;
import java.sql.PreparedStatement;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

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
		int id = evaluator.getId();
		String first_name = evaluator.getFirst_name();
		String middle_name = evaluator.getMiddle_name();
		String last_name = evaluator.getLast_name();
		String title = evaluator.getTitle();
		String hospital = evaluator.getHospitalName();
		Connection connection = null;
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
			 
		try {
			connection = dataSource.getConnection();
			
			String sql = "Insert into abstract_person values(?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, this.getMaxPersonID() + 1);
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
			ps2.setInt(6, 1);
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

	public List<Evaluator> getEvaluator(int id) {
		String sql = "Select * from evaluator where id = ?";
		List<Evaluator> evaluator = jdbcTemplateObject.query(sql, new EvaluatorMapper());
		return evaluator;
	}
	
	public List<Evaluator> getAllEvaluators() {
		String sql = "Select * from evaluator order by last_name";
		List<Evaluator> evaluator = jdbcTemplateObject.query(sql, new EvaluatorMapper());
		return evaluator;
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
		String sql = "Select max(id) from abstract_person";
		int person_id = jdbcTemplateObject.queryForInt(sql);
		return person_id;
	}
}
