$(document).ready(function(){
		$('#user').html('<div class="alert alert-success" role="alert"><p class="text-right"><button type="button" id="users" class="btn btn-outline-secondary">' +sessionStorage.user + '</button><button type="button" id="users" class="btn btn-outline-secondary" onclick="logout()">Logout</button></p></div>');
		$('#users').click(function(){
			var custId =  (sessionStorage.data).split("_")[1];
			sessionStorage.setItem("userId",custId);
			location.href = "userDetails.php";
		});

	});
function logout()
{
	sessionStorage.removeItem("user");
	sessionStorage.removeItem("userId");
	sessionStorage.removeItem("data");
	alert("You have successfully logged out!"); 
	location.href="login.php";
}