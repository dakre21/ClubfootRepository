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
<style type="text/css">
  body {
    padding-top: 70px;
  }
  .nav_links{
  margin-left:35%;
  width:30%;
  	border: 1px solid #000000;
  }
.nav_links ul { 
	margin:0 auto;
	padding: 0px;
	background-color:#D8D8D8;
	
	list-style-type: none;
}
.nav_links li a{
	display: block;
	padding:2px;
	width: 100%;
	color: #585858;
	border-bottom: 1px solid black;
	background-color: #D0DBF0
	text-decoration:none;
}
.nav_links li a:hover{
	background-color:#A4A4A4;
	color: #585858;
	text-decoration:none;

}


</style>
<title>Clubfoot Registry | Patient Reports</title>
	<jsp:include page="navbar.jsp" />
</head>
<body>

<div class="container">
	<div class="jumbotron">
		<h1>
			Patients
		</h1>
		<hr>
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

			<label for="race">Before/After </label>
			<input type="radio" name="after" value="after" path="after"> After
			<input type="radio" name="before" value="before" path="before"> Before
			<input type="radio" name="on" value="on" path="on"> On <br>
			
			<label for="dob">Date of birth: </label>
			<input type="date" name="dob" id="dob" class="form-control" path="dob" placeholder="dd/mm/yyyy"  validate pattern="\d{1,2}/\d{1,2}/\d{4}" title="dd/mm/yyyy"> 
			
			<label for="race">Before/After </label>
			<input type="radio" name="after_eval" value="after_eval" path="after_eval"> After
			<input type="radio" name="before_eval" value="before_eval" path="before_eval"> Before
			<input type="radio" name="on_eval" value="on_eval" path="on"> On <br>
			
			<label for="dob">Evaluation date: </label>
			<input type="date" name="eval_date" id="eval_date" class="form-control" path="eval_date" placeholder="dd/mm/yyyy"  validate pattern="\d{1,2}/\d{1,2}/\d{4}" title="dd/mm/yyyy"> 
			
			<label for="race">Relatives with clubfoot? </label>
			<input type="radio" name="yes" value="yes" path="yes"> Yes
			<input type="radio" name="no" value="no" path="no"> No
			<input type="radio" name="unsure" value="unsure" path="unsure"> Unsure
			
			<div class="form-group">
					<label for="hospital_id">Hospital</label>
					<form:select class="form-control" path="hospitalList" id="hospital_id" name="hospital_id">
                    <form:option value="" label="Select a Hospital" disabled="true" selected="true" style="display: none;"/>
                    <form:options items="${hospitalList}" />
                    </form:select><br>
            
            
		<a role="button" class="btn btn-primary btn-lg">Generate Report</a>
		</div>
	</div>	
	<hr>
	
	<div class="row">
		<div class="col-xl-12">
			<c:if test="${not empty patient_reports}">
		    	<c:forEach var="o" items="${patient_reports}">
		    	
		    	</c:forEach>
		    </c:if>
		</div>
	</div>
	</div>	

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