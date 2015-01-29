package com.packt.clubfootReg.domain;

import org.springframework.web.multipart.MultipartFile;

public class newPatient {
	
	private String guardianConsent;
	private String photoConsent;
	private String hospital;
	private String patient_lastName;
	private String patient_firstName;
	private String patient_midName;
	private String sex;
	private String race;
	private String dob;
	private String addr1;
	private String addr2;
	private String village;
	private String province;
	private String country;
	private String guardian_lastName;
	private String guardian_firstName;
	private String guardian_midName;
	private String guardian_relationship;
	private String guardian_phone1;
	private String guardian_phone2;
	private int id;
	//private MultipartFile pre_imgfile;

	public newPatient() {
		// TODO Auto-generated constructor stub
		super();
	}
	//Getter
	public String getGuardianConsent() {
		return guardianConsent;
	}
	//Setter
	public void setGuardianConsent(String guardianConsent) {
		this.guardianConsent = guardianConsent;
	}
	
	public String getPhotoConsent() {
		return photoConsent;
	}
	
	public void setPhotoConsent(String photoConsent) {
		this.photoConsent = photoConsent;
	}
	
	public String getHospital() {
		return hospital;
	}
	
	public void setHospital(String hospital) {
		this.hospital = hospital;
	}
	
	public String getPatient_lastName() {
		return patient_lastName;
	}
	
	public void setPatient_lastName(String patient_lastName) {
		this.patient_lastName = patient_lastName;
	}
	
	public String getPatient_firstName() {
		return patient_firstName;
	}
	
	public void setPatient_firstName(String patient_firstName) {
		this.patient_firstName = patient_firstName;
	}
	
	public String getPatient_midName() {
		return patient_midName;
	}
	
	public void setPatient_midName(String patient_midName) {
		this.patient_midName = patient_midName;
	}
	
	public String getSex() {
		return sex;
	}
	
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public String getRace() {
		return race;
	}
	
	public void setRace(String race) {
		this.race = race;
	}
	
	public String getDob() {
		return dob;
	}
	
	public void setDob(String dob) {
		this.dob = dob;
	}
	
	public String getAddr1() {
		return addr1;
	}
	
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	
	public String getAddr2() {
		return addr2;
	}
	
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	
	public String getVillage() {
		return village;
	}
	
	public void setVillage(String village) {
		this.village = village;
	}
	
	public String getProvince() {
		return province;
	}
	
	public void setProvince(String province) {
		this.province = province;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getGuardian_lastName() {
		return guardian_lastName;
	}
	
	public void setGuardian_lastName(String guardian_lastName) {
		this.guardian_lastName = guardian_lastName;
	}
	
	public String getGuardian_firstName() {
		return guardian_firstName;
	}
	
	public void setGuardian_firstName(String guardian_firstName) {
		this.guardian_firstName = guardian_firstName;
	}
	
	public String getGuardian_midName() {
		return guardian_midName;
	}
	
	public void setGuardian_midName(String guardian_midName) {
		this.guardian_midName = guardian_midName;
	}
	
	public String getGuardian_relationship() {
		return guardian_relationship;
	}
	
	public void setGuardian_relationship(String guardian_relationship) {
		this.guardian_relationship = guardian_relationship;
	}
	
	public String getGuardian_phone1() {
		return guardian_phone1;
	}
	
	public void setGuardian_phone1(String guardian_phone1) {
		this.guardian_phone1 = guardian_phone1;
	}
	
	public String getGuardian_phone2() {
		return guardian_phone2;
	}
	
	public void setGuardian_phone2(String guardian_phone2) {
		this.guardian_phone2 = guardian_phone2;
	}
/*
	public MultipartFile getPre_imgfile() {
		return pre_imgfile;
	}
	
	public void setPre_imgfile(MultipartFile pre_imgfile) {
		this.pre_imgfile = pre_imgfile;
	}
*/
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
