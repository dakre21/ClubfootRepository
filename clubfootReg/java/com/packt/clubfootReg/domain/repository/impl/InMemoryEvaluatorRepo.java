package com.packt.clubfootReg.domain.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.packt.clubfootReg.domain.Evaluator;
import com.packt.clubfootReg.domain.repository.EvaluatorRepo;

import javax.sql.DataSource;

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

	public Evaluator getEvaluator1(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void addEvaluator(Evaluator evaluator) {
		listOfEvaluators.add(evaluator);
		int id = evaluator.getId();
/*		Connection connection = null;
		
		try {
			connection = dataSource.getConnection();
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ps.setString(2, hospitalName);
			ps.setString(3, userName);
			ps.executeUpdate();
			ps.close();
		}catch (SQLException e) {
			throw new RuntimeException(e);
 
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {}
			}
		}*/
		
		return;
		
	}

	public List<Evaluator> getEvaluator(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteEvaluator(int id) {
		// TODO Auto-generated method stub
		
	}

	public void updateEvaluator(Evaluator evaluator) {
		// TODO Auto-generated method stub
		
	}

}
