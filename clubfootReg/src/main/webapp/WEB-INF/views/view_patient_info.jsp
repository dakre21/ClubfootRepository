<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html"; charset=ISO-8859-1">
<title>CURE Clubfoot | Patient Info</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
<style type="text/css">
body {
    padding-top: 70px;
    font-weight: normal;
  }
  .section{
  padding-top: 15px;
  font-weight: normal;


}

label {
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
<div class="container">
<nav id="myNavbar" class="navbar navbar-default navbar-inverse navbar-fixed-top" role="navigation">
  <!-- Brand and toggle get grouped for better mobile display -->
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbarCollapse">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="home">Clubfoot Registry</a>
    </div>
    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="navbarCollapse">
      <ul class="nav navbar-nav navbar-right">
              <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
                  Patients
                  <span class="caret"></span>
                </a>
                <ul class="dropdown-menu" role="menu">
                    <li><a href="view_patients">View Patients</a></li>
                      <li><a href="newpatient">Add Patient</a></li>
                  </ul>
              </li>
              <li class="dropdown">
                <a href="view_evaluators" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
                  Evaluators
                  <span class="caret"></span>
                </a>
                <ul class="dropdown-menu" role="menu">
                    <li><a href="view_evaluators">View Evaluators</a></li>
                      <li><a href="evaluator">Add Evaluator</a></li>
                  </ul>
              </li>
              <li class="dropdown">
                <a href="view_hospitals" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
                  Hospitals
                  <span class="caret"></span>
                </a>
                <ul class="dropdown-menu" role="menu">
                    <li><a href="view_hospitals">View Hospitals</a></li>
                      <li><a href="hospital">Add Hospital</a></li>
                  </ul>
              </li>
              <li class="dropdown">
                <a href="view_users" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
                  Users
                  <span class="caret"></span>
                </a>
                <ul class="dropdown-menu" role="menu">
                    <li><a href="view_users">View Users</a></li>
                      <li><a href="adduser">Add User</a></li>
                  </ul>
              </li>
              <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
                  Reports
                  <span class="caret"></span>
                </a>
                <ul class="dropdown-menu" role="menu">
                    <li><a href="#">Hospital</a></li>
                      <li><a href="#">Patient</a></li>
                      <li><a href="#">Visit</a></li>
                  </ul>
              </li>
              <li class="dropdown">
                	<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">User Session
                	<span class="caret"></span>
                	</a>
                	<ul class="dropdown-menu" role="menu">
                		<li><a href="login">Log in</a></li>
                		<li class="logout"><a href="<c:url value="/j_spring_security_logout"/>">Log out</a></li>
                	</ul>
              
              <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
                  <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
                  My Account
                  <span class="caret"></span>
                </a>
                <ul class="dropdown-menu" role="menu">
                    <li><a href="#">View My Account</a></li>
                      <li><a href="#">Account Information</a></li>
                  </ul>
              </li>  
            </ul>
    </div>
  </div>
</nav>
</div>
</head>

<body>


<div class="container">
<div class="row clearfix">
	<div class="col-sm-2 column"></div>
	<div class="col-md-8 column">
		<h1>Patient Info</h1>
		<hr>
	
		<div class = "section">
			<legend>Personal Information</legend>
			
			<label><b>Name:&nbsp </b><label>${patient.patient_firstName}&nbsp</label><label>${patient.patient_midName}&nbsp</label><label>${patient.patient_lastName}&nbsp</label> </label><br>
			<label><b>Sex:&nbsp</b></label><label>${patient.sex}</label><br>
			<label><b>Date of Birth (dd/mm/yyyy):&nbsp</b></label><label>${patient.dob}</label><br>
			<label><b>Race:&nbsp</b></label><label>${patient.race}</label><br>
			<label><b>Tribe:&nbsp</b></label><label>${patient.tribe}</label><br>
		</div>

		<div class = "section">
			<legend>Diagnosis</legend>
			
			<label><b>Evaluator:&nbsp </b><label><a href = "">${patient.evaluator}</a></label><br>
			<label><b>Evaluation date (dd/mm/yyyy):&nbsp</b></label><label>${patient.evaluation_date}</label><br>
			<label><b>Hospital/Clinic:&nbsp</b></label><label>${patient.hospital}</label><br>
			<label><b>Feet affected:&nbsp</b></label><label>${patient.feet}</label><br>
			<label><b>Diagnosis:&nbsp</b></label><label>${patient.diagnosis}</label><br>
			<label><b>Deformity at birth:&nbsp</b></label><label>${patient.deformity_at_birth}</label><br>
			<label><b>Any previous treatments:&nbsp </b><label>${patient.previous_treatments}&nbsp</label></label><br>
			<label><b>Number of previous treatments:&nbsp</b></label><label>${patient.previous_treatments_num}</label><br>
			<label><b>Type of previous treatments:&nbsp</b></label><label></label><br>
			<label><b>Diagnosed prenatally:&nbsp</b></label><label>${patient.diagnosis_prenatally}</label><br>
			<label><b>Prenatal diagnosis at pregnancy week:&nbsp</b></label><label>${patient.diagnosis_prenatally_week}</label><br>
			<label><b>Prenatal diagnosis confirmed at birth:&nbsp</b></label><label>${patient.prenatally_diag_confirmation}</label><br>
			<label><b>Diagnosis comments:&nbsp</b></label><label>${patient.diagnosis_comments}</label><br>

		</div>

		<div class = "section">
			<legend>Physical Examination</legend>
			
			<label><b>Abnormalities:&nbsp </b><label>${patient.abnormalities}&nbsp</label></label><br>
			<label><b>Weakness:&nbsp</b></label><label>${patient.weakness}</label><br>

		</div>


		<div class = "section">
			<legend>Referral Information</legend>
			
			<label><b>Referral source:&nbsp </b><label>${patient.referral}</label><br>
			<label><b>Referring doctor:&nbsp</b></label><label>${patient.referral_doc_name}</label><br>
			<label><b>Referring hospital:&nbsp</b></label><label>${patient.referral_hospital_name}</label><br>
			<label><b>Other referral:&nbsp</b></label><label>${patient.referral_other}</label><br>

		</div>

		<div class = "section">
			<legend>Patient Address</legend>
			
			<label><b>Address 1:&nbsp </b><label>${patient.addr1}</label><br>
			<label><b>Address 2:&nbsp</b></label><label>${patient.addr2}</label><br>
			<label><b>City:&nbsp</b></label><label>${patient.village}</label><br>
			<label><b>State:&nbsp</b></label><label>${patient.province}</label><br>
			<label><b>Country:&nbsp</b></label><label>${patient.country}</label><br>

		</div>

		<div class = "section">
			<legend>Parent/Guardian Information</legend>
	
			<h2>Primary</h2>
			<label><b>Name:&nbsp </b><label>${patient.guardian_firstName}&nbsp</label><label>${patient.guardian_midName}&nbsp</label><label>${patient.guardian_lastName}&nbsp</label> </label><br>			
			<label><b>Relationship to patient:&nbsp</b></label><label>${patient.guardian_relationship}</label><br>
			<label><b>Phone 1:&nbsp</b></label><label>${patient.guardian_phone1}</label><br>
			<label><b>Phone 2:&nbsp</b></label><label>${patient.guardian_phone2}</label><br>

			<h2>Secondary</h2>
			<label><b>Name:&nbsp </b><label>${patient.second_guardian_first}&nbsp</label><label>${patient.second_guardian_mid}&nbsp</label><label>${patient.second_guardian_last}&nbsp</label> </label><br>			
			<label><b>Relationship to patient:&nbsp</b></label><label>${patient.second_guardian_relationship}</label><br>
			<label><b>Phone 1:&nbsp</b></label><label>${patient.second_guardian_phone1}</label><br>
			<label><b>Phone 2:&nbsp</b></label><label>${patient.second_guardian_phone2}</label><br>

			<h2>Other Emergency Contact</h2>
			<label><b>Name:&nbsp </b><label>${patient.other_guardian_first}&nbsp</label><label>${patient.other_guardian_mid}&nbsp</label><label>${patient.other_guardian_last}&nbsp</label> </label><br>			
			<label><b>Relationship to patient:&nbsp</b></label><label>${patient.other_guardian_relationship}</label><br>
			<label><b>Phone 1:&nbsp</b></label><label>${patient.other_guardian_phone1}</label><br>
			<label><b>Phone 2:&nbsp</b></label><label>${patient.other_guardian_phone2}</label><br>
			<br>
			<label><b>Emergency Contact:&nbsp</b></label><label>${patient.emergency_contact}</label><br>

		</div>

		<div class = "section">
			<legend>Family History</legend>

			<label><b>Any relatives with the clubfoot deformity:&nbsp </b><label>${patient.deformity_history}</label><br>
			<label><b>Number of affected relatives:&nbsp</b></label><label>${patient.deformity_history_num}</label><br>
			<label><b>Length of pregnancy (in weeks):&nbsp</b></label><label>${patient.pregnancy}</label><br>
			<label><b>Did the mother have any complications during pregnancy:&nbsp</b></label><label></label><br>
			<label><b>Pregnancy complications:&nbsp</b></label><label>${patient.pregnancy_complications_explained}</label><br>
			<label><b>Did the mother consume alcohol during pregnancy:&nbsp </b><label>${patient.pregnancy_alch}</label><br>
			<label><b>Did the mother smoke during pregnancy:&nbsp</b></label><label>${patient.pregnancy_smoke}</label><br>
			<label><b>Any complications during birth:&nbsp</b></label><label>${patient.complications}</label><br>
			<label><b>Place of birth:&nbsp</b></label><label>${patient.place_birth}</label><br>

		</div>

		<div class = "section">
			<legend>Post Treatment Photo(s)</legend>

		</div>

		<div class = "section">
			<legend>Visits</legend>

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
		</div>
		
	</div>
	</div>
</div>

<div class="row">
	<div class="col-xs-12">
		<footer align="center">
			<p>&copy; Some Copywrite Info</p>
		</footer>
	</div>
</div>
	
</div>
</body>
</html>                                 		