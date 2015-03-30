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
	</style>

	<title>Clubfoot Registry | Add Evaluator</title>
	<jsp:include page="navbar.jsp" />
</head>

<body>
<div class="container">
	<div class="row clearfix">
		<div class="col-sm-2 column"></div>
		<div class="col-md-8 column">
			<h1 align="center">Add New Evaluator</h1>
			<form action="#" th:action="@{/evaluator}" th:object="${evaluator}" modelAttribute="Evaluator" "id="Evaluator" method="post">
				
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<label for="title">Title</label>
							<select class="form-control" id="title" name="title">
								<option value="" disabled selected style="display: none;">Select a Title</option>
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
							<label for="hospital_id">Hospital</label>
							<!--<form:select class="form-control" path="hospitalList" items="${hospitalList}" id="hospital_id" name="hospital_id"/>-->
							<form:select class="form-control" path="hospitalList" id="hospital_id" name="hospital_id">
                      			<form:option value="" label="Select a Hospital" disabled="true" selected="true" style="display: none;"/>
                      			<form:options items="${hospitalList}" />
                       		</form:select>
						</div>
					</div>
				</div>
				&nbsp;
				<div class="row" align="center">
					<button type="submit" class="btn btn-lg btn-primary">Save</button>
				</div>
			</form>
		</div>
		<div class="col-sm-2 column"></div>
	</div>
</div>

<script type="text/javascript">
	$(".dropdown-menu li a").click(function(){
	  var selText = $(this).text();
	  $(this).parents('.btn-group').find('.dropdown-toggle').html(selText+' <span class="caret"></span>');
	});
</script>

</body>
</html> 