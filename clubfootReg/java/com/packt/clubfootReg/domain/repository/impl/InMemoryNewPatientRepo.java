package com.packt.clubfootReg.domain.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.packt.clubfootReg.domain.newPatient;
import com.packt.clubfootReg.domain.repository.newPatientRepo;

import javax.sql.DataSource;
import java.sql.Connection; 
import java.sql.SQLException;
import java.sql.PreparedStatement;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

@Repository
public class InMemoryNewPatientRepo implements newPatientRepo{
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	private List<newPatient> listOfPatients = new ArrayList<newPatient>();
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
		
	}
	
	public void addPatient(newPatient newpatient) {
		listOfPatients.add(newpatient);
		int id = newpatient.getId();
		String street = newpatient.getAddr1();
		String city = newpatient.getVillage();
		String state = newpatient.getProvince();
		String country = newpatient.getCountry();
		String dob = newpatient.getDob();
		String name = newpatient.getHospital();
		String relationship_to_patient = newpatient.getGuardian_relationship();
		String consent_inclusion = newpatient.getGuardianConsent();
		String consent_photos = newpatient.getPhotoConsent();
		String first_name = newpatient.getPatient_firstName();
		String last_name = newpatient.getPatient_lastName();
		String middle_name = newpatient.getPatient_midName();
		String first_nameG = newpatient.getGuardian_firstName();
		String last_nameG = newpatient.getGuardian_lastName();
		String middle_nameG = newpatient.getGuardian_midName();
		String query = "Insert into address (id, street, city, state, country) values (?, ?, ?, ?, ?)";
		String query2 = "Insert into patient (id, dob, consent_inclusion, consent_photos) values (?, ?, ?, ?)";
		String query3 = "Insert into hospital (id, name) values (?, ?)";
		String query4 = "Insert into patient_associates (patient_id, relationship_to_patient) values (?, ?)";
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ps.setString(2, street);
			ps.setString(3, city);
			ps.setString(4, state);
			ps.setString(5, country);
			ps.executeUpdate();
			ps.close();
/*		
			PreparedStatement ps1 = conn.prepareStatement(query2);
			ps1.setInt(1, id);
			ps1.setString(2, dob);
			ps1.setString(3, consent_inclusion);
			ps1.setString(4, consent_photos);
			ps1.executeUpdate();
			ps1.close();
*/		
			PreparedStatement ps2 = conn.prepareStatement(query3);
			ps2.setInt(1, id);
			ps2.setString(2, name);
			ps2.executeUpdate();
			ps2.close();
/*			
			PreparedStatement ps3 = conn.prepareStatement(query4);
			ps3.setInt(1, id);
			ps3.setString(2,  relationship_to_patient);
			ps3.executeUpdate();
			ps3.close();
*/			
		} catch (SQLException e) {
			throw new RuntimeException(e);
 
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
		
		return;
	}
	public InMemoryNewPatientRepo() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void deletePatient(int id) {
		String query = "delete from patient where id = ?";
		jdbcTemplateObject.update(query, id);
		System.out.println("Deleted patient with id = " + id);
	}
	public void updatePatient(newPatient newpatient) {
		
		
	}

	public List<newPatient> getPatient(int id) {
		String query = "select * from patient where id = ?";
		List <newPatient> patients = jdbcTemplateObject.query(query, new PatientMapper());
		return patients;
	}
	public newPatient getNewPatient(int id) {
		String query = "select * from patient where id = ?";
		newPatient patient = jdbcTemplateObject.queryForObject(query, new Object[]{id}, new PatientMapper());
		return patient;
	}


}
