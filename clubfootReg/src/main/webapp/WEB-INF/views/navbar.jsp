<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
                    <li><a href="viewpatients">View Patients</a></li>
                      <li><a href="newpatient">Add Patient</a></li>
                  </ul>
              </li>
              <li class="dropdown">
                <a href="viewevaluators" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
                  Evaluators
                  <span class="caret"></span>
                </a>
                <ul class="dropdown-menu" role="menu">
                    <li><a href="viewevaluators">View Evaluators</a></li>
                      <li><a href="evaluator">Add Evaluator</a></li>
                  </ul>
              </li>
              <li class="dropdown">
                <a href="viewhospitals" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
                  Hospitals
                  <span class="caret"></span>
                </a>
                <ul class="dropdown-menu" role="menu">
                    <li><a href="viewhospitals">View Hospitals</a></li>
                      <li><a href="hospital">Add Hospital</a></li>
                  </ul>
              </li>
              <li class="dropdown">
                <a href="viewusers" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
                  Users
                  <span class="caret"></span>
                </a>
                <ul class="dropdown-menu" role="menu">
                    <li><a href="viewusers">View Users</a></li>
                      <li><a href="adduser">Add User</a></li>
                  </ul>
              </li>
              <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
                  Reports
                  <span class="caret"></span>
                </a>
                <ul class="dropdown-menu" role="menu">
                    <li><a href="hospitalreports">Hospital</a></li>
                      <li><a href="patientreports">Patient</a></li>
                      <li><a href="visitreports">Visit</a></li>
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