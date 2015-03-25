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
  	
  	<title>Clubfoot Registry | Edit User</title>
  
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
			$("#user_name").val("${user.user_name}");
			$("#email").val("${user.email}");
			$("#hospital_id").val("${user.hospital_id}");
			$("#role_id").val("${user.role_id}");
  		}
  	</script>
	<jsp:include page="navbar.jsp" />
</head>

<body>
<div class="container">
	<div class="row clearfix">
		<div class="col-sm-2 column"></div>
		<div class="col-md-8 column">
			<h1>Update User</h1>  
			<form action="#" th:action="@{/edit_user}" th:object="${user}" modelAttribute="editUser" method="post" id="updateUser">
				<div class="form-group">
					<label for="user_name">User Name</label>
					<input type="name" class="form-control" id="user_name" name="user_name" path="user_name" />
				</div>
				
				<div class="form-group">
					<label for="email">Email</label>
					<input type="text" class="form-control" id="email" name="email" path="email" />
				</div>
				
				<div class="form-group">
					<label for="role_id">Role</label>
					<form:select class="form-control" path="roleList" id="role_id" name="role_id">
                    	<form:option value="" label="Select a Role" disabled="true" selected="true" style="display: none;"/>
                    	<form:options items="${roleList}" />
                    </form:select>
				</div>
				
				<div class="form-group">
					<label for="hospital">Hospital</label>
					<form:select class="form-control" path="hospitalList" id="hospital_id" name="hospital_id">
                    	<form:option value="" label="Select a Hospital" disabled="true" selected="true" style="display: none;"/>
                    	<form:options items="${hospitalList}" />
                    </form:select>
				</div>
			
				&nbsp;
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