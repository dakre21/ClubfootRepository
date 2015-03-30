<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html"; charset=ISO-8859-1">
<title>Clubfoot Registry | Users</title>
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

<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
     url="jdbc:mysql://localhost:3306/icr_spring"
     user="root"  password="sparkey1"/>

<sql:query dataSource="${snapshot}" var="result">
SELECT COUNT(offon) FROM icr_spring.user WHERE offon='offline';
</sql:query>


<div class="container">
	<div class="jumbotron">
		<h1>
			Users
			<a role="button" class="btn btn-primary btn-lg" href="adduser">Add New User</a>
			<a role="button" class="btn btn-lg btn-primary" href="view_users">Refresh Page</a>
		</h1>
		
		<h2>
		<table border="1" width="100%">
			<tr>
			<th>Number of Unsynced Records:</th>
			</tr>
			<c:forEach var="row" items="${result.rows}">
			<tr>
			<td><c:out value="${row}"/></td>
			</tr>
			</c:forEach>
			</table>
		</h2>
		<hr>
		<table class='table table-striped'>
		   	<thead>
		   		<tr>
		    		<th>Username</th>
		    		<th>Email</th>
		    		<th>Hospital</th>
		    		<th>Role</th>
		    	</tr>
		    </thead>
	   
	    	<tbody>
        	<c:if test="${not empty users}">
            <c:forEach var="o" items="${users}">
              <tr>
                  <td>${o.user_name}</td>
                  <td>${o.email}</td>
                  <td>${o.hospital_name}</td>
                  <td>${o.role_name}</td>
                  <td><a href="edit_user?id=${o.id}">Edit</a></td>
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