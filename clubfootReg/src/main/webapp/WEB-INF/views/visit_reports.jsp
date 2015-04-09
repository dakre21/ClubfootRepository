<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html"; charset=ISO-8859-1">
<title>CURE Clubfoot | Visit Reports</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
<style type="text/css">
  body {
    padding-top: 70px;
  }
</style>
<script>
	window.onload = function(){
		
		if("${filters.hospital_id}" > 0)
			document.getElementById("hospital_id").value = "${filters.hospital_id}";
		else
			document.getElementById("hospital_id").value = "";
		
		
		if("${filters.complications}" == "No")
			document.getElementById("compNo").checked = true;
		else if("${filters.complications}" == "Yes")
			document.getElementById("compYes").checked = true;
		else if("${filters.complications}" == "Unspecified")
			document.getElementById("compUn").checked = true;
		
		if("${filters.relapse}" == "No")
			document.getElementById("relNo").checked = true;
		else if("${filters.relapse}" == "Yes")
			document.getElementById("relYes").checked = true;
		else if("${filters.relapse}" == "Unspecified")
			document.getElementById("relUn").checked = true;
		
		if("${filters.leftTreatment}" == "None")
			document.getElementById("leftN").checked = true;
		else if("${filters.leftTreatment}" == "C - Manipulation & Casting")
			document.getElementById("leftC").checked = true;
		else if("${filters.leftTreatment}" == "T - Tenotomy")
			document.getElementById("leftT").checked = true;
		else if("${filters.leftTreatment}" == "B - Brace Application")
			document.getElementById("leftB").checked = true;
		else if("${filters.leftTreatment}" == "R - Refer")
			document.getElementById("leftR").checked = true;
		else if("${filters.leftTreatment}" == "S - Surgery")
			document.getElementById("leftS").checked = true;
		else if("${filters.leftTreatment}" == "O - Other")
			document.getElementById("leftO").checked = true;
		
		if("${filters.rightTreatment}" == "None")
			document.getElementById("rightN").checked = true;
		else if("${filters.rightTreatment}" == "C - Manipulation & Casting")
			document.getElementById("rightC").checked = true;
		else if("${filters.rightTreatment}" == "T - Tenotomy")
			document.getElementById("rightT").checked = true;
		else if("${filters.rightTreatment}" == "B - Brace Application")
			document.getElementById("rightB").checked = true;
		else if("${filters.rightTreatment}" == "R - Refer")
			document.getElementById("rightR").checked = true;
		else if("${filters.rightTreatment}" == "S - Surgery")
			document.getElementById("rightS").checked = true;
		else if("${filters.rightTreatment}" == "O - Other")
			document.getElementById("rightO").checked = true;
		

	}
</script>
	<jsp:include page="navbar.jsp" />
</head>

<body>


<div class="container">
	<div class="jumbotron">
		<h1>Visit Report</h1>
		<hr>
		<form action="#" th:action="@{/visit_reports}"  modelAttribute="filters" method="post" id="filterVisits">
		<div class="form-group">
			
			<label for="hospital_id">Hospital</label>
			<form:select class="form-control" path="hospitalList" id="hospital_id" name="hospital_id">
            	<form:option value="" label="Select a Hospital" disabled="true" selected="true" style="display: none;"/>
                <form:options items="${hospitalList}" />
            </form:select> <br>
            
            <!-- 
            <label for="all">All Hospitals</label>
			<input type="checkbox" name="all" id="all" path="all"> <br>
			
			<label for="start">Start date: </label>
			<input type="date" name="start" id="start" class="form-control" path="start" placeholder="dd/mm/yyyy"  validate pattern="\d{1,2}/\d{1,2}/\d{4}" title="dd/mm/yyyy"> <br>
			
			<label for="end">End date: </label>
			<input type="date" name="end" id="end" class="form-control" path="end" placeholder="dd/mm/yyyy"  validate pattern="\d{1,2}/\d{1,2}/\d{4}" title="dd/mm/yyyy"> <br>
			-->
			
			<label for = "complications"><em>*</em>Were there any complications? </label>	
			<INPUT TYPE="radio" id = "compNo" NAME="complications" path="complications" onClick = "complicationsFalse()"VALUE="No">No
			<INPUT TYPE="radio" id = "compYes" NAME="complications" path="complications" onClick = "complicationsTrue()" VALUE="Yes">Yes
			<INPUT TYPE="radio" id = "compUn" NAME="complications" path="complications" onClick = "complicationsUnspecified()" VALUE="Unspecified">Unspecified<br>
				
			<label for = "relapse"><em>*</em>Did the patient experience any relapses? </label>	
			<INPUT TYPE="radio" id = "relNo" NAME="relapse" path="relapse" onClick = "relapseFalse()"VALUE="No">No
			<INPUT TYPE="radio" id = "relYes" NAME="relapse" path="relapse" onClick = "relapseTrue()" VALUE="Yes">Yes
			<INPUT TYPE="radio" id = "relUn" NAME="relapse" path="relapse" onClick = "relapseUnspecified()" VALUE="Unspecified">Unspecified<br>
				
			<label for = "leftTreatment"><em>*</em>Left foot treatment: </label>	
			<INPUT TYPE="radio" id = "leftN" NAME="leftTreatment" path="leftTreatment" onClick = "noneLeftTrue()" VALUE="None">None
			<INPUT TYPE="radio" id = "leftC" NAME="leftTreatment" path="leftTreatment" onClick = "castingLeftTrue()"VALUE="C - Manipulation & Casting">C - Manipulation & Casting
			<INPUT TYPE="radio" id = "leftT" NAME="leftTreatment" path="leftTreatment" onClick = "tenotomyLeftTrue()" VALUE="T - Tenotomy">T - Tenotomy
			<INPUT TYPE="radio" id = "leftB" NAME="leftTreatment" path="leftTreatment" onClick = "braceLeftTrue()" VALUE="B - Brace Application">B - Brace Application
			<INPUT TYPE="radio" id = "leftR" NAME="leftTreatment" path="leftTreatment" onClick = "referLeftTrue()" VALUE="R - Refer">R - Refer
			<INPUT TYPE="radio" id = "leftS" NAME="leftTreatment" path="leftTreatment" onClick = "surgeryLeftTrue()" VALUE="S - Surgery">S - Surgery
			<INPUT TYPE="radio" id = "leftO" NAME="leftTreatment" path="leftTreatment" onClick = "otherLeftTrue()" VALUE="O - Other">O - Other<br>
			
			<label for = "rightTreatment"><em>*</em>Right foot treatment: </label>	
			<INPUT TYPE="radio" id = "rightN" NAME="rightTreatment" path="rightTreatment" onClick = "noneRightTrue()" VALUE="None">None
			<INPUT TYPE="radio" id = "rightC" NAME="rightTreatment" path="rightTreatment" onClick = "castingRightTrue()"VALUE="C - Manipulation & Casting">C - Manipulation & Casting
			<INPUT TYPE="radio" id = "rightT" NAME="rightTreatment" path="rightTreatment" onClick = "tenotomyRightTrue()" VALUE="T - Tenotomy">T - Tenotomy
			<INPUT TYPE="radio" id = "rightB" NAME="rightTreatment" path="rightTreatment" onClick = "braceRightTrue()" VALUE="B - Brace Application">B - Brace Application
			<INPUT TYPE="radio" id = "rightR" NAME="rightTreatment" path="rightTreatment" onClick = "referRightTrue()" VALUE="R - Refer">R - Refer
			<INPUT TYPE="radio" id = "rightS" NAME="rightTreatment" path="rightTreatment" onClick = "surgeryRightTrue()" VALUE="S-Surgery">S - Surgery
			<INPUT TYPE="radio" id = "rightO" NAME="rightTreatment" path="rightTreatment" onClick = "otherRightTrue()" VALUE="O-Other">O - Other<br>
			<br>
			<button class="btn btn-primary btn-lg" type="submit">Generate Report</button>
			<button class="btn btn-primary btn-lg" type="reset">Clear</button>
		</div>	
		</form>
	</div>
		<table class='table table-striped'>
		   	<thead>
		   		<tr>
		   			<th>Visit ID</th>
		   			<th>Patient ID</th>
		   			<th>Hospital/Clinic</th>
		   			<th>Treatment Left</th>
		   			<th>Treatment Right</th>
		    	</tr>
		    </thead>
	   
	    	<tbody>
        	<c:if test="${not empty visit_reports}">
            <c:forEach var="o" items="${visit_reports}">
              <tr>
                  <td>${o.id}</td>
                  <td>${o.patientId}</td>
                  <td>${o.hospitalId}</td>
                  <td>${o.leftTreatment}</td>
                  <td>${o.rightTreatment}</td>
              </tr>
            </c:forEach>
          </c:if>
	      </tbody>
	  </table>	

	<hr>

	<div class="row">
		<div class="col-xs-12">
			<footer align="center">
				<p>&copy; Some Copyright Info</p>
			</footer>
		</div>
	</div>
</div>
</body>
</html> 