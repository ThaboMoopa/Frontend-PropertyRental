<?php
include('templates/inc_header.html'); 
//include('functions/inc_validateRegister.php');
?>
<script src="js/loggedin.js"></script> 
<script src="js/validateProperty.js"></script>
<div id="user"></div>
<div id="container">
	<form id="frmProperty" name="frmProperty" method="post" action="<?php $_SERVER['SCRIPT_NAME']; ?>">
		<h1 class="text-center text-primary">Property</h1>
		<h6 class="text-center text-primary">Please Select a property</h6>
		<ul class="list-group">
			<h3 class="text-danger">Rosenvale</h3>
			<li class="list-group-item">
			<!--input for the email -->
			<div class="form-group row">
					<div class="col-sm-4">
						<img src="images/rosenvale.jpg" class="img-thumbnail">
					</div>
					<div class="col-sm-4">
						<div class="col-sm-3"><img src="images/bathroom.svg" id="bathroom"><p>1 - 2 Bathrooms</p></div>
						
						<div class="col-sm-3"><img src="images/garage.svg" id="bathroom"></div>
						<p>1 - 15 Parking spaces with additional visitors parking area </p>
					</div>
					<div class="col-sm-4">
						<div class="col-sm-4"><img src="images/rand.svg" id="bathroom"></div><p>Price: 3000 - 6000</p>
						<div class="col-sm-4"><img src="images/calendar.svg" id="bathroom"></div><p>Available to Rent</p>
					</div>
						<label for="Address" id="Rosenvale">Address : </label>
						<p>Rosenvale Road, </p>
						<p>Cape Town, </p>
						<p>Western Cape,</p>
						<p>7570 </p> 		
			</div>
			<input type="submit" id="submitRosenvale" value="Select" class="btn btn-success"onclick="validateRosenvale()"> 
				 <small id="errorBedrooms" class="text-danger"></small>
			</li>
		</ul>
		<br />
		<ul class="list-group">
			<h3 class="text-danger">Exploria</h3>
			<li class="list-group-item">
			<!--input for the email -->
			<div class="form-group row">
					<div class="col-sm-4">
						<img src="images/exploria.jpg" class="img-thumbnail">
					</div>
					<div class="col-sm-4">
						<div class="col-sm-3"><img src="images/bathroom.svg" id="bathroom"><p>1 - 2 Bathrooms</p></div>
						
						<div class="col-sm-3"><img src="images/garage.svg" id="bathroom"></div>
						<p>1 - 15 Parking spaces with additional visitors parking area </p>
					</div>
					<div class="col-sm-4">
						<div class="col-sm-4"><img src="images/rand.svg" id="bathroom"></div><p>Price: 3000 - 6000</p>
						<div class="col-sm-4"><img src="images/calendar.svg" id="bathroom"></div><p>Available to Rent</p>
					</div>
						<label for="Address" id="Rosenvale">Address: </label>
						<p>Exploria Road, </p>
						<p>Cape Town, </p>
						<p>Western Cape,</p>
						<p>7570 </p> 		
			</div>
			<input type="submit" id="submitExploria" value="Select" class="btn btn-success"onclick="validateExploria()"> 
				 <small id="errorBedrooms" class="text-danger"></small>
			</li>
		</ul>
		<script>
			document.write('<input type="hidden" value="'+sessionStorage.data+'" id="hidden">'); 
		</script>
</form>

<?php

include('templates/inc_footer.html'); 
?>
