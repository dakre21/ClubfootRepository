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
		//int id = newpatient.getId();
		Integer guardianConsent = newpatient.getGuardianConsent();
		Integer photoConsent = newpatient.getPhotoConsent();
		Integer hospital = newpatient.getHospital();
		String patient_lastName = newpatient.getPatient_lastName();
		String patient_firstName = newpatient.getPatient_firstName();
		String patient_midName = newpatient.getPatient_midName();
		String sex = newpatient.getSex();
		String race = newpatient.getRace();
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
		Integer deformity_history_num = newpatient.getDeformity_history_num();
		Integer pregnancy = newpatient.getPregnancy();
		String pregnancy_complications_explained = newpatient.getPregnancy_complications_explained();
		String pregnancy_alc = newpatient.getPregnancy_alc();
		String pregnancy_smoke = newpatient.getPregnancy_smoke();
		String complications = newpatient.getComplications();
		Integer place_birth = newpatient.getPlace_birth();
		String referral = newpatient.getReferral();
		String referral_doc_name = newpatient.getReferral_doc_name();
		String referral_hospital_name = newpatient.getReferral_hospital_name();
		String referral_other = newpatient.getReferral_other();
		Integer evaluator = newpatient.getEvaluator();
		String evaluation_date = newpatient.getEvaluation_date();
		String feet = newpatient.getFeet();
		String diagnosis = newpatient.getDiagnosis();
		String deformity_at_birth = newpatient.getDeformity_at_birth();
		String previous_treatments = newpatient.getPrevious_treatments();
		String previous_treatments_num = newpatient.getPrevious_treatments_num();
		String diagnosis_prenatally = newpatient.getDiagnosis_prenatally();
		String diagnosis_prenatally_week = newpatient.getDiagnosis_prenatally_week();
		String prenatally_diag_confirmation = newpatient.getPrenatally_diag_confirmation();
		String diagnosis_comments = newpatient.getDiagnosis_comments();
		String abnormalities = newpatient.getAbnormalities();
		String weakness = newpatient.getWeakness();
		
		int patient_id;
		int address_id;
		int pg_id;
		
		// Address
		String sql_address = "Insert into address (id, street, city, state, country) values (?, ?, ?, ?, ?)";
		
		// General Info
		String sql_abstract_person = "Insert into abstract_person (id, address_id, created, first_name, last_name, middle_name) "
				                   + "values (?, ?, ?, ?, ?, ?)";
		
		// Patient, Family History
		String sql_patient = "Insert into patient (id, evaluator_id, hospital_id, consent_inclusion, consent_photos, birth_place, " +
							 "birth_complications, affected_relatives, pregency_length, pregnancy_complications, " +
							 "pregnancy_drinking, pregnancy_smoking, referral_source, referral_other, referral_doctor_name, " +
							 "referral_hospital_name) " +
		                     "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		// Parent/Guardian Info
		String sql_abstract_person_pg = "Insert into abstract_person (id, created, first_name, last_name, middle_name) "
								      + "values (?, ?, ?, ?, ?)";
		String sql_associate_pg = "Insert into associate (id) values (?)";
		String sql_patient_associates_pg = "Insert into patient_associates (patient_id, associate_id, relationship_to_patient, is_emergency_contact) "
							             + "values (?, ?, ?, ?)";
		
		// Family History
		
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		Connection conn = null;
		PreparedStatement ps;
		
		try {
			conn = dataSource.getConnection();
			
			address_id = getMaxAddressID()+1;
			patient_id = getMaxPersonID()+1;
			
			// ADDRESS
			ps = conn.prepareStatement(sql_address);
			ps.setInt(1, address_id);
			ps.setString(2, "Address");
			ps.setString(3, "Village");
			ps.setString(4, "Province");
			ps.setString(5, "Country");
			/*
			ps.setInt(1, address_id);
			ps.setString(2, addr1);
			ps.setString(3, village);
			ps.setString(4, province);
			ps.setString(5, country);
			*/
			ps.executeUpdate();
			ps.close();
			
			
			// GENERAL INFO
			ps = conn.prepareStatement(sql_abstract_person);
			ps.setInt(1, patient_id);
			ps.setInt(2, address_id);
			ps.setString(3, dateFormat.format(date));
			ps.setString(4, "First");
			ps.setString(5, "Last");
			ps.setString(6, "Middle");
			/*
			ps.setString(4, patient_firstName);
			ps.setString(5, patient_lastName);
			ps.setString(6, patient_midName);
			*/
			ps.executeUpdate();
			ps.close();
			
			
			// PATIENT
			ps = conn.prepareStatement(sql_patient);
			ps.setInt(1, patient_id);
			ps.setInt(2, 0);
			ps.setInt(3, 0);
			ps.setInt(4, 1);
			ps.setInt(5, 1);
			ps.setInt(6, 0);
			ps.setString(7, "Birth Complications");
			ps.setInt(8, 0);
			ps.setInt(9, 36);
			ps.setString(10, "Pregnancy Complications");
			ps.setString(11, "No");
			ps.setString(12, "No");
			ps.setString(13, "Unspecified");
			ps.setString(14, null);
			ps.setString(15, null);
			ps.setString(16, null);
			
			/*
			ps.setInt(2, evaluator); /// <--- THIS IS NOT WORKING
			ps.setInt(3, hospital);
			ps.setInt(4, guardianConsent);
			ps.setInt(5, photoConsent);
			ps.setInt(6, place_birth);
			ps.setString(7, complications);
			if (deformity_history.equalsIgnoreCase("Yes")) {
				ps.setInt(8, deformity_history_num);
			} else {
				ps.setInt(8, 0);
			}
			ps.setInt(9, pregnancy);
			ps.setString(10, pregnancy_complications_explained);
			ps.setString(11, pregnancy_alc);
			ps.setString(12, pregnancy_smoke);
			ps.setString(13, referral);
			if(referral.equalsIgnoreCase("Other")) {
				ps.setString(14, referral_other);
			} else {
				ps.setString(14, null);
			}
			if (referral.equalsIgnoreCase("Hospital/Clinic")) {
				ps.setString(15, referral_doc_name);
				ps.setString(16, referral_hospital_name);
			} else {
				ps.setString(15, null);
				ps.setString(16, null);
			}
			*/
			ps.executeUpdate();
			ps.close();
			
			
			// PRIMARY PARENT/GUARDIAN
			ps = conn.prepareStatement(sql_abstract_person_pg);
			pg_id = getMaxPersonID()+1;
			ps.setInt(1, pg_id);
			ps.setString(2, dateFormat.format(date));
			ps.setString(3, "Guardian First");
			ps.setString(4, "Guardian Last");
			ps.setString(5, "Guardian Middle");
			/*
			ps.setString(3, guardian_firstName);
			ps.setString(4, guardian_lastName);
			ps.setString(5, guardian_midName);
			*/
			ps.executeUpdate();
			ps.close();
			
			ps = conn.prepareStatement(sql_associate_pg);
			ps.setInt(1, pg_id);
			ps.executeUpdate();
			ps.close();
			
			ps = conn.prepareStatement(sql_patient_associates_pg);
			ps.setInt(1, patient_id);
			ps.setInt(2, pg_id);
			ps.setString(3, "father");
			ps.setInt(4, 1);
			/*
			ps.setString(3, guardian_relationship);
			if(emergency_contact.equalsIgnoreCase("Primary")) {
				ps.setInt(4, 1);
			} else {
				ps.setInt(4, 0);
			}
			*/
			ps.executeUpdate();
			ps.close();
			
			
			// SECONDARY PARENT/GUARDIAN
			/*
			if (second_guardian_first != "" || !other_guardian_first.isEmpty()) {
				ps = conn.prepareStatement(sql_abstract_person_pg);
				pg_id = getMaxPersonID()+1;
				ps.setInt(1, pg_id);
				ps.setString(2, dateFormat.format(date));
				ps.setString(3, second_guardian_first);
				ps.setString(4, second_guardian_last);
				ps.setString(5, second_guardian_mid);
				ps.executeUpdate();
				ps.close();
				
				ps = conn.prepareStatement(sql_associate_pg);
				ps.setInt(1, pg_id);
				ps.executeUpdate();
				ps.close();
				
				ps = conn.prepareStatement(sql_patient_associates_pg);
				ps.setInt(1, patient_id);
				ps.setInt(2, pg_id);
				ps.setString(3, second_guardian_relationship);
				if(emergency_contact.equalsIgnoreCase("Secondary")) {
					ps.setInt(4, 1);
				} else {
					ps.setInt(4, 0);
				}
				ps.executeUpdate();
				ps.close();
			}
				
			
			// EMERGENCY CONTACT
			if (other_guardian_first != "" || !other_guardian_first.isEmpty()) {
				ps = conn.prepareStatement(sql_abstract_person_pg);
				pg_id = getMaxPersonID()+1;
				ps.setInt(1, pg_id);
				ps.setString(2, dateFormat.format(date));
				ps.setString(3, other_guardian_first);
				ps.setString(4, other_guardian_last);
				ps.setString(5, other_guardian_mid);
				ps.executeUpdate();
				ps.close();
				
				ps = conn.prepareStatement(sql_associate_pg);
				ps.setInt(1, pg_id);
				ps.executeUpdate();
				ps.close();
				
				ps = conn.prepareStatement(sql_patient_associates_pg);
				ps.setInt(1, patient_id);
				ps.setInt(2, pg_id);
				ps.setString(3, other_guardian_relationship);
				if(emergency_contact.equalsIgnoreCase("Other")) {
					ps.setInt(4, 1);
				} else {
					ps.setInt(4, 0);
				}
				ps.executeUpdate();
				ps.close();
			}
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

	public newPatient getPatient(int id) {
		Connection conn = null;
		newPatient patient = null;
		
		try {
			conn = dataSource.getConnection();
			
			// General Info - Address
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
			
			// Guardian - Contact Info
			sql = "select a.id, b.relationship_to_patient, b.is_emergency_contact, c.is_affected, d.first_name, d.last_name, d.middle_name " +
				  "from patient a " +
				  "inner join patient_associates b on a.id = b.patient_id " +
				  "inner join associate c on b.associate_id = c.id " +
				  "inner join abstract_person d on c.id = d.id " +
				  "where a.id = ?";
			PreparedStatement ps2 = conn.prepareStatement(sql);
			ps2.setInt(1, id);
			ResultSet rs2 = ps2.executeQuery();
			
			int count = 0;
			while (rs2.next()) {
				if (count == 0) {
					patient.setGuardian_relationship(rs2.getString("relationship_to_patient"));
					patient.setGuardian_firstName(rs2.getString("first_Name"));
					patient.setGuardian_lastName(rs2.getString("last_name"));
					patient.setGuardian_midName(rs2.getString("middle_name"));
					if (rs2.getInt("is_emergency_contact") == 1) {
						patient.setEmergency_contact("primary");
					}
				}
				else if (count == 1) {
					patient.setSecond_guardian_relationship(rs2.getString("relationship_to_patient"));
					patient.setSecond_guardian_first(rs2.getString("first_Name"));
					patient.setSecond_guardian_last(rs2.getString("last_name"));
					patient.setSecond_guardian_mid(rs2.getString("middle_name"));
					if (rs2.getInt("is_emergency_contact") == 1) {
						patient.setEmergency_contact("secondary");
					}
				}
				else {
					patient.setOther_guardian_relationship(rs2.getString("relationship_to_patient"));
					patient.setOther_guardian_first(rs2.getString("first_Name"));
					patient.setOther_guardian_last(rs2.getString("last_name"));
					patient.setOther_guardian_mid(rs2.getString("middle_name"));
					if (rs2.getInt("is_emergency_contact") == 1) {
						patient.setEmergency_contact("other");
					}
				}
				System.out.println(count);
				count++;
			}
			
			rs2.close();
			ps2.close();
			
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
