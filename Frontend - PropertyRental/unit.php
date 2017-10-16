<?php 
include("templates/inc_header.html"); 
?>
<script src="js/loggedin.js"></script> 
<script src="js/validateUnit.js"></script>
<script>
	$(function(){
		$("#datepicker").datepicker();
	});
	$(function(){
		$("#datepicker2").datepicker(); 
	});
	
</script> 
<div id="user"></div>
<div id="container">
		<form name="unitForm" id="unitForm" method="post" action="<?php $_SERVER['SCRIPT_NAME']; ?>">
		<h1 class="text-center text-primary">Unit</h1>
		<h6 class="text-center text-primary">Please fill in the form below</h6>

		<ul class="list-group">
			<h3 class="text-danger">Bedrooms</h3>
			<li class="list-group-item">
				
			<!--input for the email -->
			<div class="form-group row">
				<label for="rooms" class="col-sm-2 col-form-label" >Number of bedrooms:</label>
					<div class="col-sm-5">
						<input type="radio" name="rdoRooms" id="room1" class="form-check-input" value="0">0 
						<p>Cost price is R3000.00</p>
						<input type="radio" name="rdoRooms" id="room1" class="form-check-input" value="1">1
						<p>Cost price is R4000.00</p>
						<input type="radio" name="rdoRooms" id="room2" class="form-check-input" value="2">2
						<p>Cost price is R5000.00</p>
						<input type="radio" name="rdoRooms" id="room3" class="form-check-input" value="3">3
						<p>Cost price is R6000.00</p>
				 		<script>
							$("input[name=rdoRooms]").click(function(){
								if($('input:radio[name=rdoRooms]:checked').val()==0)
								{
									$('#image').hide().html();
								}
								else if($('input:radio[name=rdoRooms]:checked').val()==1)
								{
									$('#image').hide().html('<img src="images/oneroom.jpg" height="250px" width="200px">').fadeIn('slow');
								}
								else if($('input:radio[name=rdoRooms]:checked').val()==2)
								{
									$('#image').hide().html('<img src="images/tworooms.jpg" height="250px" width="200px">').fadeIn('slow');
								}
								else if($('input:radio[name=rdoRooms]:checked').val()==3)
								{
									$('#image').hide().html('<img src="images/threerooms.jpg" height="250px" width="200px">').fadeIn('slow');
								}
							});
						</script>
					</div>
					<div class="col-sm-5">
						<div id="image" ></div>
					</div>
				 </div>
				 <small id="errorBedrooms" class="text-danger"></small>
			</li>
		</ul>
		<br />
		<ul class="list-group">
			<h3 class="text-danger">Bathroom</h3>
			<li class="list-group-item">
			<!--input for the password -->
			<div class="form-group row"> 
				 <label for="bathroom" class="col-sm-2 col-form-label" >Bathroom Type:</label>
				 	<div class="col-sm-5">
						<input type="radio" name="rdoBathroom" id="bathroom1" class="form-check-input" value="shower">Shower only
						<br />
						<input type="radio" name="rdoBathroom" id="bathroom2" class="form-check-input" value="both">Shower and Bath
					</div>
					<div class="col-sm-5">
					<div id="bath"></div>
					</div>
				</div>
				<small id="errorBathrooms" class="text-danger"></small>
			</li>
		</ul>
		<br />
		<ul class="list-group">
			<h3 class="text-danger">Parking</h3>
			<li class="list-group-item">

				<p>Do you require any parking space?</p> 
			<div class="form-group row">

				 <label for="bathroom" class="col-sm-2 col-form-label" >Parking</label>
				 	<div class="col-sm-5">
						<input type="radio" name="rdoParking" id="parking1" class="form-check-input" value="Yes">Yes
						&nbsp; &nbsp; &nbsp; 
						<input type="radio" name="rdoParking" id="parking2" class="form-check-input" value="No">No
				 		
					</div>
				</div>
				<small id="errorParking" class="text-danger"></small>
			</li>
		</ul>
		<br />
		<ul class="list-group">
			<h3 class="text-danger">Occupation</h3>
			<li class="list-group-item">

				<p>Select the dates when you would like to occupy the unit</p> 
				<div class="form-group row">
				 <label for="bathroom" class="col-sm-2 col-form-label" >Start date:</label>
				 	<div class="col-sm-5">
						<input type="text" id="datepicker">
						<small id="errorStartDate" class="text-danger"></small>
					</div>
				</div>
				
				<div class="form-group row">
					<label for="bathroom" class="col-sm-2 col-form-label" >End date:</label>
						<div class="col-sm-5">
						<input type="text" id="datepicker2">
				 		<small id="errorEndDate" class="text-danger"></small>
				 	</div>
					</div>
					<input type="submit" name="submitRegister" class="btn btn-success" value="Submit" onclick="validate()">
			</li>
		</ul>
		<br />
		
		<div id="cost"></div>
		<script>
			document.write('<input type="hidden" value="'+sessionStorage.data+'" id="hidden">'); 
		</script>
		</form>
		
</div>

<?php
include("templates/inc_footer.html");  
?>