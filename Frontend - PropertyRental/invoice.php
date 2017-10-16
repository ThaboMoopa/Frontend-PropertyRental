<?php
include("templates/inc_header.html"); 
?>
<script src="js/loggedin.js"></script>
	<div id="user"></div>
	<script src="js/invoice.js"></script>
		<h1 class="text-center text-primary">Invoice</h1>
		<h6 class="text-center text-primary">Below is the order for your transaction</h6>
					<div class="col-sm-12">
						<div class="alert alert-success" role="alert">
						<h3>Invoice</h3>
						</div>
					</div>
					<table class="table">
						<tr>
							<td>
							<p>Symphony Way</p>
							<p>Bellville</p>
							<p>Cape Town</p>
							<p>7535</p>
						</td>
						<td>
							<p>Invoice : <span id="invoice"></span></p>
							<p>Invoice Date : <span id="todaysdate"></span></p>
						</td>
						</tr>
					</table>
					<div class="col-sm-12">
						<div class="alert alert-success" role="alert">
						<h3>Client Details</h3>
						</div>
						<table class="table">
							<thead>
								<tr>
									<th>Name</th>
									<th>Surname</th>
									<th>Email</th>
									<th>Contact</th>
								</tr>
								<tr>
									<td><span id="clientName"></span></td>
									<td><span id="surname"></span></td>
									<td><span id="email"></span></td>
									<td><span id="contact"></span></td>
								</tr>
							</thead>
						</table>
					</div>
					<div class="col-sm-12">
						<div class="alert alert-success" role="alert">
						<h3>Property Details</h3>
						</div>
					</div>
					<table class="table">
							<thead>
								<tr>
									<th>Name</th>
									<th>Unit No</th>
									<th>Bathroom Type</th>
									<th>Number of rooms</th>
									<th>Parking Bay Number</th>
									<th>Price</th>

								</tr>
								<tr>
									<td><span id="propertyName"></span></td>
									<td><span id="unitNumber"></span></td>
									<td><span id="bathroom"></span></td>
									<td><span id="rooms"></span></td>
									<td><span id="parking"></span></td>
									<td><span id="price"></span></td>
								</tr>
							</thead>
						</table>
					<div class="col-sm-12">
						<div class="alert alert-success" role="alert">
						<h3>Occupation Details</h3>
						</div>
					</div>
					<table class="table">
							<thead>
								<tr>
									<th>Start Date</th>
									<th>End date</th>
								</tr>
								<tr>
									<td><span id="start"></span></td>
									<td><span id="end"></span></td>
								</tr>
							</thead>
						</table>
		<script>
			document.write('<input type="hidden" value="'+sessionStorage.data+'" id="hidden">'); 
		</script>
<?php
include("templates/inc_footer.html"); 
?>