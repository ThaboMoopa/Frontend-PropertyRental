
	//-------------------validate the Email---------------------//
function validateEmail(email)
{
	if($("#txtEmail").val() === ""){
			$("#errorEmail").text("Please enter an email address.").show();
				//++errorInput; 
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

		$("#txtEmail").keydown(function(){
			$.ajax({
			  dataType: "json",
			  url: "http://localhost:8080/resident/readResident?",
			  data: data,
			  success: function(data)
				{
					// document.write(data.id); 
					// document.write(data.name); 
					// document.write(data.surname); 
					// document.write(data.contact);
					// document.write(data.email);
					// document.write(data.password);  
					 
					$("#register_output").html(data.id);
					// $.each(data, function(key, val){
	 			// 	items.push("<li id='" + key + "'>" + val + "</li>");
 				} 
 			});//.appendTo("body"); 
		
			}); 
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



function validate(){ 

		var errorInput = 0; 
		var email = validateEmail($("#txtEmail").val()); 
		var password = validatePassword($("#txtPassword").val());
		if(email == 0 || password == 0)
		{
			//prevent the form from being submitted if there is an error
				event.preventDefault();
				++errorInput; 
		}
		
		if(errorInput == 0)
		{
			//read the data that is inserted in to the database and retrieve the customer id using the email
						$.ajax({
						type: "GET",
			  			dataType: "json",
			  			url: "http://localhost:8080/resident/readResidentEmail?",
			  			data: "email=" + email,
			  			async: false,
			  			success: function(response)
						{
								var customerId = response.id; 
								var currentDate = new Date();
														
								//configure the date to display yyyy/mm/dd
								var month = currentDate.getMonth()+1;
								var day = currentDate.getDate();
								var output = currentDate.getFullYear() + '/' + ((''+month).length<2 ? '0' : '') + month + '/' + ((''+day).length<2 ? '0' : '') + day; 
								
								//data to create a random number for the orderNumber
    							var orderNumber = Math.floor((Math.random() * 1000000)+1); 

    							//data to serialize 
    							values = "customerId:_"+response.id + '_' + response.name + '_' + response.surname;
    							userDetails = ""+response.name+" "+response.surname; 
								//create an order for the customer 
								$.ajax({
									type: "GET", 
									dataType: "json", 
									async: false,
									//http://localhost:8080/order/1/addOrder?orderNumber=55&dateDay=1997/12/30
									url: "http://localhost:8080/order/" + customerId + "/addOrder?", 
									data: "orderNumber="+ orderNumber + "&dateDay=" + output,
									success: function(data)
									{
										//data to add on to the serialized data
										values += " _orderNumber_"+data.id; 
										//retrieve the order ID for this transaction
										
										$.ajax({
											type: "GET", 
											dataType: "json", 
											async: false,
											//http://localhost:8080/order/findOrderByOrderNumber?orderNumber=889671
											url: "http://localhost:8080/order/findOrderByOrderNumber?", 
											data: "orderNumber=" + orderNumber,
											success: function(data)
											{
												sessionStorage.setItem("data",values);
												sessionStorage.setItem("user",userDetails); 
												location.href = "property.php"; 
											}
									});									}
								}); 
								 
							}, 
							error: function()
							{
								$('#errorLogin').html('<div class="alert alert-danger" role="alert">Unable to login. Please click here to <a href="register.php">Register</a></div>');
							}
 						});
					}
 			event.preventDefault();
		}
function createOrder(response)
{
		
}

		//}
// }	

$("#registerForm").submit(validate);
