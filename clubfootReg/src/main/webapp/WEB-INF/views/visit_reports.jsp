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
  .nav_links{
  margin-left:35%;
  width:30%;
  	border: 1px solid #000000;
  }
.nav_links ul { 
	margin:0 auto;
	padding: 0px;
	background-color:#D8D8D8;
	
	list-style-type: none;
}
.nav_links li a{
	display: block;
	padding:2px;
	width: 100%;
	color: #585858;
	border-bottom: 1px solid black;
	background-color: #D0DBF0
	text-decoration:none;
}
.nav_links li a:hover{
	background-color:#A4A4A4;
	color: #585858;
	text-decoration:none;

}


</style>
<title>Clubfoot Registry | Visit Reports</title>
	<jsp:include page="navbar.jsp" />
</head>
<body>
<div class="container">
	<div class="jumbotron">
		<h1>
			Visits
		</h1>
		<hr>
		<a role="button" class="btn btn-primary btn-lg">Generate Report</a>
		<table class='table table-striped'>
		   	<thead>
		   		<tr>
		   			<th>Visit id</th>
		    	</tr>
		    </thead>
	   
	    	<tbody>
        	<c:if test="${not empty visit}">
            <c:forEach var="o" items="${visit}">
              <tr>
                  <td>${o.visits}</td>
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