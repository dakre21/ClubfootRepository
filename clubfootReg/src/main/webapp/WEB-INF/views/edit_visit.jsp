<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
<title>Clubfoot Registry | Edit Visit</title>
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
	  $('#nextVisitDate').hide();
	  $('#dateOfNextVisit1').hide();
	  $('#castLeftNum').hide();
	  $('#casterLeft').hide();
	  $('#castLeftNum1').hide();
	  $('#casterLeft1').hide();
	  $('#abductionLeft').hide();
	  $('#abductionLeft1').hide();
	  $('#dorsiflexionLeft').hide();
	  $('#dorsiflexionLeft1').hide();
	  $('#braceLeft').hide();
	  $('#braceLeft1').hide();
	  $('#problemsLeft').hide();
	  $('#problemsLeft1').hide();
	  $('#actionsLeft').hide();
	  $('#actionsLeft1').hide();
	  $('#otherLeft').hide();
	  $('#otherLeft1').hide();
	  $('div.surgeryLeftClass').hide();
	  $('#castRightNum').hide();
	  $('#casterRight').hide();
	  $('#castRightNum1').hide();
	  $('#casterRight1').hide();
	  $('#abductionRight').hide();
	  $('#abductionRight1').hide();
	  $('#dorsiflexionRight').hide();
	  $('#dorsiflexionRight1').hide();
	  $('#otherRight').hide();
	  $('#otherRight1').hide();
	  $('div.surgeryRightClass').hide();
	  $('#braceRight').hide();
	  $('#braceRight1').hide();
	  $('#problemsRight').hide();
	  $('#problemsRight1').hide();
	  $('#actionsRight').hide();
	  $('#actionsRight1').hide();
	  $('#description').hide();
	  $('#results').hide();
	  $('#treatmentComplications').hide();
	  $('#description1').hide();
	  $('#results1').hide();
	  $('#treatmentComplications1').hide();

  if ("${visit.isLastVisit}" == "Yes"){
	document.getElementById("lvYes").checked = true;
  }
  else if("${visit.isLastVisit}" == "No"){
	document.getElementById("lvNo").checked = true;
	$('#nextVisitDate').show();
	$('#dateOfNextVisit1').show();
  }
  else if("${visit.isLastVisit}" == "Unspecified"){
	document.getElementById("lvUn").checked = true;
  }

  if ("${visit.relapse}" == "Yes")
	document.getElementById("relapseYes").checked = true;
  else if("${visit.relapse}" == "No")
	document.getElementById("relapseNo").checked = true;
  else if("${visit.relapse}" == "Unspecified")
	document.getElementById("relapseUn").checked = true;

  if ("${visit.hindfootLeftVarus}" == 1)
	document.getElementById("hindfootLeftVarusVarus").checked = true;
  else if("${visit.hindfootLeftVarus}" == 2)
	document.getElementById("hindfootLeftVarusNeutral").checked = true;
  else if("${visit.hindfootLeftVarus}" == 3)
	document.getElementById("hindfootLeftVarusValgus").checked = true;
  else if("${visit.hindfootLeftVarus}" == 0)
	document.getElementById("hindfootLeftVarusNA").checked = true;

  if ("${visit.hindfootLeftCavus}" == 1)
	document.getElementById("hindfootLeftCanvusP").checked = true;
  else if("${visit.hindfootLeftCavus}" == 2)
	document.getElementById("hindfootLeftCanvusC").checked = true;
  else if("${visit.hindfootLeftCavus}" == 0)
	document.getElementById("hindfootLeftCanvusNA").checked = true;

  if ("${visit.leftPC}" == 1)
	document.getElementById("leftPC1").checked = true;
  else if("${visit.leftPC}" == 2)
	document.getElementById("leftPC2").checked = true;
  else if("${visit.leftPC}" == 0)
	document.getElementById("leftPC3").checked = true;

  if ("${visit.leftEH}" == 1)
	document.getElementById("leftEH1").checked = true;
  else if("${visit.leftEH}" == 2)
	document.getElementById("leftEH2").checked = true;
  else if("${visit.leftEH}" == 0)
	document.getElementById("leftEH3").checked = true;

  if ("${visit.leftRE}" == 1)
	document.getElementById("leftRE1").checked = true;
  else if("${visit.leftRE}" == 2)
	document.getElementById("leftRE2").checked = true;
  else if("${visit.leftRE}" == 0)
	document.getElementById("leftRE3").checked = true;

  if ("${visit.leftMC}" == 1)
	document.getElementById("leftMC1").checked = true;
  else if("${visit.leftMC}" == 2)
	document.getElementById("leftMC2").checked = true;
  else if("${visit.leftMC}" == 0)
	document.getElementById("leftMC3").checked = true;

  if ("${visit.leftTHC}" == 1)
	document.getElementById("leftTHC1").checked = true;
  else if("${visit.leftTHC}" == 2)
	document.getElementById("leftTHC2").checked = true;
  else if("${visit.leftTHC}" == 0)
	document.getElementById("leftTHC3").checked = true;

  if ("${visit.leftCLB}" == 1)
	document.getElementById("leftCLB1").checked = true;
  else if("${visit.leftCLB}" == 2)
	document.getElementById("leftCLB2").checked = true;
  else if("${visit.leftCLB}" == 0)
	document.getElementById("leftCLB3").checked = true;

  /*
  if ("${visit.leftTreatment}" == "None")
	document.getElementById("LT1").checked = true;
  else if("${visit.leftTreatment}" == "C - Manipulation & Casting")
	document.getElementById("LT2").checked = true;
  else if("${visit.leftTreatment}" == "T - Tenotomy")
	document.getElementById("LT3").checked = true;
  else if("${visit.leftTreatment}" == "B - Brace Application")
	document.getElementById("LT4").checked = true;
  else if("${visit.leftTreatment}" == "R - Refer")
	document.getElementById("LT5").checked = true;
  else if("${visit.leftTreatment}" == "S - Surgery")
	document.getElementById("LT6").checked = true;
  else if("${visit.leftTreatment}" == "O - Other")
	document.getElementById("LT7").checked = true;

  if ("${visit.surgeryLeft}" == "Posterior Release")
	document.getElementById("SL1").checked = true;
  else if("${visit.surgeryLeft}" == "Medial Release")
	document.getElementById("SL2").checked = true;
  else if("${visit.surgeryLeft}" == "Subtalar Release")
	document.getElementById("SL3").checked = true;
  else if("${visit.surgeryLeft}" == "Plantar Release")
	document.getElementById("SL4").checked = true;
  else if("${visit.surgeryLeft}" == "Achilles Lengthening")
	document.getElementById("SL5").checked = true;
  else if("${visit.surgeryLeft}" == "Tendon Transfers")
	document.getElementById("SL6").checked = true;
  else if("${visit.surgeryLeft}" == "Osteotomies")
	document.getElementById("SL7").checked = true;
  else if("${visit.surgeryLeft}" == "Arthrodesis")
	document.getElementById("SL8").checked = true;
  else if("${visit.surgeryLeft}" == "Talectomy")
	document.getElementById("SL9").checked = true;
  else if("${visit.surgeryLeft}" == "Other")
	document.getElementById("SL10").checked = true;
*/

  if ("${visit.hindfootRightVarus}" == 1)
	document.getElementById("hindfootRightVarusVarus").checked = true;
  else if("${visit.hindfootRightVarus}" == 2)
	document.getElementById("hindfootRightVarusNeutral").checked = true;
  else if("${visit.hindfootRightVarus}" == 3)
	document.getElementById("hindfootRightVarusValgus").checked = true;
  else if("${visit.hindfootRightVarus}" == 0)
	document.getElementById("hindfootRightVarusNA").checked = true;

  if ("${visit.hindfootRightCavus}" == 1)
	document.getElementById("hindfootRightCavusP").checked = true;
  else if("${visit.hindfootRightCavus}" == 2)
	document.getElementById("hindfootRightCavusC").checked = true;
  else if("${visit.hindfootRightCavus}" == 0)
	document.getElementById("hindfootRightCavusNA").checked = true;

  if ("${visit.rightPC}" == 1)
	document.getElementById("rightPC1").checked = true;
  else if("${visit.rightPC}" == 2)
	document.getElementById("rightPC2").checked = true;
  else if("${visit.rightPC}" == 0)
	document.getElementById("rightPC3").checked = true;

  if ("${visit.rightEH}" == 1)
	document.getElementById("rightEH1").checked = true;
  else if("${visit.rightEH}" == 2)
	document.getElementById("rightEH2").checked = true;
  else if("${visit.rightEH}" == 0)
	document.getElementById("rightEH3").checked = true;

  if ("${visit.rightRE}" == 1)
	document.getElementById("rightRE1").checked = true;
  else if("${visit.rightRE}" == 2)
	document.getElementById("rightRE2").checked = true;
  else if("${visit.rightRE}" == 0)
	document.getElementById("rightRE3").checked = true;

  if ("${visit.rightMC}" == 1)
	document.getElementById("rightMC1").checked = true;
  else if("${visit.rightMC}" == 2)
	document.getElementById("rightMC2").checked = true;
  else if("${visit.rightMC}" == 0)
	document.getElementById("rightMC3").checked = true;

  if ("${visit.rightTHC}" == 1)
	document.getElementById("rightTHC1").checked = true;
  else if("${visit.rightTHC}" == 2)
	document.getElementById("rightTHC2").checked = true;
  else if("${visit.rightTHC}" == 0)
	document.getElementById("rightTHC3").checked = true;

  if ("${visit.rightCLB}" == 1)
	document.getElementById("rightCLB1").checked = true;
  else if("${visit.rightCLB}" == 2)
	document.getElementById("rightCLB2").checked = true;
  else if("${visit.rightCLB}" == 0)
	document.getElementById("rightCLB3").checked = true;
/*
  if ("${visit.rightTreatment}" == "None")
	document.getElementById("RT1").checked = true;
  else if("${visit.rightTreatment}" == "C - Manipulation & Casting")
	document.getElementById("RT2").checked = true;
  else if("${visit.rightTreatment}" == "T - Tenotomy")
	document.getElementById("RT3").checked = true;
  else if("${visit.rightTreatment}" == "B - Brace Application")
	document.getElementById("RT4").checked = true;
  else if("${visit.rightTreatment}" == "R - Refer")
	document.getElementById("RT5").checked = true;
  else if("${visit.rightTreatment}" == "S - Surgery")
	document.getElementById("RT6").checked = true;
  else if("${visit.rightTreatment}" == "O - Other")
	document.getElementById("RT7").checked = true;

  if ("${visit.surgeryRight}" == "Posterior Release")
	document.getElementById("SR1").checked = true;
  else if("${visit.surgeryRight}" == "Medial Release")
	document.getElementById("SR2").checked = true;
  else if("${visit.surgeryRight}" == "Subtalar Release")
	document.getElementById("SR3").checked = true;
  else if("${visit.surgeryRight}" == "Plantar Release")
	document.getElementById("SR4").checked = true;
  else if("${visit.surgeryRight}" == "Achilles Lengthening")
	document.getElementById("SR5").checked = true;
  else if("${visit.surgeryRight}" == "Tendon Transfers")
	document.getElementById("SR6").checked = true;
  else if("${visit.surgeryRight}" == "Osteotomies")
	document.getElementById("SR7").checked = true;
  else if("${visit.surgeryRight}" == "Arthrodesis")
	document.getElementById("SR8").checked = true;
  else if("${visit.surgeryRight}" == "Talectomy")
	document.getElementById("SR9").checked = true;
  else if("${visit.surgeryRight}" == "Other")
	document.getElementById("SR10").checked = true;
*/
  if ("${visit.complications}" == "No"){
	document.getElementById("compNo").checked = true;
  }
  else if("${visit.complications}" == "Yes"){
	document.getElementById("compYes").checked = true;
	$('#description').show();
	$('#results').show();
	$('#treatmentComplications').show();
	$('#description1').show();
	$('#results1').show();
	$('#treatmentComplications1').show();
  }
  else if("${visit.complications}" == "Unspecified")
  {
	document.getElementById("compUn").checked = true;
  }

  $("#hospitalId").val("${visit.hospitalId}");
  $("#evaluatorId").val("${visit.evaluatorId}");

  document.getElementById("comments").value = "${visit.comments}";

  }  

  function braceLeftTrue(){
	  $('#castLeftNum').hide();
	  $('#casterLeft').hide();
	  $('#castLeftNum1').hide();
	  $('#casterLeft1').hide();
	  $('#abductionLeft').hide();
	  $('#abductionLeft1').hide();
	  $('#dorsiflexionLeft').hide();
	  $('#dorsiflexionLeft1').hide();
	  $('#otherLeft').hide();
	  $('#otherLeft1').hide();
	  $('div.surgeryLeftClass').hide();
	  $('#braceLeft').show();
	  $('#braceLeft1').show();
	  $('#problemsLeft').show();
	  $('#problemsLeft1').show();
	  $('#actionsLeft').show();
	  $('#actionsLeft1').show();
  }
  
  function tenotomyLeftTrue(){
	  $('#abductionLeft').show();
	  $('#abductionLeft1').show();
	  $('#dorsiflexionLeft').show();
	  $('#dorsiflexionLeft1').show();
	  $('#castLeftNum').hide();
	  $('#casterLeft').hide();
	  $('#castLeftNum1').hide();
	  $('#casterLeft1').hide();
	  $('#otherLeft').hide();
	  $('#otherLeft1').hide();
	  $('div.surgeryLeftClass').hide();
	  $('#braceLeft').hide();
	  $('#braceLeft1').hide();
	  $('#problemsLeft').hide();
	  $('#problemsLeft1').hide();
	  $('#actionsLeft').hide();
	  $('#actionsLeft1').hide();
  }
  
  function surgeryLeftTrue(){
	  $('div.surgeryLeftClass').show();
	  $('#braceLeft').hide();
	  $('#braceLeft1').hide();
	  $('#problemsLeft').hide();
	  $('#problemsLeft1').hide();
	  $('#actionsLeft').hide();
	  $('#actionsLeft1').hide();
	  $('#abductionLeft').hide();
	  $('#abductionLeft1').hide();
	  $('#dorsiflexionLeft').hide();
	  $('#dorsiflexionLeft1').hide();
	  $('#castLeftNum').hide();
	  $('#casterLeft').hide();
	  $('#castLeftNum1').hide();
	  $('#casterLeft1').hide();
	  $('#otherLeft').hide();
	  $('#otherLeft1').hide();


  }
  
  function referLeftTrue(){
	  $('#castLeftNum').hide();
	  $('#casterLeft').hide();
	  $('#castLeftNum1').hide();
	  $('#casterLeft1').hide();
	  $('#abductionLeft').hide();
	  $('#abductionLeft1').hide();
	  $('#dorsiflexionLeft').hide();
	  $('#dorsiflexionLeft1').hide();
	  $('#braceLeft').hide();
	  $('#braceLeft1').hide();
	  $('#problemsLeft').hide();
	  $('#problemsLeft1').hide();
	  $('#actionsLeft').hide();
	  $('#actionsLeft1').hide();
	  $('#otherLeft').hide();
	  $('#otherLeft1').hide();
	  $('div.surgeryLeftClass').hide();


  }
  
  function otherLeftTrue(){
	  $('#otherLeft').show();
	  $('#otherLeft1').show();
	  $('div.surgeryLeftClass').hide();
	  $('#braceLeft').hide();
	  $('#braceLeft1').hide();
	  $('#problemsLeft').hide();
	  $('#problemsLeft1').hide();
	  $('#actionsLeft').hide();
	  $('#actionsLeft1').hide();
	  $('#abductionLeft').hide();
	  $('#abductionLeft1').hide();
	  $('#dorsiflexionLeft').hide();
	  $('#dorsiflexionLeft1').hide();
	  $('#castLeftNum').hide();
	  $('#casterLeft').hide();
	  $('#castLeftNum1').hide();
	  $('#casterLeft1').hide();
  }
  function noneLeftTrue(){
	  $('#castLeftNum').hide();
	  $('#casterLeft').hide();
	  $('#castLeftNum1').hide();
	  $('#casterLeft1').hide();
	  $('#abductionLeft').hide();
	  $('#abductionLeft1').hide();
	  $('#dorsiflexionLeft').hide();
	  $('#dorsiflexionLeft1').hide();
	  $('#braceLeft').hide();
	  $('#braceLeft1').hide();
	  $('#problemsLeft').hide();
	  $('#problemsLeft1').hide();
	  $('#actionsLeft').hide();
	  $('#actionsLeft1').hide();
	  $('#otherLeft').hide();
	  $('#otherLeft1').hide();
	  $('div.surgeryLeftClass').hide();

  }
  function castingLeftTrue(){
	  $('#castLeftNum').show();
	  $('#casterLeft').show();
	  $('#castLeftNum1').show();
	  $('#casterLeft1').show();
	  $('#otherLeft').hide();
	  $('#otherLeft1').hide();
	  $('div.surgeryLeftClass').hide();
	  $('#braceLeft').hide();
	  $('#braceLeft1').hide();
	  $('#problemsLeft').hide();
	  $('#problemsLeft1').hide();
	  $('#actionsLeft').hide();
	  $('#actionsLeft1').hide();
	  $('#abductionLeft').hide();
	  $('#abductionLeft1').hide();
	  $('#dorsiflexionLeft').hide();
	  $('#dorsiflexionLeft1').hide();
  }
  
  function braceRightTrue(){
	  $('#castRightNum').hide();
	  $('#casterRight').hide();
	  $('#castRightNum1').hide();
	  $('#casterRight1').hide();
	  $('#abductionRight').hide();
	  $('#abductionRight1').hide();
	  $('#dorsiflexionRight').hide();
	  $('#dorsiflexionRight1').hide();
	  $('#otherRight').hide();
	  $('#otherRight1').hide();
	  $('div.surgeryRightClass').hide();
	  $('#braceRight').show();
	  $('#braceRight1').show();
	  $('#problemsRight').show();
	  $('#problemsRight1').show();
	  $('#actionsRight').show();
	  $('#actionsRight1').show();
  }
  
  function tenotomyRightTrue(){
	  $('#castRightNum').hide();
	  $('#casterRight').hide();
	  $('#castRightNum1').hide();
	  $('#casterRight1').hide();
	  $('#abductionRight').show();
	  $('#abductionRight1').show();
	  $('#dorsiflexionRight').show();
	  $('#dorsiflexionRight1').show();
	  $('#otherRight').hide();
	  $('#otherRight1').hide();
	  $('div.surgeryRightClass').hide();
	  $('#braceRight').hide();
	  $('#braceRight1').hide();
	  $('#problemsRight').hide();
	  $('#problemsRight1').hide();
	  $('#actionsRight').hide();
	  $('#actionsRight1').hide();
  }
  
  function surgeryRightTrue(){
	  $('#castRightNum').hide();
	  $('#casterRight').hide();
	  $('#castRightNum1').hide();
	  $('#casterRight1').hide();
	  $('#abductionRight').hide();
	  $('#abductionRight1').hide();
	  $('#dorsiflexionRight').hide();
	  $('#dorsiflexionRight1').hide();
	  $('#otherRight').hide();
	  $('#otherRight1').hide();
	  $('div.surgeryRightClass').show();
	  $('#braceRight').hide();
	  $('#braceRight1').hide();
	  $('#problemsRight').hide();
	  $('#problemsRight1').hide();
	  $('#actionsRight').hide();
	  $('#actionsRight1').hide();


  }
  
  function referRightTrue(){
	  $('#castRightNum').hide();
	  $('#casterRight').hide();
	  $('#castRightNum1').hide();
	  $('#casterRight1').hide();
	  $('#abductionRight').hide();
	  $('#abductionRight1').hide();
	  $('#dorsiflexionRight').hide();
	  $('#dorsiflexionRight1').hide();
	  $('#otherRight').hide();
	  $('#otherRight1').hide();
	  $('div.surgeryRightClass').hide();
	  $('#braceRight').hide();
	  $('#braceRight1').hide();
	  $('#problemsRight').hide();
	  $('#problemsRight1').hide();
	  $('#actionsRight').hide();
	  $('#actionsRight1').hide();


  }
  
  function otherRightTrue(){
	  $('#castRightNum').hide();
	  $('#casterRight').hide();
	  $('#castRightNum1').hide();
	  $('#casterRight1').hide();
	  $('#abductionRight').hide();
	  $('#abductionRight1').hide();
	  $('#dorsiflexionRight').hide();
	  $('#dorsiflexionRight1').hide();
	  $('#otherRight').show();
	  $('#otherRight1').show();
	  $('div.surgeryRightClass').hide();
	  $('#braceRight').hide();
	  $('#braceRight1').hide();
	  $('#problemsRight').hide();
	  $('#problemsRight1').hide();
	  $('#actionsRight').hide();
	  $('#actionsRight1').hide();
  }
  function noneRightTrue(){
	  $('#castRightNum').hide();
	  $('#casterRight').hide();
	  $('#castRightNum1').hide();
	  $('#casterRight1').hide();
	  $('#abductionRight').hide();
	  $('#abductionRight1').hide();
	  $('#dorsiflexionRight').hide();
	  $('#dorsiflexionRight1').hide();
	  $('#otherRight').hide();
	  $('#otherRight1').hide();
	  $('div.surgeryRightClass').hide();
	  $('#braceRight').hide();
	  $('#braceRight1').hide();
	  $('#problemsRight').hide();
	  $('#problemsRight1').hide();
	  $('#actionsRight').hide();
	  $('#actionsRight1').hide();

  }
  function castingRightTrue(){
	  $('#castRightNum').show();
	  $('#casterRight').show();
	  $('#castRightNum1').show();
	  $('#casterRight1').show();
	  $('#abductionRight').hide();
	  $('#abductionRight1').hide();
	  $('#dorsiflexionRight').hide();
	  $('#dorsiflexionRight1').hide();
	  $('#otherRight').hide();
	  $('#otherRight1').hide();
	  $('div.surgeryRightClass').hide();
	  $('#braceRight').hide();
	  $('#braceRight1').hide();
	  $('#problemsRight').hide();
	  $('#problemsRight1').hide();
	  $('#actionsRight').hide();
	  $('#actionsRight1').hide();
  }
  
  function complicationsTrue(){
	  $('#description').show();
	  $('#results').show();
	  $('#treatmentComplications').show();
	  $('#description1').show();
	  $('#results1').show();
	  $('#treatmentComplications1').show();
	  
  }
  function complicationsFalse(){
	  $('#description').hide();
	  $('#results').hide();
	  $('#treatmentComplications').hide();
	  $('#description1').hide();
	  $('#results1').hide();
	  $('#treatmentComplications1').hide();
  }
  
  function lastVisitTrue(){
	  $('#nextVisitDate').hide();
	  $('#dateOfNextVisit1').hide();
  }
  function lastVisitFalse(){
	  $('#nextVisitDate').show();
	  $('#dateOfNextVisit1').show();
  }
  </script>
  <jsp:include page="navbar.jsp" />
</head>

<body>
<div class="container">
<div class="row clearfix">
	<div class="col-sm-2 column"></div>
	<div class="col-md-8 column">

	<form action="#" th:action="@{/edit_visit}" th:object="${visit}" modelAttribute="editVisit"  method="post" id="updateVisit">		
		<h1>Edit Visit for Patient ID: ${visit.patientId}</h1>
		
		<div class = "form-group">
			<p><i>Please complete the form. Mandatory fields are marked with a </i><em>*</em></p>
		  	
		  	<input type="hidden" class="form-control" name="patientId" path="patientId" value="${visit.patientId}">
		  	
		  	<label for="hospitalId"><em>*</em>Hospital/Clinic: </label>
			<form:select class="form-control" path="hospitalList" id="hospitalId" name="hospitalId">
            	<form:option value="" label="Select a Hospital" disabled="true" selected="true" style="display: none;"/>
                <form:options items="${hospitalList}" />
       		</form:select>
		  	<br>
		  	
		  	<label for="evaluatorId">Evaluator</label>
			<form:select class="form-control" path="evaluatorList" id="evaluatorId" name="evaluatorId">
            	<form:option value="" label="Select an Evaluator" disabled="true" selected="true" style="display: none;"/>
                <form:options items="${evaluatorList}" />
            </form:select>
            <br>
		  	
		  	<!-- 
	  		<label for = "evaluatorId"><em>*</em>Name of Evaluator:</label>
	  		<input type="text" name="evaluatorId" class="form-control" path="evaluatorId" >
	  		<a href="evaluator">Add evaluator</a> <br>
	  		-->
	  		
	  		<label for="dateOfVisit"><em>*</em>Date of visit: </label>
			<input type="date" name="dateOfVisit" id="dateOfVisit" class="form-control" path="dateOfVisit" placeholder="dd/mm/yyyy"   validate pattern="\d{1,2}/\d{1,2}/\d{4}" title="dd/mm/yyyy"> 
	  		<br>
	  		
		  	<label for = "isLastVisit">Is this the patient's final treatment visit? </label>
			<INPUT TYPE="radio" id = "lvYes" NAME="isLastVisit" path="isLastVisit" onClick = "lastVisitTrue()" VALUE="Yes">Yes
			<INPUT TYPE="radio" id = "lvNo" NAME="isLastVisit" path="isLastVisit" onClick = "lastVisitFalse()" VALUE="No">No
			<INPUT TYPE="radio" id = "lvUn" NAME="isLastVisit" path="isLastVisit" onClick = "lastVisitTrue()" VALUE="Unspecified">Unspecified<br>
		 
		    <label for="nextVisitDate" id = "dateOfNextVisit1"><em>*</em>Date of next visit: </label>
			<input type="date" name="nextVisitDate" id="nextVisitDate" class="form-control" path="nextVisitDate" placeholder="dd/mm/yyyy"   validate pattern="\d{1,2}/\d{1,2}/\d{4}" title="dd/mm/yyyy"> 
		 
		  	<label for = "relapse">Did the patient experience a relapse? </label>
			<INPUT TYPE="radio" id = "relapseYes" NAME="relapse" path="relapse" VALUE="Yes">Yes
			<INPUT TYPE="radio" id = "relapseNo" NAME="relapse" path="relapse" VALUE="No">No
			<INPUT TYPE="radio" id = "relapseUn" NAME="relapse" path="relapse" VALUE="Unspecified">Unspecified<br>
		</div>
		
		<div class = "form-group">
			<!--  <button class='toggle'>Hide Left Foot</button>-->
 			<fieldset>
				<legend>Left Foot</legend>
				<!--  <form>-->
				<label for = "hindfootLeftVarus">Varus: </label>
				<INPUT TYPE="radio" id = "hindfootLeftVarusVarus" NAME="hindfootLeftVarus" path="hindfootLeftVarus" VALUE="1">Varus
				<INPUT TYPE="radio" id = "hindfootLeftVarusNeutral" NAME="hindfootLeftVarus" path="hindfootLeftVarus" VALUE="2">Neutral
				<INPUT TYPE="radio" id = "hindfootLeftVarusValgus" NAME="hindfootLeftVarus" path="hindfootLeftVarus" VALUE="3">Valgus
				<INPUT TYPE="radio" id = "hindfootLeftVarusNA" NAME="hindfootLeftVarus" path="hindfootLeftVarus" VALUE="0">Not Assessed<br>
		  	
		  		<label for = "hindfootLeftCavus">Cavus: </label>
				<INPUT TYPE="radio" id = "hindfootLeftCanvusP" NAME="hindfootLeftCavus" path="hindfootLeftCavus" VALUE="1">Present
				<INPUT TYPE="radio" id = "hindfootLeftCanvusC" NAME="hindfootLeftCavus" path="hindfootLeftCavus" VALUE="2">Corrected
				<INPUT TYPE="radio" id = "hindfootLeftCanvusNA" NAME="hindfootLeftCavus" path="hindfootLeftCavus" VALUE="0">Not Assessed<br>
		  		
		  		<label for = "hindfootLeftAbductus">Abductus ° (-30 to 70): </label>
		  		<input type="text" name="hindfootLeftAbductus" class="form-control" path="hindfootLeftAbductus" value = "${visit.hindfootLeftAbductus}">
		  		<label for="hindfootLeftEquinus">Equinus ° (-50 to 30): </label>
				<input type="text" name="hindfootLeftEquinus" id="hindfootLeftEquinus" class="form-control" path="hindfootLeftEquinus" value = "${visit.hindfootLeftEquinus}"> 
		   	</fieldset>
		   
	  		<fieldset>
				<legend> Pirani Scores (Hindfoot) </legend>
				<label for = "leftPC"><em>*</em>Posterior crease: </label>
	  			
				<INPUT TYPE="radio" id = "leftPC1" NAME="leftPC" path="leftPC" VALUE="1">1
				<INPUT TYPE="radio" id = "leftPC2" NAME="leftPC" path="leftPC" VALUE="2">0.5
				<INPUT TYPE="radio" id = "leftPC3" NAME="leftPC" path="leftPC" VALUE="0">0<br>
	  			
	  			<label for = "leftEH"><em>*</em>Empty Heel: </label>	
				<INPUT TYPE="radio" id = "leftEH1" NAME="leftEH" path="leftEH" VALUE="1">1
				<INPUT TYPE="radio" id = "leftEH2" NAME="leftEH" path="leftEH" VALUE="2">0.5
				<INPUT TYPE="radio" id = "leftEH3" NAME="leftEH" path="leftEH" VALUE="0">0<br>
	  	
	  			<label for = "leftRE"><em>*</em>Rigid equinus: </label>	
				<INPUT TYPE="radio" id = "leftRE1" NAME="leftRE" path="leftRE" VALUE="1">1
				<INPUT TYPE="radio" id = "leftRE2" NAME="leftRE" path="leftRE" VALUE="2">0.5
				<INPUT TYPE="radio" id = "leftRE3" NAME="leftRE" path="leftRE" VALUE="0">0	
			</fieldset>
			
			<fieldset>
				<legend> Pirani Scores (Midfoot) </legend>
			
				<label for = "leftMC"><em>*</em>Medial Crease: </label>
				<INPUT TYPE="radio" id = "leftMC1" NAME="leftMC" path="leftMC" VALUE="1">1
				<INPUT TYPE="radio" id = "leftMC2" NAME="leftMC" path="leftMC" VALUE="2">0.5
				<INPUT TYPE="radio" id = "leftMC3" NAME="leftMC" path="leftMC" VALUE="0">0<br>
	  			
	  			<label for = "leftTHC"><em>*</em>Talar Head Coverage: </label>	
				<INPUT TYPE="radio" id = "leftTHC1" NAME="leftTHC" path="leftTHC" VALUE="1">1
				<INPUT TYPE="radio" id = "leftTHC2" NAME="leftTHC" path="leftTHC" VALUE="2">0.5
				<INPUT TYPE="radio" id = "leftTHC3" NAME="leftTHC" path="leftTHC" VALUE="0">0<br>
	  	
	  			<label for = "leftCLB"><em>*</em>Curved Lateral Border: </label>	
				<INPUT TYPE="radio" id = "leftCLB1" NAME="leftCLB" path="leftCLB" VALUE="1">1
				<INPUT TYPE="radio" id = "leftCLB2" NAME="leftCLB" path="leftCLB" VALUE="2">0.5
				<INPUT TYPE="radio" id = "leftCLB3" NAME="leftCLB" path="leftCLB" VALUE="0">0	
			</fieldset>
			
			<!--
			<fieldset>
				<label for = "leftTreatment"><em>*</em>Treatment: </label>	
				<INPUT TYPE="radio" id = "LT1" NAME="leftTreatment" path="leftTreatment" onClick = "noneLeftTrue()" VALUE="None">None
				<INPUT TYPE="radio" id = "LT2" NAME="leftTreatment" path="leftTreatment" onClick = "castingLeftTrue()"VALUE="C - Manipulation & Casting">C - Manipulation & Casting
				<INPUT TYPE="radio" id = "LT3" NAME="leftTreatment" path="leftTreatment" onClick = "tenotomyLeftTrue()" VALUE="T - Tenotomy">T - Tenotomy
				<INPUT TYPE="radio" id = "LT4" NAME="leftTreatment" path="leftTreatment" onClick = "braceLeftTrue()" VALUE="B - Brace Application">B - Brace Application
				<INPUT TYPE="radio" id = "LT5" NAME="leftTreatment" path="leftTreatment" onClick = "referLeftTrue()" VALUE="R - Refer">R - Refer
				<INPUT TYPE="radio" id = "LT6" NAME="leftTreatment" path="leftTreatment" onClick = "surgeryLeftTrue()" VALUE="S - Surgery">S - Surgery
				<INPUT TYPE="radio" id = "LT7" NAME="leftTreatment" path="leftTreatment" onClick = "otherLeftTrue()" VALUE="O - Other">O - Other<br>
				
				<label for = "casterLeft" id = "casterLeft1">Caster: </label>
	  			<input type="text" name="casterLeft" id = "casterLeft" class="form-control" path="casterLeft" value = "${visit.casterLeft}">
	  			
	  			<label for = "castLeftNum" id = "castLeftNum1">Casting Number: </label>
	  			<input type="text" name="castLeftNum" id = "castLeftNum" class="form-control" path="castLeftNum" value = "${visit.castLeftNum}">
	  			
	  			<label for = "abductionLeft" id = "abductionLeft1">Degrees abduction: </label>
	  			<input type="text" name="abductionLeft" id = "abductionLeft" class="form-control" path="abductionLeft" value = "${visit.abductionLeft}">
	  			
	  			<label for = "dorsiflexionLeft" id = "dorsiflexionLeft1">Degrees dorsiflexion: </label>
	  			<input type="text" name="dorsiflexionLeft" id = "dorsiflexionLeft" class="form-control" path="dorsiflexionLeft" value = "${visit.dorsiflexionLeft}">
	  			
	  			<label for = "braceLeft" id = "braceLeft1"><em>*</em>Brace Compliance: </label> 
  				<select name="braceLeft" id = "braceLeft" >
  					<option value="Unspecified" path="braceLeft">Unspecified</option>
			  		<option value="Good" path="braceLeft">Good</option>
			  		<option value="Fair" path="braceLeft">Fair</option>
			  		<option value="Poor" path="braceLeft">Poor</option>
			  		<option value="None" path="braceLeft">None</option>
			  	</select><br>
	  			
	  			<label for = "problemsLeft" id = "problemsLeft1">Problems: </label>
	  			<input type="text" name="problemsLeft" id = "problemsLeft" class="form-control" path="problemsLeft" value = "${visit.problemsLeft}">
	  			
	  			<label for = "actionsLeft" id = "actionsLeft1">Actions: </label>
	  			<input type="text" name="actionsLeft" id = "actionsLeft" class="form-control" path="actionsLeft" value = "${visit.actionsLeft}">
	  			
	  			<label for = "otherLeft" id = "otherLeft1"><em>*</em>Please give details: </label>
	  			<input type="text" name="otherLeft" id = "otherLeft" class="form-control" path="otherLeft" value = "${visit.otherLeft}" >
	  			
	  			<div class = "surgeryLeftClass">
		  			<label for = "surgeryLeft" id = "surgeryLeft1"><em>*</em>Surgery Type: </label>	
					<INPUT TYPE="radio" id = "SL1" NAME="surgeryLeft"  path="surgeryLeft" VALUE="Posterior Release">Posterior Release
					<INPUT TYPE="radio" id = "SL2" NAME="surgeryLeft"  path="surgeryLeft" VALUE="Medial Release">Medial Release
					<INPUT TYPE="radio" id = "SL3" NAME="surgeryLeft"  path="surgeryLeft" VALUE="Subtalar Release">Subtalar Release
					<INPUT TYPE="radio" id = "SL4" NAME="surgeryLeft"  path="surgeryLeft" VALUE="Plantar Release">Plantar Release
					<INPUT TYPE="radio" id = "SL5" NAME="surgeryLeft"  path="surgeryLeft" VALUE="Achilles Lengthening ">Achilles Lengthening 
					<INPUT TYPE="radio" id = "SL6" NAME="surgeryLeft"  path="surgeryLeft" VALUE="Tendon Transfers">Tendon Transfers
					<INPUT TYPE="radio" id = "SL7" NAME="surgeryLeft"  path="surgeryLeft" VALUE="Osteotomies">Osteotomies
					<INPUT TYPE="radio" id = "SL8" NAME="surgeryLeft"  path="surgeryLeft" VALUE="Arthrodesis">Arthrodesis
					<INPUT TYPE="radio" id = "SL9" NAME="surgeryLeft"  path="surgeryLeft" VALUE="Talectomy">Talectomy	
					<INPUT TYPE="radio" id = "SL10" NAME="surgeryLeft"  path="surgeryLeft" VALUE="Other">Other<br>	
					<label for = "leftSurgeryComments" >Surgery Comments: </label>
		  			<input type="text" name="leftSurgeryComments" id = "leftSurgeryComments" class="form-control" path="leftSurgeryComments" value = "${visit.leftSurgeryComments}">	
			    </div>
	  		</fieldset>
	  		-->
		</div>
		
		
		<div class = "form-group">
			<!-- <button class='toggle'>Hide Right Foot</button> -->
			<fieldset> 
				<legend>Right Foot</legend>
				
				<label for = "hindfootRightVarus">Varus: </label>
				<INPUT TYPE="radio" id = "hindfootRightVarusVarus" NAME="hindfootRightVarus" path="hindfootRightVarus" VALUE="1">Varus
				<INPUT TYPE="radio" id = "hindfootRightVarusNeutral" NAME="hindfootRightVarus" path="hindfootRightVarus" VALUE="2">Neutral
				<INPUT TYPE="radio" id = "hindfootRightVarusValgus" NAME="hindfootRightVarus" path="hindfootRightVarus" VALUE="3">Valgus
				<INPUT TYPE="radio" id = "hindfootRightVarusNA" NAME="hindfootRightVarus" path="hindfootRightVarus" VALUE="0">Not Assessed<br>
		  	
		  		<label for = "hindfootRightCavus">Cavus: </label>
				<INPUT TYPE="radio" id="hindfootRightCavusP" NAME="hindfootRightCavus" path="hindfootRightCavus" VALUE="1">Present
				<INPUT TYPE="radio" id="hindfootRightCavusC" NAME="hindfootRightCavus" path="hindfootRightCavus" VALUE="2">Corrected
				<INPUT TYPE="radio" id="hindfootRightCavusNA" NAME="hindfootRightCavus" path="hindfootRightCavus" VALUE="0">Not Assessed<br>
		  		
		  		<label for = "hindfootRightAbductus">Abductus ° (-30 to 70): </label>
		  		<input type="text" name="hindfootRightAbductus" class="form-control" path="hindfootRightAbductus" value = "${visit.hindfootRightAbductus}">
		  		<label for="hindfootRightEquinus">Equinus ° (-50 to 30): </label>
				<input type="text" name="hindfootRightEquinus" id="hindfootRightEquinus" class="form-control" path="hindfootRightEquinus" value = "${visit.hindfootRightEquinus}"> 
	  		</fieldset>
	  		
	  		<fieldset>
				<legend> Pirani Scores (Hindfoot) </legend>
				
				<label for = "rightPC"><em>*</em>Posterior crease: </label>
				<INPUT TYPE="radio" id = "rightPC1" NAME="rightPC" path="rightPC" VALUE="1">1
				<INPUT TYPE="radio" id = "rightPC2" NAME="rightPC" path="rightPC" VALUE="2">0.5
				<INPUT TYPE="radio" id = "rightPC3" NAME="rightPC" path="rightPC" VALUE="0">0<br>
	  			
	  			<label for = "rightEH"><em>*</em>Empty Heel: </label>	
				<INPUT TYPE="radio" id = "rightEH1" NAME="rightEH" path="rightEH" VALUE="1">1
				<INPUT TYPE="radio" id = "rightEH2" NAME="rightEH" path="rightEH" VALUE="2">0.5
				<INPUT TYPE="radio" id = "rightEH3" NAME="rightEH" path="rightEH" VALUE="0">0<br>
	  	
	  			<label for = "rightRE"><em>*</em>Rigid equinus: </label>	
				<INPUT TYPE="radio" id = "rightRE1" NAME="rightRE" path="rightRE" VALUE="1">1
				<INPUT TYPE="radio" id = "rightRE2" NAME="rightRE" path="rightRE" VALUE="2">0.5
				<INPUT TYPE="radio" id = "rightRE3" NAME="rightRE" path="rightRE" VALUE="0">0	
			</fieldset>
			
			<fieldset>
				<legend> Pirani Scores (Midfoot) </legend>
			
				<label for = "rightMC"><em>*</em>Medial Crease: </label>
				<INPUT TYPE="radio" id = "rightMC1" NAME="rightMC" path="rightMC" VALUE="1">1
				<INPUT TYPE="radio" id = "rightMC2" NAME="rightMC" path="rightMC" VALUE="2">0.5
				<INPUT TYPE="radio" id = "rightMC3" NAME="rightMC" path="rightMC" VALUE="0">0<br>
	  			
	  			<label for = "rightTHC"><em>*</em>Talar Head Coverage: </label>	
				<INPUT TYPE="radio" id = "rightTHC1" NAME="rightTHC" path="rightTHC" VALUE="1">1
				<INPUT TYPE="radio" id = "rightTHC2" NAME="rightTHC" path="rightTHC" VALUE="2">0.5
				<INPUT TYPE="radio" id = "rightTHC3" NAME="rightTHC" path="rightTHC" VALUE="0">0<br>
	  	
	  			<label for = "rightCLB"><em>*</em>Curved Lateral Border: </label>	
				<INPUT TYPE="radio" id = "rightCLB1" NAME="rightCLB" path="rightCLB" VALUE="1">1
				<INPUT TYPE="radio" id = "rightCLB2" NAME="rightCLB" path="rightCLB" VALUE="2">0.5
				<INPUT TYPE="radio" id = "rightCLB3" NAME="rightCLB" path="rightCLB" VALUE="0">0	
			</fieldset>
			
			<!--
			<fieldset>
				<label for = "rightTreatment"><em>*</em>Treatment: </label>	
				<INPUT TYPE="radio" id = "RT1" NAME="rightTreatment" path="rightTreatment" onClick = "noneRightTrue()" VALUE="none">None
				<INPUT TYPE="radio" id = "RT2" NAME="rightTreatment" path="rightTreatment" onClick = "castingRightTrue()"VALUE="C - Manipulation & Casting">C - Manipulation & Casting
				<INPUT TYPE="radio" id = "RT3" NAME="rightTreatment" path="rightTreatment" onClick = "tenotomyRightTrue()" VALUE="T - Tenotomy">T - Tenotomy
				<INPUT TYPE="radio" id = "RT4" NAME="rightTreatment" path="rightTreatment" onClick = "braceRightTrue()" VALUE="B - Brace Application">B - Brace Application
				<INPUT TYPE="radio" id = "RT5" NAME="rightTreatment" path="rightTreatment" onClick = "referRightTrue()" VALUE="R - Refer">R - Refer
				<INPUT TYPE="radio" id = "RT6" NAME="rightTreatment" path="rightTreatment" onClick = "surgeryRightTrue()" VALUE="S-Surgery">S - Surgery
				<INPUT TYPE="radio" id = "RT7" NAME="rightTreatment" path="rightTreatment" onClick = "otherRightTrue()" VALUE="O-Other">O - Other<br>
				<label for = "casterRight" id = "casterRight1">Caster: </label>
	  			<input type="text" name="casterRight" id = "casterRight" class="form-control" path="casterRight" value = "${visit.casterRight}">
	  			<label for = "castRightNum" id = "castRightNum1">Casting Number: </label>
	  			<input type="text" name="castRightNum" id = "castRightNum" class="form-control" path="castRightNum" value = "${visit.castRightNum}">
	  			<label for = "abductionRight" id = "abductionRight1">Degrees abduction: </label>
	  			<input type="text" name="abductionRight" id = "abductionRight" class="form-control" path="abductionRight" value = "${visit.abductionRight}">
	  			<label for = "dorsiflexionRight" id = "dorsiflexionRight1">Degrees dorsiflexion: </label>
	  			<input type="text" name="dorsiflexionRight" id = "dorsiflexionRight" class="form-control" path="dorsiflexionRight" value = "${visit.dorsiflexionRight}">
	  			<label for = "braceRight" id = "braceRight1"><em>*</em>Brace Compliance: </label> 
	  				<select name="braceRight" id = "braceRight" >
	  					<option value="unspecified" path="braceRight"> Unspecified </option>
				  		<option value="good" path="braceRight"> Good </option>
				  		<option value="fair" path="braceRight"> Fair </option>
				  		<option value="poor" path="braceRight"> Poor </option>
				  		<option value="none" path="braceRight"> None </option>
				  	</select><br>
	  			<label for = "problemsRight" id = "problemsRight1">Problems: </label>
	  			<input type="text" name="problemsRight" id = "problemsRight" class="form-control" path="problemsRight" value = "${visit.problemsRight}">
	  			<label for = "actionsRight" id = "actionsRight1">Degrees dorsiflexion: </label>
	  			<input type="text" name="actionsRight" id = "actionsRight" class="form-control" path="actionsRight" value = "${visit.actionsRight}">
	  			<label for = "otherRight" id = "otherRight1"><em>*</em>Please give detials: </label>
	  			<input type="text" name="otherRight" id = "otherRight" class="form-control" path="otherRight" value = "${visit.otherRight}">
	  			<div class = "surgeryRightClass">
		  			<label for = "surgeryRight" id = "surgeryRight1"><em>*</em>Surgery Type: </label>	
					<INPUT TYPE="radio" id = "SR1" NAME="surgeryRight"  path="surgeryRight" VALUE="Posterior Release">Posterior Release
					<INPUT TYPE="radio" id = "SR2" NAME="surgeryRight"  path="surgeryRight" VALUE="Medial Release">Medial Release
					<INPUT TYPE="radio" id = "SR3" NAME="surgeryRight"  path="surgeryRight" VALUE="Subtalar Release">Subtalar Release
					<INPUT TYPE="radio" id = "SR4" NAME="surgeryRight"  path="surgeryRight" VALUE="Plantar Release">Plantar Release
					<INPUT TYPE="radio" id = "SR5" NAME="surgeryRight"  path="surgeryRight" VALUE="Achilles Lengthening ">Achilles Lengthening 
					<INPUT TYPE="radio" id = "SR6" NAME="surgeryRight"  path="surgeryRight" VALUE="Tendon Transfers">Tendon Transfers
					<INPUT TYPE="radio" id = "SR7" NAME="surgeryRight"  path="surgeryRight" VALUE="Osteotomies">Osteotomies
					<INPUT TYPE="radio" id = "SR8" NAME="surgeryRight"  path="surgeryRight" VALUE="Arthrodesis">Arthrodesis
					<INPUT TYPE="radio" id = "SR9" NAME="surgeryRight"  path="surgeryRight" VALUE="Talectomy">Talectomy	
					<INPUT TYPE="radio" id = "SR10" NAME="surgeryRight"  path="surgeryRight" VALUE="Other">Other<br>	
					<label for = "rightSurgeryComments" >Surgery Comments: </label>
		  			<input type="text" name="rightSurgeryComments" id = "rightSurgeryComments" class="form-control" path="rightSurgeryComments" value = "${visit.rightSurgeryComments}">	
			    </div>
			</fieldset>
			-->
		</div>
	
		<div class = "form-group">
			<fieldset>
				<legend>Complications</legend>
				
				<label for = "complications"><em>*</em>Were there any complications? </label>	
				<INPUT TYPE="radio" id = "compNo" NAME="complications" path="complications" onClick = "complicationsFalse()"VALUE="No">No
				<INPUT TYPE="radio" id = "compYes" NAME="complications" path="complications" onClick = "complicationsTrue()" VALUE="Yes">Yes
				<INPUT TYPE="radio" id = "compUn" NAME="complications" path="complications" onClick = "complicationsFalse()" VALUE="Unspecified">Unspecified<br>
				
				<label for = "description" id = "description1"><em>*</em>Description of complication(s): </label>
	  			<input type="text" name="description" id = "description" class="form-control" path="description" value = "${visit.description}">
	  			
	  			<label for = "treatmentComplications" id = "treatmentComplications1"><em>*</em>Treatment of complication(s): </label>
	  			<input type="text" name="treatmentComplications" id = "treatmentComplications" class="form-control" path="treatmentComplications" value = "${visit.treatmentComplications}">
	  			
	  			<label for = "results" id = "results1">Results after treatment: </label>
	  			<input type="text" name="results" id = "results" class="form-control" path="results" value = "${visit.results}">	
			</fieldset>
		</div>
	
		<div class = "form-group">
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
		</div>
		
		<div class = "form-group">
			<label for="comments">Comments: </label>
			<textarea id="comments" name = "comments" class = "form-control" path = "comments" value = "${visit.comments}"></textarea><br>
			<!-- <input type="text" name="comments" class="form-control" path="comments"> <br>-->
		</div>
	
		<div class="row" align="center">
			<button type="submit" class="btn btn-lg btn-primary">Submit Form</button>
			<button type="reset" class="btn btn-lg btn-default">Clear</button>
		</div>
	</form>
</div>
</div>
</div>

</body>
</html>