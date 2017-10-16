$(document).ready(function(){

	//retrieve the session data
	var sessionData = $('#hidden').val(); 

	//retrieve the orderLine unique number
	var invoiceNumber =  $('#hidden').val().split("_")[9];

	//Manipulating the date function 
	var today = new Date();
	var dd = today.getDate();
	var mm = today.getMonth()+1; //January is 0!
	var yyyy = today.getFullYear();

	if(dd<10) {
    	dd = '0'+dd
	} 

	if(mm<10) {
    	mm = '0'+mm
	} 

	today = mm + '/' + dd + '/' + yyyy;

	$.ajax({
		type: "GET",
		dataType: "json",
		url: "http://localhost:8080/OrderLine/findByOrderLineNumber?",
		data: "orderLineNumber=" + invoiceNumber, 
		async: false,
		success: function(results)
		{ 
			$('#clientName').text(results.orders.resident.name);
			$('#surname').text(results.orders.resident.surname);
			$('#email').text(results.orders.resident.email);
			$('#contact').text(results.orders.resident.contact);

			$('#propertyName').text(results.property.propertyName);	
			var unit = results.property.id;
			$.ajax({
				type: "GET",
				dataType: "json",
				url: "http://localhost:8080/unit/findByPropertyId?",
				data: "id=" + unit, 
				async: false,
				success: function(data)
				{ 
					$('#propertyName').text(data.property.name); 
					$('#unitNumber').text(data.unitNo);
					$('#parking').text(data.parking);
					$('#bathroom').text(data.bathroomType);
					$('#rooms').text(data.rooms);
					$('#price').text(data.price);

					//convert json dates to normal dates
					var startdate = new Date(parseInt(data.startDate)); 
					var display = $.datepicker.formatDate("dd/mm/yy", startdate); 
					var enddate = new Date(parseInt(data.endDate)); 
					var displayDate = $.datepicker.formatDate("dd/mm/yy", enddate);

					$('#start').text(display);
					$('#end').text(displayDate);
				}
			}); 
		}
	}); 

	//display to screen information
	$('#invoice').text(invoiceNumber); 
	$('#todaysdate').text(today);
})