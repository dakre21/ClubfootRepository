<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html"; charset=ISO-8859-1">
<title>Clubfoot Registry | Hospitals</title>
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
			Hospitals
			<a role="button" class="btn btn-lg btn-primary" href="hospital">Add New Hospital</a>
		</h1>
		<hr>
		<table class='table table-striped'>
		   	<thead>
		   		<tr>
		    		<th>Hospital/Clinic Name</th>
		    		<th>Region</th>
		    	</tr>
		    </thead>
	   
	    	<tbody>
        	<c:if test="${not empty hospitals}">
            <c:forEach var="o" items="${hospitals}">
              <tr>
                  <td>${o.hospitalName}</td>
                  <td>${o.regionName}</td>
                  <sec:authorize ifAnyGranted="ROLE_ADMIN">
                  <td><a href="edithospital?id=${o.id}">Edit</a></td>
                  </sec:authorize>
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