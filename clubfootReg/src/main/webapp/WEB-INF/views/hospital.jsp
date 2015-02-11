
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

<title>Clubfoot Registry | Add Hospital</title>
<div class="container">
    <nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="/clubfootReg/home">Clubfoot Registry</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li><a href="signup" class="btn btn-lg btn-mini">Sign up for an account</a></li>
        <li><a href="login" class="btn btn-lg btn-mini">Log in</a></li>
        <li><a href="<c:url value="/j_spring_security_logout"/>" class="btn btn-lg btn-mini">Log out</a></li>
      </ul>
      <form class="navbar-form navbar-left" role="search">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Search the registry">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
      </form>
      <ul class="nav navbar-nav navbar-right">
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="true">Form information <span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
            <li><a href="newpatient">Add new patient</a></li>
            <li><a href="evaluator">Add evaluator</a></li>
            <li><a href="hospital">Add hospital</a></li>
            <li><a href="adduser">Add user</a></li>
            <li><a href="visit">Add visit</a></li>
          </ul>
        </li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
</div>
</head>

<body>

<div class="container">
  <div class="row clearfix">
    <div class="col-sm-2 column"></div>
    <div class="col-md-8 column">
      <h1 align="center">Add New Hospital</h1>
      <form action="#" th:action="@{/evaluator}" th:object="${evaluator}" modelAttribute="Evaluator" id="Evaluator" method="post">
        <div class="form-group">
          <label for="hospital">Hospital/Clinic Name</label>
          <input type="text" class="form-control" id="hospital" name="hospitalName" path="hospitalName"/>
        </div>
        <div class="row">
          <div class="col-md-12">
            <div class="form-group">
              <label for="region">Region</label>
              <select class="form-control" id="hospitalRegion" name="hospitalRegion">
                <option>Select a Region</option>
                          <option value="region1" name="hospitalRegion" path="hospitalRegion">Region1</option>
                          <option value="region2" name="hospitalRegion" path="hospitalRegion">Region2</option>
                      </select>
            </div>
          </div>
        </div>
        &nbsp;
        <div class="row" align="center">
          <button type="submit" class="btn btn-lg btn-primary">Submit Form</button>
          <button type="reset" class="btn btn-lg btn-default">Clear</button>
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