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
			<form action="#" th:action="@{/adduser}" th:object="${user}" modelAttribute="User" id="User" method="post">
				<div class="form-group">
					<label for="user_name">User Name</label>
					<input type="name" class="form-control" name="userName" path="userName" />
				</div>
				<div class="form-group">
					<label for="region">Hospital Affiliation</label>
					<select class="form-control" name="hospitalName" required/>
						<option>Select a Hospital</option>
		                    	<option value="hospital1" path="hospitalName">Hospital1</option>
	               				<option value="hospital2" path="hospitalName">Hospital2</option>
	                			<option value="hospital3" path="hospitalName">Hospital3</option>
		                	</select>
				</div>
				<div class="row">
					
					<div class="col-md-6">
					
					</div>
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