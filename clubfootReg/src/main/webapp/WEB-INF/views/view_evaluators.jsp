<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
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
</head>

<body>
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
			<a class="navbar-brand" href="#">CURE Clubfoot</a>
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
	                  	<li><a href="#">Add Patient</a></li>
	                </ul>
	            </li>
	            <li class="dropdown">
	            	<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
	            		Evaluators
	            		<span class="caret"></span>
	            	</a>
	            	<ul class="dropdown-menu" role="menu">
	                	<li><a href="evaluators.php">View Evaluators</a></li>
	                  	<li><a href="add_evaluator.php">Add Evaluator</a></li>
	                </ul>
	            </li>
	            <li class="dropdown">
	            	<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
	            		Hospitals
	            		<span class="caret"></span>
	            	</a>
	            	<ul class="dropdown-menu" role="menu">
	                	<li><a href="">View Hospitals</a></li>
	                  	<li><a href="add_hospital.php">Add Hospital</a></li>
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
	            		<span class="glyphicon glyphicon-user" aria-hidden="true"></span>
	            		My Account
	            		<span class="caret"></span>
	            	</a>
	            	<ul class="dropdown-menu" role="menu">
	                	<li><a href="#">View My Account</a></li>
	                  	<li><a href="#">Account Information</a></li>
	                 	<li><a href="#">Log Out</a></li>
	                </ul>
	            </li>  
            </ul>
		</div>
	</div>
</nav>

<div class="container">
	<div class="jumbotron">
		<h1>
			Evaluators
			<a role="button" class="btn btn-primary" href="#">Add New Evaluator</a>
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
	    		<tr>
	        		<td>First Name</td>
	        		<td>Middle Name</td>
	        		<td>Last Name</td>
	        		<td>Title</td>
	        		<td>Hospital ID</td>
	        	</tr>
	        </tbody>
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