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
	<jsp:include page="navbar.jsp" />
</head>

<body>


<div class="container">
	<div class="jumbotron">
		<form action="#" th:action="@{/visit_reports}"  modelAttribute="filters" method="post" id="filterVisits">
		<div class="form-group">
			
			<label for="hospital_id">Hospital</label>
			<form:select class="form-control" path="hospitalList" id="hospital_id" name="hospital_id">
            	<form:option value="" label="Select a Hospital" disabled="true" selected="true" style="display: none;"/>
                <form:options items="${hospitalList}" />
            </form:select> <br>
            
            <label for="all">All Hospitals</label>
			<input type="checkbox" name="all" id="all" path="all"> <br>
			
			<label for="start">Start date: </label>
			<input type="date" name="start" id="start" class="form-control" path="start" placeholder="dd/mm/yyyy"  validate pattern="\d{1,2}/\d{1,2}/\d{4}" title="dd/mm/yyyy"> <br>
			
			<label for="end">End date: </label>
			<input type="date" name="end" id="end" class="form-control" path="end" placeholder="dd/mm/yyyy"  validate pattern="\d{1,2}/\d{1,2}/\d{4}" title="dd/mm/yyyy"> <br>
			
			<label for = "complications"><em>*</em>Were there any complications? </label>	
			<INPUT TYPE="radio" NAME="complications" path="complications" onClick = "complicationsFalse()"VALUE="No" required>No
			<INPUT TYPE="radio" NAME="complications" path="complications" onClick = "complicationsTrue()" VALUE="Yes" required>Yes
			<INPUT TYPE="radio" NAME="complications" path="complications" onClick = "complicationsUnspecified()" VALUE="Unspecified" required>Unspecified<br>
				
			<label for = "relapse"><em>*</em>Did the patient experience any relapses? </label>	
			<INPUT TYPE="radio" NAME="relapse" path="relapse" onClick = "relapseFalse()"VALUE="No" required>No
			<INPUT TYPE="radio" NAME="relapse" path="relapse" onClick = "relapseTrue()" VALUE="Yes" required>Yes
			<INPUT TYPE="radio" NAME="relapse" path="relapse" onClick = "relapseUnspecified()" VALUE="Unspecified" required>Unspecified<br>
				
			<label for = "leftTreatment"><em>*</em>Left foot treatment: </label>	
			<INPUT TYPE="radio" NAME="leftTreatment" path="leftTreatment" onClick = "noneLeftTrue()" VALUE="None">None
			<INPUT TYPE="radio" NAME="leftTreatment" path="leftTreatment" onClick = "castingLeftTrue()"VALUE="C - Manipulation & Casting">C - Manipulation & Casting
			<INPUT TYPE="radio" NAME="leftTreatment" path="leftTreatment" onClick = "tenotomyLeftTrue()" VALUE="T - Tenotomy">T - Tenotomy
			<INPUT TYPE="radio" NAME="leftTreatment" path="leftTreatment" onClick = "braceLeftTrue()" VALUE="B - Brace Application">B - Brace Application
			<INPUT TYPE="radio" NAME="leftTreatment" path="leftTreatment" onClick = "referLeftTrue()" VALUE="R - Refer">R - Refer
			<INPUT TYPE="radio" NAME="leftTreatment" path="leftTreatment" onClick = "surgeryLeftTrue()" VALUE="S - Surgery">S - Surgery
			<INPUT TYPE="radio" NAME="leftTreatment" path="leftTreatment" onClick = "otherLeftTrue()" VALUE="O - Other">O - Other<br>
			
			<label for = "rightTreatment"><em>*</em>Right foot treatment: </label>	
			<INPUT TYPE="radio" NAME="rightTreatment" path="rightTreatment" onClick = "noneRightTrue()" VALUE="none">None
			<INPUT TYPE="radio" NAME="rightTreatment" path="rightTreatment" onClick = "castingRightTrue()"VALUE="C - Manipulation & Casting">C - Manipulation & Casting
			<INPUT TYPE="radio" NAME="rightTreatment" path="rightTreatment" onClick = "tenotomyRightTrue()" VALUE="T - Tenotomy">T - Tenotomy
			<INPUT TYPE="radio" NAME="rightTreatment" path="rightTreatment" onClick = "braceRightTrue()" VALUE="B - Brace Application">B - Brace Application
			<INPUT TYPE="radio" NAME="rightTreatment" path="rightTreatment" onClick = "referRightTrue()" VALUE="R - Refer">R - Refer
			<INPUT TYPE="radio" NAME="rightTreatment" path="rightTreatment" onClick = "surgeryRightTrue()" VALUE="S-Surgery">S - Surgery
			<INPUT TYPE="radio" NAME="rightTreatment" path="rightTreatment" onClick = "otherRightTrue()" VALUE="O-Other">O - Other<br>
			
			<button class="btn btn-primary btn-lg" type="submit">Generate Report</button>
		</div>	
		</form>
	
		<table class='table table-striped'>
		   	<thead>
		   		<tr>
		   			<th>Visit ID</th>
		   			<th>Patient ID</th>
		   			<th>Treatment Left</th>
		   			<th>Treatment Right</th>
		   			<th>Hospital/Clinic</th>
		    	</tr>
		    </thead>
	   
	    	<tbody>
        	<c:if test="${not empty visit_reports}">
            <c:forEach var="o" items="${visit_reports}">
              <tr>
                  <td>${o.id}</td>
                 <!--  <td>${o.leftTreatment}</td>
                  <td>${o.rightTreatment}</td>-->
                  <td>${o.hospitalId}</td>
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