package com.packt.clubfootReg.domain.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import com.packt.clubfootReg.domain.Evaluator;

/**
 * 
 * @author David
 * This class is the Evaluator Mapper class which retrieves information stored in the database in regards to the Evaluator
 */
// Evaluator mapper class
public class EvaluatorMapper implements RowMapper<Evaluator> {

	//JDBC template method extractData sets up query methods that set up the result set
	public Object extractData(ResultSet arg0) throws SQLException, DataAccessException {
		return null;
	}

	// Method that sets up the Result set from its obj rs, and the row numbers
	public Evaluator mapRow(ResultSet rs, int rowNum) throws SQLException {
		Evaluator evaluator = new Evaluator(rs.getInt("id"), null, null, null, null, null, 1);	// Instantiates the object evaluator
		return evaluator;	// Returns evaluator
	}

}
