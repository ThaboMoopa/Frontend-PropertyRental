<?php
include('templates/inc_header.html'); 
?>

<h1 class="text-center text-primary">Resident Details</h1>
<form id="frmDetails" name="frmDetails" method="post" action="<?php $_SERVER['SCRIPT_NAME']; ?>">
<table class="table">
	<tr>
		<th>Name</th><th>Surname</th><th>Email</th><th>Contact</th>
	</tr>
	<td><div id="username"></div></td>
	<td><div id="surname"></div></td>
	<td><div id="email"></div></td>
	<td><div id="contact"></div></td>
</table>
<button type="button" class="btn btn-primary" onclick="editDetails()">
  Edit Details
</button>

</table>
</form>

<script> 
$.ajax({
		type: "GET",
		dataType: "json",
		url: "http://localhost:8080/resident/readResident?",
		data: "id="+sessionStorage.userId, 
		async: false,
		success: function(data)
		{ 
			$('#username').text(data.name); 
			$('#surname').text(data.surname);
			$('#email').text(data.email); 
			$('#contact').text(data.contact);  
		}
	}); 
function editDetails(){
	$.ajax({
		type: "GET",
		dataType: "json",
		url: "http://localhost:8080/resident/readResident?",
		data: "id="+sessionStorage.userId, 
		async: false,
		success: function(data)
		{ 
			var userEdit = "_" + data.id + "_" + data.name + "_" + data.surname + "_" + data.email+ "_" + data.contact;
			sessionStorage.setItem("editUser",userEdit);
			location.href="editDetails.php"; 
		}
	}); 

}
</script>
<?php
include('templates/inc_footer.html'); 
?>