
<?php 
include('templates/inc_header.html'); 
?>
<script src="js/validateEdit.js"></script>
<div id="surname"></div>
<div id="container">
<h1>Edit Details</h1>
<h6>Please fill in the information below</h6>
<form id="registerForm" method="post">
	<ul class="list-group">
		<li class="list-group-item">
	<div class="form-group row">
		
		<label for="name" class="col-sm-1 col-form-label">Name</label>
		<div class="col-sm-5">
			<script>
			var username = sessionStorage.editUser.split("_")[2]; //value of the last number
			var surname = sessionStorage.editUser.split("_")[3];
			var email = sessionStorage.editUser.split("_")[4];
			var contact = sessionStorage.editUser.split("_")[5];
			document.write('<input type="text" name="txtname" id="txtName" class="form-control" value="'+username+'"');
			</script>
			<small id="errorName" class="text-danger"></small>
		</div>
	</div>

	<!--input for the surname -->
	<div class="form-group row">
		<label for="surname" class="col-sm-1 col-form-label" >Surname</label>
		
			<div class="col-sm-5">
				<div id="surname"></div>
				<script>
				var surname = sessionStorage.editUser.split("_")[3];
				document.write('<input type="text" name="txtSurname" id="txtSurname" class="form-control" value="'+surname+'"');
				</script>
		 		<small id="errorSurname" class="text-danger"></small>
			</div>
		</div>

	<!--input for the email -->
	<div class="form-group row">
		<label for="email" class="col-sm-1 col-form-label" >Email</label>
			<div class="col-sm-5">
				<script>
				var email = sessionStorage.editUser.split("_")[4];
				document.write('<input type="text" readonly name="txtEmail" id="txtEmail" class="form-control" value="'+email+'"');
				</script>
		 		<small id="errorEmail" class="text-danger"></small>
			</div>
		 </div>

	 <!--input for the contact -->
	<div class="form-group row">

		<label for="contact" class="col-sm-1 col-form-label" >Contact</label>
			<div class="col-sm-5">
				<script>
				var contact = sessionStorage.editUser.split("_")[5];
				document.write('<input type="text" name="txtContact" id="txtContact" class="form-control" value="'+contact+'"');
				</script>
		 		<small id="errorContact" class="text-danger"></small>
			</div>
		</div>

	<!--input for the password -->
	<div class="form-group row"> 
		 <label for="password" class="col-sm-1 col-form-label" >Password</label>
		 	<div class="col-sm-5">
				<input type="password" name="txtPassword" id="txtPassword" class="form-control">
		 		<small id="errorPassword" class="text-danger"></small>
			</div>
		</div>

	<!--input for the confirm password -->
	<div class="form-group row">
		<label for="password" class="col-sm-1 col-form-label" >Confirm password</label>
			<div class="col-sm-5">
				<input type="password" name="txtConfirm" id="txtConfirm" class="form-control">
		 		<small id="errorConfirmPassword" class="text-danger"></small>
			</div>
		 </div>	

<!--Example data outoput -->
<div id="register_output"></div>

	<!--Button to handle the form -->
	<div class="form-group row">
		<input type="submit" name="submit" class="btn btn-outline-success" value="Edit" onclick="validate()">
		<script>
		document.write('<input type="hidden" value="'+sessionStorage.data+'" id="hidden">');
		</script>
	</div>

</li>
</ul>
</form>
</container>
<?php

include('templates/inc_footer.html'); 
?>
