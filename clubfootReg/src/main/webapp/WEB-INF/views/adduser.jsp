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
<title>Clubfoot Registry | Add User</title>
<div class="container">
	<jsp:include page="navbar.jsp" />
</head>

<body>

<div class="container">
	<div class="row clearfix">
		<div class="col-sm-2 column"></div>
		<div class="col-md-8 column">
			<h1 align="center">Add New User</h1>
			<form action="#" th:action="@{/adduser}" th:object="${user}" modelAttribute="user" id="User" method="post">
				<div class="form-group">
					<label for="user_name">User Name</label>
					<input type="name" class="form-control" name="user_name" path="user_name" />
				</div>
				
				<div class="form-group">
					<label for="email">Email</label>
					<input type="text" class="form-control" name="email" path="email" />
				</div>
				
				<div class="form-group">
					<label for="role_id">Role</label>
					<select class="form-control" name="role_id" required>
						<option>Select a Role</option>
		                <option value="0" path="role_id">Admin</option>
	               		<option value="1" path="role_id">Data Entry</option>
		            </select>
				</div>
				
				<div class="form-group">
					<label for="hospital_id">Hospital Affiliation</label>
					<select class="form-control" name="hospital_id" required>
						<option>Select a Hospital</option>
		                <option value="0" path="hospital_id">Hospital1</option>
	               		<option value="1" path="hospital_id">Hospital2</option>
	                	<option value="2" path="hospital_id">Hospital3</option>
		            </select>
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

<script type="text/javascript">
	$(".dropdown-menu li a").click(function(){
	  var selText = $(this).text();
	  $(this).parents('.btn-group').find('.dropdown-toggle').html(selText+' <span class="caret"></span>');
	});
</script>

</body>
</html> 