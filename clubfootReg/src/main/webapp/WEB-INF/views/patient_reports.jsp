
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html"; charset=ISO-8859-1">
<title>Clubfoot Registry | Patient Reports</title>
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
		if("${filters.sex}" == "male")
			document.getElementById("male").checked = true;
		else if("${filters.sex}" == "female")
			document.getElementById("female").checked = true;
		
		if("${filters.race}" == "asian")
			document.getElementById("asian").checked = true;
		else if("${filters.race}" == "white")
			document.getElementById("white").checked = true;
		else if("${filters.race}" == "black")
			document.getElementById("black").checked = true;
		else if("${filters.race}" == "indian")
			document.getElementById("indian").checked = true;
		else if("${filters.race}" == "mixed")
			document.getElementById("mixed").checked = true;
		else if("${filters.race}" == "other")
			document.getElementById("other").checked = true;
		else if("${filters.race}" == "unspecified")
			document.getElementById("unspecified").checked = true;
		
		if("${filters.relatives}" == "yes")
			document.getElementById("relYes").checked = true;
		else if("${filters.relatives}" == "no")
			document.getElementById("relNo").checked = true;
		else if("${filters.relatives}" == "unspecified")
			document.getElementById("relUn").checked = true;
		
	    if("${filters.hospitalId}" > 0 )
			document.getElementById("hospitalId").value = "${filters.hospitalId}";
		else		
			document.getElementById("hospitalId").value = "";
	}
</script>
	<jsp:include page="navbar.jsp" />
</head>

<body>


<div class="container">
	<div class="jumbotron">
		<h1>Patient Report</h1>
		<hr>
		<form action="#" th:action="@{/patient_reports}"  modelAttribute="filters" method="post" id="filterPatients">
		<div class="form-group">
			<label for="sex">Gender: </label>
			<input type="radio" id = "male" name="sex" value="male" path="sex" > Male
			<input type="radio" id = "female" name="sex" value="female" path="sex" > Female <br>

			<label for="race">Race: </label>
			<input type="radio" id = "asian" name="race" value="asian" path="race"> Asian
			<input type="radio" id = "white" name="race" value="white" path="race"> Caucasian (White) 
			<input type="radio" id = "black" name="race" value="black" path="race"> African (Black)
			<input type="radio" id = "indian" name="race" value="indian" path="race"> Asian (Indian)
			<input type="radio" id = "mixed" name="race" value="mixed" path="race"> Mixed
			<input type="radio" id = "other" name="race" value="other" path="race"> Other
			<input type="radio" id = "unspecified" name="race" value="unspecified" path="race"> Unspecified <br>
			
			<label for="relatives">Relatives with clubfoot? </label>
			<input type="radio" id = "relYes" name="relatives" value="yes" path="relatives"> Yes
			<input type="radio" id = "relNo" name="relatives" value="no" path="relatives"> No
			<input type="radio" id = "relUn" name="relatives" value="unspecified" path="relatives"> Unspecified <br>
			
			<label for="hospitalId">Hospital</label>
			<form:select class="form-control" path="hospitalList" id="hospitalId" name="hospitalId">
            	<form:option  id = "selected" value="" label="Select a Hospital" disabled="true" selected="true" style="display: none;"/>
                <form:options items="${hospitalList}" />
            </form:select><br>
			<!-- 
			<label for="dobSel">Before/After </label>
			<input type="radio" name="dobSel" value="after" path="dobSel"> After
			<input type="radio" name="dobSel" value="before" path="dobSel"> Before
			<input type="radio" name="dobSel" value="on" path="dobSel"> On <br>
			
			<label for="dob">Date of birth: </label>
			<input type="date" name="dob" id="dob" class="form-control" path="dob" placeholder="dd/mm/yyyy"  validate pattern="\d{1,2}/\d{1,2}/\d{4}" title="dd/mm/yyyy"> <br>
			
			<label for="eval_dateSel">Before/After </label>
			<input type="radio" name="eval_dateSel" value="after" path="eval_dateSel"> After
			<input type="radio" name="eval_dateSel" value="before" path="eval_dateSel"> Before
			<input type="radio" name="eval_dateSel" value="on" path="eval_dateSel"> On <br>
			
			<label for="eval_date">Evaluation date: </label>
			<input type="date" name="eval_date" id="eval_date" class="form-control" path="eval_date" placeholder="dd/mm/yyyy"  validate pattern="\d{1,2}/\d{1,2}/\d{4}" title="dd/mm/yyyy"> <br> 
            -->
            <button class="btn btn-primary btn-lg" type="submit">Generate Report</button>
            <button class="btn btn-primary btn-lg" type="reset">Clear</button>
		</div>
		</form>
	</div>
	
	<br>
		
	<table id="patients_table" class='table table-striped'>
	   	<thead>
	   		<tr>
	    		<th>ID</th>
	    		<th>First Name</th>
	    		<th>Middle Name</th>
	    		<th>Last Name</th>
	    	</tr>
	    </thead>
   
    	<tbody>
	       	<c:if test="${not empty patients}">
	        	<c:forEach var="o" items="${patients}">
	            	<tr>
	                	<td><a href="view_patient_info?id=${o.id}">${o.id}</a></td>
				  		<td>${o.patientFirstName}</td>
				  		<td>${o.patientMiddleName}</td>
				  		<td>${o.patientLastName}</td>
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