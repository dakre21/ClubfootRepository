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

  }
  function lastVisitTrue(){
	  $('#dateOfNextVisit').hide();
	  $('#dateOfNextVisit1').hide();


  }
  function lastVisitFalse(){
	  $('#dateOfNextVisit').show();
	  $('#dateOfNextVisit1').show();


  }
  <!--$(function(){
      $('button').click(function(){  
              if( $(this).html()=='Hide Right Foot') $(this).html('Hide Right Foot Data');
          $(this).nextAll('fieldset:first').toggle();

          $(this).html()=='Show Right Foot Data'?($(this).html('Hide Right Foot Data')):($(this).html('Show Right Foot Data'));
      });
  })-->
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
			<INPUT TYPE="radio" NAME="leftTreatment" path="leftTreatment" VALUE="none">None
			<INPUT TYPE="radio" NAME="leftTreatment" path="leftTreatment" VALUE="C - Manipulation & Casting">C - Manipulation & Casting
			<INPUT TYPE="radio" NAME="leftTreatment" path="leftTreatment" VALUE="T - Tenotomy">T - Tenotomy
			<INPUT TYPE="radio" NAME="leftTreatment" path="leftTreatment" VALUE="B - Brace Application">B - Brace Application
			<INPUT TYPE="radio" NAME="leftTreatment" path="leftTreatment" VALUE="R - Refer">R - Refer
			<INPUT TYPE="radio" NAME="leftTreatment" path="leftTreatment" VALUE="S-Surgery">S - Surgery
			<INPUT TYPE="radio" NAME="leftTreatment" path="leftTreatment" VALUE="O-Other">O - Other
		
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
			<INPUT TYPE="radio" NAME="rightTreatment" path="rightTreatment" VALUE="none">None
			<INPUT TYPE="radio" NAME="rightTreatment" path="rightTreatment" VALUE="C - Manipulation & Casting">C - Manipulation & Casting
			<INPUT TYPE="radio" NAME="rightTreatment" path="rightTreatment" VALUE="T - Tenotomy">T - Tenotomy
			<INPUT TYPE="radio" NAME="rightTreatment" path="rightTreatment" VALUE="B - Brace Application">B - Brace Application
			<INPUT TYPE="radio" NAME="rightTreatment" path="rightTreatment" VALUE="R - Refer">R - Refer
			<INPUT TYPE="radio" NAME="rightTreatment" path="rightTreatment" VALUE="S-Surgery">S - Surgery
			<INPUT TYPE="radio" NAME="rightTreatment" path="rightTreatment" VALUE="O-Other">O - Other
		</fieldset>
	</div>
	
	<div class = "form-group">
		<fieldset>
			<legend>Complications</legend>
				<label for = "complications"><em>*</em>Were there any complications? </label>	
				<INPUT TYPE="radio" NAME="complications" path="complications" VALUE="No">No
				<INPUT TYPE="radio" NAME="complications" path="complications" VALUE="Yes"5">Yes
				<INPUT TYPE="radio" NAME="complications" path="complications" VALUE="Unspecified">Unspecified<br>	
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