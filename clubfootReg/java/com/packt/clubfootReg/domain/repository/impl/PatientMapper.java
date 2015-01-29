package com.packt.clubfootReg.domain.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.packt.clubfootReg.domain.newPatient;

public class PatientMapper implements RowMapper<newPatient> {

	public Object extractData(ResultSet arg0) throws SQLException,
			DataAccessException {

		return null;
	}

	public newPatient mapRow(ResultSet rs, int rowNum) throws SQLException {
		newPatient patient = new newPatient();
		patient.setId(rs.getInt("id"));
		return patient;
	}

}
