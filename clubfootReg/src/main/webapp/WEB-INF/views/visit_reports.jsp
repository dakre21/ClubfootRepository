<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html"; charset=ISO-8859-1">
<title>CURE Clubfoot | Visit Reports</title>
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
		   		<tr>
		   			<th>Visit ID</th>
		   			<th>Patient ID</th>
		   			<th>Treatment Left</th>
		   			<th>Treatment Right</th>
		   			<th>Hospital/Clinic</th>
		    	</tr>
		    </thead>
	   
	    	<tbody>
        	<c:if test="${not empty visit_reports}">
            <c:forEach var="o" items="${visit_reports}">
              <tr>
                  <td><a href="view_visit_info?id=${o.id}">${o.id}</a></td>
                  <td>${o.patientId}</td>
                  <td>${o.leftTreatment}</td>
                  <td>${o.rightTreatment}</td>
                  <td>${o.hospitalId}</td>
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