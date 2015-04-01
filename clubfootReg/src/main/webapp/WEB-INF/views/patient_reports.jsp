
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

<script>
	function generateReport() {
		  
		
	}
</script>

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
		<h1>Patient Report</h1>
		<hr>
		<form action="#" th:action="@{/patient_reports}"  modelAttribute="filters" method="post" id="filterPatients">
		<div class="form-group">
			<label for="sex">Gender: </label>
			<input type="radio" name="sex" value="male" path="sex" > Male
			<input type="radio" name="sex" value="female" path="sex" > Female <br>

			<label for="race">Race: </label>
			<input type="radio" name="race" value="asian" path="race"> Asian
			<input type="radio" name="race" value="white" path="race"> Caucasian (White) 
			<input type="radio" name="race" value="black" path="race"> African (Black)
			<input type="radio" name="race" value="indian" path="race"> Asian (Indian)
			<input type="radio" name="race" value="mixed" path="race"> Mixed
			<input type="radio" name="race" value="other" path="race"> Other
			<input type="radio" name="race" value="unspecified" path="race"> Unspecified <br>
			
			<label for="relatives">Relatives with clubfoot? </label>
			<input type="radio" name="relatives" value="yes" path="relatives"> Yes
			<input type="radio" name="relatives" value="no" path="relatives"> No
			<input type="radio" name="relatives" value="unspecified" path="relatives"> Unspecified <br>
			
			<label for="hospital_id">Hospital</label>
			<form:select class="form-control" path="hospitalList" id="hospital_id" name="hospital_id">
            	<form:option value="" label="Select a Hospital" disabled="true" selected="true" style="display: none;"/>
                <form:options items="${hospitalList}" />
            </form:select><br>

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
            
            <button class="btn btn-primary btn-lg" type="submit">Generate Report</button>
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
				  		<td>${o.patient_firstName}</td>
				  		<td>${o.patient_midName}</td>
				  		<td>${o.patient_lastName}</td>
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