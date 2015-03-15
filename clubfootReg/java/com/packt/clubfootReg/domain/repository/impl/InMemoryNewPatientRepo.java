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

/**
 * 
 * @author David
 * This class represents the InMemoryNewPatientRepo class that uses CRUD actions (methods) to manipulate data in the database
 */
@Repository
public class InMemoryNewPatientRepo implements newPatientRepo{
	private DataSource dataSource; // Instantiation of the datasource object
	private JdbcTemplate jdbcTemplateObject; // Instantiation of the JdbcTemplate object
	private List<newPatient> listOfPatients = new ArrayList<newPatient>(); // Creation of a new list of users
	
	// JDBCTemplate subclass DataSource sets up the environment to allow data to be manipulated in this Spring app
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource; // Sets the current object this of the class's attribute dataSource eqal to the object of datasource
		this.jdbcTemplateObject = new JdbcTemplate(dataSource); // Instantiation of the JDBCTemplateObject class which takes in the object of datasource to set up data synchronization
	}
	
	// This method effectively adds data that was saved to the model to the MySQL instance of the database
	public void addPatient(newPatient newpatient) {
		listOfPatients.add(newpatient); // Adds the object of the model "newpatient" to the list created above
		//int id = newpatient.getId();
		
		// The patient model has around 60 fields that are being retrieved in this instance of the repo class
		// There are integers, strings, and date formatted information that is saved from the form to the model 
		// That is going to be synchronized to the database
		Integer guardianConsent = newpatient.getGuardianConsent();
		Integer photoConsent = newpatient.getPhotoConsent();
		Integer hospital = newpatient.getHospital();
		String patient_lastName = newpatient.getPatient_lastName();
		String patient_firstName = newpatient.getPatient_firstName();
		String patient_midName = newpatient.getPatient_midName();
		String sex = newpatient.getSex();
		String race = newpatient.getRace();
		String dob = newpatient.getDob();
		String tribe = newpatient.getTribe();
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
		Integer diagnosis_prenatally_week = newpatient.getDiagnosis_prenatally_week();
		String prenatally_diag_confirmation = newpatient.getPrenatally_diag_confirmation();
		String diagnosis_comments = newpatient.getDiagnosis_comments();
		String abnormalities = newpatient.getAbnormalities();
		String weakness = newpatient.getWeakness();
		
		int patient_id; // Gets the integer value of the patient id
		int address_id;	// Gets the integer value of the address id
		int pg_id; // Gets the integer value of the guardian id
		
		// Address
		String sql_address = "Insert into address (id, street, city, state, country) values (?, ?, ?, ?, ?)"; // First sql statement that contains the information to query into address
		
		// General Info
		String sql_abstract_person = "Insert into abstract_person (id, address_id, created, first_name, last_name, middle_name) " 
				                   + "values (?, ?, ?, ?, ?, ?)";// First sql statement that contains the information to query into abstract_person
		
		// Patient, Family History
		String sql_patient = "Insert into patient (id, diagnosis, diagnosis_comment, evaluator_id, hospital_id, feet_affected, " +
							 "evaluation_date, dob, tribe, consent_inclusion, consent_photos, birth_place, " +
							 "birth_complications, affected_relatives, pregency_length, pregnancy_complications, " +
							 "pregnancy_drinking, pregnancy_smoking, referral_source, referral_other, referral_doctor_name, " +
							 "referral_hospital_name, deformity_at_birth, prenatal_week, prenatal_confirmed) " +
		                     "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";// First sql statement that contains the information to query into patient
		
		// Parent/Guardian Info
		String sql_abstract_person_pg = "Insert into abstract_person (id, created, first_name, last_name, middle_name) "
								      + "values (?, ?, ?, ?, ?)"; // First sql statement that contains the information to query into abstract_person
		String sql_associate_pg = "Insert into associate (id) values (?)"; // First sql statement that contains the information to query into associate person
		String sql_patient_associates_pg = "Insert into patient_associates (patient_id, associate_id, relationship_to_patient, is_emergency_contact) "
							             + "values (?, ?, ?, ?)"; // First sql statement that contains the information to query into associate person guardian
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); // Sets up the date format for data to be properly synchronized to the database
		Date date = new Date(); // Instantiation of the Date class
		Connection conn = null; // Instantiation of the connection to the database
		PreparedStatement ps;	// Instantiation of the class "PreparedStatement" of how the query statements are prepared to be added to the database
		
		/**
		 * The following contains a set of prepared statements to be prepared to be synchronized to the MySql database.
		 * The prepared statements pull information that was saved to the model via the form submission.
		 */
		try {
			conn = dataSource.getConnection(); // Connection of the dataSource with the MySql sever
			
			address_id = getMaxAddressID()+1;
			patient_id = getMaxPersonID()+1;
			
			// ADDRESS
			ps = conn.prepareStatement(sql_address); // Instantiation of the class "PreparedStatement" of how the query statements are prepared to be added to the database and establishment of the sql query
			/* TEST DATA
			ps.setInt(1, address_id);
			ps.setString(2, "Address");
			ps.setString(3, "Village");
			ps.setString(4, "Province");
			ps.setString(5, "Country");
			*/
			ps.setInt(1, address_id);
			ps.setString(2, addr1);
			ps.setString(3, village);
			ps.setString(4, province);
			ps.setString(5, country);
			ps.executeUpdate();
			ps.close();
			
			
			// GENERAL INFO
			ps = conn.prepareStatement(sql_abstract_person);
			ps.setInt(1, patient_id);
			ps.setInt(2, address_id);
			ps.setString(3, dateFormat.format(date));
			/* TEST DATA
			ps.setString(4, "First");
			ps.setString(5, "Last");
			ps.setString(6, "Middle");
			*/
			ps.setString(4, patient_firstName);
			ps.setString(5, patient_lastName);
			ps.setString(6, patient_midName);
			ps.executeUpdate();
			ps.close();
			
			
			// PATIENT
			ps = conn.prepareStatement(sql_patient);
			ps.setInt(1, patient_id);
			/* TEST DATA
			ps.setString(2, "Idiopathic Clubfoot");
			ps.setString(3, "Test Comments");
			ps.setInt(4, 0);
			ps.setInt(5, 0);
			ps.setString(6, "Left");
			ps.setString(7, "2015-03-04 00:00:00");
			ps.setInt(8, 1);
			ps.setInt(9, 1);
			ps.setInt(10, 0);
			ps.setString(11, "Birth Complications");
			ps.setInt(12, 0);
			ps.setInt(13, 36);
			ps.setString(14, "Pregnancy Complications");
			ps.setString(15, "No");
			ps.setString(16, "No");
			ps.setString(17, "Unspecified");
			ps.setString(18, null);
			ps.setString(19, null);
			ps.setString(20, null);
			ps.setString(21, "Yes");
			ps.setInt(22, 30);
			ps.setString(23, "Yes");
			*/
			ps.setString(2, diagnosis);
			ps.setString(3, diagnosis_comments);
			//ps.setInt(4, evaluator); /// <--- THIS IS NOT WORKING
			ps.setInt(4, 0);
			ps.setInt(5, hospital);
			ps.setString(6, feet);
			ps.setString(7, evaluation_date);
			ps.setString(8, dob);
			ps.setString(9, tribe);
			ps.setInt(10, guardianConsent);
			ps.setInt(11, photoConsent);
			ps.setInt(12, place_birth);
			ps.setString(13, complications);
			if (deformity_history.equalsIgnoreCase("Yes")) {
				ps.setInt(14, deformity_history_num);
			} else {
				ps.setInt(14, 0);
			}
			ps.setInt(15, pregnancy);
			ps.setString(16, pregnancy_complications_explained);
			ps.setString(17, pregnancy_alc);
			ps.setString(18, pregnancy_smoke);
			ps.setString(19, referral);
			if(referral.equalsIgnoreCase("Other")) {
				ps.setString(20, referral_other);
			} else {
				ps.setString(20, null);
			}
			if (referral.equalsIgnoreCase("Hospital/Clinic")) {
				ps.setString(21, referral_doc_name);
				ps.setString(22, referral_hospital_name);
			} else {
				ps.setString(21, null);
				ps.setString(22, null);
			}
			ps.setString(23, deformity_at_birth);
			ps.setInt(24, diagnosis_prenatally_week);
			ps.setString(25, prenatally_diag_confirmation);
			ps.executeUpdate();
			ps.close();
			
			
			// PRIMARY PARENT/GUARDIAN
			ps = conn.prepareStatement(sql_abstract_person_pg);
			pg_id = getMaxPersonID()+1;
			ps.setInt(1, pg_id);
			ps.setString(2, dateFormat.format(date));
			/* TEST DATA
			ps.setString(3, "Guardian First");
			ps.setString(4, "Guardian Last");
			ps.setString(5, "Guardian Middle");
			*/
			ps.setString(3, guardian_firstName);
			ps.setString(4, guardian_lastName);
			ps.setString(5, guardian_midName);
			ps.executeUpdate();
			ps.close();
			
			
			// ASSOCIATE
			ps = conn.prepareStatement(sql_associate_pg);
			ps.setInt(1, pg_id);
			ps.executeUpdate();
			ps.close();
			
			
			// PATIENT ASSOCIATES
			ps = conn.prepareStatement(sql_patient_associates_pg);
			ps.setInt(1, patient_id);
			ps.setInt(2, pg_id);
			/* TEST DATA
			ps.setString(3, "father");
			ps.setInt(4, 1);
			*/
			ps.setString(3, guardian_relationship);
			if(emergency_contact.equalsIgnoreCase("Primary")) {
				ps.setInt(4, 1);
			} else {
				ps.setInt(4, 0);
			}
			ps.executeUpdate();
			ps.close();
			
			
			// SECONDARY PARENT/GUARDIAN
			if (second_guardian_first != "" || !second_guardian_first.isEmpty()) {
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
		} catch (SQLException e) { // Catches SQL exception errors
			throw new RuntimeException(e);
 
		} finally {
			if (conn != null) { // Closes SQL connection 
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
		listOfPatients.add(newpatient);
		int id = newpatient.getId();
		Integer guardianConsent = newpatient.getGuardianConsent();
		Integer photoConsent = newpatient.getPhotoConsent();
		Integer hospital = newpatient.getHospital();
		String patient_lastName = newpatient.getPatient_lastName();
		String patient_firstName = newpatient.getPatient_firstName();
		String patient_midName = newpatient.getPatient_midName();
		String sex = newpatient.getSex();
		String race = newpatient.getRace();
		String dob = newpatient.getDob();
		String tribe = newpatient.getTribe();
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
		Integer diagnosis_prenatally_week = newpatient.getDiagnosis_prenatally_week();
		String prenatally_diag_confirmation = newpatient.getPrenatally_diag_confirmation();
		String diagnosis_comments = newpatient.getDiagnosis_comments();
		String abnormalities = newpatient.getAbnormalities();
		String weakness = newpatient.getWeakness();
		
		String sql_address = "Update address set street = ?, city = ?, state = ?, country = ? where id = ?";
		
		String sql_abstract_person = "Update abstract_person set first_name = ?, last_name = ?, middle_name = ? where id = ?";
		
		String sql_patient = "Update patient set diagnosis = ?, diagnosis_comment = ?, evaluator_id = ?, hospital_id = ?, " +
							 "feet_affected = ?, evaluation_date = ?, dob = ?, tribe = ?, consent_inclusion = ?, " +
							 "consent_photos = ?, birth_place = ?, birth_complications = ?, affected_relatives = ?, " +
							 "pregency_length = ?, pregnancy_complications = ?, pregnancy_drinking = ?, pregnancy_smoking = ?, " +
							 "referral_source = ?, referral_other = ?, referral_doctor_name = ?, referral_hospital_name = ?, " +
							 "deformity_at_birth = ?, prenatal_week = ?, prenatal_confirmed = ? " +
							 "where id = ?";
		
		String sql_patient_associates = "Update patient_associates set relationship_to_patient = ?, is_emergency_contact = ? " +
										"where patient_id = ? and associate_id = ?";
		
		Connection conn = null;
		PreparedStatement ps;
		
		try {
			conn = dataSource.getConnection();
			
			// ADDRESS
			ps = conn.prepareStatement(sql_address);
			ps.setString(1, addr1);
			ps.setString(2, village);
			ps.setString(3, province);
			ps.setString(4, country);
			ps.setInt(5, this.getAddressIDForPerson(id));
			ps.executeUpdate();
			ps.close();
			
			
			// ABSTRACT PERSON
			ps = conn.prepareStatement(sql_abstract_person);
			ps.setString(1, patient_firstName);
			ps.setString(2, patient_lastName);
			ps.setString(3, patient_midName);
			ps.setInt(4, id);
			ps.executeUpdate();
			ps.close();
			
			
			// PATIENT
			
			ps = conn.prepareStatement(sql_patient);
			/*
			ps.setString(1, "Idiopathic Clubfoot");
			ps.setString(2, "Test Comments");
			ps.setInt(3, 0);
			ps.setInt(4, 0);
			ps.setString(5, "Left");
			ps.setString(6, "2015-03-04 00:00:00");
			ps.setString(7, "1993-08-24 00:00:00");
			ps.setString(8, "Some Crazy Tribe");
			ps.setInt(9, 1);
			ps.setInt(10, 1);
			ps.setInt(11, 0);
			ps.setString(12, "Birth Complications");
			ps.setInt(13, 0);
			ps.setInt(14, 36);
			ps.setString(15, "Pregnancy Complications");
			ps.setString(16, "No");
			ps.setString(17, "No");
			ps.setString(18, "Unspecified");
			ps.setString(19, null);
			ps.setString(20, null);
			ps.setString(21, null);
			ps.setString(22, "Yes");
			ps.setInt(23, 30);
			ps.setString(24, "Yes");
			*/
			
			ps.setString(1, diagnosis);
			ps.setString(2, diagnosis_comments);
			//ps.setInt(3, evaluator); /// <--- THIS IS NOT WORKING
			ps.setInt(3, 0);
			ps.setInt(4, hospital);
			ps.setString(5, feet);
			ps.setString(6, evaluation_date);
			ps.setString(7, dob);
			ps.setString(8, tribe);
			ps.setInt(9, guardianConsent);
			ps.setInt(10, photoConsent);
			ps.setInt(11, place_birth);
			ps.setString(12, complications);
			if (deformity_history.equalsIgnoreCase("Yes")) {
				ps.setInt(13, deformity_history_num);
			} else {
				ps.setInt(13, 0);
			}
			ps.setInt(14, pregnancy);
			ps.setString(15, pregnancy_complications_explained);
			ps.setString(16, pregnancy_alc);
			ps.setString(17, pregnancy_smoke);
			ps.setString(18, referral);
			if(referral.equalsIgnoreCase("Other")) {
				ps.setString(19, referral_other);
			} else {
				ps.setString(19, null);
			}
			if (referral.equalsIgnoreCase("Hospital/Clinic")) {
				ps.setString(20, referral_doc_name);
				ps.setString(21, referral_hospital_name);
			} else {
				ps.setString(20, null);
				ps.setString(21, null);
			}
			ps.setString(22, deformity_at_birth);
			ps.setInt(23, diagnosis_prenatally_week);
			ps.setString(24, prenatally_diag_confirmation);
			ps.setInt(25, id);
			ps.executeUpdate();
			ps.close();

			
			// PRIMARY PARENT/GUARDIAN
			int[] associate_ids = new int[3];
			associate_ids = this.getAssociateIDsForPatient(id);
			
			if (associate_ids[0] != 0 && (guardian_firstName != "" || !guardian_lastName.isEmpty())) {
				ps = conn.prepareStatement(sql_abstract_person);
				ps.setString(1, guardian_firstName);
				ps.setString(2, guardian_lastName);
				ps.setString(3, guardian_midName);
				ps.setInt(4, associate_ids[0]);
				ps.executeUpdate();
				ps.close();
			
				// PATIENT ASSOCIATES
				ps = conn.prepareStatement(sql_patient_associates);
				ps.setString(1, guardian_relationship);
				if(emergency_contact.equalsIgnoreCase("Primary")) {
					ps.setInt(2, 1);
				} else {
					ps.setInt(2, 0);
				}
				ps.setInt(3, id);
				ps.setInt(4, associate_ids[0]);
				ps.executeUpdate();
				ps.close();
			}
			
			
			// SECONDARY PARENT/GUARDIAN
			if (associate_ids[1] != 0 && (second_guardian_first != "" || !second_guardian_first.isEmpty())) {
				ps = conn.prepareStatement(sql_abstract_person);
				ps.setString(1, second_guardian_first);
				ps.setString(2, second_guardian_last);
				ps.setString(3, second_guardian_mid);
				ps.setInt(4, associate_ids[1]);
				ps.executeUpdate();
				ps.close();
			
				// PATIENT ASSOCIATES
				ps = conn.prepareStatement(sql_patient_associates);
				ps.setString(1, second_guardian_relationship);
				if(emergency_contact.equalsIgnoreCase("Secondary")) {
					ps.setInt(2, 1);
				} else {
					ps.setInt(2, 0);
				}
				ps.setInt(3, id);
				ps.setInt(4, associate_ids[1]);
				ps.executeUpdate();
				ps.close();
			}
				
			
			// EMERGENCY CONTACT
			if (associate_ids[2] != 0 && (other_guardian_first != "" || !other_guardian_first.isEmpty())) {
				ps = conn.prepareStatement(sql_abstract_person);
				ps.setString(1, other_guardian_first);
				ps.setString(2, other_guardian_last);
				ps.setString(3, other_guardian_mid);
				ps.setInt(4, associate_ids[2]);
				ps.executeUpdate();
				ps.close();
			
				// PATIENT ASSOCIATES
				ps = conn.prepareStatement(sql_patient_associates);
				ps.setString(1, other_guardian_relationship);
				if(emergency_contact.equalsIgnoreCase("Other")) {
					ps.setInt(2, 1);
				} else {
					ps.setInt(2, 0);
				}
				ps.setInt(3, id);
				ps.setInt(4, associate_ids[2]);
				ps.executeUpdate();
				ps.close();
			}
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

	public newPatient getPatient(int id) {
		Connection conn = null;
		newPatient patient = null;
		
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
				patient.setDeformity_at_birth(rs2.getString("deformity_at_birth"));
				patient.setDiagnosis_prenatally_week(rs2.getInt("prenatal_week"));
				patient.setPrenatally_diag_confirmation(rs2.getString("prenatal_confirmed"));
				patient.setDiagnosis_comments(rs2.getString("diagnosis_comment"));
				patient.setReferral(rs2.getString("referral_source"));
				patient.setReferral_doc_name(rs2.getString("referral_doctor_name"));
				patient.setReferral_hospital_name(rs2.getString("referral_hospital_name"));
				patient.setReferral_other(rs2.getString("referral_other"));
				patient.setDeformity_history_num(rs2.getInt("affected_relatives"));
				patient.setPregnancy(rs2.getInt("pregency_length"));
				patient.setPregnancy_complications_explained(rs2.getString("pregnancy_complications"));
				patient.setPregnancy_alc(rs2.getString("pregnancy_drinking"));
				patient.setPregnancy_smoke(rs2.getString("pregnancy_smoking"));
				patient.setComplications(rs2.getString("birth_complications"));
				patient.setPlace_birth(rs2.getInt("birth_place"));
			}
			
			rs2.close();
			ps2.close();
			
			
			// Guardian/Emergency Contact Info
			sql = "select a.id, b.relationship_to_patient, b.is_emergency_contact, c.is_affected, d.first_name, d.last_name, d.middle_name " +
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
					patient.setGuardian_relationship(rs3.getString("relationship_to_patient"));
					patient.setGuardian_firstName(rs3.getString("first_Name"));
					patient.setGuardian_lastName(rs3.getString("last_name"));
					patient.setGuardian_midName(rs3.getString("middle_name"));
					if (rs3.getInt("is_emergency_contact") == 1) {
						patient.setEmergency_contact("primary");
					}
				}
				else if (count == 1) {
					patient.setSecond_guardian_relationship(rs3.getString("relationship_to_patient"));
					patient.setSecond_guardian_first(rs3.getString("first_Name"));
					patient.setSecond_guardian_last(rs3.getString("last_name"));
					patient.setSecond_guardian_mid(rs3.getString("middle_name"));
					if (rs3.getInt("is_emergency_contact") == 1) {
						patient.setEmergency_contact("secondary");
					}
				}
				else {
					patient.setOther_guardian_relationship(rs3.getString("relationship_to_patient"));
					patient.setOther_guardian_first(rs3.getString("first_Name"));
					patient.setOther_guardian_last(rs3.getString("last_name"));
					patient.setOther_guardian_mid(rs3.getString("middle_name"));
					if (rs3.getInt("is_emergency_contact") == 1) {
						patient.setEmergency_contact("other");
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
			
			String sql = "select a.id, a.consent_inclusion, a.consent_photos, a.hospital_id, b.first_name, b.last_name, " +
		    				    "b.middle_name, a.dob, a.evaluator_id, a.evaluation_date, a.feet_affected, a.diagnosis " +
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
	
	public int getAddressIDForPerson(int id) {
		Connection conn = null;
		int address_id = 0;
		
		try {
			conn = dataSource.getConnection();
			
			String sql = "Select address_id from abstract_person where id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				address_id = rs.getInt(1);
			}
			
			rs.close();
			ps.close();
			return address_id;
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

	@Override
	public int[] getAssociateIDsForPatient(int id) {
		Connection conn = null;
		int[] ids = new int[3];
		int count = 0;
		
		try {
			conn = dataSource.getConnection();
			
			String sql = "Select * from patient_associates where patient_id = ? order by associate_id";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				ids[count] = rs.getInt("associate_id");
				count++;
			}
			
			rs.close();
			ps.close();
			return ids;
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
