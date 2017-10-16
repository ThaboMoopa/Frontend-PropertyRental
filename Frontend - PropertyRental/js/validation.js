


//----------------------validate the name-----------------------//
function validateName(username){
	
	if(username === ""){
			$("#errorName").text("Please enter a name.").show();
			 

			//fade out the error text when the user clicks on the textbox
				$("#txtName").click(function(){
        			$("#errorName").fadeOut('slow'); 
    			});

    			//prevent the form from being submitted if there is an error
				event.preventDefault(); 
				return 0; 
		}
		else if(!isNaN(username))
		{
			$("#errorName").text("Only alphabetic characters allowed in the field.").show();
			//++errorInput; 

			//fade out the error text when the user clicks on the textbox
				$("#txtName").click(function(){
        			$("#errorName").fadeOut('slow'); 
    			});
    			return 0; 

    			//prevent the form from being submitted if there is an error
				event.preventDefault(); 
		}
		else
			return username; 
		

}
//-------------------------validate the surname --------------------//
function validateSurname(surname)
{
		if($("#txtSurname").val() === ""){
			$("#errorSurname").text("Please enter a surname.").show();
				//++errorInput; 
			//fade out the error text when the user clicks on the textbox
				$("#txtSurname").click(function(){
        			$("#errorSurname").fadeOut('slow'); 
    			});
    			return 0; 

    			//prevent the form from being submitted if there is an error
				event.preventDefault(); 
				return "";
		}
		else if(!isNaN(surname))
		{
			$("#errorSurname").text("Only alphabetic characters allowed in the field.").show();
			//++errorInput; 

			//fade out the error text when the user clicks on the textbox
				$("#txtSurname").click(function(){
        			$("#errorSurname").fadeOut('slow'); 
    			});
    			return 0; 

    			//prevent the form from being submitted if there is an error
				event.preventDefault(); 
		}
		else
		{
			//$("#txtSurname").text('<img src="images/correct.svg"').show();
			return surname; 
		}
		$("#successMessage2").html(errorInput);


}
//-------------------validate the Email---------------------//
function validateEmail(email)
{

		
		var matchingEmails = null;  
		$.ajax({
			  type: "GET",
			  dataType: "json",
			  url: "http://localhost:8080/resident/readResidentEmail?",
			  data: "email=" + email,
			  async: false,
			  success: function(response)
				{
					console.log(response); 
				matchingEmails = response.email;
				$("#successMessage3").html(matchingEmails + " its empty 3"); 
				
 				} 

 			});
	   
	if(email === matchingEmails)
	{
	$("#errorEmail").html("The email address already exists, please try again");
		$("#txtEmail").click(function(){
        $("#errorEmail").fadeOut('slow'); 
    });
		event.preventDefault();
		return 0;
	}

	 else if($("#txtEmail").val() === ""){
			$("#errorEmail").text("Please enter an email address.").show();
				 
			//fade out the error text when the user clicks on the textbox
				$("#txtEmail").click(function(){
        			$("#errorEmail").fadeOut('slow'); 
    			});

    			//prevent the form from being submitted if there is an error
				event.preventDefault();
				return 0;
			
		}
		else if(validEmail(email) === false) 
			{
			$("#errorEmail").text("Email is invalid! Please try again.").show();
				//++errorInput; 
			//fade out the error text when the user clicks on the textbox
				$("#txtEmail").click(function(){
        			$("#errorEmail").fadeOut('slow'); 
    			});

    			//prevent the form from being submitted if there is an error
				event.preventDefault(); 
				return 0;
			}
			else if(matchingEmails === email)
			{
				$("#errorEmail").text("Email already exists please try a different email address.");
					event.preventDefault();
					return 0; 
			}
		else
		{
			$("#txtEmail").text('<img src="images/correct.svg"').show();
			return email; 
		}
		
		function validEmail(eEmail)
		{
			var filter = /^([0-9a-zA-Z]+[-._+&amp;])*[0-9a-zA-Z]+@([-0-9a-zA-Z]+[.])+[a-zA-Z]{2,6}$/; 
			if(filter.test(eEmail))
				return true; 
			else 
				return false; 
		}
		
}
//-------------------validate the Contact---------------------//
function validateContact(contact)
{
		if($("#txtContact").val() === ""){
			$("#errorContact").text("Please enter a contact number.").show();
				//++errorInput; 
			//fade out the error text when the user clicks on the textbox
				$("#txtContact").click(function(){
        			$("#errorContact").fadeOut('slow'); 
    			});

    			//prevent the form from being submitted if there is an error
				event.preventDefault();
				return 0;  
		}
		else if(isNaN(contact))
		{
			$("#errorContact").text("Only numeric characters are allowed in the field.").show();
				//++errorInput; 
			//fade out the error text when the user clicks on the textbox
				$("#txtContact").click(function(){
        			$("#errorContact").fadeOut('slow'); 
    			});

    			//prevent the form from being submitted if there is an error
				event.preventDefault(); 
				return 0; 
		}
		else
		{
			$("#txtContact").text('<img src="images/correct.svg"').show();
			return contact; 
		}
		//$("#successMessage2").html(errorInput);

}

//-------------------validate the Password---------------------//
function validatePassword(password)
{

		if($("#txtPassword").val() === ""){
			$("#errorPassword").text("Please enter a password.").show();
				//++errorInput; 
			//fade out the error text when the user clicks on the textbox
				$("#txtPassword").click(function(){
        			$("#errorPassword").fadeOut('slow'); 
    			});

    			//prevent the form from being submitted if there is an error
				event.preventDefault(); 
				return 0; 
		}
		else if(password.length <6)
		{
			$("#errorPassword").text("Password is too short, length of password must be greater than 6 characters.").show();
				//++errorInput; 
			//fade out the error text when the user clicks on the textbox
				$("#txtPassword").click(function(){
        			$("#errorPassword").fadeOut('slow'); 
    			});
    			return 0; 

    			//prevent the form from being submitted if there is an error
				event.preventDefault(); 
		}
		else
		{
			//$("#txtPassword").text('<img src="images/correct.svg"').show();
			return password; 
		}
		//$("#successMessage2").html(errorInput);
}

//-------------------validate the Confirm password---------------------//
function validateConfirmPassword(confirmPassword)
{

		if($("#txtConfirm").val() === ""){
			$("#errorConfirmPassword").text("Please enter a confirm password.").show();
				//++errorInput; 
			//fade out the error text when the user clicks on the textbox
				$("#txtConfirm").click(function(){
        			$("#errorConfirmPassword").fadeOut('slow'); 
    			});

    			//prevent the form from being submitted if there is an error
				event.preventDefault(); 
				return 0; 
		}
		else
		{
			//$("#txtConfirm").text('<img src="images/correct.svg"').show();
			return confirmPassword; 
		}
	}	
//---------------validate compare password---------------------------//
function comparePasswordValid(password, confirmPassword)
{
	if($("#txtPassword").val() !== $("#txtConfirm").val())
		{
			$("#errorConfirmPassword").text("Password does not match.").show();
				//++errorInput; 
			//fade out the error text when the user clicks on the textbox
				$("#txtConfirm").click(function(){
        			$("#errorConfirmPassword").fadeOut('slow'); 
    			});

    			//prevent the form from being submitted if there is an error
				event.preventDefault(); 
				return 0; 
		}
		else
			return 1; 
}

function validate(){ 

		var errorInput = 0; 
		var username = validateName($("#txtName").val());
		var surname = validateSurname($("#txtSurname").val()); 
		var email = validateEmail($("#txtEmail").val()); 
		var contact = validateContact($("#txtContact").val()); 
		var password = validatePassword($("#txtPassword").val());
		var confirmPassword = validateConfirmPassword($('#txtConfirm').val());
		var comparePassword = comparePasswordValid(password,confirmPassword); 
		if(username == 0 || surname==0 || email == 0 || contact == 0 || password == 0|| confirmPassword==0)
		{
			//prevent the form from being submitted if there is an error
				event.preventDefault();
				++errorInput; 
		}
		
		if(errorInput == 0)
		{
			//$.session.set('Name','Inaam'); 
			var serializedData; 
			//data to send to the database
	 		var data = "name=" + username + "&surname=" + 
		 	surname + "&email=" + email + "&contact=" 
			+ contact + "&password=" + password; 
			 
			$.ajax({
			type: "POST",
			dataType: "json",
			url: "http://localhost:8080/resident/addResident?",
			data: data,
			async: false,
			success: function(data)
			{ 
				var emailLink = "email=" + email; 
					$.ajax({
			  		type: "GET",
			 		dataType: "json",
			  		url: "http://localhost:8080/resident/readResidentEmail?",
			  		data: emailLink, //"email=" + email,
			  		async: false,
			  		success: function(response)
						{
							
							console.log(response);
							var infoHtml = ""; 
							infoHtml += '<div class="alert alert-success" role="alert">';
							infoHtml += '<h4 class="alert-heading">Well Done! ' + username + ' ' + surname + '</h4>';  
							infoHtml += '<p>You have successfully registered, your user id is: ' + response.id + '</p>';
							infoHtml += '<hr>' 
							infoHtml += '<p class="mb-0">Please click here <a href="login.php" class="alert-link">Login</a></p>'; 
							infoHtml += '</div>'; 

							$("#container").fadeIn().html(infoHtml);  
					}
				});
 			}
		});
	}
	event.preventDefault();
}
		//}
// }	

//$("#registerForm").submit(validate);
