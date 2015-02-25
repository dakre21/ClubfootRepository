<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html"; charset="ISO-8859-1">
<title>CURE Clubfoot | Patient Info</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
<style type="text/css">
body {
	margin-top: 40px;
  	margin-bottom: 1%;
  	margin-left: 1%;
  	margin-right: 1%;
  	font-size: medium;
  	font-family: arial;
  	font-style: normal;
}
.section{
	padding-top: 15px;
  	font-weight: normal;
}

br{
	padding-bottom: 2px;
}
label{
	font-weight: normal;
}
h2{
	padding-top: 5px;
	padding-bottom: 2px;
	font-weight: normal;
	font-size: large;
	text-decoration: underline;
}
</style>
<jsp:include page="navbar.jsp" />
</head>

<body>
<div class="container">
<div class="row clearfix">
	<div class="col-sm-2 column"></div>
	<div class="col-md-8 column">	
		<h1>Patient Info</h1>
		<hr>
		
		<div class = "section">
			<fieldset><legend>Personal Information</legend>
			
			<label><b>Name:&nbsp </b></label><label>${patient.patient_firstName}&nbsp</label><label>${patient.patient_midName}&nbsp</label><label>${patient.patient_lastName}&nbsp</label><br>
			<label><b>Sex:&nbsp</b></label><label>${patient.sex}</label><br>
			<label><b>Date of Birth (dd/mm/yyyy):&nbsp</b></label><label>${patient.dob}</label><br>
			<label><b>Race:&nbsp</b></label><label>${patient.race}</label><br>
			<label><b>Tribe:&nbsp</b></label><label>${patient.tribe}</label><br>
			
			</fieldset>
		</div>
		
		<div class = "section">
			<fieldset><legend>Diagnosis</legend>
			
			<label><b>Evaluator:&nbsp </b></label><label><a href = "">${patient.evaluator}</a></label><br>
			<label><b>Evaluation date (dd/mm/yyyy):&nbsp</b></label><label>${patient.evaluation_date}</label><br>
			<label><b>Hospital/Clinic:&nbsp</b></label><label>${patient.hospital}</label><br>
			<label><b>Feet affected:&nbsp</b></label><label>${patient.feet}</label><br>
			<label><b>Diagnosis:&nbsp</b></label><label>${patient.diagnosis}</label><br>
			<label><b>Deformity at birth:&nbsp</b></label><label>${patient.deformity_at_birth}</label><br>
			<label><b>Any previous treatments:&nbsp </b></label><label>${patient.previous_treatments}&nbsp</label><br>
			<label><b>Number of previous treatments:&nbsp</b></label><label>${patient.previous_treatments_num}</label><br>
			<label><b>Type of previous treatments:&nbsp</b></label><label></label><br>
			<label><b>Diagnosed prenatally:&nbsp</b></label><label>${patient.diagnosis_prenatally}</label><br>
			<label><b>Prenatal diagnosis at pregnancy week:&nbsp</b></label><label>${patient.diagnosis_prenatally_week}</label><br>
			<label><b>Prenatal diagnosis confirmed at birth:&nbsp</b></label><label>${patient.prenatally_diag_confirmation}</label><br>
			<label><b>Diagnosis comments:&nbsp</b></label><label>${patient.diagnosis_comments}</label><br>

			</fieldset>
		</div>
		 
		<div class = "section">
			<fieldset><legend>Physical Examination</legend>
			
			<label><b>Abnormalities:&nbsp </b></label><label>${patient.abnormalities}&nbsp</label><br>
			<label><b>Weakness:&nbsp</b></label><label>${patient.weakness}</label><br>
			
			</fieldset>
		</div>
		
		<div class = "section">
			<fieldset><legend>Referral Information</legend>

			
			<label><b>Referral source:&nbsp </b></label><label>${patient.referral}</label><br>
			<label><b>Referring doctor:&nbsp</b></label><label>${patient.referral_doc_name}</label><br>
			<label><b>Referring hospital:&nbsp</b></label><label>${patient.referral_hospital_name}</label><br>
			<label><b>Other referral:&nbsp</b></label><label>${patient.referral_other}</label><br>

			</fieldset>
		</div>
		
		<div class = "section">
			<fieldset><legend>Patient Address</legend>
			
			<label><b>Address 1:&nbsp </b></label><label>${patient.addr1}</label><br>
			<label><b>Address 2:&nbsp</b></label><label>${patient.addr2}</label><br>
			<label><b>City:&nbsp</b></label><label>${patient.village}</label><br>
			<label><b>State:&nbsp</b></label><label>${patient.province}</label><br>
			<label><b>Country:&nbsp</b></label><label>${patient.country}</label><br>
			
			</fieldset>
		</div>
		
		<div class = "section">
			<fieldset><legend>Parent/Guardian Information</legend>
	
			<h2>Primary</h2>
			<label><b>Name:&nbsp</b></label><label>${patient.guardian_firstName}&nbsp</label><label>${patient.guardian_midName}&nbsp</label><label>${patient.guardian_lastName}&nbsp</label><br>			
			<label><b>Relationship to patient:&nbsp</b></label><label>${patient.guardian_relationship}</label><br>
			<label><b>Phone 1:&nbsp</b></label><label>${patient.guardian_phone1}</label><br>
			<label><b>Phone 2:&nbsp</b></label><label>${patient.guardian_phone2}</label><br>
			
			<h2>Secondary</h2>
			<label><b>Name:&nbsp </b></label><label>${patient.second_guardian_first}&nbsp</label><label>${patient.second_guardian_mid}&nbsp</label><label>${patient.second_guardian_last}&nbsp</label><br>			
			<label><b>Relationship to patient:&nbsp</b></label><label>${patient.second_guardian_relationship}</label><br>
			<label><b>Phone 1:&nbsp</b></label><label>${patient.second_guardian_phone1}</label><br>
			<label><b>Phone 2:&nbsp</b></label><label>${patient.second_guardian_phone2}</label><br>

			<h2>Other Emergency Contact</h2>
			<label><b>Name:&nbsp </b></label><label>${patient.other_guardian_first}&nbsp</label><label>${patient.other_guardian_mid}&nbsp</label><label>${patient.other_guardian_last}&nbsp</label><br>			
			<label><b>Relationship to patient:&nbsp</b></label><label>${patient.other_guardian_relationship}</label><br>
			<label><b>Phone 1:&nbsp</b></label><label>${patient.other_guardian_phone1}</label><br>
			<label><b>Phone 2:&nbsp</b></label><label>${patient.other_guardian_phone2}</label><br>
			<br>
			<label><b>Emergency Contact:&nbsp</b></label><label>${patient.emergency_contact}</label><br>

			</fieldset>
		</div>
		
		<div class = "section">
			<fieldset><legend>Family History</legend>

			<label><b>Any relatives with the clubfoot deformity:&nbsp </b></label><label>${patient.deformity_history}</label><br>
			<label><b>Number of affected relatives:&nbsp</b></label><label>${patient.deformity_history_num}</label><br>
			<label><b>Length of pregnancy (in weeks):&nbsp</b></label><label>${patient.pregnancy}</label><br>
			<label><b>Did the mother have any complications during pregnancy:&nbsp</b></label><label></label><br>
			<label><b>Pregnancy complications:&nbsp</b></label><label>${patient.pregnancy_complications_explained}</label><br>
			<label><b>Did the mother consume alcohol during pregnancy:&nbsp </b></label><label>${patient.pregnancy_alch}</label><br>
			<label><b>Did the mother smoke during pregnancy:&nbsp</b></label><label>${patient.pregnancy_smoke}</label><br>
			<label><b>Any complications during birth:&nbsp</b></label><label>${patient.complications}</label><br>
			<label><b>Place of birth:&nbsp</b></label><label>${patient.place_birth}</label><br>

			</fieldset>
		</div>
		
		<div class = "section">
			<fieldset><legend>Post Treatment Photo(s)</legend></fieldset>
		</div>
		
		<div class = "section">
			<fieldset><legend>Visits</legend>

			<table class='table table-striped'>
			   	<thead>
			   		<tr>
			    		<th>Date of visit (dd/mm/yyyy)</th>
			    		<th>Treatment (left)</th>
			    		<th>Treatment (right)</th>
			    		<th>Pirani score (left)</th>
			    		<th>Pirani score (right)</th>
	
			    	</tr>
			    </thead>
		   
		    	<tbody>
	              <tr>
	                  <td></td>
					  <td></td>
					  <td></td>
					  <td></td>
					  <td></td>
					  <td><a href="">View Details</a></td>
	              </tr>
		      	</tbody>
	  		</table>
			</fieldset>
		</div>
	</div>
	<div class="col-sm-2 column"></div>
</div>
</div>

<div class="row">
	<div class="col-xs-12">
		<footer align="center">
			<p>&copy; Some Copywrite Info</p>
		</footer>
	</div>
</div>

</body>
</html>                                 		