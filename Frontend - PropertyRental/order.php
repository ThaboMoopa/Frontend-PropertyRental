<?php
include("templates/inc_header.html"); 
?>
<script>
	document.write("<p>You are Logged in: "+sessionStorage.data+"</p>");
	</script>
	<script src="js/validateorder.js"></script>
		<h1>Order details</h1>
		<h6>Below is the order for your transaction</h6>

		<ul class="list-group">
			<li class="list-group-item">
				
			<!--input for the email -->
			<!-- <div class="form-group row"> -->
					<hr>
					<div class="col-sm-12">
						
							<p>Client Details</p>
							<label for="name">Name: </label><span id="clientName"></span><br />
							<label for="surname">Surname:</label><span id="surname"></span><br />
							<label for="email">Email:</label><span id="email"></span><br />
							<label for="contact">Contact: </label><span id="contact"></span>
					</div>
					<hr>
					<div class="col-sm-12">
						
							<p>Property Details</p>
							<label for="name">Name: </label><span id="propertyName"></span><br />
							<label for="unit">Unit No: </label><span id="unitNumber"></span><br />
							<label for="bathroom">Bathroom Type: </label><span id="bathroom"></span><br />
							<label for="rooms">Number of rooms: </label><span id="rooms"></span><br />
							<label for="parking">Parking Bay Number: </label><span id="parking"></span><br />
							<label for="price">Price: </label><span id="price"></span><br />
					</div>
					<div class="col-sm-12">
						
							<p>Occupation Details</p>
							<label for="start">Start Date: </label><span id="start"></span><br />
							<label for="end">End date: </label><span id="end"></span><br />
					</div>
			</li>
		</ul>
		<script>
			document.write('<input type="hidden" value="'+sessionStorage.data+'" id="hidden">'); 
		</script>
<?php
include("templates/inc_footer.html"); 
?>