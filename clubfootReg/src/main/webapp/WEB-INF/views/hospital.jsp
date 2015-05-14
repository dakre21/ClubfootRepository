
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
</style>
<title>Clubfoot Registry | Add Hospital</title>
	<jsp:include page="navbar.jsp" />
</head>

<body>

<div class="container">
	<div class="row clearfix">
    	<div class="col-sm-2 column"></div>
    	<div class="col-md-8 column">
      		<h1 align="center">Add New Hospital</h1>
      		<form action="#" th:action="@{/hospital}" th:object="${hospital}" modelAttribute="Hospital" id="Hospital" method="post">
        		<div class="form-group">
          			<label for="hospitalName">Hospital/Clinic Name</label>
          			<input type="text" class="form-control" id="hospitalName" name="hospitalName" path="hospitalName"/>
        		</div>
         		<div class="form-group">
              		<label for="regionId">Region</label>
                	<form:select class="form-control" path="regionList" id="regionId" name="regionId">
                 		<form:option value="" label="Select a Region" disabled="true" selected="true" style="display: none;"/>
                 		<form:options items="${regionList}" />
                 	</form:select>
            	</div>
        		&nbsp;
        		<div class="row" align="center">
          			<button type="submit" class="btn btn-lg btn-primary">Save</button>
        		</div>
      		</form>
    	</div>
    	<div class="col-sm-2 column"></div>
  	</div>
</div>

<script type="text/javascript">
  $(".dropdown-menu li a").click(function(){
    var selText = $(this).text();
    $(this).parents('.btn-group').find('.dropdown-toggle').html(selText+' <span class="caret"></span>');
  });
</script>

</body>
</html>