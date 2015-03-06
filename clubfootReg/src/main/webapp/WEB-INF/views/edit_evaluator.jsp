<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  	<!-- Latest compiled and minified CSS -->
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

  	<!-- Latest compiled and minified JavaScript -->
  	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
  	
  	<title>Clubfoot Registry | Edit Patient</title>
  
  	<style type="text/css">
		body {
	  		padding-top: 70px;
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
	  	em {
	  		color: red;
	  	}
	  	input[type=submit] {
  			width: 150px;
  			padding: 10px;
		}
 	</style>
  	
  	<script>
  		window.onload = function() { 
			$("#title").val("${evaluator.title}");
			$("#hospital_id").val("${evaluator.hospital_id}");
  		}
  	</script>
	<jsp:include page="navbar.jsp" />
</head>

<body>
<div class="container">
	<div class="row clearfix">
		<div class="col-sm-2 column"></div>
		<div class="col-md-8 column">
			<h1>Update patient </h1>  
			<form action="#" th:action="@{/edit_evaluator}" th:object="${evaluator}" modelAttribute="editEvaluator" method="post" id="updateEvaluator">
				<div class="form-group">
					<label for="first_name">First Name</label>
					<input type="name" class="form-control" id="first_name" name="first_name" path="first_name" value="${evaluator.first_name}"/>
				</div>
				
				<div class="form-group">
					<label for="middle_name">Middle Name</label>
					<input type="name" class="form-control" id="middle_name" name="middle_name" path="middle_name" value="${evaluator.middle_name}"/>
				</div>
				
				<div class="form-group">
					<label for="last_name">Last Name</label>
					<input type="name" class="form-control" id="last_name" name="last_name" path="last_name" value="${evaluator.last_name}"/>
				</div>
				
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<label for="title">Title</label>
							<select class="form-control" id="title" name="title">
								<option value="" name="title" path="title">Select a Title</option>
		                    	<option value="Doctor" name="title" path="title">Doctor</option>
		                    	<option value="Nurse" name="title" path="title">Nurse</option>
		                    	<option value="Midwife" name="title" path="title">Midwife</option>
		                    	<option value="Physical Therapist" name="title" path="title">Physical Therapist</option>
		                    	<option value="Officer" name="title" path="title">Officer</option>
		                    	<option value="Other" name="title" path="title">Other</option>
		                	</select>
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<label for="hospital">Hospital</label>
							<form:select class="form-control" path="hospitalList" id="hospital_id" name="hospital_id">
                      			<form:option value="" label="Select a Hospital" disabled="true" selected="true" style="display: none;"/>
                      			<form:options items="${hospitalList}" />
                       		</form:select>
						</div>
					</div>
				</div>
			
				<div class="row" align="center">
					<button type="submit" class="btn btn-lg btn-primary">Submit Form</button>
					<button type="reset" class="btn btn-lg btn-default">Clear</button>
				</div>
			</form>
		</div>
		<div class="col-sm-2 column"></div>
	</div>
</div>
</body>
</html>