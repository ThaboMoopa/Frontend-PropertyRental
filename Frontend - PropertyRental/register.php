
<?php 
include('templates/inc_header.html'); 
?>
<script src="js/validation.js"></script>
<div id="container">
<h1>Register</h1>
<h6>Please fill in the information below</h6>
<form id="registerForm" method="post">
	<ul class="list-group">
		<li class="list-group-item">
	<div class="form-group row">
		
		<label for="name" class="col-sm-1 col-form-label">Name</label>
		<div class="col-sm-5">
			<input type="text" class="form-control" name="txtname" id="txtName" aria-describedby="sizing-addon1" >
			<small id="errorName" class="text-danger"></small>
		</div>
	</div>

	<!--input for the surname -->
	<div class="form-group row">
		<label for="surname" class="col-sm-1 col-form-label" >Surname</label>
		
			<div class="col-sm-5">
				<input type="text" name="txtsurname" id="txtSurname" class="form-control">
		 		<small id="errorSurname" class="text-danger"></small>
			</div>
		</div>

	<!--input for the email -->
	<div class="form-group row">
		<label for="email" class="col-sm-1 col-form-label" >Email</label>
			<div class="col-sm-5">
				<input type="text" name="txtemail" id="txtEmail" class="form-control" >
		 		<small id="errorEmail" class="text-danger"></small>
			</div>
		 </div>

	 <!--input for the contact -->
	<div class="form-group row">

		<label for="contact" class="col-sm-1 col-form-label" >Contact</label>
			<div class="col-sm-5">
				<input type="text" name="txtcontact" id="txtContact" class="form-control"  >
		 		<small id="errorContact" class="text-danger"></small>
			</div>
		</div>

	<!--input for the password -->
	<div class="form-group row"> 
		 <label for="password" class="col-sm-1 col-form-label" >Password</label>
		 	<div class="col-sm-5">
				<input type="password" name="txtPassword" id="txtPassword" class="form-control" >
		 		<small id="errorPassword" class="text-danger"></small>
			</div>
		</div>

	<!--input for the confirm password -->
	<div class="form-group row">
		<label for="password" class="col-sm-1 col-form-label" >Confirm password</label>
			<div class="col-sm-5">
				<input type="password" name="txtConfirm" id="txtConfirm" class="form-control" >
		 		<small id="errorConfirmPassword" class="text-danger"></small>
			</div>
		 </div>	

<!--Example data outoput -->
<div id="register_output"></div>

	<!--Button to handle the form -->
	<div class="form-group row">
		<input type="submit" name="submitRegister" class="btn btn-outline-success" value="Register" onclick="validate()">
	</div>

</li>
</ul>
</form>
</container>
<?php

include('templates/inc_footer.html'); 
?>
