package com.packt.clubfootReg.domain.repository.impl;

import java.util.ArrayList;
import java.util.List;

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

	public Visit getVisit1(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void addVisit(Visit visit) {
		listOfVisits.add(visit);
		int id = visit.getId();
		String query = "Insert into user values(?)";
		Connection connection = null;
		
		try {
			connection = dataSource.getConnection();
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
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

}
