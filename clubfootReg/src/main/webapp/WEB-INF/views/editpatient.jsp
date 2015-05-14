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
  <title>Clubfoot Registry | Edit Patient</title>
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
	  $('#pregnancyComplicationsExplained').hide();
	  $('#referralHospitalName1').hide();
	  $('#referralHospitalName').hide();
	  $('#referralDocName1').hide();
	  $('#referralDocName').hide();
	  $('#previousTreatmentsNum1').hide();
	  $('#previousTreatmentsNum').hide();
	  $('#referralOther1').hide();
	  $('#referralOther').hide();
	  $('div.prev_treat').hide();
	  $('div.diagPrenatally').hide()

	  
	  $("#hospital").val("${patient.hospital}");
	  $("#evaluator").val("${patient.evaluator}");
	  
	  if ("${patient.guardianConsent}" == 1)
	  	document.getElementById("gcYes").checked = true;
	  else
		document.getElementById("gcNo").checked = true;
	  
	  if ("${patient.photoConsent}" == 1)
		document.getElementById("pcYes").checked = true;
	  else
		document.getElementById("pcNo").checked = true;
	  
	  if ("${patient.sex}" == "Male")
		document.getElementById("sexM").checked = true;
	  else
		document.getElementById("sexF").checked = true;
	  
	  switch ("${patient.race}") {
	    case "Asian":
	    	document.getElementById("raceAsian").checked = true;
	    	break;
	    case "White":
	    	document.getElementById("raceWhite").checked = true;
	    	break;
		case "Black":
			document.getElementById("raceBlack").checked = true;
	    	break;
		case "Indian":
			document.getElementById("raceIndian").checked = true;
			break;
		case "Mixed":
			document.getElementById("raceMixed").checked = true;
			break;
		case "Other":
			document.getElementById("raceOther").checked = true;
			break;
		default:
			document.getElementById("raceUn").checked = true;
			break;
	  }
	  
	  /*
	  trying to figure out how to display a date from database
	  
	  var year = "${patient.dob}".substring(0, 4);
	  var month = "${patient.dob}".substring(5, 7);
	  var day = "${patient.dob}".substring(8, 10);
	  var date = month + '/' + day + '/' + year;
	  $("#dob").val(date);*/
	  
	  switch ("${patient.guardianRelationship}") {
	    case "mother":
	    	document.getElementById("relMom").checked = true;
	    	break;
	    case "father":
	    	document.getElementById("relDad").checked = true;
	    	break;
		case "grandparent":
			document.getElementById("relGparent").checked = true;
	    	break;
		case "brother":
			document.getElementById("relBro").checked = true;
			break;
		case "sister":
			document.getElementById("relSis").checked = true;
			break;
		case "aunt":
			document.getElementById("relAunt").checked = true;
			break;
		case "uncle":
			document.getElementById("relUncle").checked = true;
			break;
		case "friend":
			document.getElementById("relFriend").checked = true;
			break;
		case "other":
			document.getElementById("relOther").checked = true;
			break;
		default:
			document.getElementById("relUn").checked = true;
			break;
	  }
	  
	  if ("${patient.secondGuardianFirst}") {
	    document.getElementById("secondGuardianYes").checked = true;
		$('fieldset.guardian_check').show();
		$('secondGuardianPhone1').prop('required', true);
		switch ("${patient.secondGuardianRelationship}") {
	    case "mother":
	    	document.getElementById("relMom2").checked = true;
	    	break;
	    case "father":
	    	document.getElementById("relDad2").checked = true;
	    	break;
		case "grandparent":
			document.getElementById("relGparent2").checked = true;
	    	break;
		case "brother":
			document.getElementById("relBro2").checked = true;
			break;
		case "sister":
			document.getElementById("relSis2").checked = true;
			break;
		case "aunt":
			document.getElementById("relAunt2").checked = true;
			break;
		case "uncle":
			document.getElementById("relUncle2").checked = true;
			break;
		case "friend":
			document.getElementById("relFriend2").checked = true;
			break;
		case "other":
			document.getElementById("relOther2").checked = true;
			break;
		default:
			document.getElementById("relUn2").checked = true;
			break;
	  }
	  }
      else {
		document.getElementById("secondGuardianNo").checked = true;
      }
      
	  switch ("${patient.emergencyContact}") {
	  	case "primary":
	  		document.getElementById("emergencyPrimary").checked = true;
	  		break;
	  	case "secondary":
	  		document.getElementById("emergencySecondary").checked = true;
	  		$('fieldset.guardian_check').show();
	  		$('secondGuardianPhone1').prop('required', true);
	  		break;
	  	case "other":
	  		document.getElementById("emergencyOther").checked = true;
	  		$('fieldset.emergencyContact').show();
	  		$('otherGuardianPhone1').prop('required', true);
	  		switch ("${patient.otherGuardianRelationship}") {
		    case "mother":
		    	document.getElementById("relMom3").checked = true;
		    	break;
		    case "father":
		    	document.getElementById("relDad3").checked = true;
		    	break;
			case "grandparent":
				document.getElementById("relGparent3").checked = true;
		    	break;
			case "brother":
				document.getElementById("relBro3").checked = true;
				break;
			case "sister":
				document.getElementById("relSis3").checked = true;
				break;
			case "aunt":
				document.getElementById("relAunt3").checked = true;
				break;
			case "uncle":
				document.getElementById("relUncle3").checked = true;
				break;
			case "friend":
				document.getElementById("relFriend3").checked = true;
				break;
			case "other":
				document.getElementById("relOther3").checked = true;
				break;
			default:
				document.getElementById("relUn3").checked = true;
				break;
		  }
	  		break;
	  	default:
	  		document.getElementById("emergencyUnspecified").checked = true;
	  		break;
      }
	  if ("${patient.deformityHistoryNum}" > 0) {
	    document.getElementById("defYes").checked = true;
	    $('#deformityHistoryNum1').show();
	    $('#deformityHistoryNum').show();
	  }
	  else if ("${patient.deformityHistoryNum}" == 0) {
	    document.getElementById("defNo").checked = true;
	  }
	  else {
	    document.getElementById("defUn").checked = true;
	  }

	  if ("${patient.pregnancyComplicationsExplained}"){
		document.getElementById("pregCompYes").checked = true;
		$('#pregnancyComplicationsExplained1S').show();
	    $('#pregnancyComplicationsExplained').show();
	  }
  	  else {
    	document.getElementById("pregCompNo").checked = true;
  	  }
	  
	  if ("${patient.pregnancyAlc}" == "Yes")
		document.getElementById("pregAlcYes").checked = true;
	  else if ("${patient.pregnancyAlc}" == "No")
	   	document.getElementById("pregAlcNo").checked = true;
	  else
		document.getElementById("pregAlcUn").checked = true;
	  if ("${patient.pregnancySmoke}" == "Yes")
		document.getElementById("pregSmokeYes").checked = true;
	  else if ("${patient.pregnancySmoke}" == "No")
	   	document.getElementById("pregSmokeNo").checked = true;
	  else
		document.getElementById("pregSmokeUn").checked = true;
		
	  if ("${patient.complications}" == "Yes")
		document.getElementById("compYes").checked = true;
	  else if ("${patient.complications}" == "No")
	   	document.getElementById("compNo").checked = true;
	  else
		document.getElementById("compUn").checked = true;
		
	  if ("${patient.placeBirth}" == "0")
		document.getElementById("placeBirthHosp").checked = true;
	  else if ("${patient.placeBirth}" == "1")
	   	document.getElementById("placeBirthClinic").checked = true;
	  else if ("${patient.placeBirth}" == "2")
		document.getElementById("placeBirthHome").checked = true;
	  else
		document.getElementById("placeBirthUn").checked = true;
	  
	  switch ("${patient.referral}") {
	  	case "Hospital/Clinic":
	  		document.getElementById("refHosp").checked = true;
	  		$('#referralHospitalName1').show();
	  		$('#referralHospitalName').show();
	 		$('#referralDocName1').show();
	 	 	$('#referralDocName').show();
			break;
	  	case "Midwife":
	  		document.getElementById("refMidwife").checked = true;
			break;
	  	case "Word of Mouth":
	  		document.getElementById("refWord").checked = true;
			break;
	  	case "Promotional Materials":
	  		document.getElementById("refPromo").checked = true;
			break;
	  	case "Other":
	  		document.getElementById("refOther").checked = true;
	  		$('#referralOther1').hide();
	  		$('#referralOther').hide();
	  		$('#referralOther').prop('required',true);
			break;
		default:
			document.getElementById("refUn").checked = true;
			break;
	  }
	  
	  if ("${patient.feet}" == "Left")
	    document.getElementById("feetLeft").checked = true;
	  else if ("${patient.feet}" == "Right")
		document.getElementById("feetRight").checked = true;
	  else if ("${patient.feet}" == "Both")
		document.getElementById("feetBoth").checked = true;
	  
	  if ("${patient.diagnosis}" == "Idiopathic Clubfoot")
	    document.getElementById("diagIdio").checked = true;
	  else if ("${patient.diagnosis}" == "Syndromic Clubfoot")
		document.getElementById("diagSynd").checked = true;
	  else if ("${patient.diagnosis}" == "Neuropathic Clubfoot")
		document.getElementById("diagNeuro").checked = true;
	  else if ("${patient.diagnosis}" == "Other")
	    document.getElementById("diagOther").checked = true;
	  
	  if ("${patient.deformityAtBirth}" == "Yes")
	    document.getElementById("deformityYes").checked = true;
	  else if ("${patient.deformityAtBirth}" == "No")
		document.getElementById("deformityNo").checked = true;
	  else
		document.getElementById("deformityUn").checked = true;
	  
	  if ("${patient.previousTreatmentsNum}" > 0){
	    document.getElementById("prevYes").checked = true;
		$('div.prev_treat').hide();
	  }
	  else if ("${patient.previousTreatmentsNum}" == 0){
		document.getElementById("prevNo").checked = true;
	  }
	  else{
		document.getElementById("prevUn").checked = true;
	  }
	  
	  if ("${patient.diagnosisPrenatallyWeek}"){
	    document.getElementById("diagYes").checked = true;

	     $('div.diagPrenatally').show();
	  }
	  else {
		document.getElementById("diagNo").checked = true;
	  }
	  
	  if ("${patient.prenatallyDiagConfirmation}" == "Yes")
	    document.getElementById("prenatallyDiagYes").checked = true;
	  else if ("${patient.prenatallyDiagConfirmation}" == "No")
		document.getElementById("prenatallyDiagNo").checked = true;
	  else
		document.getElementById("prenatallyDiagUn").checked = true;
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
	  $('#referralOther').prop('required',true);
	  $('#referralHospitalName1').hide();
	  $('#referralHospitalName').hide();
	  $('#referralDocName1').hide();
	  $('#referralDocName').hide();
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

	     $('div.diagPrenatally').show();

  }
  function diagPrenatFalse(){

	     $('div.diagPrenatally').hide();

  }
  </script>
  
  	<jsp:include page="navbar.jsp" />

</head>
<body>
<div class="container">
	<div class="row clearfix">
	<div class="col-sm-2 column"></div>
	<div class="col-md-8 column">
	<h1>Edit Patient</h1>  
	<form action="#" th:action="@{/edit_patient}" th:object="${patient}" modelAttribute="editPatient" method="post" id="updatePatient">
		<div class="form-group">
			<p><i>Please complete the form. Mandatory fields are marked with a </i><em>*</em></p>
			<label for="guardianConsent"><em>*</em>Does the parent or guardian consent to being included: </label>
			<input id="gcYes" type="radio" name="guardianConsent" value="1" path="guardianConsent" > Yes
			<input id="gcNo" type="radio" name="guardianConsent" value="0" path="guardianConsent" > No <br>

			<label for="photoConsent"><em>*</em>Does the parent or guardian consent to photographs of the patient being used for CURE evaluation and marketing purposes: </label>
			<input id="pcYes" type="radio" name="photoConsent" value="1" path="photoConsent" > Yes
			<input id="pcNo" type="radio" name="photoConsent" value="0" path="photoConsent" > No <br>
			
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
			<input type="name" name="patientLastName" class="form-control" path="patientLastName" value="${patient.patientLastName}" >

			<label for="patientFirstName"><em>  *</em>First name: </label>
			<input type="name" name="patientFirstName" class="form-control" path="patientFirstName" value = "${patient.patientFirstName}" >

			<label for="patientMiddleName">   Middle name: </label>
			<input type="name" name="patientMiddleName" class="form-control" path="patientMiddleName" value = "${patient.patientMiddleName}"> <br>

			<label for="sex"><em>*</em>Sex: </label>
			<input id="sexM" type="radio" name="sex" value="male" path="sex" > Male
			<input id="sexF" type="radio" name="sex" value="female" path="sex" > Female <br>

			<label for="race">Race: </label>
			<input id="raceAsian" type="radio" name="race" value="asian" path="race"> Asian
			<input id="raceWhite" type="radio" name="race" value="white" path="race"> Caucasian (White) 
			<input id="raceBlack" type="radio" name="race" value="black" path="race"> African (Black)
			<input id="raceIndian" type="radio" name="race" value="indian" path="race"> Asian (Indian)
			<input id="raceMixed" type="radio" name="race" value="mixed" path="race"> Mixed
			<input id="raceOther" type="radio" name="race" value="other" path="race"> Other
			<input id="raceUn" type="radio" name="race" value="unspecified" path="race"> Unspecified <br>

			<label for="dob"><em>*</em>Date of birth: </label>
			<input type="date" name="dob" id="dob" class="form-control" path="dob" value= "${patient.dob}" > 
			<label for="tribe">Tribe: </label>
			<input type="text" name="tribe" class="form-control" path="tribe" value = "${patient.tribe}">
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
			<input type="text" name="addr1" class="form-control" path="addr1" value = "${patient.addr1}"> <br>
			<label for="addr2">Address 2: </label>
			<input type="text" name="addr2" class="form-control" path="addr2" value = "${patient.addr2}"> <br>
			<label for="village">Village/Town/City: </label>
			<input type="text" name="village" class="form-control" path="village" value = "${patient.village}"> 
			<label for="province">State/Province: </label>
			<input type="text" name="province" class="form-control" path="province" value = "${patient.province}"> 
			<label for="country">Country: </label>
			<input type="text" name="country" class="form-control" path="country" value = "${patient.country}"> <br>
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
			<input type="name" name="guardianLastName" class="form-control" path="guardianLastName" value = "${patient.guardianLastName}">

			<label for="guardianFirstName">  First name: </label>
			<input type="name" name="guardianFirstName" class="form-control" path="guardianFirstName" value = "${patient.guardianFirstName}">

			<label for="guardianMiddleName">   Middle name: </label>
			<input type="name" name="guardianMiddleName" class="form-control" path="guardianMiddleName" value = "${patient.guardianMiddleName}"> <br>

			<label for="guardianRelationship">Relationship to patient: </label>
			<input id="relMom" type="radio" name="guardianRelationship" value="mother" path="guardianRelationship"> Mother
			<input id="relDad" type="radio" name="guardianRelationship" value="father" path="guardianRelationship"> Father
			<input id="relGparent" type="radio" name="guardianRelationship" value="grandparent" path="guardianRelationship"> Grandparent
			<input id="relBro" type="radio" name="guardianRelationship" value="brother" path="guardianRelationship"> Brother
			<input id="relSis" type="radio" name="guardianRelationship" value="sister" path="guardianRelationship"> Sister
			<input id="relAunt" type="radio" name="guardianRelationship" value="aunt" path="guardianRelationship"> Aunt
			<input id="relUncle" type="radio" name="guardianRelationship" value="uncle" path="guardianRelationship"> Uncle 
			<input id="relFriend" type="radio" name="guardianRelationship" value="friend" path="guardianRelationship"> Friend 
			<input id="relOther" type="radio" name="guardianRelationship" value="other" path="guardianRelationship"> Other
			<input id="relUn" type="radio" name="guardianRelationship" value="unspecified" path="guardianRelationship"> Unspecified <br>

			<label for="guardianPhone1"><em>*</em>Phone number 1: </label>
			<input type="telephone" name="guardianPhone1" class="form-control"  path="guardianPhone1" placeholder="xxx-xxx-xxxx" value = "${patient.guardianPhone1}" pattern="(\+?\d[- .]*){7,13}" title="international, national or local phone number" >
			<label for="guardianPhone2">Phone number 2: </label>
			<input type="telephone" name="guardianPhone2" class="form-control"  path="guardianPhone2" value = "${patient.guardianPhone2}"placeholder="xxx-xxx-xxxx" pattern="(\+?\d[- .]*){7,13}" title="international, national or local phone number"> <br>
			
			<label for="guardian_check">Secondary parent/guardian: </label>
			<input id="secondGuardianYes" type="radio" name="guardian_check" value="Yes" path="guardian_check" onClick="guardianHandlerTrue()"> Yes
			<input id="secondGuardianNo" type="radio" name="guardian_check" value="No" path="guardian_check" onClick="guardianHandlerFalse()"> No <br>
			</div>
			<div class="row">
			<fieldset class="guardian_check">
			<legend>Secondary Parent/Guardian</legend>
				<div class="form-group">
				<label for="secondGuardianlast">Last name/Surname: </label>
				<input type="name" name="secondGuardianlast" class="form-control" path="secondGuardianlast" value = "${patient.secondGuardianLast}">
				<label for="secondGuardianFirst">First name: </label>
				<input type="name" name="secondGuardianFirst" class="form-control" path="secondGuardianFirst" value = "${patient.secondGuardianFirst}">
				<label for="secondGuardianMiddle">Middle name: </label>
				<input type="name" name="secondGuardianMiddle" class="form-control" path="secondGuardianMiddle" value = "${patient.secondGuardianMiddle}"> <br>
				
				<label for="secondGuardianRelationship">Relationship to patient: </label>
				<input id="relMom2" type="radio" name="secondGuardianRelationship" value="mother" path="secondGuardianRelationship"> Mother
				<input id="relDad2" type="radio" name="secondGuardianRelationship" value="father" path="secondGuardianRelationship"> Father
				<input id="relGparent2" type="radio" name="secondGuardianRelationship" value="grandparent" path="secondGuardianRelationship"> Grandparent
				<input id="relBro2" type="radio" name="secondGuardianRelationship" value="brother" path="secondGuardianRelationship"> Brother
				<input id="relSis2" type="radio" name="secondGuardianRelationship" value="sister" path="secondGuardianRelationship"> Sister
				<input id="relAunt2" type="radio" name="secondGuardianRelationship" value="aunt" path="secondGuardianRelationship"> Aunt
				<input id="relUncle2" type="radio" name="secondGuardianRelationship" value="uncle" path="secondGuardianRelationship"> Uncle 
				<input id="relFriend2" type="radio" name="secondGuardianRelationship" value="friend" path="secondGuardianRelationship"> Friend 
				<input id="relOther2" type="radio" name="secondGuardianRelationship" value="other" path="secondGuardianRelationship"> Other
				<input id="relUn2" type="radio" name="secondGuardianRelationship" value="unspecified1" path="secondGuardianRelationship"> Unspecified <br>
			
				<label for="secondGuardianPhone1"><em>*</em>Phone number 1: </label>
				<input type="telephone" name="secondGuardianPhone1" class="form-control" path="secondGuardianPhone1" value = "${patient.secondGuardianPhone1}" placeholder="xxx-xxx-xxxx" pattern="(\+?\d[- .]*){7,13}" title="international, national or local phone number" >
				<label for="secondGuardianPhone2">Phone number 2: </label>
				<input type="telephone" name="secondGuardianPhone2" class="form-control" path="secondGuardianPhone2"  value = "${patient.secondGuardianPhone2}" placeholder="xxx-xxx-xxxx" pattern="(\+?\d[- .]*){7,13}" title="international, national or local phone number">
				</div>
			</fieldset>
			</div>
			
			<label for="emergencyContact">Emergency Contact: </label>
			<input id="emergencyPrimary" type="radio" name="emergencyContact" value="Primary" path="emergencyContact" onClick="guardianEmergencyFalse()"> Primary
			<input id="emergencySecondary" type="radio" name="emergencyContact" value="Secondary" path="emergencyContact" onClick="guardianEmergencyFalse()"> Seconday
			<input id="emergencyOther" type="radio" name="emergencyContact" value="Other" path="emergencyContact" onClick="guardianEmergencyTrue()"> Other
			<input id="emergencyUnspecified" type="radio" name="emergencyContact" value="Unspecified" path="emergencyContact" onClick="guardianEmergencyFalse()"> Unspecified
			
			<div class="row">
			<fieldset class="emergencyContact">
			<legend>Other Emergency Contact</legend>
				<div class="form-group">
				<label for="otherGuardianLast">Last name/Surname: </label>
				<input type="name" name="otherGuardianLast" class="form-control" path="otherGuardianLast" value = "${patient.otherGuardianLast}">
				<label for="otherGuardianFirst">First name: </label>
				<input type="name" name="otherGuardianFirst" class="form-control" path="otherGuardianFirst" value = "${patient.otherGuardianFirst}">
				<label for="otherGuardianMiddle">Middle name: </label>
				<input type="name" name="otherGuardianMiddle" class="form-control" path="otherGuardianMiddle" value = "${patient.otherGuardianMiddle}"> <br>
				
				<label for="otherGuardianRelationship">Relationship to parent: </label>
				<input id="relMom3" type="radio" name="otherGuardianRelationship" value="mother" path="otherGuardianRelationship"> Mother
				<input id="relDad3" type="radio" name="otherGuardianRelationship" value="father" path="otherGuardianRelationship"> Father
				<input id="relGparent3" type="radio" name="otherGuardianRelationship" value="grandparent" path="otherGuardianRelationship"> Grandparent
				<input id="relBro3" type="radio" name="otherGuardianRelationship" value="brother" path="otherGuardianRelationship"> Brother
				<input id="relSis3" type="radio" name="otherGuardianRelationship" value="sister" path="otherGuardianRelationship"> Sister
				<input id="relAunt3" type="radio" name="otherGuardianRelationship" value="aunt" path="otherGuardianRelationship"> Aunt
				<input id="relUncle3" type="radio" name="otherGuardianRelationship" value="uncle" path="otherGuardianRelationship"> Uncle 
				<input id="relFriend3" type="radio" name="otherGuardianRelationship" value="friend" path="otherGuardianRelationship"> Friend 
				<input id="relOther3" type="radio" name="otherGuardianRelationship" value="other" path="otherGuardianRelationship" > Other
				<input id="relUn3" type="radio" name="otherGuardianRelationship" value="unspecified1" path="otherGuardianRelationship"> Unspecified <br>
			
				<label for="otherGuardianPhone1"><em>*</em>Phone number 1: </label>
				<input type="telephone" name="otherGuardianPhone1" class="form-control" path="otherGuardianPhone1" value = "${patient.otherGuardianPhone1}" placeholder="xxx-xxx-xxxx" pattern="(\+?\d[- .]*){7,13}" title="international, national or local phone number" >
				<label for="otherGuardianPhone2">Phone number 2: </label>
				<input type="telephone" name="otherGuardianPhone2" class="form-control" path="otherGuardianPhone2" value = "${patient.otherGuardianPhone2}" placeholder="xxx-xxx-xxxx" pattern="(\+?\d[- .]*){7,13}" title="international, national or local phone number">
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
			<input id="defYes" type="radio" name="deformityHistory" value="Yes" path="deformityHistory" onClick="guardianDeformityTrue()"> Yes
			<input id="defNo" type="radio" name="deformityHistory" value="No" path="deformityHistory" onClick="guardianDeformityFalse()"> No
			<input id="defUn" type="radio" name="deformityHistory" value="Unspecified" path="deformityHistory" onClick="guardianDeformityFalse()"> Unspecified <br>
			
			<label for="deformityHistoryNum" id="deformityHistoryNum1">How many: </label>
			<input type="text" name="deformityHistoryNum" class="form-control" path="deformityHistoryNum" id="deformityHistoryNum" value = "${patient.deformityHistoryNum}"> <br>
			
			<label for="pregnancy">Length of pregnancy (in weeks): </label>
			<input type="text" name="pregnancy" class="form-control" path="pregnancy" value = "${patient.pregnancy}"> <br>
			
			<label for="pregnancy_complications">Did the mother have any complications during pregnancy: </label>
			<input id="pregCompYes" type="radio" name="pregnancy_complications" value="Yes" path="pregnancy_complications" onClick="pregCompTrue()"> Yes
			<input id="pregCompNo" type="radio" name="pregnancy_complications" value="No" path="pregnancy_complications" onClick="pregCompFalse()"> No
			<input id="pregCompUn" type="radio" name="pregnancy_complications" value="Unspecified" path="pregnancy_complications" onClick="pregCompFalse()"> Unspecified <br>
			
			<label for="pregnancyComplicationsExplained" id="pregnancyComplicationsExplained1">What were the complications: </label>
			<input type="text" name="pregnancyComplicationsExplained" class="form-control" path="pregnancyComplicationsExplained" id="pregnancyComplicationsExplained" value = "${patient.pregnancyComplicationsExplained}"> <br>
			
			<label for="pregnancyAlc">Did the mother consume alcohol during pregnancy: </label>
			<input id="pregAlcYes" type="radio" name="pregnancyAlc" value="Yes" path="pregnancyAlc"> Yes
			<input id="pregAlcNo" type="radio" name="pregnancyAlc" value="No" path="pregnancyAlc"> No
			<input id="pregAlcUn" type="radio" name="pregnancyAlc" value="Unspecified" path="pregnancyAlc"> Unspecified <br>
			
			<label for="pregnancySmoke">Did the mother smoke during pregnancy: </label>
			<input id="pregSmokeYes" type="radio" name="pregnancySmoke" value="Yes" path="pregnancySmoke"> Yes
			<input id="pregSmokeNo" type="radio" name="pregnancySmoke" value="No" path="pregnancySmoke"> No
			<input id="pregSmokeUn" type="radio" name="pregnancySmoke" value="Unspecified" path="pregnancySmoke"> Unspecified <br>
			
			<label for="complications">Any complications during birth: </label>
			<input id="compYes" type="radio" name="complications" value="Yes" path="complications"> Yes
			<input id="compNo" type="radio" name="complications" value="No" path="complications"> No
			<input id="compUn" type="radio" name="complications" value="Unspecified" path="complications"> Unspecified <br> 
			
			<label for="placeBirth">Place of birth: </label>
			<input id="placeBirthHosp" type="radio" name="placeBirth" value="0" path="placeBirth"> Hospital
			<input id="placeBirthClinic" type="radio" name="placeBirth" value="1" path="placeBirth"> Clinic
			<input id="placeBirthHome" type="radio" name="placeBirth" value="2" path="placeBirth"> Home
			<input id="placeBirthUn" type="radio" name="placeBirth" value="3" path="placeBirth"> Unspecified
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
			<input id="refHosp" type="radio" name="referral" value="Hospital/Clinic" path="referral" onClick="referralFnTrue()"> Hospital/Clinic
			<input id="refMidwife" type="radio" name="referral" value="Midwife" path="referral" onClick="referralFnFalse()"> Midwife
			<input id="refWord" type="radio" name="referral" value="Word of Mouth" path="referral" onClick="referralFnFalse()"> Word of mouth
			<input id="refPromo" type="radio" name="referral" value="Promotional Materials" path="referral" onClick="referralFnFalse()"> Promotional materials
			<input id="refOther" type="radio" name="referral" value="Other" path="referral" onClick="referralOtherTrue()"> Other
			<input id="refUn" type="radio" name="referral" value="Unspecified" path="referral" onClick="referralFnFalse()"> Unspecified <br>
		
			<label for="referralDocName1" id="referralDocName1">Doctor name: </label>
			<input type="text" name="referralDocName" path="referralDocName" id="referralDocName" value = "${patient.referralDocName}">
			<label for="referralHospitalName" id="referralHospitalName1">Hospital/clinic name: </label>
			<input type="text" name="referralHospitalName" path="referralHospitalName" id="referralHospitalName" value = "${patient.referralHospitalName}">
			<label for="referralOther" id="referralOther1"><em>*</em>Please specify: </label>
			<input type="text" name="referralOther" path="referralOther" id="referralOther" value = "${patient.referralOther}" >

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
			
			<label for="evaluationDate"><em>*</em>Evaluation date (dd/mm/yyyy): </label>
			<input type="date" name="evaluationDate" class="form-control" path="evaluationDate" value = "${patient.evaluationDate}" > <br>
			
			<label for="feet"><em>*</em>Feet affected: </label>
			<input id="feetLeft" type="radio" name="feet" value="Left" path="feet" > Left
			<input id="feetRight" type="radio" name="feet" value="Right" path="feet" > Right
			<input id="feetBoth" type="radio" name="feet" value="Both" path="feet" > Both <br>
			
			<label for="diagnosis"><em>*</em>Diagnosis: </label>
			<input id="diagIdio" type="radio" name="diagnosis" value="Idiopathic Clubfoot" path="diagnosis"  > Idiopathic Clubfoot
			<input id="diagSynd" type="radio" name="diagnosis" value="Syndromic Clubfoot" path="diagnosis"  > Syndromic Clubfoot
			<input id="diagNeuro" type="radio" name="diagnosis" value="Neuropathic Clubfoot" path="diagnosis" > Neuropathic Clubfoot
			<input id="diagOther" type="radio" name="diagnosis" value="Other" path="diagnosis" > Other <br>
			
			<label for="deformityAtBirth">Deformity present at birth: </label>
			<input id="deformityYes" type="radio" name="deformityAtBirth" value="Yes" path="deformityAtBirth"> Yes
			<input id="deformityNo" type="radio" name="deformityAtBirth" value="No" path="deformityAtBirth"> No
			<input id="deformityUn" type="radio" name="deformityAtBirth" value="Unspecified" path="deformityAtBirth"> Unspecified <br>
			
			<label for="previousTreatments">Any previous treatments: </label>
			<input id="prevYes" type="radio" name="previousTreatments" value="Yes" path="previousTreatments" onClick="prevTreatmentTrue()"> Yes
			<input id="prevNo" type="radio" name="previousTreatments" value="No" path="previousTreatments" onClick="prevTreatmentFalse()"> No
			<input id="prevUn" type="radio" name="previousTreatments" value="Unspecified" path="previousTreatments"> Unspecified <br>
			<div class = "prev_treat">
				<label for="previousTreatmentsNum1" id="previousTreatmentsNum1">Number of previous treatments: </label>
				<input type="text" name="previousTreatmentsNum" class="form-control" path="previousTreatmentsNum" id="previousTreatmentsNum" value = "${patient.previousTreatmentsNum}"> <br>
				
				<label for ="previous_treatment_type" id="previous_treatment_type1">Type of previous treatments(s): </label>
				<input type="checkbox" name = "prev_treat_casting_above" value = "Casting above knee" id = "prev_treat_casting_above"> Casting above knee
				<input type="checkbox" name = "prev_treat_casting_below" value = "Casting below knee" id = "prev_treat_casting_below"> Casting below knee
				<input type="checkbox" name = "prev_treat_physiotherapy" value = "Physiotherapy" id = "prev_treat_physiotherapy"> Physiotherapy
				<input type="checkbox" name = "prev_treat_unspecified" value = "Unspecified" id = "prev_treat_unspecified"> Unspecified
				<input type="checkbox" name = "prev_treat_other" value = "Other" id = "prev_treat_other"> Other <br>
			</div>
			<label for="diagnosisPrenatally">Diagnosis prenatally: </label>
			<input id="diagYes" type="radio" name="diagnosisPrenatally" value="Yes" path="diagnosisPrenatally" onClick="diagPrenatTrue()"> Yes
			<input id="diagNo" type="radio" name="diagnosisPrenatally" value="No" path="diagnosisPrenatally" onClick="diagPrenatFalse()"> No
			<input id="diagUn" type="radio" name="diagnosisPrenatally" value="Unspecified" path="diagnosisPrenatally" onClick="diagPrenatFalse()"> Unspecified <br>
			
			<div class = "diagPrenatally">
				<label for="diagnosisPrenatallyWeek1" id="diagnosisPrenatallyWeek1">At prenatally week: </label>
				<input type="text" name="diagnosisPrenatallyWeek" class="form-control" path="diagnosisPrenatallyWeek" id="diagnosisPrenatallyWeek" value = "${patient.diagnosisPrenatallyWeek}"> <br>
				<label for="prenatallyDiagConfirmation1" id="prenatallyDiagConfirmation1">If so, confirmed at birth: </label>
				<input id="prenatallyDiagYes" type="radio" name="prenatallyDiagConfirmation" value="Yes" path="diagnosisPrenatally"> Yes
				<input id="prenatallyDiagNo" type="radio" name="prenatallyDiagConfirmation" value="No" path="diagnosisPrenatally"> No
				<input id="prenatallyDiagUn" type="radio" name="prenatallyDiagConfirmation" value="Unspecified" path="diagnosisPrenatally"> Unspecified <br>
			</div>
			<label for="diagnosisComments">Diagnosis comments: </label>
			<input type="text" name="diagnosisComments" class="form-control" path="diagnosisComments" value = "${patient.diagnosisComments}"> <br>
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
			<label for="pre-imgfile">Upload photo of patient here: </label>
			<input type="file" class="btn btn-lg btn-default" name="pre-imgfile" path="pre-imgfile"><br>
			<button type="submit" class="btn btn-lg btn-default" for="add_photo" id="add_photo">Add another photo</button>
			</div>
			</div>
		</fieldset>
			<div class="row" align="center">
					<button type="submit" class="btn btn-lg btn-primary">Save</button>
			</div>
		</div>
	</div>
</div>
</div>
	</form>
</body>
</html>