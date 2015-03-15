package com.packt.clubfootReg.domain.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.packt.clubfootReg.domain.newPatient;

/**
 * 
 * @author David
 * This class represents the patient mapper class to retrieve information stored in the database
 */
public class PatientMapper implements RowMapper<newPatient> {

	//JDBC template method extractData sets up query methods that set up the result set
	public Object extractData(ResultSet arg0) throws SQLException,
			DataAccessException {

		return null;
	}
	// Method that sets up the Result set from its obj rs, and the row numbers
	public newPatient mapRow(ResultSet rs, int rowNum) throws SQLException {
		newPatient patient = new newPatient();	// Instantiation of the patient object
		patient.setId(rs.getInt("id"));
		return patient;	// Returns the object patient	
	}

}
