<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html"; charset=ISO-8859-1">
<title>CURE Clubfoot | Evaluators</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
<style type="text/css">
  body {
    padding-top: 70px;
  }
</style>
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
                	<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">User Session
                	<span class="caret"></span>
                	</a>
                	<ul class="dropdown-menu" role="menu">
                		<li><a href="login">Log in</a></li>
                		<li class="logout"><a href="<c:url value="/j_spring_security_logout"/>">Log out</a></li>
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
	<div class="jumbotron">
		<table class='table table-striped'>
		   	<thead>
          <h1>
            Evaluators
            <a role="button" class="btn btn-lg btn-primary" href="evaluator">Add New Evaluator</a>
          </h1>
          <hr>
		   		<tr>
		    		<th>First Name</th>
		    		<th>Middle Name</th>
		    		<th>Last Name</th>
		    		<th>Title</th>
		    		<th>Hospital</th>
		    	</tr>
		    </thead>
	   
	    	<tbody>
        	<c:if test="${not empty evaluators}">
            <c:forEach var="o" items="${evaluators}">
              <tr>
                  <td>${o.first_name}</td>
                  <td>${o.middle_name}</td>
                  <td>${o.last_name}</td>
                  <td>${o.title}</td>
                  <td>${o.hospital_name}</td>
                  <td><a href="#">Edit</a></td>
              </tr>
            </c:forEach>
          </c:if>
	      </tbody>
	  </table>
	</div>	

	<hr>

	<div class="row">
		<div class="col-xs-12">
			<footer align="center">
				<p>&copy; Some Copywrite Info</p>
			</footer>
		</div>
	</div>
</div>
</body>
</html>                                 		