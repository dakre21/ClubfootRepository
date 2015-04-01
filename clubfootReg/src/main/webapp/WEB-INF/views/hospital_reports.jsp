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
<title>Clubfoot Registry | Hospital Reports</title>
	<jsp:include page="navbar.jsp" />
</head>
<body>
<div class="container">
	<div class="jumbotron">
		<h1>Hospital Report</h1>
		<hr>
		<form action="#" th:action="@{/hospital_reports}"  modelAttribute="hospital_id" method="post" id="filterHospitals">
		<div class="form-group">
			<label for="hospital_id">Hospital</label>
			<form:select class="form-control" path="hospitalList" id="hospital_id" name="hospital_id">
            	<form:option value="" label="Select a Hospital" disabled="true" selected="true" style="display: none;"/>
                <form:options items="${hospitalList}" />
            </form:select>
            
            <br>
            
            <!-- 
			<label for="dob">Start date: </label>
			<input type="date" name="start" id="start" class="form-control" path="start" placeholder="dd/mm/yyyy"  validate pattern="\d{1,2}/\d{1,2}/\d{4}" title="dd/mm/yyyy"> 
			
			<label for="dob">End date: </label>
			<input type="date" name="end" id="end" class="form-control" path="end" placeholder="dd/mm/yyyy"  validate pattern="\d{1,2}/\d{1,2}/\d{4}" title="dd/mm/yyyy"> 
			
			<label for="all">All Hospitals</label>
			<input type="checkbox" name="all" id="all" path="all"> <br>
			-->
			
			<button type="submit" class="btn btn-primary btn-lg">Generate Report</button>
		</div>
		</form>	
	</div>
	
	<div class="row">
		<div class="col-xl-12">
			<c:if test="${not empty hospitals}">
		    	<c:forEach var="o" items="${hospitals}">
					<ul>
						<li class="hospName">${o.hospitalName}
							<ul>
								<li>Region: ${o.regionName}</li>
								<li>Total Number of Patients: ${o.numOfPatients}
									<ul>
										<li>Gender
											<ul>
												<li>Males: ${o.numOfMales}</li>
												<li>Females: ${o.numOfFemales}</li>
											</ul>
										</li>
										<li>Laterality
											<ul>
												<li>Left: ${o.latLeft}</li>
												<li>Right: ${o.latRight}</li>
												<li>Unilateral: ${o.latUni}</li>
												<li>Bilateral: ${o.latBi}</li>
											</ul>
										</li>
										<li>Affected Relatives
											<ul>
												<li>Patients with affected relatives: ${o.affectedRels}</li>
												<li>Patients with no affected relatives: ${o.affectedRelsNot}</li>
												<li>Do not know if there are affected relatives: ${o.affectedRelsIDK}</li>
											</ul>
										</li>
										<li>Treatment Stages
											<ul>
												<li>Casting: ${o.treatmentC}</li>
												<li>Bracing: ${o.treatmentB}</li>
												<li>Tenotomy: ${o.treatmentT}</li>
											</ul>
										</li>
										<!-- 
										<li>Drop Outs
											<ul>
												<li>Casting: 0</li>
												<li>Bracing: 0</li>
												<li>Tenotomy: 0</li>
											</ul>
										</li>
										<li>Brace Compliance
											<ul>
												<li>Good Brace Compliance: 0</li>
												<li>Fair Brace Compliance: 0</li>
												<li>Poor Brace Compliance: 0</li>
											</ul>
										</li>
										<li>Tenotomies
											<ul>
												<li>Tenotomy performed: 0</li>
												<li>Tenotomy not performed: 0</li>
												<li>Percent Tenotomies: 0%</li>
											</ul>
										</li>
										<li>Average Casts/Patient
											<ul>
												<li>Average number of casts per patient: 0</li>
											</ul>
										</li>
										<li>8+ Casts
											<ul>
												<li>Number of patients with 8+ casts: 0</li>
											</ul>
										</li>
										<li>Age of first visit
											<ul>
												<li>0-3 months: 0</li>
												<li>3-6 months: 0</li>
												<li>6-12 months: 0</li>
												<li>1-2 years: 0</li>
												<li>2-5 years: 0</li>
												<li>5-10 years: 0</li>
												<li>10+ years: 0</li>
											</ul>
										</li>
										<li>Age of evaluation
											<ul>
												<li>0-3 months: 0</li>
												<li>3-6 months: 0</li>
												<li>6-12 months: 0</li>
												<li>1-2 years: 0</li>
												<li>2-5 years: 0</li>
												<li>5-10 years: 0</li>
												<li>10+ years: 0</li>
											</ul>
										</li>
										<li>Age of first cast
											<ul>
												<li>0-3 months: 0</li>
												<li>3-6 months: 0</li>
												<li>6-12 months: 0</li>
												<li>1-2 years: 0</li>
												<li>2-5 years: 0</li>
												<li>5-10 years: 0</li>
												<li>10+ years: 0</li>
											</ul>
										</li>
										<li>Relapse
											<ul>
												<li>Number of relapsed patients: 0</li>
											</ul>
										</li>					
									</ul>
								</li>-->
								<li>Total Number of Visits: ${o.numOfVisits}</li>
								<!-- 
								<li>Number of patients seen in reporting period: 0</li>
								<li>Number of new patients in reporting period: 0</li>
								<li>Number of visits in reporting period: 0
									<ul>
										<li>Procedures within reporting period
											<ul>
												<li>Number of castings: 0</li>
												<li>Number of tenotomies: 0</li>
												<li>Number of referrals: 0</li>
												<li>Number of brace applications: 0</li>
												<li>Number of surgeries: 0</li>
												<li>Number of other treatments: 0</li>
											</ul>
										</li>
									</ul>
								</li>-->
							</ul>
						</li>
					</ul>
					<br>		
		        </c:forEach>
		   	</c:if>
		</div>
	</div>

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