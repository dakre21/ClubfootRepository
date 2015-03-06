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
	<jsp:include page="navbar.jsp" />
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
                  <td><a href="edit_evaluator?id=${o.id}">Edit</a></td>
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