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

<title>Clubfoot Registry | Log in</title>
<div class="container">
		<nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="/clubfootReg/home">Clubfoot Registry</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li><a href="signup" class="btn btn-lg btn-mini">Sign up for an account</a></li>
        <li><a href="login" class="btn btn-lg btn-mini">Log in</a></li>
        <li><a href="<c:url value="/j_spring_security_logout"/>" class="btn btn-lg btn-mini">Log out</a></li>
      </ul>
      <form class="navbar-form navbar-left" role="search">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Search the registry">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
      </form>
      <ul class="nav navbar-nav navbar-right">
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="true">Form information <span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
            <li><a href="newpatient">Add new patient</a></li>
            <li><a href="evaluator">Add evaluator</a></li>
            <li><a href="hospital">Add hospital</a></li>
            <li><a href="adduser">Add user</a></li>
            <li><a href="visit">Add visit</a></li>
          </ul>
        </li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
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