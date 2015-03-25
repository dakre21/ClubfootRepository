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
  	
  	<title>Clubfoot Registry | Edit Hospital</title>
  
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
			$("#hospital").val("${hospital.name}");
			$("#region_id").val("${hospital.region_id}");
  		}
  	</script>
	<jsp:include page="navbar.jsp" />
</head>

<body>
<div class="container">
	<div class="row clearfix">
		<div class="col-sm-2 column"></div>
		<div class="col-md-8 column">
			<h1>Edit Hospital</h1>  
			<form action="#" th:action="@{/edit_hospital}" th:object="${hospital}" modelAttribute="editHospital" method="post" id="updateHospital">
				<div class="form-group">
          			<label for="hospital">Hospital/Clinic Name</label>
          			<input type="text" class="form-control" id="hospital" name="name" path="name"/>
        		</div>
         		<div class="form-group">
              		<label for="region_id">Region</label>
                	<form:select class="form-control" path="regionList" id="region_id" name="region_id">
                 		<form:option value="" label="Select a Region" disabled="true" selected="true" style="display: none;"/>
                 		<form:options items="${regionList}" />
                 	</form:select>
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
</body>
</html>