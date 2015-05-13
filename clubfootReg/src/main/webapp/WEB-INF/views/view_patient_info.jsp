<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  	<!-- Latest compiled and minified CSS -->
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

  	<!-- Latest compiled and minified JavaScript -->
  	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

  	<style type="text/css">
		body {
	  		padding-top: 70px;
	  		margin-top: 1%;
	  		margin-bottom: 1%;
	  		margin-left: 1%;
	  		margin-right: 1%;
	  		font-size: medium;
	  		font-family: arial;
	  		font-style: normal;
	  	}
	  	h1 {
	  		font-size: x-large;
	  		font-style: bold;
	  		line-height: 1.5;
	  		text-decoration: underline;
	  	}
	  	fieldset {
	  		margin-bottom: 15px;
	  		padding: 10px;
  	  		text-align: left;
  	  		border: 2px groove;
	  	}
	  	legend {
	  		padding: 0px 3px;
	  		font-weight: bold;
	  		font-variant: small-caps;
	  	}
	  	em {
	  		color: red;
	  	}
	  	br {
			padding-bottom: 2px;
		}
		label {
			font-weight: normal;
		}
		h2 {
			padding-top: 5px;
			padding-bottom: 2px;
			font-weight: normal;
			font-size: large;
			text-decoration: underline;
		}
	  	input[type=submit] {
  			width: 150px;
  			padding: 10px;
		}
	</style>
	
 	<title>Clubfoot Registry | View Patient Info</title>
  	<jsp:include page="navbar.jsp" />
</head>

<body>
<div class="container">
	<div class="row clearfix">
	<div class="col-sm-2 column"></div>
	<div class="col-md-8 column">
		<h1>View Patient Info</h1>  
		
		<div class = "row">
			<fieldset>
				<legend>Personal Information</legend>
				<div class = "col-md-12">
					<label><b>Name:&nbsp; </b></label><label>${patient.patientFirstName}&nbsp;</label><label>${patient.patientMiddleName}&nbsp;</label><label>${patient.patientLastName}&nbsp;</label><br>
					<label><b>Sex:&nbsp;</b></label><label>${patient.sex}</label><br>
					<label><b>Date of Birth (dd/mm/yyyy):&nbsp;</b></label><label>${patient.dob}</label><br>
					<label><b>Race:&nbsp;</b></label><label>${patient.race}</label><br>
					<label><b>Tribe:&nbsp;</b></label><label>${patient.tribe}</label><br>
				</div>
			</fieldset>
		</div>
		
		<div class = "row">
			<fieldset>
				<legend>Address</legend>
				<div class = "col-md-12">
					<label><b>Address 1:&nbsp; </b></label><label>${patient.addr1}</label><br>
					<label><b>Address 2:&nbsp;</b></label><label>${patient.addr2}</label><br>
					<label><b>City:&nbsp;</b></label><label>${patient.village}</label><br>
					<label><b>State:&nbsp;</b></label><label>${patient.province}</label><br>
					<label><b>Country:&nbsp;</b></label><label>${patient.country}</label><br>
				</div>
			</fieldset>
		</div>

		<div class = "row">
			<fieldset>
				<legend>Parent/Guardian Information</legend>
				<div class = "col-md-12">
					<h2>Primary</h2>
					<label><b>Name:&nbsp; </b></label><label>${patient.guardianFirstName}&nbsp;</label><label>${patient.guardianMiddleName}&nbsp;</label><label>${patient.guardianLastName}&nbsp;</label><br>			
					<label><b>Relationship to patient:&nbsp;</b></label><label>${patient.guardianRelationship}</label><br>
					<label><b>Phone 1:&nbsp;</b></label><label>${patient.guardianPhone1}</label><br>
					<label><b>Phone 2:&nbsp;</b></label><label>${patient.guardianPhone2}</label><br>
					<h2>Secondary</h2>
					<label><b>Name:&nbsp; </b></label><label>${patient.secondGuardianFirst}&nbsp;</label><label>${patient.secondGuardianMiddle}&nbsp;</label><label>${patient.secondGuardianLast}&nbsp;</label><br>			
					<label><b>Relationship to patient:&nbsp;</b></label><label>${patient.secondGuardianRelationship}</label><br>
					<label><b>Phone 1:&nbsp;</b></label><label>${patient.secondGuardianPhone1}</label><br>
					<label><b>Phone 2:&nbsp;</b></label><label>${patient.secondGuardianPhone2}</label><br>
					<h2>Other Emergency Contact</h2>
					<label><b>Name:&nbsp; </b></label><label>${patient.otherGuardianFirst}&nbsp;</label><label>${patient.otherGuardianMiddle}&nbsp;</label><label>${patient.otherGuardianLast}&nbsp;</label><br>			
					<label><b>Relationship to patient:&nbsp;</b></label><label>${patient.otherGuardianRelationship}</label><br>
					<label><b>Phone 1:&nbsp;</b></label><label>${patient.otherGuardianPhone1}</label><br>
					<label><b>Phone 2:&nbsp;</b></label><label>${patient.otherGuardianPhone2}</label><br>
					<br>
					<label><b>Emergency Contact:&nbsp;</b></label><label>${patient.emergencyContact}</label><br>
				</div>
			</fieldset>
		</div>

		<div class = "row">
			<fieldset>
				<legend>Family History</legend>
				<div class = "col-md-12">
					<label><b>Number of affected relatives:&nbsp;</b></label><label>${patient.deformityHistoryNum}</label><br>
					<label><b>Length of pregnancy (in weeks):&nbsp;</b></label><label>${patient.pregnancy}</label><br>
					<label><b>Pregnancy complications:&nbsp;</b></label><label>${patient.pregnancyComplicationsExplained}</label><br>
					<label><b>Did the mother consume alcohol during pregnancy:&nbsp;</b></label><label>${patient.pregnancyAlc}</label><br>
					<label><b>Did the mother smoke during pregnancy:&nbsp;</b></label><label>${patient.pregnancySmoke}</label><br>
					<label><b>Any complications during birth:&nbsp;</b></label><label>${patient.complications}</label><br>
					<label><b>Place of birth:&nbsp;</b></label><label>${patient.placeBirth}</label><br>
				</div>
			</fieldset>
		</div>

		<div class = "row">
			<fieldset>
				<legend>Referral Information</legend>
				<div class = "col-md-12">
					<label><b>Referral source:&nbsp; </b></label><label>${patient.referral}</label><br>
					<label><b>Referring doctor:&nbsp;</b></label><label>${patient.referralDocName}</label><br>
					<label><b>Referring hospital:&nbsp;</b></label><label>${patient.referralHospitalName}</label><br>
					<label><b>Other referral:&nbsp;</b></label><label>${patient.referralOther}</label><br>
				</div>
			</fieldset>
		</div>

		<div class = "row">
			<fieldset>
				<legend>Diagnosis</legend>
				<div class = "col-md-12">
					<label><b>Evaluator:&nbsp; </b></label><label><a href = "view_evaluators">${patient.evaluator}</a></label><br>
					<label><b>Evaluation date (dd/mm/yyyy):&nbsp;</b></label><label>${patient.evaluationDate}</label><br>
					<label><b>Hospital/Clinic:&nbsp;</b></label><label>${patient.hospital}</label><br>
					<label><b>Feet affected:&nbsp;</b></label><label>${patient.feet}</label><br>
					<label><b>Diagnosis:&nbsp;</b></label><label>${patient.diagnosis}</label><br>
					<label><b>Deformity at birth:&nbsp;</b></label><label>${patient.deformityAtBirth}</label><br>
					<label><b>Any previous treatments:&nbsp; </b></label><label>${patient.previousTreatments}&nbsp;</label><br>
					<label><b>Number of previous treatments:&nbsp;</b></label><label>${patient.previousTreatmentsNum}</label><br>
					<label><b>Type of previous treatments:&nbsp;</b></label><label></label><br>
					<label><b>Diagnosed prenatally:&nbsp;</b></label><label>${patient.diagnosisPrenatally}</label><br>
					<label><b>Prenatal diagnosis at pregnancy week:&nbsp;</b></label><label>${patient.diagnosisPrenatallyWeek}</label><br>
					<label><b>Prenatal diagnosis confirmed at birth:&nbsp;</b></label><label>${patient.prenatallyDiagConfirmation}</label><br>
					<label><b>Diagnosis comments:&nbsp;</b></label><label>${patient.diagnosisComments}</label><br>
				</div>
			</fieldset>
		</div>

		<div class = "row">
			<fieldset>
				<legend>Physical Examination</legend>
				<div class = "col-md-12">
					<label><b>Abnormalities:&nbsp; </b></label><label>${patient.abnormalities}&nbsp;</label><br>
					<label><b>Weakness:&nbsp;</b></label><label>${patient.weakness}</label><br>
				</div>
			</fieldset>
		</div>

		<div class = "row">
			<fieldset>
				<legend>Post Treatment Photo(s)</legend>
				<div class = "col-md-12">
					
				</div>
			</fieldset>
		</div>

		<div class = "row">
			<fieldset>
				<legend>Visits</legend>
				<div class = "col-md-12">
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
				    	<c:if test="${not empty visits}">
				            <c:forEach var="o" items="${visits}">
				            	<tr>
				            	    <td>${o.dateOfVisit}</td>
								  	<td>${o.leftTreatment}</td>
								  	<td>${o.rightTreatment}</td>
								  	<td>${o.leftScore}</td>
								  	<td>${o.rightScore}</td>
								  	<td><a href="view_visit_info?id=${o.id}">View Details</a></td>
								  	<td><a href="edit_visit?id=${o.id}">Edit</a></td>
				              	</tr>
				            </c:forEach>
				    	</c:if>
				  	</table>
				</div>
			</fieldset>
		</div>
	</div>
</div>
</div>
	
</body>
</html>