
//---------function for validate Rosenvale Selection--------//
function validateRosenvale()
{
		var propertyName = 'Rosenvale';
		var streetName = 'Rosenvale Road'; 
		property(propertyName, streetName); 
		event.preventDefault();

}

//---------function for validate Exploria Selection----//
function validateExploria()
{
		var propertyName = 'Exploria'; 
		var streetName = 'Exploria Road'; 
		property(propertyName, streetName); 
		event.preventDefault();

}
//function to submit the property and retrieve the id -- //
function property(propertyName, streetName)
{
	//data retrieve data from hidden form field of session
	var sessionData = $('#hidden').val(); 

	//address values
	var city = 'Cape Town'; 
	var province = 'Western Cape'; 
	var postalCode = '7570'; 
	var propertyID; 
	var propertyNumber = Math.floor((Math.random() * 1000000)+20);
	var data = "propertyName=" + propertyName + "&propertyNumber=" + propertyNumber;
	var addressData = "street=" + streetName + "&city="+city+ "&province="+province+"&postalCode="+postalCode; 
	//ajax function add a new property to the database 
	$.ajax({
		type: "GET",
		dataType: "json",
		url: "http://localhost:8080/addProperty?",
		data: data,
		async: false,
		success: function(response){

			//ajax function finds the id of the property inserted into the database 
				$.ajax({
				type: "GET",
				dataType: "json",
				url: "http://localhost:8080/findByPropertyNumber",
				data: "propertyNumber=" + propertyNumber,
				async: false,
				success: function(data){
						propertyID = data.id; 
						sessionStorage.setItem("data",sessionData + "_propertyID_"+data.id);

						$.ajax({
						type: "GET",
						dataType: "json",
						url: "http://localhost:8080/address/" + propertyID + "/addAddress?",
						data: addressData,
						async: false,
						success: function(results){
								

								$.ajax({
								type: "GET",
								dataType: "json",
								url: "http://localhost:8080/address/findByPropertyID?",
								data: "propertyId=" + propertyID,
								async: false,
								success: function(resultsData){
									location.href = "unit.php"; 
								}
							}); 

							
							}
						}); 


								
								
							

							//sessionStorage.setItem("data",sessionData + data.id);
						}
					}); 


						
					

					//sessionStorage.setItem("data",sessionData + data.id);
				}
			}); 
		}

	//});
//}


















