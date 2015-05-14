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
	}
</style>
  <title>Clubfoot Registry | Add Patient</title>
  <style>
	  body {
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

	  em{
	  	color: red;
	  }

	  input[type=submit] {
  		width: 150px;
  		padding: 10px;
	}
  </style>
  <script>
  window.onload = function(){
	  $('fieldset.guardian_check').hide();
	  $('fieldset.emergencyContact').hide();
	  $('#deformityHistoryNum1').hide();
	  $('#deformityHistoryNum').hide();
	  $('#pregnancyComplicationsExplained1').hide();
	  $('#referralHospitalName1').hide();
	  $('#referralHospitalName').hide();
	  $('#referralDocName1').hide();
	  $('#referralDocName').hide();
	  $('#previousTreatmentsNum1').hide();
	  $('#previousTreatmentsNum').hide();
	  $('#diagnosisPrenatallyWeek1').hide();
	  $('#diagnosisPrenatallyWeek').hide();
	  $('#referralOther1').hide();
	  $('#referralOther').hide();
	  $('div.prev_treat').hide();
	  $('#pregnancyComplicationsExplained').hide();


  }
  function guardianHandlerTrue(){
	  $('fieldset.guardian_check').show();
	  $('secondGuardianPhone1').prop('required', true);
  }
  function guardianHandlerFalse(){
	  $('fieldset.guardian_check').hide();
	  $('secondGuardianPhone1').prop('required', false);
  }
  function guardianEmergencyTrue(){
	  $('fieldset.emergencyContact').show();
	  $('otherGuardianPhone1').prop('required', true);

  }
  function guardianEmergencyFalse(){
	  $('fieldset.emergencyContact').hide();
	  $('otherGuardianPhone1').prop('required', false);
  }
  function guardianDeformityTrue(){
	  $('#deformityHistoryNum1').show();
	  $('#deformityHistoryNum').show();
  }
  function guardianDeformityFalse(){
	  $('#deformityHistoryNum1').hide();
	  $('#deformityHistoryNum').hide();
  }
  function pregCompFalse(){
	  $('#pregnancyComplicationsExplained1').hide();
	  $('#pregnancyComplicationsExplained').hide();
  }
  function pregCompTrue(){
	  $('#pregnancyComplicationsExplained1').show();
	  $('#pregnancyComplicationsExplained').show();
  }
  function referralFnTrue(){
	  $('#referralHospitalName1').show();
	  $('#referralHospitalName').show();
	  $('#referralDocName1').show();
	  $('#referralDocName').show();
	  $('#referralOther1').hide();
	  $('#referralOther').hide();
	  $('#referralOther').prop('required',false);

  }
  function referralFnFalse(){
	  $('#referralHospitalName1').hide();
	  $('#referralHospitalName').hide();
	  $('#referralDocName1').hide();
	  $('#referralDocName').hide();
	  $('#referralOther1').hide();
	  $('#referralOther').hide();
	  $('#referralOther').prop('required',false);

  }
  function referralOtherTrue(){
	  $('#referralOther1').show();
	  $('#referralOther').show();
	  $('#referralHospitalName1').hide();
	  $('#referralHospitalName').hide();
	  $('#referralDocName1').hide();
	  $('#referralDocName').hide();
	  $('#referralOther').prop('required',true);

  }
  function prevTreatmentTrue(){
	  $('#previousTreatmentsNum1').show();
	  $('#previousTreatmentsNum').show();
	  $('div.prev_treat').show();

  }
  function prevTreatmentFalse(){
	  $('#previousTreatmentsNum1').hide();
	  $('#previousTreatmentsNum').hide();
	  $('div.prev_treat').hide();

  }
  function diagPrenatTrue(){
	  $('#diagnosisPrenatallyWeek1').show();
	  $('#diagnosisPrenatallyWeek').show();
  }
  function diagPrenatFalse(){
	  $('#diagnosisPrenatallyWeek1').hide();
	  $('#diagnosisPrenatallyWeek').hide();
  }
  </script>
  
	<jsp:include page="navbar.jsp" />
</head>
<body>
<div class="container">
	<div class="row clearfix">
	<div class="col-sm-2 column"></div>
	<div class="col-md-8 column">
	<h1>Add New Patient</h1>  
	<form action="#" th:action="@{/newpatient}" th:object="${newpatient}" modelAttribute="newPatient" method="post" id="newPatient" enctype="multipart/form-data">
		<div class="form-group">
			<p><i>Please complete the form. Mandatory fields are marked with a </i><em>*</em></p>
			<label for="guardianConsent"><em>*</em>Does the parent or guardian consent to being included: </label>
			<input type="radio" name="guardianConsent" value="1" path="guardianConsent" required>  Yes
			<input type="radio" name="guardianConsent" value="0" path="guardianConsent" required> No <br>

			<label for="photoConsent"><em>*</em>Does the parent or guardian consent to photographs of the patient being used for CURE evaluation and marketing purposes: </label>
			<input type="radio" name="photoConsent" value="1" path="photoConsent" required> Yes
			<input type="radio" name="photoConsent" value="0" path="photoConsent" required> No <br>
			
			<label for="hospital">Hospital</label>
			<form:select class="form-control" path="hospitalList" id="hospital" name="hospital">
            	<form:option value="" label="Select a Hospital" disabled="true" selected="true" style="display: none;"/>
                <form:options items="${hospitalList}" />
            </form:select>
			<br>
		</div>
			
		<div class="row">
		<fieldset>
		<legend>General Information</legend>
			<div class="col-md-12">
			<div class="form-group">
			<label for="patientLastName"><em>*</em>Last name/Surname: </label>
			<input type="name" name="patientLastName" class="form-control" path="patientLastName" required >

			<label for="patientFirstName"><em>  *</em>First name: </label>
			<input type="name" name="patientFirstName" class="form-control" path="patientFirstName" required >

			<label for="patientMiddleName">   Middle name: </label>
			<input type="name" name="patientMiddleName" class="form-control" path="patientMiddleName"> <br>

			<label for="sex"><em>*</em>Sex: </label>
			<input type="radio" name="sex" value="male" path="sex" required> Male
			<input type="radio" name="sex" value="female" path="sex" > Female <br>

			<label for="race">Race: </label>
			<input type="radio" name="race" value="asian" path="race"> Asian
			<input type="radio" name="race" value="white" path="race"> Caucasian (White) 
			<input type="radio" name="race" value="black" path="race"> African (Black)
			<input type="radio" name="race" value="indian" path="race"> Asian (Indian)
			<input type="radio" name="race" value="mixed" path="race"> Mixed
			<input type="radio" name="race" value="other" path="race"> Other
			<input type="radio" name="race" value="unspecified" path="race"> Unspecified <br>

			<label for="dob"><em>*</em>Date of birth: </label>
			<input type="date" name="dob" id="dob" class="form-control" path="dob" placeholder="dd/mm/yyyy"  validate pattern="\d{1,2}/\d{1,2}/\d{4}" title="dd/mm/yyyy" required> 
			<label for="tribe">Tribe: </label>
			<input type="text" name="tribe" class="form-control" path="tribe">
			</div>
			</div>
		</fieldset>
		</div>
		
		<div class="row">
		<fieldset>
		<legend>Address</legend>
			<div class="col-md-12">
			<div class="form-group">
			<label for="addr1">Address 1: </label>
			<input type="text" name="addr1" class="form-control" path="addr1"> <br>
			<label for="addr2">Address 2: </label>
			<input type="text" name="addr2" class="form-control" path="addr2"> <br>
			<label for="village">Village/Town/City: </label>
			<input type="text" name="village" class="form-control" path="village"> 
			<label for="province">State/Province: </label>
			<input type="text" name="province" class="form-control" path="province"> 
			<label for="country">Country: </label>
			<input type="text" name="country" class="form-control" path="country"> <br>
			</div>
			</div>
		</fieldset>
		</div>

		<div class="row">
		<h2>Parent/Guardian Information</h2>
		<fieldset>
		<legend>Primary Parent/Guardian</legend>
			<div class="col-md-12">
			<div class="form-group">
			<label for="guardianLastName">Last name/Surname: </label>
			<input type="name" name="guardianLastName" class="form-control" path="guardianLastName">

			<label for="guardianFirstName">  First name: </label>
			<input type="name" name="guardianFirstName" class="form-control" path="guardianFirstName">

			<label for="guardianMiddleName">   Middle name: </label>
			<input type="name" name="guardianMiddleName" class="form-control" path="guardianMiddleName"> <br>

			<label for="guardianRelationship">Relationship to patient: </label>
			<input type="radio" name="guardianRelationship" value="mother" path="guardianRelationship"> Mother
			<input type="radio" name="guardianRelationship" value="father" path="guardianRelationship"> Father
			<input type="radio" name="guardianRelationship" value="grandparent" path="guardianRelationship"> Grandparent
			<input type="radio" name="guardianRelationship" value="brother" path="guardianRelationship"> Brother
			<input type="radio" name="guardianRelationship" value="sister" path="guardianRelationship"> Sister
			<input type="radio" name="guardianRelationship" value="aunt" path="guardianRelationship"> Aunt
			<input type="radio" name="guardianRelationship" value="uncle" path="guardianRelationship"> Uncle 
			<input type="radio" name="guardianRelationship" value="friend" path="guardianRelationship"> Friend 
			<input type="radio" name="guardianRelationship" value="other" path="guardianRelationship"> Other
			<input type="radio" name="guardianRelationship" value="unspecified1" path="guardianRelationship"> Unspecified <br>

			<label for="guardianPhone1"><em>*</em>Phone number 1: </label>
			<input type="telephone" name="guardianPhone1" class="form-control"  path="guardianPhone1" placeholder="xxx-xxx-xxxx" pattern="(\+?\d[- .]*){7,13}" title="international, national or local phone number" required>
			<label for="guardianPhone2">Phone number 2: </label>
			<input type="telephone" name="guardianPhone2" class="form-control"  path="guardianPhone2" placeholder="xxx-xxx-xxxx" pattern="(\+?\d[- .]*){7,13}" title="international, national or local phone number"> <br>
			<label for="guardian_check">Secondary parent/guardian: </label>
			<input type="radio" name="guardian_check" id="guardian_check" value="Yes" path="guardian_check" onClick="guardianHandlerTrue()"> Yes
			<input type="radio" name="guardian_check" id="guardian_check" value="No" path="guardian_check" onClick="guardianHandlerFalse()"> No <br>
			</div>
			<div class="row">
			<fieldset class="guardian_check">
			<legend>Secondary Parent/Guardian</legend>
				<div class="form-group">
				<label for="secondGuardianLast">Last name/Surname: </label>
				<input type="name" name="secondGuardianLast" class="form-control" path="secondGuardianLast">
				<label for="secondGuardianFirst">First name: </label>
				<input type="name" name="secondGuardianFirst" class="form-control" path="secondGuardianFirst">
				<label for="secondGuardianMiddle">Middle name: </label>
				<input type="name" name="secondGuardianMiddle" class="form-control" path="secondGuardianMiddle"> <br>
				
				<label for="secondGuardianRelationship">Relationship to parent: </label>
				<input type="radio" name="secondGuardianRelationship" value="mother" path="secondGuardianRelationship"> Mother
				<input type="radio" name="secondGuardianRelationship" value="father" path="secondGuardianRelationship"> Father
				<input type="radio" name="secondGuardianRelationship" value="grandparent" path="secondGuardianRelationship"> Grandparent
				<input type="radio" name="secondGuardianRelationship" value="brother" path="secondGuardianRelationship"> Brother
				<input type="radio" name="secondGuardianRelationship" value="sister" path="secondGuardianRelationship"> Sister
				<input type="radio" name="secondGuardianRelationship" value="aunt" path="secondGuardianRelationship"> Aunt
				<input type="radio" name="secondGuardianRelationship" value="uncle" path="secondGuardianRelationship"> Uncle 
				<input type="radio" name="secondGuardianRelationship" value="friend" path="secondGuardianRelationship"> Friend 
				<input type="radio" name="secondGuardianRelationship" value="other" path="secondGuardianRelationship"> Other
				<input type="radio" name="secondGuardianRelationship" value="unspecified1" path="secondGuardianRelationship"> Unspecified <br>
			
				<label for="secondGuardianPhone1"><em>*</em>Phone number 1: </label>
				<input type="telephone" name="secondGuardianPhone1" class="form-control" path="secondGuardianPhone1" placeholder="xxx-xxx-xxxx" pattern="(\+?\d[- .]*){7,13}" title="international, national or local phone number">
				<label for="secondGuardianPhone2">Phone number 2: </label>
				<input type="telephone" name="secondGuardianPhone2" class="form-control" path="secondGuardianPhone2" placeholder="xxx-xxx-xxxx" pattern="(\+?\d[- .]*){7,13}" title="international, national or local phone number">
				</div>
			</fieldset>
			</div>
			
			<label for="emergencyContact">Emergency Contact: </label>
			<input type="radio" name="emergencyContact" value="Primary" path="emergencyContact" onClick="guardianEmergencyFalse()"> Primary
			<input type="radio" name="emergencyContact" value="Secondary" path="emergencyContact" onClick="guardianEmergencyFalse()"> Seconday
			<input type="radio" name="emergencyContact" value="Other" path="emergencyContact" onClick="guardianEmergencyTrue()"> Other
			<input type="radio" name="emergencyContact" value="Unspecified" path="emergencyContact" onClick="guardianEmergencyFalse()"> Unspecified
			
			<div class="row">
			<fieldset class="emergencyContact">
			<legend>Other Emergency Contact</legend>
				<div class="form-group">
				<label for="otherGuardianLast">Last name/Surname: </label>
				<input type="name" name="otherGuardianLast" class="form-control" path="otherGuardianLast">
				<label for="otherGuardianFirst">First name: </label>
				<input type="name" name="otherGuardianFirst" class="form-control" path="otherGuardianFirst">
				<label for="otherGuardianMiddle">Middle name: </label>
				<input type="name" name="otherGuardianMiddle" class="form-control" path="otherGuardianMiddle"> <br>
				
				<label for="otherGuardianRelationship">Relationship to parent: </label>
				<input type="radio" name="otherGuardianRelationship" value="mother" path="otherGuardianRelationship"> Mother
				<input type="radio" name="otherGuardianRelationship" value="father" path="otherGuardianRelationship"> Father
				<input type="radio" name="otherGuardianRelationship" value="grandparent" path="otherGuardianRelationship"> Grandparent
				<input type="radio" name="otherGuardianRelationship" value="brother" path="otherGuardianRelationship"> Brother
				<input type="radio" name="otherGuardianRelationship" value="sister" path="otherGuardianRelationship"> Sister
				<input type="radio" name="otherGuardianRelationship" value="aunt" path="otherGuardianRelationship"> Aunt
				<input type="radio" name="otherGuardianRelationship" value="uncle" path="otherGuardianRelationship"> Uncle 
				<input type="radio" name="otherGuardianRelationship" value="friend" path="otherGuardianRelationship"> Friend 
				<input type="radio" name="otherGuardianRelationship" value="other" path="otherGuardianRelationship" > Other
				<input type="radio" name="otherGuardianRelationship" value="unspecified1" path="otherGuardianRelationship"> Unspecified <br>
			
				<label for="otherGuardianPhone1"><em>*</em>Phone number 1: </label>
				<input type="telephone" name="otherGuardianPhone1" class="form-control" path="otherGuardianPhone1" placeholder="xxx-xxx-xxxx" pattern="(\+?\d[- .]*){7,13}" title="international, national or local phone number" >
				<label for="otherGuardianPhone2">Phone number 2: </label>
				<input type="telephone" name="otherGuardianPhone2" class="form-control" path="otherGuardianPhone2" placeholder="xxx-xxx-xxxx" pattern="(\+?\d[- .]*){7,13}" title="international, national or local phone number">
				</div>
			</fieldset>
			</div>
			</div>
		</fieldset> 
		</div>
		<div class="row">
		<fieldset>
		<legend>Family History</legend>
			<div class="col-md-12">
			<div class="form-group">
			<label for="deformityHistory">Any relatives with the clubfoot deformity: </label>
			<input type="radio" name="deformityHistory" value="Yes" path="deformityHistory" onClick="guardianDeformityTrue()"> Yes
			<input type="radio" name="deformityHistory" value="No" path="deformityHistory" onClick="guardianDeformityFalse()"> No
			<input type="radio" name="deformityHistory" value="Unspecified" path="deformityHistory" onClick="guardianDeformityFalse()"> Unspecified <br>
			
			<label for="deformityHistoryNum" id="deformityHistoryNum1">How many: </label>
			<input type="text" name="deformityHistoryNum" class="form-control" path="deformityHistoryNum" id="deformityHistoryNum"> <br>
			
			<label for="pregnancy">Length of pregnancy (in weeks): </label>
			<input type="text" name="pregnancy" class="form-control" path="pregnancy"> <br>
			<label for="pregnancy_complications">Did the mother have any complications during pregnancy: </label>
			<input type="radio" name="pregnancy_complications" value="Yes" path="pregnancy_complications" onClick="pregCompTrue()"> Yes
			<input type="radio" name="pregnancy_complications" value="No" path="pregnancy_complications" onClick="pregCompFalse()"> No
			<input type="radio" name="pregnancy_complications" value="Unspecified" path="pregnancy_complications" onClick="pregCompFalse()"> Unspecified <br>
			
			<label for="pregnancyComplicationsExplained" id="pregnancyComplicationsExplained1">What were the complications: </label>
			<input type="text" name="pregnancyComplicationsExplained" class="form-control" path="pregnancyComplicationsExplained" id="pregnancyComplicationsExplained"> <br>
			
			<label for="pregnancy_alc">Did the mother consume alcohol during pregnancy: </label>
			<input type="radio" name="pregnancyAlc" value="Yes" path="pregnancyAlc"> Yes
			<input type="radio" name="pregnancyAlc" value="No" path="pregnancyAlc"> No
			<input type="radio" name="pregnancyAlc" value="Unspecified" path="pregnancyAlc"> Unspecified <br>
			<label for="pregnancySmoke">Did the mother smoke during pregnancy: </label>
			<input type="radio" name="pregnancySmoke" value="Yes" path="pregnancySmoke"> Yes
			<input type="radio" name="pregnancySmoke" value="No" path="pregnancySmoke"> No
			<input type="radio" name="pregnancySmoke" value="Unspecified" path="pregnancySmoke"> Unspecified <br>
			<label for="complications">Any complications during birth: </label>
			<input type="radio" name="complications" value="Yes" path="complications"> Yes
			<input type="radio" name="complications" value="No" path="complications"> No
			<input type="radio" name="complications" value="Unspecified" path="complications"> Unspecified <br> 
			<label for="placeBirth">Place of birth: </label>
			<input type="radio" name="placeBirth" value="0" path="placeBirth"> Hospital
			<input type="radio" name="placeBirth" value="1" path="placeBirth"> Clinic
			<input type="radio" name="placeBirth" value="2" path="placeBirth"> Home
			<input type="radio" name="placeBirth" value="3" path="placeBirth"> Unspecified
			</div>
			</div>
		</fieldset>
		</div>
		<div class="row">
		<fieldset>
		<legend>Referral Information</legend>
			<div class="col-md-12">
			<div class="form-group">
			<label for="referral">Referral source:</label>
			<input type="radio" name="referral" value="Hospital/Clinic" path="referral" onClick="referralFnTrue()"> Hospital/Clinic
			<input type="radio" name="referral" value="Midwife" path="referral" onClick="referralFnFalse()"> Midwife
			<input type="radio" name="referral" value="Word Of Mouth" path="referral" onClick="referralFnFalse()"> Word of mouth
			<input type="radio" name="referral" value="Promotional Materials" path="referral" onClick="referralFnFalse()"> Promotional materials
			<input type="radio" name="referral" value="Other" path="referral" onClick="referralOtherTrue()"> Other
			<input type="radio" name="referral" value="Unspecified" path="referral" onClick="referralFnFalse()"> Unspecified <br>
		
			<label for="referralDocName1" id="referralDocName1">Doctor name: </label>
			<input type="text" name="referralDocName" path="referralDocName" id="referralDocName">
			<label for="referralHospitalName" id="referralHospitalName1">Hospital/clinic name: </label>
			<input type="text" name="referralHospitalName" path="referralHospitalName" id="referralHospitalName">
			<label for="referralOther" id="referralOther1"><em>*</em>Please specify: </label>
			<input type="text" name="referralOther" path="referralOther" id="referralOther" required>
			</div>
			</div>
		</fieldset>
		</div>
		
		<div class="row">
		<fieldset>
		<legend>Diagnosis</legend>
			<div class="col-mid-12">
			<div class="form-group"> 
			
			<label for="evaluator">Evaluator</label>
			<form:select class="form-control" path="evaluatorList" id="evaluator" name="evaluator">
            	<form:option value="" label="Select an Evaluator" disabled="true" selected="true" style="display: none;"/>
                <form:options items="${evaluatorList}" />
            </form:select>
			<!-- <a href="evaluator">Add evaluator</a>-->
			<br>
			
			<label for="evaluationDate"><em>*</em>Evaluation date (dd/mm/yyyy): </label>
			<input type="date" name="evaluationDate" class="form-control" path="evaluationDate" required> <br>
			
			<label for="feet"><em>*</em>Feet affected: </label>
			<input type="radio" name="feet" value="Left" path="feet" required> Left
			<input type="radio" name="feet" value="Right" path="feet" required> Right
			<input type="radio" name="feet" value="Both" path="feet" required> Both <br>
			
			<label for="diagnosis"><em>*</em>Diagnosis: </label>
			<input type="radio" name="diagnosis" value="Idiopathic Clubfoot" path="diagnosis" required> Idiopathic Clubfoot
			<input type="radio" name="diagnosis" value="Syndromic Clubfoot" path="diagnosis" required> Syndromic Clubfoot
			<input type="radio" name="diagnosis" value="Neuropathic Clubfoot" path="diagnosis" required> Neuropathic Clubfoot
			<input type="radio" name="diagnosis" value="Other" path="diagnosis" required> Other <br>
			
			<label for="deformityAtBirth">Deformity present at birth: </label>
			<input type="radio" name="deformityAtBirth" value="Yes" path="deformityAtBirth"> Yes
			<input type="radio" name="deformityAtBirth" value="No" path="deformityAtBirth"> No
			<input type="radio" name="deformityAtBirth" value="Unspecified" path="deformityAtBirth"> Unspecified <br>
			
			<label for="previousTreatments">Any previous treatments: </label>
			<input type="radio" name="previousTreatments" value="Yes" path="previousTreatments" onClick="prevTreatmentTrue()"> Yes
			<input type="radio" name="previousTreatments" value="No" path="previousTreatments" onClick="prevTreatmentFalse()"> No
			<input type="radio" name="previousTreatments" value="Unspecified" path="previousTreatments"> Unspecified <br>
			<div class = "prev_treat">
				<label for="previousTreatmentsNum1" id="previousTreatmentsNum1">Number of previous treatments: </label>
				<input type="text" name="previousTreatmentsNum" class="form-control" path="previousTreatmentsNum" id="previousTreatmentsNum"> <br>
				
				<label for ="previous_treatment_type" id="previous_treatment_type1">Type of previous treatments(s): </label>
				<input type="checkbox" name = "prev_treat_casting_above" value = "Casting above knee" id = "prev_treat_casting_above"> Casting above knee
				<input type="checkbox" name = "prev_treat_casting_below" value = "Casting below knee" id = "prev_treat_casting_below"> Casting below knee
				<input type="checkbox" name = "prev_treat_physiotherapy" value = "Physiotherapy" id = "prev_treat_physiotherapy"> Physiotherapy
				<input type="checkbox" name = "prev_treat_unspecified" value = "Unspecified" id = "prev_treat_unspecified"> Unspecified
				<input type="checkbox" name = "prev_treat_other" value = "Other" id = "prev_treat_other"> Other <br>
			</div>
			
			<label for="diagnosisPrenatally">Diagnosis prenatally: </label>
			<input type="radio" name="diagnosisPrenatally" value="Yes" path="diagnosisPrenatally" onClick="diagPrenatTrue()"> Yes
			<input type="radio" name="diagnosisPrenatally" value="No" path="diagnosisPrenatally" onClick="diagPrenatFalse()"> No
			<input type="radio" name="diagnosisPrenatally" value="Unspecified" path="diagnosisPrenatally" onClick="diagPrenatFalse()"> Unspecified <br>
			
			<label for="diagnosisPrenatallyWeek1" id="diagnosisPrenatallyWeek1">At prenatally week: </label>
			<input type="text" name="diagnosisPrenatallyWeek" class="form-control" path="diagnosisPrenatallyWeek" id="diagnosisPrenatallyWeek"> <br>
			<label for="prenatallyDiagConfirmation1" id="prenatallyDiagConfirmation1">If so, confirmed at birth: </label>
			<input type="radio" name="prenatallyDiagConfirmation" value="Yes" path="diagnosisPrenatally"> Yes
			<input type="radio" name="prenatallyDiagConfirmation" value="No" path="diagnosisPrenatally"> No
			<input type="radio" name="prenatallyDiagConfirmation" value="Unspecified" path="diagnosisPrenatally"> Unspecified <br><br>
			
			<label for="diagnosisComments">Diagnosis comments: </label>
			<input type="text" name="diagnosisComments" class="form-control" path="diagnosisComments"> <br>
			</div>
			</div>
		</fieldset>
		</div>
		
		<div class="row">
		<fieldset>
		<legend>Physical Examination</legend>
			<div class="col-md-12">
			<div class="form-group">
			<label for="abnormalities">Any abnormalities: </label>
			<input type="checkbox" name="abnormalities" value="Head" path="abnormalities"> Head
			<input type="checkbox" name="abnormalities" value="Heart_lungs" path="abnormalities"> Heart/Lungs
			<input type="checkbox" name="abnormalities" value="Urinary_digestive" path="abnormalities"> Urinary/Digestive
			<input type="checkbox" name="abnormalities" value="Skin" path="abnormalities"> Skin
			<input type="checkbox" name="abnormalities" value="Spine" path="abnormalities"> Spine
			<input type="checkbox" name="abnormalities" value="Hips" path="abnormalities"> Hips
			<input type="checkbox" name="abnormalities" value="Upper_extremities" path="abnormalities"> Upper extremities
			<input type="checkbox" name="abnormalities" value="Lower_extremities" path="abnormalities"> Lower extremities
			<input type="checkbox" name="abnormalities" value="Neurological" path="abnormalities"> Neurological <br>
			<label for="weakness">Any weakness: </label>
			<input type="checkbox" name="weakness" value="Arms" path="weakness"> Arms
			<input type="checkbox" name="weakness" value="Legs" path="weakness"> Legs
			<input type="checkbox" name="weakness" value="Other" path="weakness"> Other parts of body
			</div>
			</div>
		</fieldset>
		</div>
		<div class="row">
		<fieldset>
		<legend>Feet pre-treatments photo(s)</legend>
			<div class="col-md-12">
			<div class="form-group">
			<label for="fileName">Upload photo of patient here: </label>
			<input type="file" class="btn btn-lg btn-default" id="file" name="file" path="file"><br>
			<button type="submit" class="btn btn-lg btn-default" for="add_photo" id="add_photo" value="Upload">Add another photo</button>
			</div>
			</div>
		</fieldset>
			<div class="row" align="center">
				<button type="submit" class="btn btn-lg btn-primary" value="Upload">Save</button>
			</div>
		</div>
	</div>
</div>
</div>
	</form>
</body>
</html>