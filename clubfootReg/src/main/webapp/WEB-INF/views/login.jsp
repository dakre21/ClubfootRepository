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
<title>Clubfoot Registry | Log in</title>
<div class="container">
<nav id="myNavbar" class="navbar navbar-default navbar-inverse navbar-fixed-top" role="navigation">
  <!-- Brand and toggle get grouped for better mobile display -->
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbarCollapse">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="home">Clubfoot Registry</a>
    </div>
    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="navbarCollapse">
      <ul class="nav navbar-nav navbar-right">
              <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
                  Patients
                  <span class="caret"></span>
                </a>
                <ul class="dropdown-menu" role="menu">
                    <li><a href="#">View Patients</a></li>
                      <li><a href="newpatient">Add Patient</a></li>
                  </ul>
              </li>
              <li class="dropdown">
                <a href="view_evaluators" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
                  Evaluators
                  <span class="caret"></span>
                </a>
                <ul class="dropdown-menu" role="menu">
                    <li><a href="view_evaluators">View Evaluators</a></li>
                      <li><a href="evaluator">Add Evaluator</a></li>
                  </ul>
              </li>
              <li class="dropdown">
                <a href="view_hospitals" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
                  Hospitals
                  <span class="caret"></span>
                </a>
                <ul class="dropdown-menu" role="menu">
                    <li><a href="view_hospitals">View Hospitals</a></li>
                      <li><a href="hospital">Add Hospital</a></li>
                  </ul>
              </li>
              <li class="dropdown">
                <a href="view_users" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
                  Users
                  <span class="caret"></span>
                </a>
                <ul class="dropdown-menu" role="menu">
                    <li><a href="view_users">View Users</a></li>
                      <li><a href="adduser">Add User</a></li>
                  </ul>
              </li>
              <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
                  Reports
                  <span class="caret"></span>
                </a>
                <ul class="dropdown-menu" role="menu">
                    <li><a href="#">Hospital</a></li>
                      <li><a href="#">Patient</a></li>
                      <li><a href="#">Visit</a></li>
                  </ul>
              </li>
              <li class="dropdown">
                	
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
                  User Session
                  <span class="caret"></span>
                </a>
                <ul class="dropdown-menu" role="menu">
                    <li><a href="login">Log in</a></li>
                      <li><a href="<c:url value="/j_spring_security_logout"/>">Log out</a></li>
                  </ul>
              </li>
              <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
                  <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
                  My Account
                  <span class="caret"></span>
                </a>
                <ul class="dropdown-menu" role="menu">
                    <li><a href="#">View My Account</a></li>
                      <li><a href="#">Account Information</a></li>
                  </ul>
              </li>  
            </ul>
    </div>
  </div>
</nav>
</div>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Please sign in</h3>
					</div>
					<div class="panel-body">
						<c:if test="${not empty error }">
						<div class="alert alert-danger">
							<spring:message code="AbstractUserDetailsAuthenticationProvider.badCredentials"/><br />
						</div>
						</c:if>
						<form action="<c:url value= "/j_spring_security_check">
						</c:url>" method="post">
							<fieldset>
								<div class="form-group">
									<input class="form-control" placeholder="User Name" name='j_username' type="text">
								</div>
								<div class="form-group">
									<input class="form-control" placeholder="Password" name='j_password' type="password" value="">
								</div>
								<input class="btn btn-lg btn-success btn-block" type="submit" value="Login" href="/clubfootReg/home">
							</fieldset>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>