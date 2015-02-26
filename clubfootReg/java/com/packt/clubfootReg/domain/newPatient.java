package com.packt.clubfootReg.domain;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class newPatient {
	private int id;
	private Integer guardianConsent;
	private Integer photoConsent;
	private Integer hospital;
	private String patient_lastName;
	private String patient_firstName;
	private String patient_midName;
	private String sex;
	private String race;
	private String tribe;
	//private Date dob;
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
	private String second_guardian_last;
	private String second_guardian_first;
	private String second_guardian_mid;
	private String second_guardian_relationship;
	private String second_guardian_phone1;
	private String second_guardian_phone2;
	private String emergency_contact;
	private String other_guardian_last;
	private String other_guardian_first;
	private String other_guardian_mid;
	private String other_guardian_relationship;
	private String other_guardian_phone1;
	private String other_guardian_phone2;
	private String deformity_history;
	//private String deformity_history_num;
	private Integer deformity_history_num;
	//private String pregnancy;
	private Integer pregnancy;
	private String pregnancy_complications_explained;
	private String pregnancy_alc; //YNU
	private String pregnancy_smoke; //YNU
	private String complications; //YNU
	//private String place_birth;
	private Integer place_birth;
	private String referral;
	private String referral_doc_name;
	private String referral_hospital_name;
	private String referral_other;
	//private String evaluator;
	private Integer evaluator;
	//private Date evaluation_date;
	private String evaluation_date;
	private String feet;
	private String diagnosis;
	private String deformity_at_birth; //YNU
	private String previous_treatments; //YNU
	private String previous_treatments_num;
	private String diagnosis_prenatally; //YNU
	private String diagnosis_prenatally_week;
	private String prenatally_diag_confirmation; //YNU
	private String diagnosis_comments;
	private String abnormalities;
	private String weakness;
	//private MultipartFile pre_imgfile;

	public newPatient() {
		super();
	}
	
	public newPatient(int id, String patient_firstName, String patient_lastName, String patient_midName, String addr1, String village, String province, String country){
		this.id = id;
		this.patient_firstName = patient_firstName;
		this.patient_lastName = patient_lastName;
		this.patient_midName = patient_midName;
		this.addr1 = addr1;
		this.village = village;
		this.province = province;
		this.country = country;
	}
	
	
	public Integer getGuardianConsent() {
		return guardianConsent;
	}
	public void setGuardianConsent(Integer guardianConsent) {
		this.guardianConsent = guardianConsent;
	}
	
	
	public Integer getPhotoConsent() {
		return photoConsent;
	}
	public void setPhotoConsent(Integer photoConsent) {
		this.photoConsent = photoConsent;
	}
	
	
	public Integer getHospital() {
		return hospital;
	}
	public void setHospital(Integer hospital) {
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
	
	
	public String getTribe() {
		return tribe;
	}
	public void setTribe(String tribe) {
		this.tribe = tribe;
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
	
	/*
	public String getGuardian_check() {
		return guardian_check;
	}
	public void setGuardian_check(String guardian_check) {
		this.guardian_check = guardian_check;
	}
	*/
	
	
	public String getEmergency_contact() {
		return emergency_contact;
	}
	public void setEmergency_contact(String emergency_contact) {
		this.emergency_contact = emergency_contact;
	}
	
	
	public String getDeformity_history() {
		return deformity_history;
	}
	public void setDeformity_history(String deformity_history) {
		this.deformity_history = deformity_history;
	}
	
	
	public Integer getPregnancy() {
		return pregnancy;
	}
	public void setPregnancy(Integer pregnancy) {
		this.pregnancy = pregnancy;
	}
	
	
	public String getPregnancy_complications_explained() {
		return pregnancy_complications_explained;
	}
	public void setPregnancy_complications_explained(String pregnancy_complications_explained) {
		this.pregnancy_complications_explained = pregnancy_complications_explained;
	}
	
	
	public String getPregnancy_alc() {
		return pregnancy_alc;
	}
	public void setPregnancy_alc(String pregnancy_alc) {
		this.pregnancy_alc = pregnancy_alc;
	}
	
	
	public String getPregnancy_smoke() {
		return pregnancy_smoke;
	}
	public void setPregnancy_smoke(String pregnancy_smoke) {
		this.pregnancy_smoke = pregnancy_smoke;
	}
	
	
	public String getComplications() {
		return complications;
	}
	public void setComplications(String complications) {
		this.complications = complications;
	}
	
	
	public Integer getPlace_birth() {
		return place_birth;
	}
	public void setPlace_birth(Integer place_birth) {
		this.place_birth = place_birth;
	}
	
	
	public String getReferral() {
		return referral;
	}
	public void setReferral(String referral) {
		this.referral = referral;
	}
	
	
	public Integer getEvaluator() {
		return evaluator;
	}
	public void setEvaluator_name(Integer evaluator) {
		this.evaluator = evaluator;
	}
	
	
	public String getEvaluation_date() {
		return evaluation_date;
	}
	public void setEvaluation_date(String evaluation_date) {
		this.evaluation_date = evaluation_date;
	}
	
	
	public String getFeet() {
		return feet;
	}
	public void setFeet(String feet) {
		this.feet = feet;
	}
	
	
	public String getDiagnosis() {
		return diagnosis;
	}
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	
	
	public String getDeformity_at_birth() {
		return deformity_at_birth;
	}
	public void setDeformity_at_birth(String deformity_at_birth) {
		this.deformity_at_birth = deformity_at_birth;
	}
	
	
	public String getPrevious_treatments() {
		return previous_treatments;
	}
	public void setPrevious_treatments(String previous_treatments) {
		this.previous_treatments = previous_treatments;
	}
	
	
	public String getDiagnosis_prenatally() {
		return diagnosis_prenatally;
	}
	public void setDiagnosis_prenatally(String diagnosis_prenatally) {
		this.diagnosis_prenatally = diagnosis_prenatally;
	}
	
	
	public String getPrenatally_diag_confirmation() {
		return prenatally_diag_confirmation;
	}
	public void setPrenatally_diag_confirmation(String prenatally_diag_confirmation) {
		this.prenatally_diag_confirmation = prenatally_diag_confirmation;
	}
	
	
	public String getDiagnosis_comments() {
		return diagnosis_comments;
	}
	public void setDiagnosis_comments(String diagnosis_comments) {
		this.diagnosis_comments = diagnosis_comments;
	}
	
	
	public String getAbnormalities() {
		return abnormalities;
	}
	public void setAbnormalities(String abnormalities) {
		this.abnormalities = abnormalities;
	}
	
	
	public String getWeakness() {
		return weakness;
	}
	public void setWeakness(String weakness) {
		this.weakness = weakness;
	}
	
	
	public String getSecond_guardian_last() {
		return second_guardian_last;
	}
	public void setSecond_guardian_last(String second_guardian_last) {
		this.second_guardian_last = second_guardian_last;
	}
	
	
	public String getSecond_guardian_first() {
		return second_guardian_first;
	}
	public void setSecond_guardian_first(String second_guardian_first) {
		this.second_guardian_first = second_guardian_first;
	}
	
	
	public String getSecond_guardian_mid() {
		return second_guardian_mid;
	}
	public void setSecond_guardian_mid(String second_guardian_mid) {
		this.second_guardian_mid = second_guardian_mid;
	}
	
	
	public String getSecond_guardian_relationship() {
		return second_guardian_relationship;
	}
	public void setSecond_guardian_relationship(
			String second_guardian_relationship) {
		this.second_guardian_relationship = second_guardian_relationship;
	}
	
	
	public String getSecond_guardian_phone1() {
		return second_guardian_phone1;
	}
	public void setSecond_guardian_phone1(String second_guardian_phone1) {
		this.second_guardian_phone1 = second_guardian_phone1;
	}
	
	
	public String getSecond_guardian_phone2() {
		return second_guardian_phone2;
	}
	public void setSecond_guardian_phone2(String second_guardian_phone2) {
		this.second_guardian_phone2 = second_guardian_phone2;
	}
	
	
	public String getOther_guardian_last() {
		return other_guardian_last;
	}
	public void setOther_guardian_last(String other_guardian_last) {
		this.other_guardian_last = other_guardian_last;
	}
	
	
	public String getOther_guardian_first() {
		return other_guardian_first;
	}
	public void setOther_guardian_first(String other_guardian_first) {
		this.other_guardian_first = other_guardian_first;
	}
	
	
	public String getOther_guardian_mid() {
		return other_guardian_mid;
	}
	public void setOther_guardian_mid(String other_guardian_mid) {
		this.other_guardian_mid = other_guardian_mid;
	}
	
	
	public String getOther_guardian_relationship() {
		return other_guardian_relationship;
	}
	public void setOther_guardian_relationship(String other_guardian_relationship) {
		this.other_guardian_relationship = other_guardian_relationship;
	}
	
	
	public String getOther_guardian_phone1() {
		return other_guardian_phone1;
	}
	public void setOther_guardian_phone1(String other_guardian_phone1) {
		this.other_guardian_phone1 = other_guardian_phone1;
	}
	
	
	public String getOther_guardian_phone2() {
		return other_guardian_phone2;
	}
	public void setOther_guardian_phone2(String other_guardian_phone2) {
		this.other_guardian_phone2 = other_guardian_phone2;
	}
	
	
	public Integer getDeformity_history_num() {
		return deformity_history_num;
	}
	public void setDeformity_history_num(Integer deformity_history_num) {
		this.deformity_history_num = deformity_history_num;
	}
	
	
	public String getReferral_doc_name() {
		return referral_doc_name;
	}
	public void setReferral_doc_name(String referral_doc_name) {
		this.referral_doc_name = referral_doc_name;
	}
	
	
	public String getReferral_hospital_name() {
		return referral_hospital_name;
	}
	public void setReferral_hospital_name(String referral_hospital_name) {
		this.referral_hospital_name = referral_hospital_name;
	}
	
	
	public String getReferral_other() {
		return referral_other;
	}
	public void setReferral_other(String referral_other) {
		this.referral_other = referral_other;
	}
	
	
	public String getPrevious_treatments_num() {
		return previous_treatments_num;
	}
	public void setPrevious_treatments_num(String previous_treatments_num) {
		this.previous_treatments_num = previous_treatments_num;
	}
	
	
	public String getDiagnosis_prenatally_week() {
		return diagnosis_prenatally_week;
	}
	public void setDiagnosis_prenatally_week(String diagnosis_prenatally_week) {
		this.diagnosis_prenatally_week = diagnosis_prenatally_week;
	}
}
