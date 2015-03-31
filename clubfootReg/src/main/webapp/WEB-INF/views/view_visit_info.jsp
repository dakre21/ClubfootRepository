<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
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
<title>Clubfoot Registry | View Visit Info</title>
 <style>
	  body {
	  	margin-top: 1%;
	  	margin-bottom: 1%;
	  	margin-left: 1%;
	  	margin-right: 1%;
	  	font-size: medium;
	  	font-family: arial;
	  	font-style: normal;
	  }

	  h1 {
	  	font-size: x-large;
	  	font-style: bold;
	  	line-height: 1.5;
	  	text-decoration: underline;
	  }

	  fieldset {
	  	margin-bottom: 15px;
	  	padding: 10px;
  	  	text-align: left;
  	  	border: 2px groove;
	  }

	  legend {
	  	padding: 0px 3px;
	  	font-weight: bold;
	  	font-variant: small-caps;
	  }

	  em{
	  	color: red;
	  }

	  input[type=submit] {
  		width: 150px;
  		padding: 10px;
	}
  </style>
  
	<jsp:include page="navbar.jsp" />
</head>

<body>

<div class="container">
	<div class="row clearfix">
		<div class="col-sm-2 column"></div>
		<div class="col-md-8 column">
			<h1>View Visit Info</h1>
			
			<div class = "form-group">
				<label><b>Hospital/Clinic:&nbsp;</b></label><label>${visit.hospitalId}</label><br>
				<label><b>Name of Evaluator:&nbsp;</b></label><label>${visit.evaluatorId}</label><br>
				<label><b>Date of Visit:&nbsp;</b></label><label>   </label><br>
				<label><b>Date of Next Visit:&nbsp;</b></label><label>   </label><br>
				<label><b>Is this the Patient's Final Visit:&nbsp;</b></label><label>   </label><br>
				<label><b>Did the Patient Experience a relapse:&nbsp;</b></label><label>${visit.relapse }</label><br>
			</div>

			<div class = "form-group">
 				<fieldset>
				<legend>Left Foot</legend>
					<label><b>Varus:&nbsp;</b></label><label>${visit.hindfootLeftVarus }   </label><br>
					<label><b>Cavus:&nbsp;</b></label><label>${visit.hindfootLeftCavus }  </label><br>
					<label><b>Degrees Abductus:&nbsp;</b></label><label>${visit.hindfootLeftAbductus }   </label><br>
					<label><b>Degrees Equinus:&nbsp;</b></label><label> ${visit.hindfootLeftEquinus }  </label><br>
  					
  					<fieldset>
					<legend> Pirani Scores (Hindfoot) </legend>
						<label><b>Posterior crease:&nbsp;</b></label><label>${visit.leftPC }   </label><br>
						<label><b>Empty Heel:&nbsp;</b></label><label>${visit.leftEH }   </label><br>
						<label><b>Rigid Equinus:&nbsp;</b></label><label>${visit.leftRE }   </label><br>
					</fieldset>
		
					<fieldset>
					<legend> Pirani Scores (Midfoot) </legend>
						<label><b>Medial crease:&nbsp;</b></label><label>${visit.leftMC }   </label><br>
						<label><b>Talar Head Coverage:&nbsp;</b></label><label>${visit.leftTHC }   </label><br>
						<label><b>Curved Lateral Border:&nbsp;</b></label><label>${visit.leftCLB }   </label><br>
					</fieldset>
		
					<legend>Treatment</legend>
						<label><b>Type:&nbsp;</b></label><label>${visit.leftTreatment }   </label><br>
						<!--  	<label><b>Pending on type:&nbsp;</b></label><label>   </label><br>
							<label><b>Pending on type:&nbsp;</b></label><label>   </label><br> -->
  				</fieldset>
			</div>
			
			<div class = "form-group">
 				<fieldset>
				<legend>Right Foot</legend>
					<label><b>Varus:&nbsp;</b></label><label>${visit.hindfootRightVarus }   </label><br>
					<label><b>Cavus:&nbsp;</b></label><label>${visit.hindfootRightCavus }  </label><br>
					<label><b>Degrees Abductus:&nbsp;</b></label><label>${visit.hindfootRightAbductus }   </label><br>
					<label><b>Degrees Equinus:&nbsp;</b></label><label> ${visit.hindfootRightEquinus }  </label><br>
  					
  					<fieldset>
					<legend> Pirani Scores (Hindfoot) </legend>
						<label><b>Posterior crease:&nbsp;</b></label><label>${visit.rightPC }   </label><br>
						<label><b>Empty Heel:&nbsp;</b></label><label>${visit.rightEH }   </label><br>
						<label><b>Rigid Equinus:&nbsp;</b></label><label>${visit.rightRE }   </label><br>
					</fieldset>
		
					<fieldset>
					<legend> Pirani Scores (Midfoot) </legend>
						<label><b>Medial crease:&nbsp;</b></label><label>${visit.rightMC }   </label><br>
						<label><b>Talar Head Coverage:&nbsp;</b></label><label>${visit.rightTHC }   </label><br>
						<label><b>Curved Lateral Border:&nbsp;</b></label><label>${visit.rightCLB }   </label><br>
					</fieldset>
		
					<legend>Treatment</legend>
						<label><b>Type:&nbsp;</b></label><label>${visit.rightTreatment }   </label><br>
						<!--  	
						<label><b>Pending on type:&nbsp;</b></label><label>   </label><br>
						<label><b>Pending on type:&nbsp;</b></label><label>   </label><br> -->
  				</fieldset>
			</div>

			<div class = "form-group">
				<fieldset>
				<legend>Complications</legend>
					<label><b>Were there any Complications:&nbsp;</b></label><label>${visit.comments }   </label><br>
					<label><b>Description of Complication(s):&nbsp;</b></label><label>${visit.complications }   </label><br>
					<label><b>Treatment of Complication(s):&nbsp;</b></label><label>${visit.treatmentComplications }   </label><br>
					<label><b>Results after Treatment:&nbsp;</b></label><label>${visit.results }   </label><br>
				</fieldset>
			</div>
			
			<div class = "form-group">
				<fieldset>
				<legend>Feet pre-treatments photo(s)</legend>
				<div class="col-md-12">
					<div class="form-group">
					</div>
				</div>
				</fieldset>
			</div>
		</div>
	</div>
</div>

</body>

</html>