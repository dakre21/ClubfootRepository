package edu.uiowa.icr.implementation;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Date;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.mysql.jdbc.CallableStatement;

import edu.uiowa.icr.implementation.inter.PatientRepo;
import edu.uiowa.icr.models.Evaluator;
import edu.uiowa.icr.models.Hospital;
import edu.uiowa.icr.models.ReportsPatients;
import edu.uiowa.icr.models.ReportsVisits;
import edu.uiowa.icr.models.Visit;
import edu.uiowa.icr.models.Patient;

import javax.sql.DataSource;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.Blob;
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
public class InMemoryPatientRepo implements PatientRepo{
	private DataSource dataSource; // Instantiation of the datasource object
	private JdbcTemplate jdbcTemplateObject; // Instantiation of the JdbcTemplate object
	private List<Patient> listOfPatients = new ArrayList<Patient>(); // Creation of a new list of users
	
	// JDBCTemplate subclass DataSource sets up the environment to allow data to be manipulated in this Spring app
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource; // Sets the current object this of the class's attribute dataSource eqal to the object of datasource
		this.jdbcTemplateObject = new JdbcTemplate(dataSource); // Instantiation of the JDBCTemplateObject class which takes in the object of datasource to set up data synchronization
	}
	
	// This method effectively adds data that was saved to the model to the MySQL instance of the database
	public void addPatient(Patient newpatient) {
		listOfPatients.add(newpatient); // Adds the object of the model "newpatient" to the list created above
		//int id = newpatient.getId();
		
		// The patient model has around 60 fields that are being retrieved in this instance of the repo class
		// There are integers, strings, and date formatted information that is saved from the form to the model 
		// That is going to be synchronized to the database
		Integer guardianConsent = newpatient.getGuardianConsent();
		Integer photoConsent = newpatient.getPhotoConsent();
		Integer hospital = newpatient.getHospital();
		String patientLastName = newpatient.getPatientLastName();
		String patientFirstName = newpatient.getPatientFirstName();
		String patientMiddleName = newpatient.getPatientMiddleName();
		String sex = newpatient.getSex();
		String race = newpatient.getRace();
		String dob = newpatient.getDob();
		String tribe = newpatient.getTribe();
		String addr1 = newpatient.getAddr1();
		String addr2 = newpatient.getAddr2();
		String village = newpatient.getVillage();
		String province = newpatient.getProvince();
		String country = newpatient.getCountry();
		String guardianLastName = newpatient.getGuardianLastName();
		String guardianFirstName = newpatient.getGuardianFirstName();
		String guardianMiddleName = newpatient.getGuardianMiddleName();
		String guardianRelationship = newpatient.getGuardianRelationship();
		String guardianPhone1 = newpatient.getGuardianPhone1();
		String guardianPhone2 = newpatient.getGuardianPhone2();
		String secondGuardianLast = newpatient.getSecondGuardianLast();
		String secondGuardianFirst = newpatient.getSecondGuardianFirst();
		String secondGuardianMiddle = newpatient.getSecondGuardianMiddle();
		String secondGuardianRelationship = newpatient.getSecondGuardianRelationship();
		String secondGuardianPhone1 = newpatient.getSecondGuardianPhone1();
		String secondGuardianPhone2 = newpatient.getSecondGuardianPhone2();
		String emergencyContact = newpatient.getEmergencyContact();
		String otherGuardianLast = newpatient.getOtherGuardianLast();
		String otherGuardianFirst = newpatient.getOtherGuardianFirst();
		String otherGuardianMiddle = newpatient.getOtherGuardianMiddle();
		String otherGuardianRelationship = newpatient.getOtherGuardianRelationship();
		String otherGuardianPhone1 = newpatient.getOtherGuardianPhone1();
		String otherGuardianPhone2 = newpatient.getOtherGuardianPhone2();
		String deformityHistory = newpatient.getDeformityHistory();
		Integer deformityHistoryNum = newpatient.getDeformityHistoryNum();
		Integer pregnancy = newpatient.getPregnancy();
		String pregnancyComplicationsExplained = newpatient.getPregnancyComplicationsExplained();
		String pregnancyAlc = newpatient.getPregnancyAlc();
		String pregnancySmoke = newpatient.getPregnancySmoke();
		String complications = newpatient.getComplications();
		//bbrown: Where in the heck is placeBirth coming from?
		//We should not use it for now because it is set to 0 and causes
		//a mysql error.
		Integer placeBirth = newpatient.getPlaceBirth();
		String referral = newpatient.getReferral();
		String referralDocName = newpatient.getReferralDocName();
		String referralHospitalName = newpatient.getReferralHospitalName();
		String referralOther = newpatient.getReferralOther();
		Integer evaluator = newpatient.getEvaluator();
		String evaluationDate = newpatient.getEvaluationDate();
		String feet = newpatient.getFeet();
		String diagnosis = newpatient.getDiagnosis();
		String deformityAtBirth = newpatient.getDeformityAtBirth();
		String previousTreatments = newpatient.getPreviousTreatments();
		String previousTreatmentsNum = newpatient.getPreviousTreatmentsNum();
		String diagnosisPrenatally = newpatient.getDiagnosisPrenatally();
		Integer diagnosisPrenatallyWeek = newpatient.getDiagnosisPrenatallyWeek();
		String prenatallyDiagConfirmation = newpatient.getPrenatallyDiagConfirmation();
		String diagnosisComments = newpatient.getDiagnosisComments();
		String abnormalities = newpatient.getAbnormalities();
		String weakness = newpatient.getWeakness();
		
		int patientId; // Gets the integer value of the patient id
		int addressId;	// Gets the integer value of the address id
		int pgId; // Gets the integer value of the guardian id
		
		// Address
		String sqlAddress = "Insert into address (id, street, city, state, country) values (?, ?, ?, ?, ?)"; // First sql statement that contains the information to query into address
		
		// General Info
		String sqlAbstractPerson = "Insert into abstract_person (id, address_id, created, first_name, last_name, middle_name) " 
				                   + "values (?, ?, ?, ?, ?, ?)";// First sql statement that contains the information to query into abstract_person
		
		// Patient, Family History
		String sqlPatient = "Insert into patient (id, diagnosis, diagnosis_comment, evaluator_id, hospital_id, feet_affected, " +
							 "evaluation_date, dob, tribe, consent_inclusion, consent_photos, birth_place, " +
							 "birth_complications, affected_relatives, pregency_length, pregnancy_complications, " +
							 "pregnancy_drinking, pregnancy_smoking, referral_source, referral_other, referral_doctor_name, " +
							 "referral_hospital_name, deformity_at_birth, prenatal_week, prenatal_confirmed, sex, race) " +
		                     "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";// First sql statement that contains the information to query into patient
		
		// Parent/Guardian Info
		String sqlAbstractPersonPg = "Insert into abstract_person (id, created, first_name, last_name, middle_name) "
								      + "values (?, ?, ?, ?, ?)"; // First sql statement that contains the information to query into abstract_person
		String sqlAssociatePg = "Insert into associate (id) values (?)"; // First sql statement that contains the information to query into associate person
		String sqlPatientAssociatesPg = "Insert into patient_associates (patient_id, associate_id, relationship_to_patient, phone1, phone2, is_emergency_contact) "
							             + "values (?, ?, ?, ?, ?, ?)"; // First sql statement that contains the information to query into associate person guardian
		
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // Sets up the date format for data to be properly synchronized to the database
		Date date = new Date(); // Instantiation of the Date class
		Connection conn = null; // Instantiation of the connection to the database
		PreparedStatement ps;	// Instantiation of the class "PreparedStatement" of how the query statements are prepared to be added to the database
		
		/**
		 * The following contains a set of prepared statements to be prepared to be synchronized to the MySql database.
		 * The prepared statements pull information that was saved to the model via the form submission.
		 */
		try {
			conn = dataSource.getConnection(); // Connection of the dataSource with the MySql sever
			
			addressId = getMaxAddressID()+1;
			patientId = getMaxPersonID()+1;
			System.out.println("GOT MAX ADDRESS ID: "+addressId);
			
			//this.addPhoto(newpatient.getFileName().getBytes());
			
			// ADDRESS
			//String sqlAddress = 
			//"Insert into address (id, street, city, state, country) 
			//values (?, ?, ?, ?, ?)"; 
			// First sql statement that contains the informatio
			ps = conn.prepareStatement(sqlAddress); // Instantiation of the class "PreparedStatement" of how the query statements are prepared to be added to the database and establishment of the sql query
			/* TEST DATA
			ps.setInt(1, address_id);
			ps.setString(2, "Address");
			ps.setString(3, "Village");
			ps.setString(4, "Province");
			ps.setString(5, "Country");
			*/
			System.out.println("Address number and street:" +addr1);
			ps.setInt(1, addressId);
			ps.setString(2, addr1);
			ps.setString(3, village);
			ps.setString(4, province);
			ps.setString(5, country);
			ps.executeUpdate();
			ps.close();
			
			
			// GENERAL INFO
			//String sqlAbstractPerson = 
			//"Insert into abstract_person 
			//(id, address_id, created, first_name, last_name, middle_name) " 
	        //           + "values (?, ?, ?, ?, ?, ?)";
			ps = conn.prepareStatement(sqlAbstractPerson);
			ps.setInt(1, patientId);
			ps.setInt(2, addressId);
			ps.setString(3, dateFormat.format(date));
			ps.setString(4, patientFirstName);
			ps.setString(5, patientLastName);
			ps.setString(6, patientMiddleName);
			ps.executeUpdate();
			ps.close();
			
			
			// PATIENT
			//Insert into patient 
			//(id, diagnosis, diagnosis_comment, 
			//evaluator_id, hospital_id, feet_affected, 
			//evaluation_date, dob, tribe, 
			//consent_inclusion, consent_photos, birth_place,
			//birth_complications, affected_relatives, pregency_length, 
			//pregnancy_complications, pregnancy_drinking, pregnancy_smoking,
			//referral_source, referral_other, referral_doctor_name, 
			//referral_hospital_name, deformity_at_birth, prenatal_week, 
			//prenatal_confirmed, sex, race) " +
            //        "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";// First sql stat
			ps = conn.prepareStatement(sqlPatient);
			ps.setInt(1, patientId);
			/* TEST DATA
			ps.setString(2, "Idiopathic Clubfoot");
			ps.setString(3, "Test Comments");
			ps.setInt(4, evaluator);
			ps.setInt(5, 1);
			ps.setString(6, "Left");
			ps.setString(7, "2015-03-04 00:00:00");
			ps.setString(8, "1993-08-24 00:00:00");
			ps.setString(9, "Some Tribe");
			ps.setInt(10, 1);
			ps.setInt(11, 1);
			ps.setInt(12, 0);
			ps.setString(13, "Birth Complications");
			ps.setInt(14, 0);
			ps.setInt(15, 36);
			ps.setString(16, "Pregnancy Complications");
			ps.setString(17, "No");
			ps.setString(18, "No");
			ps.setString(19, "Unspecified");
			ps.setString(20, null);
			ps.setString(21, null);
			ps.setString(22, null);
			ps.setString(23, "Yes");
			ps.setInt(24, 30);
			ps.setString(25, "Yes");
			ps.setString(26, "male");
			ps.setString(27, "asian");
			*/
			
			ps.setString(2, diagnosis);
			ps.setString(3, diagnosisComments);
			ps.setInt(4, evaluator);
			ps.setInt(5, hospital);
			ps.setString(6, feet);
			System.out.println("Evaluation date: "+ evaluationDate);
			//ps.setString(7, dateFormat.format(evaluationDate));
			System.out.println("DOB: "+dob);
			try {
               System.out.println("TRying dates");
			   java.sql.Date evalDate= (java.sql.Date)dateFormat.parse(evaluationDate);
			   ps.setDate(7, evalDate);
			   
			   Date dobDate = dateFormat.parse(dob);
			   System.out.println("DOB DATR:"+dobDate);
			   ps.setDate(8, (java.sql.Date)dateFormat.parse(dob));
			} catch (Exception dpe) {
				ps.setString(7, "2015-03-04 00:00:00");
				ps.setString(8, "2015-03-04 00:00:00");
				System.out.println(dpe.getStackTrace());
			}

			ps.setString(9, tribe);
			ps.setInt(10, guardianConsent);
			ps.setInt(11, photoConsent);
			System.out.println("PLACE BIRTH: " +placeBirth);
			ps.setInt(12, addressId);
			ps.setString(13, complications);
			if (deformityHistory.equalsIgnoreCase("Yes")) {
				ps.setInt(14, deformityHistoryNum);
			} else {
				ps.setInt(14, 0);
			}
			ps.setInt(15, pregnancy);
			ps.setString(16, pregnancyComplicationsExplained);
			ps.setString(17, pregnancyAlc);
			ps.setString(18, pregnancySmoke);
			ps.setString(19, referral);
			if(referral.equalsIgnoreCase("Other")) {
				ps.setString(20, referralOther);
			} else {
				ps.setString(20, null);
			}
			if (referral.equalsIgnoreCase("Hospital/Clinic")) {
				ps.setString(21, referralDocName);
				ps.setString(22, referralHospitalName);
			} else {
				ps.setString(21, null);
				ps.setString(22, null);
			}
			ps.setString(23, deformityAtBirth);
			//bbrown: Failed here because diagnosisPrenatallyWeek was null
			System.out.println("DIAGNOSIS PRENATAL WEEK: "+diagnosisPrenatallyWeek);
			ps.setInt(24, 23);
			ps.setString(25, prenatallyDiagConfirmation);
			ps.setString(26, sex);
			ps.setString(27, race);
			//Causes an error with the address table
			ps.executeUpdate();
			ps.close();
			
			
			// PRIMARY PARENT/GUARDIAN
			ps = conn.prepareStatement(sqlAbstractPersonPg);
			pgId = getMaxPersonID()+1;
			ps.setInt(1, pgId);
			ps.setString(2, dateFormat.format(date));
			/* TEST DATA
			ps.setString(3, "Guardian First");
			ps.setString(4, "Guardian Last");
			ps.setString(5, "Guardian Middle");
			*/
			
			
			ps.setString(3, guardianFirstName);
			ps.setString(4, guardianLastName);
			ps.setString(5, guardianMiddleName);
			ps.executeUpdate();
			ps.close();
			
			
			// ASSOCIATE
			ps = conn.prepareStatement(sqlAssociatePg);
			ps.setInt(1, pgId);
			ps.executeUpdate();
			ps.close();
			
			
			// PATIENT ASSOCIATES
			ps = conn.prepareStatement(sqlPatientAssociatesPg);
			ps.setInt(1, patientId);
			ps.setInt(2, pgId);
			/* TEST DATA
			ps.setString(3, "father");
			ps.setInt(4, 1);
			*/
			
			ps.setString(3, guardianRelationship);
			ps.setString(4, guardianPhone1);
			ps.setString(5, guardianPhone2);
			if(emergencyContact.equalsIgnoreCase("Primary")) {
				ps.setInt(6, 1);
			} else {
				ps.setInt(6, 0);
			}
			ps.executeUpdate();
			ps.close();
			
			
			// SECONDARY PARENT/GUARDIAN
			if (secondGuardianFirst != "" || !secondGuardianFirst.isEmpty()) {
				ps = conn.prepareStatement(sqlAbstractPersonPg);
				pgId = getMaxPersonID()+1;
				ps.setInt(1, pgId);
				ps.setString(2, dateFormat.format(date));
				ps.setString(3, secondGuardianFirst);
				ps.setString(4, secondGuardianLast);
				ps.setString(5, secondGuardianMiddle);
				ps.executeUpdate();
				ps.close();
				
				ps = conn.prepareStatement(sqlAssociatePg);
				ps.setInt(1, pgId);
				ps.executeUpdate();
				ps.close();
				
				ps = conn.prepareStatement(sqlPatientAssociatesPg);
				ps.setInt(1, patientId);
				ps.setInt(2, pgId);
				ps.setString(3, secondGuardianRelationship);
				ps.setString(4, secondGuardianPhone1);
				ps.setString(5, secondGuardianPhone2);
				if(emergencyContact.equalsIgnoreCase("Secondary")) {
					ps.setInt(6, 1);
				} else {
					ps.setInt(6, 0);
				}
				ps.executeUpdate();
				ps.close();
			}
				
			
			// EMERGENCY CONTACT
			if (otherGuardianFirst != "" || !otherGuardianFirst.isEmpty()) {
				ps = conn.prepareStatement(sqlAbstractPersonPg);
				pgId = getMaxPersonID()+1;
				ps.setInt(1, pgId);
				ps.setString(2, dateFormat.format(date));
				ps.setString(3, otherGuardianFirst);
				ps.setString(4, otherGuardianLast);
				ps.setString(5, otherGuardianMiddle);
				ps.executeUpdate();
				ps.close();
				
				ps = conn.prepareStatement(sqlAssociatePg);
				ps.setInt(1, pgId);
				ps.executeUpdate();
				ps.close();
				
				ps = conn.prepareStatement(sqlPatientAssociatesPg);
				ps.setInt(1, patientId);
				ps.setInt(2, pgId);
				ps.setString(3, otherGuardianRelationship);
				ps.setString(4, otherGuardianPhone1);
				ps.setString(5, otherGuardianPhone2);
				if(emergencyContact.equalsIgnoreCase("Other")) {
					ps.setInt(6, 1);
				} else {
					ps.setInt(6, 0);
				}
				ps.executeUpdate();
				ps.close();
			}
			
		} catch (SQLException e) { // Catches SQL exception errors
			throw new RuntimeException(e);
 
		} //catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		//} 
		finally {
			if (conn != null) { // Closes SQL connection 
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
		
		return;
	}

	public InMemoryPatientRepo() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * Method the effectively deletes new patient information stored in the database
	 */
	public void deletePatient(int id) {
		String query = "delete from patient where id = ?";
		jdbcTemplateObject.update(query, id);
		System.out.println("Deleted patient with id = " + id);
	}
	
	/**
	 * Method that updates patient information
	 */
	public void updatePatient(Patient newpatient) {
		listOfPatients.add(newpatient);
		int id = newpatient.getId();
		Integer guardianConsent = newpatient.getGuardianConsent();
		Integer photoConsent = newpatient.getPhotoConsent();
		Integer hospital = newpatient.getHospital();
		String patientLastName = newpatient.getPatientLastName();
		String patientFirstName = newpatient.getPatientFirstName();
		String patientMiddleName = newpatient.getPatientMiddleName();
		String sex = newpatient.getSex();
		String race = newpatient.getRace();
		String dob = newpatient.getDob();
		String tribe = newpatient.getTribe();
		String addr1 = newpatient.getAddr1();
		String addr2 = newpatient.getAddr2();
		String village = newpatient.getVillage();
		String province = newpatient.getProvince();
		String country = newpatient.getCountry();
		String guardianLastName = newpatient.getGuardianLastName();
		String guardianFirstName = newpatient.getGuardianFirstName();
		String guardianMiddleName = newpatient.getGuardianMiddleName();
		String guardianRelationship = newpatient.getGuardianRelationship();
		String guardianPhone1 = newpatient.getGuardianPhone1();
		String guardianPhone2 = newpatient.getGuardianPhone2();
		String secondGuardianLast = newpatient.getSecondGuardianLast();
		String secondGuardianFirst = newpatient.getSecondGuardianFirst();
		String secondGuardianMiddle = newpatient.getSecondGuardianMiddle();
		String secondGuardianRelationship = newpatient.getSecondGuardianRelationship();
		String secondGuardianPhone1 = newpatient.getSecondGuardianPhone1();
		String secondGuardianPhone2 = newpatient.getSecondGuardianPhone2();
		String emergencyContact = newpatient.getEmergencyContact();
		String otherGuardianLast = newpatient.getOtherGuardianLast();
		String otherGuardianFirst = newpatient.getOtherGuardianFirst();
		String otherGuardianMiddle = newpatient.getOtherGuardianMiddle();
		String otherGuardianRelationship = newpatient.getOtherGuardianRelationship();
		String otherGuardianPhone1 = newpatient.getOtherGuardianPhone1();
		String otherGuardianPhone2 = newpatient.getOtherGuardianPhone2();
		String deformityHistory = newpatient.getDeformityHistory();
		Integer deformityHistoryNum = newpatient.getDeformityHistoryNum();
		Integer pregnancy = newpatient.getPregnancy();
		String pregnancyComplicationsExplained = newpatient.getPregnancyComplicationsExplained();
		String pregnancyAlc = newpatient.getPregnancyAlc();
		String pregnancySmoke = newpatient.getPregnancySmoke();
		String complications = newpatient.getComplications();
		Integer placeBirth = newpatient.getPlaceBirth();
		String referral = newpatient.getReferral();
		String referralDocName = newpatient.getReferralDocName();
		String referralHospitalName = newpatient.getReferralHospitalName();
		String referralOther = newpatient.getReferralOther();
		Integer evaluator = newpatient.getEvaluator();
		String evaluationDate = newpatient.getEvaluationDate();
		String feet = newpatient.getFeet();
		String diagnosis = newpatient.getDiagnosis();
		String deformityAtBirth = newpatient.getDeformityAtBirth();
		String previousTreatments = newpatient.getPreviousTreatments();
		String previousTreatmentsNum = newpatient.getPreviousTreatmentsNum();
		String diagnosisPrenatally = newpatient.getDiagnosisPrenatally();
		Integer diagnosisPrenatallyWeek = newpatient.getDiagnosisPrenatallyWeek();
		String prenatallyDiagConfirmation = newpatient.getPrenatallyDiagConfirmation();
		String diagnosisComments = newpatient.getDiagnosisComments();
		String abnormalities = newpatient.getAbnormalities();
		String weakness = newpatient.getWeakness();
		
		String sqlAddress = "Update address set street = ?, city = ?, state = ?, country = ? where id = ?";
		
		String sqlAbstractPerson = "Update abstract_person set first_name = ?, last_name = ?, middle_name = ? where id = ?";
		
		String sqlPatient = "Update patient set diagnosis = ?, diagnosis_comment = ?, evaluator_id = ?, hospital_id = ?, " +
							 "feet_affected = ?, evaluation_date = ?, dob = ?, tribe = ?, consent_inclusion = ?, " +
							 "consent_photos = ?, birth_place = ?, birth_complications = ?, affected_relatives = ?, " +
							 "pregency_length = ?, pregnancy_complications = ?, pregnancy_drinking = ?, pregnancy_smoking = ?, " +
							 "referral_source = ?, referral_other = ?, referral_doctor_name = ?, referral_hospital_name = ?, " +
							 "deformity_at_birth = ?, prenatal_week = ?, prenatal_confirmed = ?, sex = ?, race = ? " +
							 "where id = ?";
		
		String sqlPatientAssociates = "Update patient_associates set relationship_to_patient = ?, phone1 = ?, phone2 = ?, is_emergency_contact = ? " +
										"where patient_id = ? and associate_id = ?";
		
		Connection conn = null;
		PreparedStatement ps;
		
		try {
			conn = dataSource.getConnection();
			
			// ADDRESS
			ps = conn.prepareStatement(sqlAddress);
			ps.setString(1, addr1);
			ps.setString(2, village);
			ps.setString(3, province);
			ps.setString(4, country);
			ps.setInt(5, this.getAddressIDForPerson(id));
			ps.executeUpdate();
			ps.close();
			
			
			// ABSTRACT PERSON
			ps = conn.prepareStatement(sqlAbstractPerson);
			ps.setString(1, patientFirstName);
			ps.setString(2, patientLastName);
			ps.setString(3, patientMiddleName);
			ps.setInt(4, id);
			ps.executeUpdate();
			ps.close();
			
			
			// PATIENT
			
			ps = conn.prepareStatement(sqlPatient);
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
			ps.setString(2, diagnosisComments);
			ps.setInt(3, evaluator);
			ps.setInt(4, hospital);
			ps.setString(5, feet);
			ps.setString(6, evaluationDate);
			ps.setString(7, dob);
			ps.setString(8, tribe);
			ps.setInt(9, guardianConsent);
			ps.setInt(10, photoConsent);
			ps.setInt(11, placeBirth);
			ps.setString(12, complications);
			if (deformityHistory.equalsIgnoreCase("Yes")) {
				ps.setInt(13, deformityHistoryNum);
			} else {
				ps.setInt(13, 0);
			}
			ps.setInt(14, pregnancy);
			ps.setString(15, pregnancyComplicationsExplained);
			ps.setString(16, pregnancyAlc);
			ps.setString(17, pregnancySmoke);
			ps.setString(18, referral);
			if(referral.equalsIgnoreCase("Other")) {
				ps.setString(19, referralOther);
			} else {
				ps.setString(19, null);
			}
			if (referral.equalsIgnoreCase("Hospital/Clinic")) {
				ps.setString(20, referralDocName);
				ps.setString(21, referralHospitalName);
			} else {
				ps.setString(20, null);
				ps.setString(21, null);
			}
			ps.setString(22, deformityAtBirth);
			ps.setInt(23, diagnosisPrenatallyWeek);
			ps.setString(24, prenatallyDiagConfirmation);
			ps.setString(25, sex);
			ps.setString(26, race);
			ps.setInt(27, id);
			ps.executeUpdate();
			ps.close();

			
			// PRIMARY PARENT/GUARDIAN
			int[] associateIds = new int[3];
			associateIds = this.getAssociateIDsForPatient(id);
			
			if (associateIds[0] != 0 && (guardianFirstName != "" || !guardianLastName.isEmpty())) {
				ps = conn.prepareStatement(sqlAbstractPerson);
				ps.setString(1, guardianFirstName);
				ps.setString(2, guardianLastName);
				ps.setString(3, guardianMiddleName);
				ps.setInt(4, associateIds[0]);
				ps.executeUpdate();
				ps.close();
			
				// PATIENT ASSOCIATES
				ps = conn.prepareStatement(sqlPatientAssociates);
				ps.setString(1, guardianRelationship);
				ps.setString(2, guardianPhone1);
				ps.setString(3, guardianPhone2);
				if(emergencyContact.equalsIgnoreCase("Primary")) {
					ps.setInt(4, 1);
				} else {
					ps.setInt(4, 0);
				}
				ps.setInt(5, id);
				ps.setInt(6, associateIds[0]);
				ps.executeUpdate();
				ps.close();
			}
			
			
			// SECONDARY PARENT/GUARDIAN
			if (associateIds[1] != 0 && (secondGuardianFirst != "" || !secondGuardianFirst.isEmpty())) {
				ps = conn.prepareStatement(sqlAbstractPerson);
				ps.setString(1, secondGuardianFirst);
				ps.setString(2, secondGuardianLast);
				ps.setString(3, secondGuardianMiddle);
				ps.setInt(4, associateIds[1]);
				ps.executeUpdate();
				ps.close();
			
				// PATIENT ASSOCIATES
				ps = conn.prepareStatement(sqlPatientAssociates);
				ps.setString(1, secondGuardianRelationship);
				ps.setString(2, secondGuardianPhone1);
				ps.setString(3, secondGuardianPhone2);
				if(emergencyContact.equalsIgnoreCase("Secondary")) {
					ps.setInt(4, 1);
				} else {
					ps.setInt(4, 0);
				}
				ps.setInt(5, id);
				ps.setInt(6, associateIds[1]);
				ps.executeUpdate();
				ps.close();
			}
				
			
			// EMERGENCY CONTACT
			if (associateIds[2] != 0 && (otherGuardianFirst != "" || !otherGuardianFirst.isEmpty())) {
				ps = conn.prepareStatement(sqlAbstractPerson);
				ps.setString(1, otherGuardianFirst);
				ps.setString(2, otherGuardianLast);
				ps.setString(3, otherGuardianMiddle);
				ps.setInt(4, associateIds[2]);
				ps.executeUpdate();
				ps.close();
			
				// PATIENT ASSOCIATES
				ps = conn.prepareStatement(sqlPatientAssociates);
				ps.setString(1, otherGuardianRelationship);
				ps.setString(2, otherGuardianPhone1);
				ps.setString(3, otherGuardianPhone2);
				if(emergencyContact.equalsIgnoreCase("Other")) {
					ps.setInt(4, 1);
				} else {
					ps.setInt(4, 0);
				}
				ps.setInt(5, id);
				ps.setInt(6, associateIds[2]);
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

	public Patient getPatient(int id) {
		Connection conn = null; // Resets the connection to the database
		Patient patient = null; // Resets the model
		
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
				patient = new Patient(
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
				patient.setDeformityAtBirth(rs2.getString("deformity_at_birth"));
				patient.setDiagnosisPrenatallyWeek(rs2.getInt("prenatal_week"));
				patient.setPrenatallyDiagConfirmation(rs2.getString("prenatal_confirmed"));
				patient.setDiagnosisComments(rs2.getString("diagnosis_comment"));
				patient.setReferral(rs2.getString("referral_source"));
				patient.setReferralDocName(rs2.getString("referral_doctor_name"));
				patient.setReferralHospitalName(rs2.getString("referral_hospital_name"));
				patient.setReferralOther(rs2.getString("referral_other"));
				patient.setDeformityHistoryNum(rs2.getInt("affected_relatives"));
				patient.setPregnancy(rs2.getInt("pregency_length"));
				patient.setPregnancyComplicationsExplained(rs2.getString("pregnancy_complications"));
				patient.setPregnancyAlc(rs2.getString("pregnancy_drinking"));
				patient.setPregnancySmoke(rs2.getString("pregnancy_smoking"));
				patient.setComplications(rs2.getString("birth_complications"));
				patient.setPlaceBirth(rs2.getInt("birth_place"));
				patient.setSex(rs2.getString("sex"));
				patient.setRace(rs2.getString("race"));
			}
			
			rs2.close();
			ps2.close();
			
			
			// Guardian/Emergency Contact Info
			sql = "select a.id, b.relationship_to_patient, b.phone1, b.phone2, b.is_emergency_contact, c.is_affected, d.first_name, d.last_name, d.middle_name " +
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
					patient.setGuardianRelationship(rs3.getString("relationship_to_patient"));
					patient.setGuardianPhone1(rs3.getString("phone1"));
					patient.setGuardianPhone2(rs3.getString("phone2"));
					patient.setGuardianFirstName(rs3.getString("first_Name"));
					patient.setGuardianLastName(rs3.getString("last_name"));
					patient.setGuardianMiddleName(rs3.getString("middle_name"));
					if (rs3.getInt("is_emergency_contact") == 1) {
						patient.setEmergencyContact("primary");
					}
				}
				else if (count == 1) {
					patient.setSecondGuardianRelationship(rs3.getString("relationship_to_patient"));
					patient.setSecondGuardianPhone1(rs3.getString("phone1"));
					patient.setSecondGuardianPhone2(rs3.getString("phone2"));
					patient.setSecondGuardianFirst(rs3.getString("first_Name"));
					patient.setSecondGuardianLast(rs3.getString("last_name"));
					patient.setSecondGuardianMiddle(rs3.getString("middle_name"));
					if (rs3.getInt("is_emergency_contact") == 1) {
						patient.setEmergencyContact("secondary");
					}
				}
				else {
					patient.setOtherGuardianRelationship(rs3.getString("relationship_to_patient"));
					patient.setOtherGuardianPhone1(rs3.getString("phone1"));
					patient.setOtherGuardianPhone2(rs3.getString("phone2"));
					patient.setOtherGuardianFirst(rs3.getString("first_Name"));
					patient.setOtherGuardianLast(rs3.getString("last_name"));
					patient.setOtherGuardianMiddle(rs3.getString("middle_name"));
					if (rs3.getInt("is_emergency_contact") == 1) {
						patient.setEmergencyContact("other");
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
		
	public Patient getNewPatient(int id) {
		String query = "select * from patient where id = ?";
		Patient patient = jdbcTemplateObject.queryForObject(query, new Object[]{id}, new PatientMapper());
		return patient;
	}

	/**
	 * Method that retrieves all Users data from a series of sql queries to the database, and puts it into a result set
	 * to be viewed in the "view" pages
	 */
	@Override
	public List<Patient> getAllPatients() {
		Connection conn = null; // Resets the connection to the database
		Patient patient = null; // Resets the model
		List<Patient> patients = null; // Resets the list
		
		/**
		 * Reseting the database connection to retrieve information that's stored in the mysql database
		 * via queries that are sent through the open connection. The results of the data received by this class
		 * is saved in a result set to be displayed in the jsp view. 
		 */
		try {
			conn = dataSource.getConnection();
			
			String sql = "select a.id, a.consent_inclusion, a.consent_photos, a.hospital_id, b.first_name, b.last_name, " +
		    		            "b.middle_name, a.dob, a.evaluator_id, a.evaluation_date, a.feet_affected, a.diagnosis, " +
		    		            "a.sex, a.race " +
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
				patient = new Patient(
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

	/**
	 * Method that retrieves the max person id
	 */
	@Override
	public int getMaxPersonID() {
		Connection conn = null; // Resets the connection to the database
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
	
	/**
	 * Method that gets the address id for person
	 */
	public int getAddressIDForPerson(int id) {
		Connection conn = null; // Resets the connection to the database
		int addressId = 0;
		
		try {
			conn = dataSource.getConnection();
			
			String sql = "Select address_id from abstract_person where id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				addressId = rs.getInt(1);
			}
			
			rs.close();
			ps.close();
			return addressId;
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
		Connection conn = null; // Resets the connection to the database
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
		Connection conn = null; // Resets the connection to the database
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
	
	public Map<Integer, String> getAllHospitals() {
		Connection conn = null; // Resets the connection to the database
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
	
	public Map<Integer, String> getAllEvaluators() {
		Connection conn = null; // Resets the connection to the database
		Map<Integer, String> evaluators = new LinkedHashMap<Integer,String>();
		
		try {
			conn = dataSource.getConnection();
			
			String sql = "Select a.id, concat(b.last_name, ', ', b.first_name, ' ', left(b.middle_name, 1)) as name " + 
						 "From evaluator a inner join abstract_person b on a.id = b.id " +
						 "Order by b.last_name";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				evaluators.put(rs.getInt("id"), rs.getString("name"));
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

	public List<Visit> getVisitsForPatient(int patientId) {
		Connection conn = null; // Resets the connection to the database
		Visit visit = null; // Resets the model
		List<Visit> visits = null; // Resets the list
		
		/**
		 * Reseting the database connection to retrieve information that's stored in the mysql database
		 * via queries that are sent through the open connection. The results of the data received by this class
		 * is saved in a result set to be displayed in the jsp view. 
		 */
		try {
			conn = dataSource.getConnection();
			
			String sql = "select a.id, a.visit_date, " +
					     "(select treatment from foot b join visit d on b.visit_id = d.id where b.visit_id = a.id and laterality = 'Left') as leftTreatment, " +
					     "(select sum(if(pc=2,0.5,pc)+if(eh=2,0.5,eh)+if(re=2,0.5,re)+if(mc=2,0.5,mc)+if(thc=2,0.5,thc)+if(clb=2,0.5,clb)) " +
					     "from foot z join visit y on z.visit_id = y.id where z.visit_id = a.id and laterality = 'Left') as leftScore, " +
					     "(select treatment from foot c join visit e on c.visit_id = e.id where c.visit_id = a.id and laterality = 'Right') as rightTreatment, " +
					     "(select sum(if(pc=2,0.5,pc)+if(eh=2,0.5,eh)+if(re=2,0.5,re)+if(mc=2,0.5,mc)+if(thc=2,0.5,thc)+if(clb=2,0.5,clb)) " +
					     "from foot z join visit y on z.visit_id = y.id where z.visit_id = a.id and laterality = 'Right') as rightScore " +
					     "from visit a " +
					     "where patient_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, patientId);
			ResultSet rs = ps.executeQuery();
			
			if (rs.last()) {
			  visits = new ArrayList<>(rs.getRow());
			  rs.beforeFirst(); 
			}
			
			while (rs.next()) {
				visit = new Visit(patientId);
				visit.setId(rs.getInt("id"));
				visit.setDateOfVisit(rs.getString("visit_date"));
				visit.setLeftTreatment(rs.getString("leftTreatment"));
				visit.setLeftScore(rs.getInt("leftScore"));
				visit.setRightTreatment(rs.getString("rightTreatment"));
				visit.setRightScore(rs.getInt("rightScore"));
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
	public void addPhoto(byte[] bytes) {
		System.out.println("MAKES IT HERE!!!!!!!!");
		Connection connection = null;	// Instantiation of the database connection
		try{
			connection = dataSource.getConnection();	// Connection of the dataSource with the MySql sever
			String sql = "Insert into patient (photo) values (?)";	// First sql statement that contains the information to query into abstract_person
			PreparedStatement ps = connection.prepareStatement(sql); // Instantiation of the class "PreparedStatement" of how the query statements are prepared to be added to the database with an instantiation of the database connection	
			ps.setBytes(1, bytes);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) { // Catches SQL exception errors
			throw new RuntimeException(e);
 
		} finally {
			if (connection != null) { // Closes SQL connection 
				try {
					connection.close();
				} catch (SQLException e) {}
			}
		}
		
		
	}

	@Override
	public List<Patient> getAllPatientsReports(ReportsPatients filters) {
		Connection conn = null; // Resets the connection to the database
		Patient patient = null; // Resets the model
		List<Patient> rp = null; // Resets the list
		
		/**
		 * Reseting the database connection to retrieve information that's stored in the mysql database
		 * via queries that are sent through the open connection. The results of the data received by this class
		 * is saved in a result set to be displayed in the jsp view. 
		 */
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = dataSource.getConnection();
			
			if (filters == null) {
				String sql = "Select a.id, a.consent_inclusion, a.consent_photos, a.hospital_id, b.first_name, b.last_name, " +
			            		"b.middle_name, a.dob, a.evaluator_id, a.evaluation_date, a.feet_affected, a.diagnosis, " +
			            		"a.sex, a.race " +
			            	 "from patient a " +
			            	 "inner join abstract_person b on a.id = b.id " +
			            	 "order by a.id";
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
			}
			else {
				CallableStatement cs = (CallableStatement) conn.prepareCall("{call filterPatientReport(?, ?, ?, ?)}");
				
				String sex = filters.getSex();
				String race = filters.getRace();
				String relatives = filters.getRelatives();
				Integer hospitalId = filters.getHospitalId();
				//String dobSel = filters.getDobSel();
				//String dob = filters.getDob();
				//String eval_dateSel = filters.getEval_dateSel();
				//String eval_date = filters.getEval_date();
				
				if (sex != null) { 
					cs.setString(1, sex); 
				} else { 
					cs.setString(1, "null"); 
				}
				
				if (race != null) { 
					cs.setString(2, race); 
				} else { 
					cs.setString(2, "null"); 
				}
				
				if (relatives != null) {
					if (relatives.equalsIgnoreCase("yes")) {
						cs.setString(3, "yes");
					}
					else if (relatives.equalsIgnoreCase("no")) {
						cs.setString(3, "no");
					}
					else {
						cs.setString(3, "unspecified");
					}
				} else { 
					cs.setString(3, "null"); 
				}
				
				if (hospitalId != null) { 
					cs.setInt(4, hospitalId); 
				} else { 
					cs.setInt(4, 0); 
				}
				/*
				if (dobSel != null) { 
					cs.setString(5, dobSel); 
				} else { 
					cs.setString(5, "null"); 
				}
				
				if (dob != null) { 
					cs.setString(6, dob); 
				} else { 
					cs.setString(6, "null"); 
				}
				
				if (eval_dateSel != null) { 
					cs.setString(7, eval_dateSel); 
				} else { 
					cs.setString(7, "null"); 
				}
				
				if (eval_date != null) { 
					cs.setString(8, eval_date); 
				} else { 
					cs.setString(8, "null"); 
				}*/
				
				cs.execute();
				rs = cs.getResultSet();
			}
			
			
			System.out.println("MADE IT HERE");
			
			if (rs.last()) {
			  rp = new ArrayList<>(rs.getRow());
			  rs.beforeFirst(); 
			}
			
			while (rs.next()) {
				patient = new Patient();
				patient.setId(rs.getInt("id"));
				patient.setPatientFirstName(rs.getString("first_name"));
				patient.setPatientLastName(rs.getString("last_name"));
				patient.setPatientMiddleName(rs.getString("middle_name"));
				rp.add(patient);
			}
			
			if (ps != null)
				ps.close();
			
			rs.close();
			return rp;
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
