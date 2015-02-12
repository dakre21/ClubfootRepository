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
</head>

<body>
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
            			<li><a href="view_evaluators">View evaluators</a></li>
            			<li><a href="hospital">Add hospital</a></li>
            			<li><a href="adduser">Add user</a></li>
            			<li><a href="visit">Add visit</a></li>
          			</ul>
        		</li>
      		</ul>
    	</div><!-- /.navbar-collapse -->
  	</div><!-- /.container-fluid -->
</nav>

<div class="container">
	<div class="jumbotron">
		<h1>
			Evaluators
			<a role="button" class="btn btn-primary" href="evaluator">Add New Evaluator</a>
		</h1>
		<table class='table table-striped'>
		   	<thead>
		   		<tr>
		    		<th>First Name</th>
		    		<th>Middle Name</th>
		    		<th>Last Name</th>
		    		<th>Title</th>
		    		<th>Hospital ID</th>
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
                  <td>${o.hospital_id}</td>
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