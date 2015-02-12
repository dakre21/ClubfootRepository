package com.packt.clubfootReg.domain.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import com.packt.clubfootReg.domain.Evaluator;

public class EvaluatorMapper implements RowMapper<Evaluator> {

	public Object extractData(ResultSet arg0) throws SQLException, DataAccessException {
		return null;
	}

	public Evaluator mapRow(ResultSet rs, int rowNum) throws SQLException {
		Evaluator evaluator = new Evaluator(rs.getInt("id"), null, null, null, null, null, 1);
		return evaluator;
	}

}
