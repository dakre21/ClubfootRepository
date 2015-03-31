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
	  $('fieldset.emergency_contact').hide();
	  $('#deformity_history_num1').hide();
	  $('#deformity_history_num').hide();
	  $('#preg_complications_explained1').hide();
	  $('#pregnancy_complications_explained').hide();
	  $('#referral_hospital_name1').hide();
	  $('#referral_hospital_name').hide();
	  $('#referral_doc_name1').hide();
	  $('#referral_doc_name').hide();
	  $('#previous_treatments_num1').hide();
	  $('#previous_treatments_num').hide();
	  $('#diagnosis_prenatally_week1').hide();
	  $('#diagnosis_prenatally_week').hide();
	  $('#referral_other1').hide();
	  $('#referral_other').hide();
	  $('div.prev_treat').hide();
	  $('#prenatallyDiagYes').hide();
	  $('#prenatallyDiagNO').hide();
	  $('#prenatallyDiagUn').hide();
	  
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
	  var year = "${patient.dob}".substring(0, 4);
	  var month = "${patient.dob}".substring(5, 7);
	  var day = "${patient.dob}".substring(8, 10);
	  var date = month + '/' + day + '/' + year;
	  $("#dob").val(date);*/
	  
	  switch ("${patient.guardian_relationship}") {
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
	  
	  if ("${patient.second_guardian_last}") {
	    document.getElementById("secondGuardianYes").checked = true;
		$('fieldset.guardian_check').show();
		$('second_guardian_phone1').prop('required', true);
	  }
      else {
		document.getElementById("secondGuardianNo").checked = true;
      }
      
	  switch ("${patient.emergency_contact}") {
	  	case "primary":
	  		document.getElementById("emergencyPrimary").checked = true;
	  		break;
	  	case "secondary":
	  		document.getElementById("emergencySecondary").checked = true;
	  		break;
	  	case "other":
	  		document.getElementById("emergencyOther").checked = true;
	  		$('fieldset.emergency_contact').show();
	  		$('other_guardian_phone1').prop('required', true);

	  		break;
	  	default:
	  		document.getElementById("emergencyUnspecified").checked = true;
	  		break;
      }

	  if ("${patient.deformity_history_num}" > 0) {
	    document.getElementById("defYes").checked = true;
	    $('#deformity_history_num1').show();
	    $('#deformity_history_num').show();
	  }
	  else if ("${patient.deformity_history_num}" == 0) {
	    document.getElementById("defNo").checked = true;
	  }
	  else {
	    document.getElementById("defUn").checked = true;
	  }
	  

	  if ("${patient.pregnancy_complications_explained}"){
		document.getElementById("pregCompYes").checked = true;
		$('#preg_complications_explained1').show();
	    $('#pregnancy_complications_explained').show();
	  }
  	  else {
    	document.getElementById("pregCompNo").checked = true;
  	  }
	  
	  if ("${patient.pregnancy_alc}" == "Yes")
		document.getElementById("pregAlcYes").checked = true;
	  else if ("${patient.pregnancy_alc}" == "No")
	   	document.getElementById("pregAlcNo").checked = true;
	  else
		document.getElementById("pregAlcUn").checked = true;

	  if ("${patient.pregnancy_smoke}" == "Yes")
		document.getElementById("pregSmokeYes").checked = true;
	  else if ("${patient.pregnancy_smoke}" == "No")
	   	document.getElementById("pregSmokeNo").checked = true;
	  else
		document.getElementById("pregSmokeUn").checked = true;
		
	  if ("${patient.complications}" == "Yes")
		document.getElementById("compYes").checked = true;
	  else if ("${patient.complications}" == "No")
	   	document.getElementById("compNo").checked = true;
	  else
		document.getElementById("compUn").checked = true;
		
	  if ("${patient.place_birth}" == "0")
		document.getElementById("placeBirthHosp").checked = true;
	  else if ("${patient.place_birth}" == "1")
	   	document.getElementById("placeBirthClinic").checked = true;
	  else if ("${patient.place_birth}" == "2")
		document.getElementById("placeBirthHome").checked = true;
	  else
		document.getElementById("placeBirthUn").checked = true;
	  
	  switch ("${patient.referral}") {
	  	case "Hospital/Clinic":
	  		document.getElementById("refHosp").checked = true;
	  		$('#referral_hospital_name1').show();
	  		$('#referral_hospital_name').show();
	 		$('#referral_doc_name1').show();
	 	 	$('#referral_doc_name').show();
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
	  		$('#referral_other1').hide();
	  		$('#referral_other').hide();
	  		$('#referral_other').prop('required',true);

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
	  
	  if ("${patient.deformity_at_birth}" == "Yes")
	    document.getElementById("deformityYes").checked = true;
	  else if ("${patient.deformity_at_birth}" == "No")
		document.getElementById("deformityNo").checked = true;
	  else
		document.getElementById("deformityUn").checked = true;
	  
	  if ("${patient.previous_treatments_num}" > 0){
	    document.getElementById("prevYes").checked = true;
		$('div.prev_treat').hide();
	  }
	  else if ("${patient.previous_treatments_num}" == 0){
		document.getElementById("prevNo").checked = true;
	  }
	  else{
		document.getElementById("prevUn").checked = true;
	  }
	  
	  if ("${patient.diagnosis_prenatally_week}"){
	    document.getElementById("diagYes").checked = true;
		 $('#diagnosis_prenatally_week1').show();
	     $('#diagnosis_prenatally_week').show();
	     $('#prenatallyDiagYes').show();
	     $('#prenatallyDiagNO').show();
	     $('#prenatallyDiagUn').show();
	  }
	  else {
		document.getElementById("diagNo").checked = true;
	  }
	  
	  if ("${patient.prenatally_diag_confirmation}" == "Yes")
	    document.getElementById("prenatallyDiagYes").checked = true;
	  else if ("${patient.prenatally_diag_confirmation}" == "No")
		document.getElementById("prenatallyDiagNo").checked = true;
	  else
		document.getElementById("prenatallyDiagUn").checked = true;
  }
  function guardianHandlerTrue(){
	  $('fieldset.guardian_check').show();
	  $('second_guardian_phone1').prop('required', true);
  }
  function guardianHandlerFalse(){
	  $('fieldset.guardian_check').hide();
	  $('second_guardian_phone1').prop('required', false);
  }
  function guardianEmergencyTrue(){
	  $('fieldset.emergency_contact').show();
	  $('other_guardian_phone1').prop('required', true);

  }
  function guardianEmergencyFalse(){
	  $('fieldset.emergency_contact').hide();
	  $('other_guardian_phone1').prop('required', false);
  }
  function guardianDeformityTrue(){
	  $('#deformity_history_num1').show();
	  $('#deformity_history_num').show();
  }
  function guardianDeformityFalse(){
	  $('#deformity_history_num1').hide();
	  $('#deformity_history_num').hide();
  }
  function pregCompFalse(){
	  $('#preg_complications_explained1').hide();
	  $('#pregnancy_complications_explained').hide();
  }
  function pregCompTrue(){
	  $('#preg_complications_explained1').show();
	  $('#pregnancy_complications_explained').show();
  }
  function referralFnTrue(){
	  $('#referral_hospital_name1').show();
	  $('#referral_hospital_name').show();
	  $('#referral_doc_name1').show();
	  $('#referral_doc_name').show();
	  $('#referral_other1').hide();
	  $('#referral_other').hide();
	  $('#referral_other').prop('required',false);

  }
  function referralFnFalse(){
	  $('#referral_hospital_name1').hide();
	  $('#referral_hospital_name').hide();
	  $('#referral_doc_name1').hide();
	  $('#referral_doc_name').hide();
	  $('#referral_other1').hide();
	  $('#referral_other').hide();
	  $('#referral_other').prop('required',false);


  }
  function referralOtherTrue(){
	  $('#referral_other1').show();
	  $('#referral_other').show();
	  $('#referral_other').prop('required',true);
	  $('#referral_hospital_name1').hide();
	  $('#referral_hospital_name').hide();
	  $('#referral_doc_name1').hide();
	  $('#referral_doc_name').hide();
  }
  function prevTreatmentTrue(){
	  $('#previous_treatments_num1').show();
	  $('#previous_treatments_num').show();
	  $('div.prev_treat').show();

  }
  function prevTreatmentFalse(){
	  $('#previous_treatments_num1').hide();
	  $('#previous_treatments_num').hide();
	  $('div.prev_treat').hide();

  }
  function diagPrenatTrue(){
	  $('#diagnosis_prenatally_week1').show();
	  $('#diagnosis_prenatally_week').show();
	  $('#prenatallyDiagYes').show();
	  $('#prenatallyDiagNO').show();
	  $('#prenatallyDiagUn').show();
  }
  function diagPrenatFalse(){
	  $('#diagnosis_prenatally_week1').hide();
	  $('#diagnosis_prenatally_week').hide();
	  $('#prenatallyDiagYes').hide();
	  $('#prenatallyDiagNO').hide();
	  $('#prenatallyDiagUn').hide();
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
			<label for="patient_lastName"><em>*</em>Last name/Surname: </label>
			<input type="name" name="patient_lastName" class="form-control" path="patient_lastName" value="${patient.patient_lastName}" >

			<label for="patient_firstName"><em>  *</em>First name: </label>
			<input type="name" name="patient_firstName" class="form-control" path="patient_firstName" value = "${patient.patient_firstName}" >

			<label for="patient_midName">   Middle name: </label>
			<input type="name" name="patient_midName" class="form-control" path="patient_midName" value = "${patient.patient_midName}"> <br>

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
			<input type="date" name="dob" id="dob" class="form-control" path="dob" > 
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
			<label for="guardian_lastName">Last name/Surname: </label>
			<input type="name" name="guardian_lastName" class="form-control" path="guardian_lastName" value = "${patient.guardian_lastName}">

			<label for="guardian_firstName">  First name: </label>
			<input type="name" name="guardian_firstName" class="form-control" path="guardian_firstName" value = "${patient.guardian_firstName}">

			<label for="guardian_midName">   Middle name: </label>
			<input type="name" name="guardian_midName" class="form-control" path="guardian_midName" value = "${patient.guardian_midName}"> <br>

			<label for="guardian_relationship">Relationship to patient: </label>
			<input id="relMom" type="radio" name="guardian_relationship" value="mother" path="guardian_relationship"> Mother
			<input id="relDad" type="radio" name="guardian_relationship" value="father" path="guardian_relationship"> Father
			<input id="relGparent" type="radio" name="guardian_relationship" value="grandparent" path="guardian_relationship"> Grandparent
			<input id="relBro" type="radio" name="guardian_relationship" value="brother" path="guardian_relationship"> Brother
			<input id="relSis" type="radio" name="guardian_relationship" value="sister" path="guardian_relationship"> Sister
			<input id="relAunt" type="radio" name="guardian_relationship" value="aunt" path="guardian_relationship"> Aunt
			<input id="relUncle" type="radio" name="guardian_relationship" value="uncle" path="guardian_relationship"> Uncle 
			<input id="relFriend" type="radio" name="guardian_relationship" value="friend" path="guardian_relationship"> Friend 
			<input id="relOther" type="radio" name="guardian_relationship" value="other" path="guardian_relationship"> Other
			<input id="relUn" type="radio" name="guardian_relationship" value="unspecified" path="guardian_relationship"> Unspecified <br>

			<label for="guardian_phone1"><em>*</em>Phone number 1: </label>
			<input type="telephone" name="guardian_phone1" class="form-control"  path="guardian_phone1" placeholder="xxx-xxx-xxxx" value = "${patient.guardian_phone1}" pattern="(\+?\d[- .]*){7,13}" title="international, national or local phone number" >
			<label for="guardian_phone2">Phone number 2: </label>
			<input type="telephone" name="guardian_phone2" class="form-control"  path="guardian_phone2" value = "${patient.guardian_phone2}"placeholder="xxx-xxx-xxxx" pattern="(\+?\d[- .]*){7,13}" title="international, national or local phone number"> <br>
			
			<label for="guardian_check">Secondary parent/guardian: </label>
			<input id="secondGuardianYes" type="radio" name="guardian_check" value="Yes" path="guardian_check" onClick="guardianHandlerTrue()"> Yes
			<input id="secondGuardianNo" type="radio" name="guardian_check" value="No" path="guardian_check" onClick="guardianHandlerFalse()"> No <br>
			</div>
			<div class="row">
			<fieldset class="guardian_check">
			<legend>Secondary Parent/Guardian</legend>
				<div class="form-group">
				<label for="second_guardian_last">Last name/Surname: </label>
				<input type="name" name="second_guardian_last" class="form-control" path="second_guardian_last" value = "${patient.second_guardian_last}">
				<label for="second_guardian_first">First name: </label>
				<input type="name" name="second_guardian_first" class="form-control" path="second_guardian_first" value = "${patient.second_guardian_first}">
				<label for="second_guardian_mid">Middle name: </label>
				<input type="name" name="second_guardian_mid" class="form-control" path="second_guardian_mid" value = "${patient.second_guardian_mid}"> <br>
				
				<label for="second_guardian_relationship">Relationship to patient: </label>
				<input id="relMom2" type="radio" name="second_guardian_relationship" value="mother" path="second_guardian_relationship"> Mother
				<input id="relDad2" type="radio" name="second_guardian_relationship" value="father" path="second_guardian_relationship"> Father
				<input id="relGparent2" type="radio" name="second_guardian_relationship" value="grandparent" path="second_guardian_relationship"> Grandparent
				<input id="relBro2" type="radio" name="second_guardian_relationship" value="brother" path="second_guardian_relationship"> Brother
				<input id="relSis2" type="radio" name="second_guardian_relationship" value="sister" path="second_guardian_relationship"> Sister
				<input id="relAunt2" type="radio" name="second_guardian_relationship" value="aunt" path="second_guardian_relationship"> Aunt
				<input id="relUncle2" type="radio" name="second_guardian_relationship" value="uncle" path="second_guardian_relationship"> Uncle 
				<input id="relFriend2" type="radio" name="second_guardian_relationship" value="friend" path="second_guardian_relationship"> Friend 
				<input id="relOther2" type="radio" name="second_guardian_relationship" value="other" path="second_guardian_relationship"> Other
				<input id="relUn2" type="radio" name="second_guardian_relationship" value="unspecified1" path="second_guardian_relationship"> Unspecified <br>
			
				<label for="second_guardian_phone1"><em>*</em>Phone number 1: </label>
				<input type="telephone" name="second_guardian_phone1" class="form-control" path="second_guardian_phone1" value = "${patient.second_guardian_phone1}" placeholder="xxx-xxx-xxxx" pattern="(\+?\d[- .]*){7,13}" title="international, national or local phone number" >
				<label for="second_guardian_phone2">Phone number 2: </label>
				<input type="telephone" name="second_guardian_phone2" class="form-control" path="second_guardian_phone2"  value = "${patient.second_guardian_phone2}" placeholder="xxx-xxx-xxxx" pattern="(\+?\d[- .]*){7,13}" title="international, national or local phone number">
				</div>
			</fieldset>
			</div>
			
			<label for="emergency_contact">Emergency Contact: </label>
			<input id="emergencyPrimary" type="radio" name="emergency_contact" value="Primary" path="emergency_contact" onClick="guardianEmergencyFalse()"> Primary
			<input id="emergencySecondary" type="radio" name="emergency_contact" value="Secondary" path="emergency_contact" onClick="guardianEmergencyFalse()"> Seconday
			<input id="emergencyOther" type="radio" name="emergency_contact" value="Other" path="emergency_contact" onClick="guardianEmergencyTrue()"> Other
			<input id="emergencyUnspecified" type="radio" name="emergency_contact" value="Unspecified" path="emergency_contact" onClick="guardianEmergencyFalse()"> Unspecified
			
			<div class="row">
			<fieldset class="emergency_contact">
			<legend>Other Emergency Contact</legend>
				<div class="form-group">
				<label for="other_guardian_last">Last name/Surname: </label>
				<input type="name" name="other_guardian_last" class="form-control" path="other_guardian_last" value = "${patient.other_guardian_last}">
				<label for="other_guardian_first">First name: </label>
				<input type="name" name="other_guardian_first" class="form-control" path="other_guardian_first" value = "${patient.other_guardian_first}">
				<label for="other_guardian_mid">Middle name: </label>
				<input type="name" name="other_guardian_mid" class="form-control" path="other_guardian_mid" value = "${patient.other_guardian_mid}"> <br>
				
				<label for="other_guardian_relationship">Relationship to parent: </label>
				<input id="relMom3" type="radio" name="other_guardian_relationship" value="mother" path="other_guardian_relationship"> Mother
				<input id="relDad3" type="radio" name="other_guardian_relationship" value="father" path="other_guardian_relationship"> Father
				<input id="relGparent3" type="radio" name="other_guardian_relationship" value="grandparent" path="other_guardian_relationship"> Grandparent
				<input id="relBro3" type="radio" name="other_guardian_relationship" value="brother" path="other_guardian_relationship"> Brother
				<input id="relSis3" type="radio" name="other_guardian_relationship" value="sister" path="other_guardian_relationship"> Sister
				<input id="relAunt3" type="radio" name="other_guardian_relationship" value="aunt" path="other_guardian_relationship"> Aunt
				<input id="relUncle3" type="radio" name="other_guardian_relationship" value="uncle" path="other_guardian_relationship"> Uncle 
				<input id="relFriend3" type="radio" name="other_guardian_relationship" value="friend" path="other_guardian_relationship"> Friend 
				<input id="relOther3" type="radio" name="other_guardian_relationship" value="other" path="other_guardian_relationship" > Other
				<input id="relUn3" type="radio" name="other_guardian_relationship" value="unspecified1" path="other_guardian_relationship"> Unspecified <br>
			
				<label for="other_guardian_phone1"><em>*</em>Phone number 1: </label>
				<input type="telephone" name="other_guardian_phone1" class="form-control" path="other_guardian_phone1" value = "${patient.other_guardian_phone1}" placeholder="xxx-xxx-xxxx" pattern="(\+?\d[- .]*){7,13}" title="international, national or local phone number" >
				<label for="other_guardian_phone2">Phone number 2: </label>
				<input type="telephone" name="other_guardian_phone2" class="form-control" path="other_guardian_phone2" value = "${patient.other_guardian_phone2}" placeholder="xxx-xxx-xxxx" pattern="(\+?\d[- .]*){7,13}" title="international, national or local phone number">
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
			<label for="deformity_history">Any relatives with the clubfoot deformity: </label>
			<input id="defYes" type="radio" name="deformity_history" value="Yes" path="deformity_history" onClick="guardianDeformityTrue()"> Yes
			<input id="defNo" type="radio" name="deformity_history" value="No" path="deformity_history" onClick="guardianDeformityFalse()"> No
			<input id="defUn" type="radio" name="deformity_history" value="Unspecified" path="deformity_history" onClick="guardianDeformityFalse()"> Unspecified <br>
			
			<label for="deformity_history_num" id="deformity_history_num1">How many: </label>
			<input type="text" name="deformity_history_num" class="form-control" path="deformity_history_num" id="deformity_history_num" value = "${patient.deformity_history_num}"> <br>
			
			<label for="pregnancy">Length of pregnancy (in weeks): </label>
			<input type="text" name="pregnancy" class="form-control" path="pregnancy" value = "${patient.pregnancy}"> <br>
			
			<label for="pregnancy_complications">Did the mother have any complications during pregnancy: </label>
			<input id="pregCompYes" type="radio" name="pregnancy_complications" value="Yes" path="pregnancy_complications" onClick="pregCompTrue()"> Yes
			<input id="pregCompNo" type="radio" name="pregnancy_complications" value="No" path="pregnancy_complications" onClick="pregCompFalse()"> No
			<input id="pregCompUn" type="radio" name="pregnancy_complications" value="Unspecified" path="pregnancy_complications" onClick="pregCompFalse()"> Unspecified <br>
			
			<label for="preg_complications_explained1" id="preg_complications_explained1">What were the complications: </label>
			<input type="text" name="pregnancy_complications_explained" class="form-control" path="pregnancy_complications_explained" id="pregnancy_complications_explained" value = "${patient.pregnancy_complications_explained}"> <br>
			
			<label for="pregnancy_alc">Did the mother consume alcohol during pregnancy: </label>
			<input id="pregAlcYes" type="radio" name="pregnancy_alc" value="Yes" path="pregnancy_alc"> Yes
			<input id="pregAlcNo" type="radio" name="pregnancy_alc" value="No" path="pregnancy_alc"> No
			<input id="pregAlcUn" type="radio" name="pregnancy_alc" value="Unspecified" path="pregnancy_alc"> Unspecified <br>
			
			<label for="pregnancy_smoke">Did the mother smoke during pregnancy: </label>
			<input id="pregSmokeYes" type="radio" name="pregnancy_smoke" value="Yes" path="pregnancy_smoke"> Yes
			<input id="pregSmokeNo" type="radio" name="pregnancy_smoke" value="No" path="pregnancy_smoke"> No
			<input id="pregSmokeUn" type="radio" name="pregnancy_smoke" value="Unspecified" path="pregnancy_smoke"> Unspecified <br>
			
			<label for="complications">Any complications during birth: </label>
			<input id="compYes" type="radio" name="complications" value="Yes" path="complications"> Yes
			<input id="compNo" type="radio" name="complications" value="No" path="complications"> No
			<input id="compUn" type="radio" name="complications" value="Unspecified" path="complications"> Unspecified <br> 
			
			<label for="place_birth">Place of birth: </label>
			<input id="placeBirthHosp" type="radio" name="place_birth" value="0" path="place_birth"> Hospital
			<input id="placeBirthClinic" type="radio" name="place_birth" value="1" path="place_birth"> Clinic
			<input id="placeBirthHome" type="radio" name="place_birth" value="2" path="place_birth"> Home
			<input id="placeBirthUn" type="radio" name="place_birth" value="3" path="place_birth"> Unspecified
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
		
			<label for="referral_doc_name1" id="referral_doc_name1">Doctor name: </label>
			<input type="text" name="referral_doc_name" path="referral_doc_name" id="referral_doc_name" value = "${patient.referral_doc_name}">
			<label for="referral_hospital_name" id="referral_hospital_name1">Hospital/clinic name: </label>
			<input type="text" name="referral_hospital_name" path="referral_hospital_name" id="referral_hospital_name" value = "${patient.referral_hospital_name}">
			<label for="referral_other" id="referral_other1"><em>*</em>Please specify: </label>
			<input type="text" name="referral_other" path="referral_other" id="referral_other" value = "${patient.referral_other}" >

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
			
			<label for="evaluation_date"><em>*</em>Evaluation date (dd/mm/yyyy): </label>
			<input type="date" name="evaluation_date" class="form-control" path="evaluation_date" value = "${patient.evaluation_date}" > <br>
			
			<label for="feet"><em>*</em>Feet affected: </label>
			<input id="feetLeft" type="radio" name="feet" value="Left" path="feet" > Left
			<input id="feetRight" type="radio" name="feet" value="Right" path="feet" > Right
			<input id="feetBoth" type="radio" name="feet" value="Both" path="feet" > Both <br>
			
			<label for="diagnosis"><em>*</em>Diagnosis: </label>
			<input id="diagIdio" type="radio" name="diagnosis" value="Idiopathic Clubfoot" path="diagnosis"  > Idiopathic Clubfoot
			<input id="diagSynd" type="radio" name="diagnosis" value="Syndromic Clubfoot" path="diagnosis"  > Syndromic Clubfoot
			<input id="diagNeuro" type="radio" name="diagnosis" value="Neuropathic Clubfoot" path="diagnosis" > Neuropathic Clubfoot
			<input id="diagOther" type="radio" name="diagnosis" value="Other" path="diagnosis" > Other <br>
			
			<label for="deformity_at_birth">Deformity present at birth: </label>
			<input id="deformityYes" type="radio" name="deformity_at_birth" value="Yes" path="deformity_at_birth"> Yes
			<input id="deformityNo" type="radio" name="deformity_at_birth" value="No" path="deformity_at_birth"> No
			<input id="deformityUn" type="radio" name="deformity_at_birth" value="Unspecified" path="deformity_at_birth"> Unspecified <br>
			
			<label for="previous_treatments">Any previous treatments: </label>
			<input id="prevYes" type="radio" name="previous_treatments" value="Yes" path="previous_treatments" onClick="prevTreatmentTrue()"> Yes
			<input id="prevNo" type="radio" name="previous_treatments" value="No" path="previous_treatments" onClick="prevTreatmentFalse()"> No
			<input id="prevUn" type="radio" name="previous_treatments" value="Unspecified" path="previous_treatments"> Unspecified <br>
			<div class = "prev_treat">
				<label for="previous_treatments_num1" id="previous_treatments_num1">Number of previous treatments: </label>
				<input type="text" name="previous_treatments_num" class="form-control" path="previous_treatments_num" id="previous_treatments_num" value = "${patient.previous_treatments_num}"> <br>
				
				<label for ="previous_treatment_type" id="previous_treatment_type1">Type of previous treatments(s): </label>
				<input type="checkbox" name = "prev_treat_casting_above" value = "Casting above knee" id = "prev_treat_casting_above"> Casting above knee
				<input type="checkbox" name = "prev_treat_casting_below" value = "Casting below knee" id = "prev_treat_casting_below"> Casting below knee
				<input type="checkbox" name = "prev_treat_physiotherapy" value = "Physiotherapy" id = "prev_treat_physiotherapy"> Physiotherapy
				<input type="checkbox" name = "prev_treat_unspecified" value = "Unspecified" id = "prev_treat_unspecified"> Unspecified
				<input type="checkbox" name = "prev_treat_other" value = "Other" id = "prev_treat_other"> Other <br>
			</div>
			<label for="diagnosis_prenatally">Diagnosis prenatally: </label>
			<input id="diagYes" type="radio" name="diagnosis_prenatally" value="Yes" path="diagnosis_prenatally" onClick="diagPrenatTrue()"> Yes
			<input id="diagNo" type="radio" name="diagnosis_prenatally" value="No" path="diagnosis_prenatally" onClick="diagPrenatFalse()"> No
			<input id="diagUn" type="radio" name="diagnosis_prenatally" value="Unspecified" path="diagnosis_prenatally" onClick="diagPrenatFalse()"> Unspecified <br>
			
			<label for="diagnosis_prenatally_week1" id="diagnosis_prenatally_week1">At prenatally week: </label>
			<input type="text" name="diagnosis_prenatally_week" class="form-control" path="diagnosis_prenatally_week" id="diagnosis_prenatally_week" value = "${patient.diagnosis_prenatally_week}"> <br>
			<label for="prenatally_diag_confirmation1" id="prenatally_diag_confirmation1">If so, confirmed at birth: </label>
			<input id="prenatallyDiagYes" type="radio" name="prenatally_diag_confirmation" value="Yes" path="diagnosis_prenatally"> Yes
			<input id="prenatallyDiagNo" type="radio" name="prenatally_diag_confirmation" value="No" path="diagnosis_prenatally"> No
			<input id="prenatallyDiagUn" type="radio" name="prenatally_diag_confirmation" value="Unspecified" path="diagnosis_prenatally"> Unspecified <br><br>
			
			<label for="diagnosis_comments">Diagnosis comments: </label>
			<input type="text" name="diagnosis_comments" class="form-control" path="diagnosis_comments" value = "${patient.diagnosis_comments}"> <br>
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