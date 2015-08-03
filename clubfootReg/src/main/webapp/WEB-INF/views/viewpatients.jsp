<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html"; charset=ISO-8859-1">
<title>Clubfoot Registry | Patients</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
<style type="text/css">
  body {
    padding-top: 70px;
  }
</style>
	<jsp:include page="navbar.jsp" />
</head>

<body>


<div class="container">
	<div class="jumbotron">
		<h1>
			Patients
			<!-- <sec:authorize access="hasAnyRole('ADMIN_ROLE')">  -->
			<a role="button" class="btn btn-primary btn-lg" href="patient">Add New Patient</a>
			<!-- </sec:authorize>  -->
		</h1>
		<hr>
		<table class='table table-striped'>
		   	<thead>
		   		<tr>
		    		<th>ID</th>
		    		<th>First Name</th>
		    		<th>Middle Name</th>
		    		<th>Last Name</th>
		    	</tr>
		    </thead>
	   
	    	<tbody>
        	<c:if test="${not empty patients}">
            <c:forEach var="o" items="${patients}">
              <tr>
                  <td><a href="viewpatientinfo?id=${o.id}">${o.id}</a></td>
				  <td>${o.patientFirstName}</td>
				  <td>${o.patientMiddleName}</td>
				  <td>${o.patientLastName}</td>
				  <sec:authorize access="hasRole('ROLE_ADMIN')">    
				  <td><a href="editpatient?id=${o.id}">Edit</a></td>
				  </sec:authorize>  
				  <td><a href="visit?id=${o.id}">Add Visit</a></td>
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
				<p>&copy; Some Copyright Info</p>
			</footer>
		</div>
	</div>
</div>
</body>
</html>   