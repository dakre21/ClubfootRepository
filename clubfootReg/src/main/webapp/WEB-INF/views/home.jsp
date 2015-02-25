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
<title>Clubfoot Registry | Home</title>
	<jsp:include page="navbar.jsp" />
</head>
<body>

<div class="container">
  <div class="row clearfix">
    <div class="col-sm-2 column"></div>
    <div class="col-md-8 column">
	<div class = "form-group">
        <h1 align = "center">
          <span>
            The Center for Bioinformatics and Computational Biology
            <br/>
            <small>The University of Iowa</small>
          </span>
        </h1>
     

        <h4 align = "center">INTERNATIONAL CLUBFOOT REGISTRY PORTALS AND ORGANIZATIONS</h4>
        <br/>
       
        <div class = "nav_links">
        <ul align = "center"class='portals-and-organizations-list'>
          <li class="portal"><a href="">CURE</a></li>
          <li class="organization"><a href="">MIRACLEFEET</a></li>
          <li class="organization"><a href="">PIA</a></li>
          <li class="portal"><a href="">POF</a></li>
          <li class="portal"><a href="">STEPS</a></li>
        </ul>

        </div>

</div>
</div>
</div>
</div>



	<!-- <div class="container">
		<h1> ${greeting } </h1>
		<p> ${tagline } </p>
		<p> ${hospital.hospitalName } </p>
		<p> ${hospital.hospitalRegion } </p>
		<br><br>
		<p> ${user.hospitalName } </p>
		<p> ${user.userName } </p>
		<br><br>
		<p> ${visit.hospitalName } </p>
		<br><br>
		<p> ${evaluator.title } </p>
	</div>-->
</body>
</html>