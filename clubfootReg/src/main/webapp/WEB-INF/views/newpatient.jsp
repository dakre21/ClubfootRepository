
<!DOCTYPE html>
<html lang="en">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <title>New Patient Form</title>
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
  <script>
  function validateForm(date) {
	  
	  	var today = new Date();
	    var dd = today.getDate();
	    var mm = today.getMonth()+1;
	    var yyyy = today.getFullYear();
	    
	    if(dd < 10)
	    {
	    	dd = '0' + dd
	    }
	    if(mm < 10)
	    {
	    	mm = '0' + mm
	    }
	    // First, get an array that holds all the elements.
	    var inputElements = document.getElementById("newPatient").elements;
	    //var date = document.getElementById("dob");
	    var dateArray = new Array();
	    //alert(date);
	    for(var i = 0; i < date.length; i++){
	    	if(date[i] != '/')
	    	{
	    		dateArray.push(date[i]);
	    	}
	    }
	    
	    if(dateArray[4] > yyyy[0] || dateArray[5] > yyyy[1] || dateArray[6] > yyyy[2] || dateArray[7] > yyyy[3] )
	    {
	    	//alert("Invalid date of birth");
	    	date.setCustomValidity("Invalid date of birth");
	    	//return false;
	    }
	    else if(dateArray[4] == yyyy[0] || dateArray[5] == yyyy[1] || dateArray[6] == yyyy[2] || dateArray[7] == yyyy[3] )
	    {
	    	if(dateArray[2] > mm[0])
	    	{
	    		//alert("Invalid date of birth");
	    		date.setCustomValidity("Invalid date of birth");
	    		//return false;
	    	}
	    	else if(dateArray[2] == mm[0])
	    	{
	    		if(dateArray[3] > mm[1])
	    		{
	    			//alert("Invalid date of birth");
	    			date.setCustomValidity("Invalid date of birth");
	    			//return false;
	    		}
	    		else if(dateArray[0] > dd[0])
	    		{
	    			//alert("Invalid date of birth");
	    			date.setCustomValidity("Invalid date of birth");
	    			//return false;
	    		}
	    		else if(dateArray[0] == dd[0])
	    		{
	    			if(dateArray[1] > dd[1])
	    			{
	    				//alert("Invalid date of birth");
	    				date.setCustomValidity("Invalid date of birth");
	    				//return false;
	    			}
	    		}
	    	}
	    }	
	    else if(dateArray[5] == 1 || dateArray[5] == 2 || dateArray[5] == 3 || dateArray[5] == 4 || dateArray[5] == 5 || dateArray[5] == 6 || dateArray[5] == 7 || dateArray[5] == 8)
	    {
	    	date.setCustomValidity("Invalid date of birth");
			//return false;
	    }
	    else
	    {
	    	date.setCustomValidity("");
	    }

  if (!Modernizr.input.required) {
    // The required attribute is not supported, so you need to check the
    // required fields yourself.
    	
    // Next, move through that array, checking eaching element.
    for(var i = 0; i < inputElements.length; i++) {

      // Check if this element is required.
      if (inputElements[i].hasAttribute("required")) {
        // If this elemnent is required, check if it has a value.
        // If not, the form fails validation, and this function returns false.
        if (inputElements[i].value == "") {
          alert("Custom required-field validation failed. The form will not be submitted.");
          return false;
        }
      }
    }

    // If you reach this point, everything worked out and the browser
    // can submit the form.
    return true;
  }
}
  </script>
</head>
<body>
	<h1>Create New patient </h1>  
	<form action="#" th:action="@{/newpatient}" th:object="${newpatient}" modelAttribute="newPatient" method="post" id="newPatient" onsubmit="return validateForm(newpatient.dob);">
		<p><i>Please complete the form. Mandatory fields are marked with a </i><em>*</em></p>
			<label for="pre-imgfile">Upload photo of patient here: </label>
			<input type="file" name="pre-imgfile" path="pre-imgfile"><br>
			<label for="guardianConsent"><em>*</em>Does the parent or guardian consent to being included: </label>
			<input type="radio" name="guardianConsent" value="guardian_consent" path="guardianConsent" required> Yes
			<input type="radio" name="guardianConsent" value="no_guardian_consent" path="guardianConsent" required> No <br>

			<label for="photoConsent"><em>*</em>Does the parent or guardian consent to photographs of the patient being used for CURE evaluation and marketing purposes: </label>
			<input type="radio" name="photoConsent" value="photo_consent" path="photoConsent" required> Yes
			<input type="radio" name="photoConsent" value="no_photo_consent" path="photoConsent" required> No <br>

			<label for="hospital"><em>*</em>Hospital/Clinic: </label>
			<select name="hospital" required>
				<option value="">Please select one of the following options</option>
				<option value="hosptial1" path="hospital">Hosptial 1</option>
				<option value="hosptial2" path="hospital">Hosptial 2</option>
			<select> <br>
		<fieldset>
		<legend>General Information</legend>
			<label for="patient_lastName"><em>*</em>Last name/Surname: </label>
			<input type="name" name="patient_lastName" path="patient_lastName" required>

			<label for="patient_firstName"><em>  *</em>First name: </label>
			<input type="name" name="patient_firstName" path="patient_firstName" required>

			<label for="patient_midName">   Middle name: </label>
			<input type="name" name="patient_midName" path="patient_midName"> <br>

			<label for="sex"><em>*</em>Sex: </label>
			<input type="radio" name="sex" value="male" path="sex" required> Male
			<input type="radio" name="sex" value="female" path="sex" required> Female <br>

			<label for="race">Race: </label>
			<input type="radio" name="race" value="asian" path="race"> Asian
			<input type="radio" name="race" value="white" path="race"> Caucasian (White) 
			<input type="radio" name="race" value="black" path="race"> African (Black)
			<input type="radio" name="race" value="indian" path="race"> Asian (Indian)
			<input type="radio" name="race" value="mixed" path="race"> Mixed
			<input type="radio" name="race" value="other" path="race"> Other
			<input type="radio" name="race" value="unspecified" path="race"> Unspecified <br>

			<label for="dob"><em>*</em>Date of birth: </label>
			<input type="date" name="dob" id="dob" path="dob" placeholder="dd/mm/yyyy" required  validate pattern="\d{1,2}/\d{1,2}/\d{4}" title="dd/mm/yyyy"> <br>
		<fieldset>
		<legend>Address</legend>
			<label for="addr1">Address 1: </label>
			<input type="text" name="addr1" path="addr1"> <br>
			<label for="address2">Address 2: </label>
			<input type="text" name="addr2" path="addr2"> <br>
			<label for="village">Village/Town/City: </label>
			<input type="text" name="village" path="village"> 
			<label for="province">State/Province: </label>
			<input type="text" name="province" path="province"> 
			<label for="country">Country: </label>
			<input type="text" name="country" path="country"> <br>
		</fieldset>
		</fieldset>

		<h2>Parent/Guardian Information</h2>
		<fieldset>
		<legend>Primary Parent/Guardian</legend>
			<label for="guardian_lastName">Last name/Surname: </label>
			<input type="name" name="guardian_lastName" path="guardian_lastName">

			<label for="guardian_firstName">  First name: </label>
			<input type="name" name="guardian_firstName"path="guardian_firstName">

			<label for="guardian_midName">   Middle name: </label>
			<input type="name" name="guardian_midName"path="guardian_midName"> <br>

			<label for="guardian_relationship">Relationship to parent: </label>
			<input type="radio" name="guardian_relationship" value="mother" path="guardian_relationship"> Mother
			<input type="radio" name="guardian_relationship" value="father" path="guardian_relationship"> Father
			<input type="radio" name="guardian_relationship" value="grandparent" path="guardian_relationship"> Grandparent
			<input type="radio" name="guardian_relationship" value="brother" path="guardian_relationship"> Brother
			<input type="radio" name="guardian_relationship" value="sister" path="guardian_relationship"> Sister
			<input type="radio" name="guardian_relationship" value="aunt" path="guardian_relationship"> Aunt
			<input type="radio" name="guardian_relationship" value="uncle" path="guardian_relationship"> Uncle 
			<input type="radio" name="guardian_relationship" value="friend" path="guardian_relationship"> Friend 
			<input type="radio" name="guardian_relationship" value="other" path="guardian_relationship"> Other
			<input type="radio" name="guardian_relationship" value="unspecified1" path="guardian_relationship"> Unspecified <br>

			<label for="guardian_phone1"><em>*</em>Phone number 1: <label>
			<input type="telephone" name="guardian_phone1" path="guardian_phone1" placeholder="xxx-xxx-xxxx" required pattern="(\+?\d[- .]*){7,13}" title="international, national or local phone number">
			<label for="guardian_phone2">Phone number 2: </label>
			<input type="telephone" name="guardian_phone2" path="guardian_phone2" placeholder="xxx-xxx-xxxx" pattern="(\+?\d[- .]*){7,13}" title="international, national or local phone number">

			</fieldset> 
			<p><input type="submit" value="Submit Form"></p>
			<a href="">Back to home page</a>

	</form>
</body>
</html>