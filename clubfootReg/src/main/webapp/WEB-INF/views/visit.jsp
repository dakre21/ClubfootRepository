<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html"; charset=ISO-8859-1">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- Latest compiled and minified JavaScript -->
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<title>Clubfoot Registry | Add Visit</title>
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
	  $('#dateOfNextVisit').hide();
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
	  $('#dateOfNextVisit').hide();
	  $('#dateOfNextVisit1').hide();
  }
  function lastVisitFalse(){
	  $('#dateOfNextVisit').show();
	  $('#dateOfNextVisit1').show();
  }
  </script>
<div class="container">
		<nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="/clubfootReg/home">Clubfoot Registry</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li><a href="signup" class="btn btn-lg btn-mini">Sign up for an account</a></li>
        <li><a href="login" class="btn btn-lg btn-mini">Log in</a></li>
        <li><a href="<c:url value="/j_spring_security_logout"/>" class="btn btn-lg btn-mini">Log out</a></li>
      </ul>
      <form class="navbar-form navbar-left" role="search">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Search the registry">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
      </form>
      <ul class="nav navbar-nav navbar-right">
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="true">Form information <span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
            <li><a href="newpatient">Add new patient</a></li>
            <li><a href="evaluator">Add evaluator</a></li>
            <li><a href="hospital">Add hospital</a></li>
            <li><a href="adduser">Add user</a></li>
            <li><a href="visit">Add visit</a></li>
          </ul>
        </li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
</div>
</head>

<body>
<div class="container">
	<div class="row clearfix">
	<div class="col-sm-2 column"></div>
	<div class="col-md-8 column">

<body>
<h1>
    Add Visit
</h1>

<form action="#" th:action="@{/visit}" th:object="${visit}" modelAttribute="Visit" id="Visit" method="post">
	<input type = "hidden" name = "submitted" value = "true" />
		<div class = "form-group">
		<p><i>Please complete the form. Mandatory fields are marked with a </i><em>*</em></p>
		
		<label for = "hospital"><em>*</em>Hospital/Clinic: </label> 
  		<select name="hospital" required>
	  		<option value="test_hospital1" path="hospitalName"> Test Hospital 1 </option>
	  		<option value="test_hospital2" path="hospitalName"> Test Hospital 2 </option>
	  		<option value="test_hospital3" path="hospitalName"> Test Hospital 3 </option>
	  		<option value="test_hospital4" path="hospitalName"> Test Hospital 4 </option>
	  	</select><br>
  		<label for = "evaluatorName"><em>*</em>Name of Evaluator:</label>
  		<input type="text" name="evaluatorName" class="form-control" path="evaluatorName" required> <a href="evaluator">Add evaluator</a> <br>
  		<label for="dateOfVisit"><em>*</em>Date of visit: </label>
		<input type="date" name="dateOfVisit" id="dateOfVisit" class="form-control" path="dateOfVisit" placeholder="dd/mm/yyyy" required  validate pattern="\d{1,2}/\d{1,2}/\d{4}" title="dd/mm/yyyy"> 
  		<label for="dateOfNextVist" id = "dateOfNextVisit1"><em>*</em>Date of next visit: </label>
		<input type="date" name="dateOfNextVisit" id="dateOfNextVisit" class="form-control" path="dateOfNextVisit" placeholder="dd/mm/yyyy" required  validate pattern="\d{1,2}/\d{1,2}/\d{4}" title="dd/mm/yyyy"> 
  
  	
  	<label for = "finalTreatment">Is this the patient's final treatment visit? </label>
	<INPUT TYPE="radio" NAME="finalTreatment" path="finalTreatment" onClick = "lastVisitTrue()" VALUE="yes_final_treatment">Yes
	<INPUT TYPE="radio" NAME="finalTreatment" path="finalTreatment" onClick = "lastVisitFalse()" VALUE="no_not_final_treatment">No
	<INPUT TYPE="radio" NAME="finalTreatment" path="finalTreatment" onClick = "lastVisitFalse()" VALUE="unspecified_final_treatment">Unspecified<br>
 
  	<label for = "finalTreatment">Did the patient experience a relapse? </label>
  	
	<INPUT TYPE="radio" NAME="relapse" path="relapse" VALUE="yes_relapse">Yes
	<INPUT TYPE="radio" NAME="relapse" path="relapse" VALUE="no_relapse">No
	<INPUT TYPE="radio" NAME="relapse" path="relapse" VALUE="unspecified_relapse">Unspecified<br>
	
	</div>
	<div class = "form-group">
	<!--  <button class='toggle'>Hide Left Foot</button>-->
 	<fieldset>
		<legend>Left Foot</legend>
		<label for = "hindfootLeftVarus">Varus: </label>
		Varus:
		<INPUT TYPE="radio" NAME="hindfootLeftVarus" path="hindfootLeftVarus" VALUE="varus">Varus
		<INPUT TYPE="radio" NAME="hindfootLeftVarus" path="hindfootLeftVarus" VALUE="neutral">Neutral
		<INPUT TYPE="radio" NAME="hindfootLeftVarus" path="hindfootLeftVarus" VALUE="valgus">Valgus
		<INPUT TYPE="radio" NAME="hindfootLeftVarus" path="hindfootLeftVarus" VALUE="notAssessed">Not Assessed<br>
  	
  		<label for = "hindfootLeftCavus">Cavus: </label>
		<INPUT TYPE="radio" NAME="hindfootLeftCavus" path="hindfootLeftCavus" VALUE="present">Present
		<INPUT TYPE="radio" NAME="hindfootLeftCavus" path="hindfootLeftCavus" VALUE="corrected">Corrected
		<INPUT TYPE="radio" NAME="hindfootLeftCavus" path="hindfootLeftCavus" VALUE="notAssessed">Not Assessed<br>
  		
  		<label for = "hindfootLeftAbductus">Abductus ° (-30 to 70): </label>
  		<input type="text" name="hindfootLeftAbductus" class="form-control" path="hindfootLeftAbductus">
  		<label for="hindfootLeftEquinus">Equinus ° (-50 to 30): </label>
		<input type="text" name="hindfootLeftEquinus" id="hindfootLeftEquinus" class="form-control" path="hindfootLeftEquinus"> 
  
  		<fieldset>
			<legend> Pirani Scores (Hindfoot) </legend>
			<label for = "hindfootLeftPosterior"><em>*</em>Posterior creaase: </label>
  			
			<INPUT TYPE="radio" NAME="hindfootLeftPosterior" path="hindfootLeftPosterior" VALUE="1">1
			<INPUT TYPE="radio" NAME="hindfootLeftPosterior" path="hindfootLeftPosterior" VALUE="0.5">0.5
			<INPUT TYPE="radio" NAME="hindfootLeftPosterior" path="hindfootLeftPosterior" VALUE="0">0<br>
  			
  			<label for = "hindfootLeftHeel"><em>*</em>Empty Heel: </label>	
			<INPUT TYPE="radio" NAME="hindfootLeftHeel" path="hindfootLeftHeel" VALUE="1">1
			<INPUT TYPE="radio" NAME="hindfootLeftHeel" path="hindfootLeftHeel" VALUE="0.5">0.5
			<INPUT TYPE="radio" NAME="hindfootLeftHeel" path="hindfootLeftHeel" VALUE="0">0<br>
  	
  			 <label for = "hindfootLeftEquinus"><em>*</em>Rigid equinus: </label>	
  			 Rigid equinus
			<INPUT TYPE="radio" NAME="hindfootLeftEquinus" path="hindfootLeftEquinus" VALUE="1">1
			<INPUT TYPE="radio" NAME="hindfootLeftEquinus" path="hindfootLeftEquinus" VALUE="0.5">0.5
			<INPUT TYPE="radio" NAME="hindfootLeftEquinus" path="hindfootLeftEquinus" VALUE="0">0	
		</fieldset>
		
		<fieldset>
			<legend> Pirani Scores (Midfoot) </legend>
		
			<label for = "midfootLeftMedial"><em>*</em>Medial Crease: </label>
			<INPUT TYPE="radio" NAME="midfootLeftMedial" path="midfootLeftMedial" VALUE="1">1
			<INPUT TYPE="radio" NAME="midfootLeftMedial" path="midfootLeftMedial" VALUE="0.5">0.5
			<INPUT TYPE="radio" NAME="midfootLeftMedial" path="midfootLeftMedial" VALUE="0">0<br>
  			
  			<label for = "midfootLeftTalar"><em>*</em>Talar Head Coverage: </label>	
			<INPUT TYPE="radio" NAME="midfootLeftTalar" path="midfootLeftTalar" VALUE="1">1
			<INPUT TYPE="radio" NAME="midfootLeftTalar" path="midfootLeftTalar" VALUE="0.5">0.5
			<INPUT TYPE="radio" NAME="midfootLeftTalar" path="midfootLeftTalar" VALUE="0">0<br>
  	
  			<label for = "midfootLeftLateral"><em>*</em>Curved Lateral Border: </label>	
			<INPUT TYPE="radio" NAME="midfootLeftLateral" path="midfootLeftLateral" VALUE="1">1
			<INPUT TYPE="radio" NAME="midfootLeftLateral" path="midfootLeftLateral" VALUE="0.5">0.5
			<INPUT TYPE="radio" NAME="midfootLeftLateral" path="midfootLeftLateral" VALUE="0">0	
		</fieldset>
		
		<legend></legend>
			<label for = "leftTreatment"><em>*</em>Treatment: </label>	
			<INPUT TYPE="radio" NAME="leftTreatment" path="leftTreatment" onClick = "noneLeftTrue()" VALUE="none">None
			<INPUT TYPE="radio" NAME="leftTreatment" path="leftTreatment" onClick = "castingLeftTrue()"VALUE="C - Manipulation & Casting">C - Manipulation & Casting
			<INPUT TYPE="radio" NAME="leftTreatment" path="leftTreatment" onClick = "tenotomyLeftTrue()" VALUE="T - Tenotomy">T - Tenotomy
			<INPUT TYPE="radio" NAME="leftTreatment" path="leftTreatment" onClick = "braceLeftTrue()" VALUE="B - Brace Application">B - Brace Application
			<INPUT TYPE="radio" NAME="leftTreatment" path="leftTreatment" onClick = "referLeftTrue()" VALUE="R - Refer">R - Refer
			<INPUT TYPE="radio" NAME="leftTreatment" path="leftTreatment" onClick = "surgeryLeftTrue()" VALUE="S-Surgery">S - Surgery
			<INPUT TYPE="radio" NAME="leftTreatment" path="leftTreatment" onClick = "otherLeftTrue()" VALUE="O-Other">O - Other<br>
			<label for = "casterLeft" id = "casterLeft1">Caster: </label>
  			<input type="text" name="casterLeft" id = "casterLeft" class="form-control" path="casterLeft">
  			<label for = "castLeftNum" id = "castLeftNum1">Casting Number: </label>
  			<input type="text" name="castLeftNum" id = "castLeftNum" class="form-control" path="castLeftNum">
  			<label for = "abductionLeft" id = "abductionLeft1">Degrees abduction: </label>
  			<input type="text" name="abductionLeft" id = "abductionLeft" class="form-control" path="abductionLeft">
  			<label for = "dorsiflexionLeft" id = "dorsiflexionLeft1">Degrees dorsiflexion: </label>
  			<input type="text" name="dorsiflexionLeft" id = "dorsiflexionLeft" class="form-control" path="dorsiflexionLeft">
  			<label for = "braceLeft" id = "braceLeft1"><em>*</em>Brace Compliance: </label> 
  				<select name="braceLeft" id = "braceLeft" required>
  					<option value="unspecified" path="brace"> Unspecified </option>
			  		<option value="good" path="braceLeft"> Good </option>
			  		<option value="fair" path="braceLeft"> Fair </option>
			  		<option value="poor" path="braceLeft"> Poor </option>
			  		<option value="none" path="braceLeft"> None </option>
			  	</select><br>
  			<label for = "problemsLeft" id = "problemsLeft1">Problems: </label>
  			<input type="text" name="problemsLeft" id = "problemsLeft" class="form-control" path="problemsLeft">
  			<label for = "actionsLeft" id = "actionsLeft1">Degrees dorsiflexion: </label>
  			<input type="text" name="actionsLeft" id = "actionsLeft" class="form-control" path="actionsLeft">
  			<label for = "otherLeft" id = "otherLeft1"><em>*</em>Please give detials: </label>
  			<input type="text" name="otherLeft" id = "otherLeft" class="form-control" path="otherLeft" required>
  			<div class = "surgeryLeftClass">
	  			<label for = "surgeryLeft" id = "surgeryLeft1"><em>*</em>Surgery Type: </label>	
				<INPUT TYPE="radio" NAME="surgeryLeft"  path="surgeryLeft" VALUE="Posterior Release">Posterior Release
				<INPUT TYPE="radio" NAME="surgeryLeft"  path="surgeryLeft" VALUE="Medial Release">Medial Release
				<INPUT TYPE="radio" NAME="surgeryLeft"  path="surgeryLeft" VALUE="Subtalar Release">Subtalar Release
				<INPUT TYPE="radio" NAME="surgeryLeft"  path="surgeryLeft" VALUE="Plantar Release">Plantar Release
				<INPUT TYPE="radio" NAME="surgeryLeft"  path="surgeryLeft" VALUE="Achilles Lengthening ">Achilles Lengthening 
				<INPUT TYPE="radio" NAME="surgeryLeft"  path="surgeryLeft" VALUE="Tendon Transfers">Tendon Transfers
				<INPUT TYPE="radio" NAME="surgeryLeft"  path="surgeryLeft" VALUE="Osteotomies">Osteotomies
				<INPUT TYPE="radio" NAME="surgeryLeft"  path="surgeryLeft" VALUE="Arthrodesis">Arthrodesis
				<INPUT TYPE="radio" NAME="surgeryLeft"  path="surgeryLeft" VALUE="Talectomy">Talectomy	
				<INPUT TYPE="radio" NAME="surgeryLeft"  path="surgeryLeft" VALUE="Other">Other<br>	
				<label for = "leftSurgeryComments" >Surgery Comments: </label>
	  			<input type="text" name="leftSurgeryComments" id = "leftSurgeryComments" class="form-control" path="leftSurgeryComments">	
		   </div>
  			
  		
  		
			</fieldset>
	</div>
	
	<div class = "form-group">
		<!-- <button class='toggle'>Hide Right Foot</button> -->
		<fieldset> 
		<legend>Right Foot</legend>
		
		<label for = "hindfootRightVarus">Varus: </label>
		Varus:
		<INPUT TYPE="radio" NAME="hindfootRightVarus" path="hindfootRightVarus" VALUE="varus">Varus
		<INPUT TYPE="radio" NAME="hindfootRightVarus" path="hindfootRightVarus" VALUE="neutral">Neutral
		<INPUT TYPE="radio" NAME="hindfootRightVarus" path="hindfootRightVarus" VALUE="valgus">Valgus
		<INPUT TYPE="radio" NAME="hindfootRightVarus" path="hindfootRightVarus" VALUE="notAssessed">Not Assessed<br>
  	
  		<label for = "hindfootRightCavus">Cavus: </label>
		<INPUT TYPE="radio" NAME="hindfootRightCavus" path="hindfootRightCavus" VALUE="present">Present
		<INPUT TYPE="radio" NAME="hindfootRightCavus" path="hindfootRightCavus" VALUE="corrected">Corrected
		<INPUT TYPE="radio" NAME="hindfootRightCavus" path="hindfootRightCavus" VALUE="notAssessed">Not Assessed<br>
  		
  		<label for = "hindfootRightAbductus">Abductus ° (-30 to 70): </label>
  		<input type="text" name="hindfootRightAbductus" class="form-control" path="hindfootRightAbductus">
  		<label for="hindfootRightEquinus">Equinus ° (-50 to 30): </label>
		<input type="text" name="hindfootRightEquinus" id="hindfootRightEquinus" class="form-control" path="hindfootRightEquinus"> 
  		
  		<fieldset>
			<legend> Pirani Scores (Hindfoot) </legend>
			<label for = "hindfootRightPosterior"><em>*</em>Posterior creaase: </label>
  			
			<INPUT TYPE="radio" NAME="hindfootRightPosterior" path="hindfootRightPosterior" VALUE="1">1
			<INPUT TYPE="radio" NAME="hindfootRightPosterior" path="hindfootRightPosterior" VALUE="0.5">0.5
			<INPUT TYPE="radio" NAME="hindfootRightPosterior" path="hindfootRightPosterior" VALUE="0">0<br>
  			
  			<label for = "hindfootRightHeel"><em>*</em>Empty Heel: </label>	
			<INPUT TYPE="radio" NAME="hindfootRightHeel" path="hindfootRightHeel" VALUE="1">1
			<INPUT TYPE="radio" NAME="hindfootRightHeel" path="hindfootRightHeel" VALUE="0.5">0.5
			<INPUT TYPE="radio" NAME="hindfootRightHeel" path="hindfootRightHeel" VALUE="0">0<br>
  	
  			 <label for = "hindfootRightEquinus"><em>*</em>Rigid equinus: </label>	
  			 Rigid equinus
			<INPUT TYPE="radio" NAME="hindfootRightEquinus" path="hindfootRightEquinus" VALUE="1">1
			<INPUT TYPE="radio" NAME="hindfootRightEquinus" path="hindfootRightEquinus" VALUE="0.5">0.5
			<INPUT TYPE="radio" NAME="hindfootRightEquinus" path="hindfootRightEquinus" VALUE="0">0	
		</fieldset>
		
		<fieldset>
			<legend> Pirani Scores (Midfoot) </legend>
		
			<label for = "midfootRightMedial"><em>*</em>Medial Crease: </label>
			<INPUT TYPE="radio" NAME="midfootRightMedial" path="midfootRightMedial" VALUE="1">1
			<INPUT TYPE="radio" NAME="midfootRightMedial" path="midfootRightMedial" VALUE="0.5">0.5
			<INPUT TYPE="radio" NAME="midfootRightMedial" path="midfootRightMedial" VALUE="0">0<br>
  			
  			<label for = "midfootRightTalar"><em>*</em>Talar Head Coverage: </label>	
			<INPUT TYPE="radio" NAME="midfootRightTalar" path="midfootRightTalar" VALUE="1">1
			<INPUT TYPE="radio" NAME="midfootRightTalar" path="midfootRightTalar" VALUE="0.5">0.5
			<INPUT TYPE="radio" NAME="midfootRightTalar" path="midfootRightTalar" VALUE="0">0<br>
  	
  			<label for = "midfootRightLateral"><em>*</em>Curved Lateral Border: </label>	
			<INPUT TYPE="radio" NAME="midfootRightLateral" path="midfootRightLateral" VALUE="1">1
			<INPUT TYPE="radio" NAME="midfootRightLateral" path="midfootRightLateral" VALUE="0.5">0.5
			<INPUT TYPE="radio" NAME="midfootRightLateral" path="midfootRightLateral" VALUE="0">0	
		</fieldset>
		
		
		<legend></legend>
			<label for = "rightTreatment"><em>*</em>Treatment: </label>	
			<INPUT TYPE="radio" NAME="rightTreatment" path="rightTreatment" onClick = "noneRightTrue()" VALUE="none">None
			<INPUT TYPE="radio" NAME="rightTreatment" path="rightTreatment" onClick = "castingRightTrue()"VALUE="C - Manipulation & Casting">C - Manipulation & Casting
			<INPUT TYPE="radio" NAME="rightTreatment" path="rightTreatment" onClick = "tenotomyRightTrue()" VALUE="T - Tenotomy">T - Tenotomy
			<INPUT TYPE="radio" NAME="rightTreatment" path="rightTreatment" onClick = "braceRightTrue()" VALUE="B - Brace Application">B - Brace Application
			<INPUT TYPE="radio" NAME="rightTreatment" path="rightTreatment" onClick = "referRightTrue()" VALUE="R - Refer">R - Refer
			<INPUT TYPE="radio" NAME="rightTreatment" path="rightTreatment" onClick = "surgeryRightTrue()" VALUE="S-Surgery">S - Surgery
			<INPUT TYPE="radio" NAME="rightTreatment" path="rightTreatment" onClick = "otherRightTrue()" VALUE="O-Other">O - Other<br>
			<label for = "casterRight" id = "casterRight1">Caster: </label>
  			<input type="text" name="casterRight" id = "casterRight" class="form-control" path="casterRight">
  			<label for = "castRightNum" id = "castRightNum1">Casting Number: </label>
  			<input type="text" name="castRightNum" id = "castRightNum" class="form-control" path="castRightNum">
  			<label for = "abductionRight" id = "abductionRight1">Degrees abduction: </label>
  			<input type="text" name="abductionRight" id = "abductionRight" class="form-control" path="abductionRight">
  			<label for = "dorsiflexionRight" id = "dorsiflexionRight1">Degrees dorsiflexion: </label>
  			<input type="text" name="dorsiflexionRight" id = "dorsiflexionRight" class="form-control" path="dorsiflexionRight">
  			<label for = "braceRight" id = "braceRight1"><em>*</em>Brace Compliance: </label> 
  				<select name="braceRight" id = "braceRight" required>
  					<option value="unspecified" path="braceRight"> Unspecified </option>
			  		<option value="good" path="braceRight"> Good </option>
			  		<option value="fair" path="braceRight"> Fair </option>
			  		<option value="poor" path="braceRight"> Poor </option>
			  		<option value="none" path="braceRight"> None </option>
			  	</select><br>
  			<label for = "problemsRight" id = "problemsRight1">Problems: </label>
  			<input type="text" name="problemsRight" id = "problemsRight" class="form-control" path="problemsRight">
  			<label for = "actionsRight" id = "actionsRight1">Degrees dorsiflexion: </label>
  			<input type="text" name="actionsRight" id = "actionsRight" class="form-control" path="actionsRight">
  			<label for = "otherRight" id = "otherRight1"><em>*</em>Please give detials: </label>
  			<input type="text" name="otherRight" id = "otherRight" class="form-control" path="otherRight" required>
  			<div class = "surgeryRightClass">
	  			<label for = "surgeryRight" id = "surgeryRight1"><em>*</em>Surgery Type: </label>	
				<INPUT TYPE="radio" NAME="surgeryRight"  path="surgeryRight" VALUE="Posterior Release">Posterior Release
				<INPUT TYPE="radio" NAME="surgeryRight"  path="surgeryRight" VALUE="Medial Release">Medial Release
				<INPUT TYPE="radio" NAME="surgeryRight"  path="surgeryRight" VALUE="Subtalar Release">Subtalar Release
				<INPUT TYPE="radio" NAME="surgeryRight"  path="surgeryRight" VALUE="Plantar Release">Plantar Release
				<INPUT TYPE="radio" NAME="surgeryRight"  path="surgeryRight" VALUE="Achilles Lengthening ">Achilles Lengthening 
				<INPUT TYPE="radio" NAME="surgeryRight"  path="surgeryRight" VALUE="Tendon Transfers">Tendon Transfers
				<INPUT TYPE="radio" NAME="surgeryRight"  path="surgeryRight" VALUE="Osteotomies">Osteotomies
				<INPUT TYPE="radio" NAME="surgeryRight"  path="surgeryRight" VALUE="Arthrodesis">Arthrodesis
				<INPUT TYPE="radio" NAME="surgeryRight"  path="surgeryRight" VALUE="Talectomy">Talectomy	
				<INPUT TYPE="radio" NAME="surgeryRight"  path="surgeryRight" VALUE="Other">Other<br>	
				<label for = "rightSurgeryComments" >Surgery Comments: </label>
	  			<input type="text" name="rightSurgeryComments" id = "rightSurgeryComments" class="form-control" path="rightSurgeryComments">	
		   </div>
		</fieldset>
	</div>
	
	<div class = "form-group">
		<fieldset>
			<legend>Complications</legend>
				<label for = "complications"><em>*</em>Were there any complications? </label>	
				<INPUT TYPE="radio" NAME="complications" path="complications" onClick = "complicationsFalse()"VALUE="No">No
				<INPUT TYPE="radio" NAME="complications" path="complications" onClick = "complicationsTrue()" VALUE="Yes"5">Yes
				<INPUT TYPE="radio" NAME="complications" path="complications" onClick = "complicationsFalse()" VALUE="Unspecified">Unspecified<br>
				<label for = "description" id = "description1"><em>*</em>Description of complication(s): </label>
	  			<input type="text" name="description" id = "description" class="form-control" path="description">
	  			<label for = "treatmentComplications" id = "treatmentComplications1"><em>*</em>Treatment of complication(s): </label>
	  			<input type="text" name="treatmentComplications" id = "treatmentComplications" class="form-control" path="treatmentComplications">
	  			<label for = "results" id = "results1">Results after treatment: </label>
	  			<input type="text" name="results" id = "results" class="form-control" path="results">	
		</fieldset>
	</div>
	<div class = "form-group">
		<legend>Feet pre-treatments photo(s)</legend>
			<div class="col-md-12">
			<div class="form-group">
			<label for="pre-imgfile">Upload photo of patient here: </label>
			<input type="file" class="btn btn-lg btn-default" name="pre-imgfile" path="pre-imgfile"><br>
			<button type="submit" class="btn btn-lg btn-default" for="add_photo" id="add_photo">Add another photo</button>
			</div>
			</div>
		</div>
	<div class = "form-group">
		<label for="comments">Comments: </label>
		<input type="text" name="comments" class="form-control" path="comments"> <br>
			
	</div>
	<div class="row" align="center">
		<button type="submit" class="btn btn-lg btn-primary">Submit Form</button>
		<button type="reset" class="btn btn-lg btn-default">Clear</button>
</div>
	</div>
	</div>
	</div>
	</div>
</form> 

</body>
</html>