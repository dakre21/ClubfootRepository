
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
          <label for="hospital">Hospital/Clinic Name</label>
          <input type="text" class="form-control" id="hospital" name="name" path="name"/>
        </div>
        <div class="row">
          <div class="col-md-12">
            <div class="form-group">
              <label for="region">Region</label>
              <select class="form-control" id="region_id" name="region_id">
                <option>Select a Region</option>
                          <option value="1" name="region_id" path="region_id">Region1</option>
                          <option value="2" name="region_id" path="region_id">Region2</option>
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