//-----function to validate the bedrooms selection--//
function validateBedrooms(bedroom)
{
	if(!$("input[name=rdoRooms]:checked").val())
	{
		$('#errorBedrooms').text("Please select number of rooms.").show(); 
		$("input[name=rdoRooms]").click( function(){
        			$('#errorBedrooms').fadeOut('slow'); 
    			}); 
		event.preventDefault();
		return 0; 
	}
	else if($("input[name=rdoRooms]:checked").val() == 0)
	{
		return 3000.00; 
	}
	else if($("input[name=rdoRooms]:checked").val() == 1)
	{
		return 4000.00; 
	}
	else if($("input[name=rdoRooms]:checked").val() == 2)
	{
		return 5000.00; 
	}
	else if($("input[name=rdoRooms]:checked").val() == 3)
	{
		return 6000.00; 
	}

}
//-----function to validate the bathroom selection--//
function validateBathrooms(bathroom)
{
	if(!$("input[name=rdoBathroom]:checked").val())
	{
		$('#errorBathrooms').text("Please select bathroom type.").show(); 
		$("input[name=rdoBathroom]").click( function(){
        			$('#errorBathrooms').fadeOut('slow'); 
    			}); 
		event.preventDefault();
		return 0; 
	}
	else if($("input[name=rdoBathroom]:checked").val() == "shower")
	{
		return "shower"; 
	}
	else if($("input[name=rdoBathroom]:checked").val() == "shower and bath")
	{
		return "shower and bath"; 
	}
}
//-----function to validate the parking selection--//
function validateParking(parking)
{
	if(!$("input[name=rdoParking]:checked").val())
	{
		$('#errorParking').text("Please select if you require a parking space.").show(); 
		$("input[name=rdoParking]").click( function(){
        			$('#errorParking').fadeOut('slow'); 
    			}); 
		event.preventDefault();
		return false; 
	}
	else if($("input[name=rdoParking]:checked").val() == "Yes")
	{
		return 120; 
	}
	else 
		return 0; 
}

//----function to validate the startDate selection--//
function validateStartDate(startDate)
{
	if($('#datepicker').val() == '')
	{
		$('#errorStartDate').text("Please select a starting date.").show(); 
		$("#datepicker").click( function(){
        			$('#errorStartDate').fadeOut('slow'); 
    			}); 
		event.preventDefault();
		return 0; 
	}
	else
		return startDate; 
}

//--function to validate the endDate selection--//
function validateEndDate(endDate)
{
	if($('#datepicker2').val() == '')
		{
			$('#errorEndDate').text("Please select the end date.").show(); 
			$("#datepicker2").click( function(){
	        			$('#errorEndDate').fadeOut('slow'); 
	    			}); 
			event.preventDefault();
			return 0; 
		}
		else 
			return endDate; 
}
function parkingConvertion(parking)
{

	if(parking > 0)
	{
		return parkingValid = true; 
	}
	else 
		return parkingValid = false;
}
function bedroomConvertion(bedroom)
{
	if(bedroom == 3000)
	{
		return 0; 
	}
	else if(bedroom == 4000)
	{
		return 1
	}
	else if(bedroom == 5000)
	{
		return 2; 
	}
	else if(bedroom == 6000)
	{
		return 3;
	}
}
//---function to submit the form--//
function validate()
{
	//variable to hold the hidden sent values 
	var sessionData = $('#hidden').val(); 
	var propertyId = $('#hidden').val().split("_").pop(); //value of the last number
	var orderNumber =  $('#hidden').val().split("_")[5];
	//alert(propertyId);


	var orderLineNumber = Math.floor((Math.random() * 1000000)+20);
	var unitNo = Math.floor(Math.random() * (20 - 20 + 1)) + 20; 
	var parkingNumber = Math.floor(Math.random() * (20 - 20 + 1)) + 20; 
	var bedroom = validateBedrooms($('input[name=rdoRooms]:checked').val()); 
	var bathrooms = validateBathrooms($("input[name=rdoBathroom]:checked").val()); 
	var parking  = validateParking($("input[name=rdoParking]:checked").val()); 
	var parkingValid = parkingConvertion(parking);  
	var bedroomValid = bedroomConvertion(bedroom); 
	var startDate = validateStartDate($('#datepicker').val()); 
	var endDate = validateEndDate($('#datepicker2').val());

	if(bedroom == 0 || bathrooms == 0 || parking == false || startDate == 0 || endDate == 0)
	{
		event.preventDefault();
	}
	else
	{
		//calculate total for the value of property
		var tax = 0.14; 
		var subTotal = bedroom + parking; //values limited to two decimal places 
		var totalTax = subTotal * tax; 
		var total = (subTotal + totalTax).toFixed(2);

		var data = "rooms=" + bedroomValid + "&unitNo=" + unitNo + "&parking=" + parkingNumber + "&bathroomType=" + bathrooms + "&price="+ total + "&startDate=" + startDate + "&endDate="+endDate+""; 
			$.ajax({
			type: "GET",
			dataType: "json",
			url: "http://localhost:8080/unit/"+propertyId+"/addUnit?",
			data: data,
			async: false,
			success: function(data)
			{ 
				$.ajax({
				type: "GET",
				dataType: "json",
				url: "http://localhost:8080/unit/findByPropertyId?",
				data: "id=" + propertyId,
				async: false,
				success: function(data)
				{ 
						$.ajax({
						type: "GET",
						dataType: "json",
						url: "http://localhost:8080/OrderLine/"+ propertyId +"/"+ orderNumber+"/addOrderLine?",
						data: "orderLineNumber=" + orderLineNumber, 
						async: false,
						success: function(data)
						{ 
							sessionStorage.setItem("data",sessionData + "_orderLineNumber_"+orderLineNumber);
							
							location.href = "invoice.php"; 
						}
					}); 
				}
			}); 
			}
		}); 
		 	event.preventDefault();
	}
	 


		










}