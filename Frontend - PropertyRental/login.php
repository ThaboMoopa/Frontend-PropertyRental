
<?php 
include('templates/inc_header.html'); 
?>
<script src="js/validateLogin.js"></script>

<div id="container">
<h1>Login</h1>
<h6>Please fill in the information below</h6>
<form id="registerForm" method="post">
	<ul class="list-group">
		<li class="list-group-item">

	<!--input for the email -->
	<div class="form-group row">
		<label for="email" class="col-sm-1 col-form-label" >Email</label>
			<div class="col-sm-5">
				<input type="text" name="txtemail" id="txtEmail" class="form-control" >
		 		<small id="errorEmail" class="text-danger"><?php echo $errorEmail; ?></small>
			</div>
		 </div>

	<!--input for the password -->
	<div class="form-group row"> 
		 <label for="password" class="col-sm-1 col-form-label" >Password</label>
		 	<div class="col-sm-5">
				<input type="password" name="txtPassword" id="txtPassword" class="form-control" >
		 		<small id="errorPassword" class="text-danger"><?php echo $errorPassword; ?></small>
			</div>
		</div>



<!--Example data outoput -->


	<!--Button to handle the form -->
	<div class="form-group row">
		<input type="submit" name="submitRegister" class="btn btn-outline-success" value="Login" onclick="validate()">
		<!-- <button id="submitRegister" name="submit" type="button" class="btn btn-outline-success">Register</button> -->

		<!--example data button-->
		<!-- <input type="submit" name="register" id="getInfo" value="getInfo" class="btn btn-outline-success">  -->
	</div>
	<div id="errorLogin"></div>

</li>
</ul>
</form>
</div>
<?php

include('templates/inc_footer.html'); 
?>
