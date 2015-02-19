package com.packt.clubfootReg.domain.repository.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.packt.clubfootReg.domain.Evaluator;
import com.packt.clubfootReg.domain.Hospital;
import com.packt.clubfootReg.domain.newPatient;
import com.packt.clubfootReg.domain.repository.newPatientRepo;

import javax.sql.DataSource;

import java.sql.Connection; 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
//import java.sql.Date;

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
		int guardianConsent = newpatient.getGuardianConsent();
		int photoConsent = newpatient.getPhotoConsent();
		String hospital = newpatient.getHospital();
		String patient_lastName = newpatient.getPatient_lastName();
		String patient_firstName = newpatient.getPatient_firstName();
		String patient_midName = newpatient.getPatient_midName();
		String sex = newpatient.getSex();
		String race = newpatient.getRace();
		//Date dob = newpatient.getDob();
		String dob = newpatient.getDob();
		String addr1 = newpatient.getAddr1();
		String addr2 = newpatient.getAddr2();
		String village = newpatient.getVillage();
		String province = newpatient.getProvince();
		String country = newpatient.getCountry();
		String guardian_lastName = newpatient.getGuardian_lastName();
		String guardian_firstName = newpatient.getGuardian_firstName();
		String guardian_midName = newpatient.getGuardian_midName();
		String guardian_relationship = newpatient.getGuardian_relationship();
		String guardian_phone1 = newpatient.getGuardian_phone1();
		String guardian_phone2 = newpatient.getGuardian_phone2();
		String second_guardian_last = newpatient.getSecond_guardian_last();
		String second_guardian_first = newpatient.getSecond_guardian_first();
		String second_guardian_mid = newpatient.getSecond_guardian_mid();
		String second_guardian_relationship = newpatient.getSecond_guardian_relationship();
		String second_guardian_phone1 = newpatient.getSecond_guardian_phone1();
		String second_guardian_phone2 = newpatient.getSecond_guardian_phone2();
		String emergency_contact = newpatient.getEmergency_contact();
		String other_guardian_last = newpatient.getOther_guardian_last();
		String other_guardian_first = newpatient.getOther_guardian_first();
		String other_guardian_mid = newpatient.getOther_guardian_mid();
		String other_guardian_relationship = newpatient.getOther_guardian_relationship();
		String other_guardian_phone1 = newpatient.getOther_guardian_phone1();
		String other_guardian_phone2 = newpatient.getOther_guardian_phone2();
		String deformity_history = newpatient.getDeformity_history();
		//int deformity_history_num = newpatient.getDeformity_history_num();
		String deformity_history_num = newpatient.getDeformity_history_num();
		String pregnancy = newpatient.getPregnancy();
		String pregnancy_complications_explained = newpatient.getPregnancy_complications_explained();
		String pregnancy_alc = newpatient.getPregnancy_alc();
		String pregnancy_smoke = newpatient.getPregnancy_smoke();
		String complications = newpatient.getComplications();
		String place_birth = newpatient.getPlace_birth();
		String referral = newpatient.getReferral();
		String referral_doc_name = newpatient.getReferral_doc_name();
		String referral_hospital_name = newpatient.getReferral_hospital_name();
		String referral_other = newpatient.getReferral_other();
		//int evaluator = newpatient.getEvaluator();
		String evaluator = newpatient.getEvaluator();
		//Date evaluation_date = newpatient.getEvaluation_date();
		String evaluation_date = newpatient.getEvaluation_date();
		String feet = newpatient.getFeet();
		String diagnosis = newpatient.getDiagnosis();
		String deformity_at_birth = newpatient.getDeformity_at_birth();
		String previous_treatments = newpatient.getPrevious_treatments();
		//int previous_treatments_num = newpatient.getPrevious_treatments_num();
		String previous_treatments_num = newpatient.getPrevious_treatments_num();
		String diagnosis_prenatally = newpatient.getDiagnosis_prenatally();
		//int diagnosis_prenatally_week = newpatient.getDiagnosis_prenatally_week();
		String diagnosis_prenatally_week = newpatient.getDiagnosis_prenatally_week();
		String prenatally_diag_confirmation = newpatient.getPrenatally_diag_confirmation();
		String diagnosis_comments = newpatient.getDiagnosis_comments();
		String abnormalities = newpatient.getAbnormalities();
		String weakness = newpatient.getWeakness();
		

		String sql_address = "Insert into address (id, street, city, state, country) values (?, ?, ?, ?, ?)";
		String sql_abstract_person = "Insert into abstract_person (id, address_id, created, first_name, last_name, middle_name) "
				                   + "values (?, ?, ?, ?, ?, ?)";
		
		String sql_previous_treatments = "";
		String sql_associate = "";
		String sql_patient_associates = "Insert into patient_associates (patient_id, relationship_to_patient) values (?, ?)";
		
		
		String sql_patient = "Insert into patient (id) values (?)";
		
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		Connection conn = null;
		PreparedStatement ps;
		
		try {
			conn = dataSource.getConnection();
			
			// ADDRESS
			ps = conn.prepareStatement(sql_address);
			ps.setInt(1, getMaxAddressID()+1);
			ps.setString(2, addr1);
			ps.setString(3, village);
			ps.setString(4, province);
			ps.setString(5, country);
			ps.executeUpdate();
			ps.close();
			
			
			// ABSTRACT_PERSON
			ps = conn.prepareStatement(sql_abstract_person);
			ps.setInt(1, getMaxPersonID()+1);
			ps.setInt(2, getMaxAddressID());
			ps.setString(3, dateFormat.format(date));
			ps.setString(4, patient_firstName);
			ps.setString(5, patient_lastName);
			ps.setString(6, patient_midName);
			ps.executeUpdate();
			ps.close();
			
			// PATIENT
			ps = conn.prepareStatement(sql_patient);
			ps.setInt(1, getMaxPersonID());
			ps.executeUpdate();
			ps.close();
			
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

	public newPatient getPatient(int id) {
		Connection conn = null;
		newPatient patient = null;
		
		try {
			conn = dataSource.getConnection();
			
			String sql = "select * " +
						 "from patient a " +
						 "inner join abstract_person b on a.id = b.id " +
						 "inner join address c on b.address_id = c.id " +
						 "where a.id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				patient = new newPatient(
					rs.getInt("id"),
					rs.getString("first_name"),
					rs.getString("last_name"),
					rs.getString("middle_name"),
					rs.getString("street"),
					rs.getString("city"),
					rs.getString("state"),
					rs.getString("country")
				);
			}
			rs.close();
			ps.close();
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
	public newPatient getNewPatient(int id) {
		String query = "select * from patient where id = ?";
		newPatient patient = jdbcTemplateObject.queryForObject(query, new Object[]{id}, new PatientMapper());
		return patient;
	}

	@Override
	public List<newPatient> getAllPatients() {
		Connection conn = null;
		newPatient patient = null;
		List<newPatient> patients = null;
		
		try {
			conn = dataSource.getConnection();
			
			String sql = "select * " +
					 	 "from patient a " +
					 	 "inner join abstract_person b on a.id = b.id " +
					 	 "inner join address c on b.address_id = c.id " +
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
					rs.getString("first_name"),
					rs.getString("last_name"),
					rs.getString("middle_name"),
					rs.getString("street"),
					rs.getString("city"),
					rs.getString("state"),
					rs.getString("country")
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

	@Override
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
	
	@Override
	public int getMaxAddressID() {
		Connection conn = null;
		int max = 0;
		
		try {
			conn = dataSource.getConnection();
			
			String sql = "Select max(id) from address";
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
