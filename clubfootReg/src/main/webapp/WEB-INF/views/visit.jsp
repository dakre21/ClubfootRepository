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
	<h1 style="color:green">
		CURE
	</h1>

<hr size="25" color="green">

<body>
<h2>
    Add Visit
</h2>

<form action="#" th:action="@{/visit}" th:object="${visit}" modelAttribute="Visit" id="Visit" method="post">
	<input type = "hidden" name = "submitted" value = "true" />
	
	<font color="red">*</font> Hospital/Clinic: 
  	<select name="hospitalName" style="width: 300px;" required>
  		<option value="test_hospital1" path="hospitalName"> Test Hospital 1 </option>
  		<option value="test_hospital2" path="hospitalName"> Test Hospital 2 </option>
  		<option value="test_hospital3" path="hospitalName"> Test Hospital 3 </option>
  		<option value="test_hospital4" path="hospitalName"> Test Hospital 4 </option>
  	</select>
  	</p>
  	
  	<font color="red">*</font> Name of Evaluator: <input type="text" name="evaluatorName" path="evaluatorName" style="width: 200px;" required/>
  	</p>
  	
  	<font color="red">*</font> Date of Visit (dd/mm/yyyy): <input type="date" name="dateOfVisit" path="dateOfVisit" style="width: 100px;" required/>
  	</p>
  	
  	Is this the patient's final treatment visit?
	<INPUT TYPE="radio" NAME="finalTreatment" path="finalTreatment" VALUE="yes_final_treatment">Yes
	<INPUT TYPE="radio" NAME="q1" path="finalTreatment" VALUE="no_not_final_treatment">No
	<INPUT TYPE="radio" NAME="q1" path="finalTreatment" VALUE="unspecified_final_treatment">Unspecified
  	</p>
  	
  	Did the patient experience a relapse?
	<INPUT TYPE="radio" NAME="relapse" path="relapse" VALUE="yes_relapse">Yes
	<INPUT TYPE="radio" NAME="relapse" path="relapse" VALUE="no_relapse">No
	<INPUT TYPE="radio" NAME="relapse" path="relapse" VALUE="unspecified_relapse">Unspecified
  	</p>

<table>
  <tr>
    <td>	
	<fieldset> 
		<legend> Left Foot </legend>  
		Varus:
		<INPUT TYPE="radio" NAME="hindfootLeftVarus" path="hindfootLeftVarus" VALUE="varus">Varus
		<INPUT TYPE="radio" NAME="hindfootLeftVarus" path="hindfootLeftVarus" VALUE="neutral">Neutral
		<INPUT TYPE="radio" NAME="hindfootLeftVarus" path="hindfootLeftVarus" VALUE="valgus">Valgus
		<INPUT TYPE="radio" NAME="hindfootLeftVarus" path="hindfootLeftVarus" VALUE="notAssessed">Not Assessed
  		</p>
		Cavus:
		<INPUT TYPE="radio" NAME="hindfootLeftCavus" path="hindfootLeftCavus" VALUE="present">Present
		<INPUT TYPE="radio" NAME="hindfootLeftCavus" path="hindfootLeftCavus" VALUE="corrected">Corrected
		<INPUT TYPE="radio" NAME="hindfootLeftCavus" path="hindfootLeftCavus" VALUE="notAssessed">Not Assessed
  		</p>
		Abductus ° (-30 to 70): <input type="text" name="hindfootLeftAbductus" path="hindfootLeftAbductus" style="width: 100px;"/>
		</p>
		Equinus ° (-50 to 30): <input type="text" name="hindfootLeftEquinus" path="hindfootLeftEquinus" style="width: 100px;"/>
		</p>
		<!-- <label> First Name: <input type = "text" name = "fname" /> </label> -->
		<!-- <label> Last Name: <input type = "text" name = "lname" /> </label>-->
		
		<fieldset>
			<legend> Pirani Scores (Hindfoot) </legend>
  			Posterior crease
			<INPUT TYPE="radio" NAME="midfootLeftPosterior" path="midfootLeftPosterior" VALUE="1">1
			<INPUT TYPE="radio" NAME="midfootLeftPosterior" path="midfootLeftPosterior" VALUE="0.5">0.5
			<INPUT TYPE="radio" NAME="midfootLeftPosterior" path="midfootLeftPosterior" VALUE="0">0
  			</p>		
  			 Empty heel
			<INPUT TYPE="radio" NAME="midfootLeftHeel" path="midfootLeftHeel" VALUE="1">1
			<INPUT TYPE="radio" NAME="midfootLeftHeel" path="midfootLeftHeel" VALUE="0.5">0.5
			<INPUT TYPE="radio" NAME="midfootLeftHeel" path="midfootLeftHeel" VALUE="0">0
  			</p>
  			 Rigid equinus
			<INPUT TYPE="radio" NAME="midfootLeftEquinus" path="midfootLeftEquinus" VALUE="1">1
			<INPUT TYPE="radio" NAME="midfootLeftEquinus" path="midfootLeftEquinus" VALUE="0.5">0.5
			<INPUT TYPE="radio" NAME="midfootLeftEquinus" path="midfootLeftEquinus" VALUE="0">0	
		</fieldset>
		
		<fieldset>
			<legend> Pirani Scores (Midfoot) </legend>
		</fieldset>
		
	</fieldset> 
	
	</td>
	
	<td>
	
	<fieldset> 
		<legend> Right Foot </legend>  
		Varus:
		<INPUT TYPE="radio" NAME="hindfootRightVarus" path="hindfootRightVarus" VALUE="varus">Varus
		<INPUT TYPE="radio" NAME="hindfootRightVarus" path="hindfootRightVarus" VALUE="neutral">Neutral
		<INPUT TYPE="radio" NAME="hindfootRightVarus" path="hindfootRightVarus" VALUE="valgus">Valgus
		<INPUT TYPE="radio" NAME="hindfootRightVarus" path="hindfootRightVarus" VALUE="notAssessed">Not Assessed
  		</p>
		Cavus:
		<INPUT TYPE="radio" NAME="hindfootRightCavus" path="hindfootRightCavus" VALUE="present">Present
		<INPUT TYPE="radio" NAME="hindfootRightCavus" path="hindfootRightCavus" VALUE="corrected">Corrected
		<INPUT TYPE="radio" NAME="hindfootRightCavus" path="hindfootRightCavus" VALUE="notAssessed">Not Assessed
  		</p>
		Abductus ° (-30 to 70): <input type="text" name="hindfootRightAbductus" path="hindfootRightAbductus" style="width: 100px;"/>
		</p>
		Equinus ° (-50 to 30): <input type="text" name="hindfootRightEquinus" path="hindfootRightEquinus" style="width: 100px;"/>
		</p>
		<!-- <label> First Name: <input type = "text" name = "fname" /> </label> -->
		<!-- <label> Last Name: <input type = "text" name = "lname" /> </label>-->
		
		<fieldset>
			<legend> Pirani Scores (Hindfoot) </legend>
  			Posterior crease
			<INPUT TYPE="radio" NAME="midfootRightPosterior" path="midfootRightPosterior" VALUE="1">1
			<INPUT TYPE="radio" NAME="midfootRightPosterior" path="midfootRightPosterior" VALUE="0.5">0.5
			<INPUT TYPE="radio" NAME="midfootRightPosterior" path="midfootRightPosterior" VALUE="0">0
  			</p>		
  			 Empty heel
			<INPUT TYPE="radio" NAME="midfootRightHeel" path="midfootRightHeel" VALUE="1">1
			<INPUT TYPE="radio" NAME="midfootRightHeel" path="midfootRightHeel" VALUE="0.5">0.5
			<INPUT TYPE="radio" NAME="midfootRightHeel" path="midfootRightHeel" VALUE="0">0
  			</p>
  			 Rigid equinus
			<INPUT TYPE="radio" NAME="midfootRightEquinus" path="midfootRightEquinus" VALUE="1">1
			<INPUT TYPE="radio" NAME="midfootRightEquinus" path="midfootRightEquinus" VALUE="0.5">0.5
			<INPUT TYPE="radio" NAME="midfootRightEquinus" path="midfootRightEquinus" VALUE="0">0	
		</fieldset>
		
		<fieldset>
			<legend> Pirani Scores (Midfoot) </legend>
		</fieldset>
		
	</fieldset> 
	
	</td>
   </tr>
</table>
	<br/>
	<input type = "submit" value = "Submit Form" />
</form> 

</body>
</html>