package com.packt.clubfootReg.domain.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.packt.clubfootReg.domain.newPatient;
import com.packt.clubfootReg.domain.repository.newPatientRepo;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

@Repository
public class InMemoryNewPatientRepo implements newPatientRepo{
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	private List<newPatient> listOfPatients = new ArrayList<newPatient>();
	
	public void addPatient(newPatient newpatient) {
		listOfPatients.add(newpatient);
		int id = newpatient.getId();
		String street = newpatient.getAddr1();
		String village = newpatient.getVillage();
		String province = newpatient.getProvince();
		String country = newpatient.getCountry();
		String query = "Insert into address (id, street, village, province, country) values (?, ?, ?, ?, ?)";
		//jdbcTemplateObject.update(query, id, street, village, province, country);
		System.out.println("Created patient address" + street + " " + village + " " + province + " " + country);
		return;
	}
	public InMemoryNewPatientRepo() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
/*
	public List<newPatient> getNewPatients() {
		// TODO Auto-generated method stub
		return listOfPatients;
	}
*/	
	public void deletePatient(int id) {
		String query = "delete from patient where id = ?";
		jdbcTemplateObject.update(query, id);
		System.out.println("Deleted patient with id = " + id);
	}
	public void updatePatient(newPatient newpatient) {
		
		
	}
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
		
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
