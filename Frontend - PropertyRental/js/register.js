//--------------------POST REQUEST STATEMTENT--------------------------//
// $(document).ready(function()
// {
// 		var username = $("#name").val(); 
// 		var surname = $("#txtsurname").val(); 
// 		var email = $("#txtemail").val(); 
// 		var contact = $("#txtcontact").val(); 
// 		var password = $("#txtpassword").val(); 


// 		var data = "name=" + username + "&surname=" + 
// 		surname + "&email=" + email + "&contact=" 
// 		+ contact + "&password=" + password; 

// 		$.ajax({
// 			dataType: "text",
// 			url: "http://localhost:8080/resident/addResident?",
// 			data: data,
// 			success: function(data)
// 			{
// 				$("#successMessage").html(data);
// 			}
// 		});

// });

//----------------------GET REQUEST STATEMENT------------------------//
 $(document).ready(function(){
	$("#getInfo").click(function(){
			var data = "id=1"; 
			var items = []; 
			
			$.ajax({
			  dataType: "json",
			  url: "http://localhost:8080/resident/readResident?",
			  data: data,
			  success: function(data)
			{
				document.write(data.id); 
				document.write(data.name); 
				document.write(data.surname); 
				document.write(data.contact);
				document.write(data.email);
				document.write(data.password);  
				 
				$("#register_output").html(data.id);
			}
				// $.each(data, function(key, val){
 			// 	items.push("<li id='" + key + "'>" + val + "</li>"); 
 			 });//.appendTo("body");
			
			 });
		});




