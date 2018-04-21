$(document).ready(function() {
	// when the button is clicked the values entered are gathered and inserted
	// into the string that will be the url route.
	$('button').click(function() {
		var x = $('#x').val() || 0;
		var y = $('#y').val() || 0;
		var url = 'api/math/add/' + x + '/' + y;

		// the get method takes the route and then has a function waiting
		// for the response which will take the data and insert it into the
		// HTML.
		$.get(url, function(data) {
			$('#result').text(data);
		});
	});
	
	//Hands on project code
	//The content entered into the "name" form will then be used to add the name to the message and url route
	$('button').click(function() {
		var x = $('#name').val();
		var url = 'api/hello/' + x;
		
		$.get(url, function(data){
			$("#welcome").text("Nice to meet you " + data + " My name is Renee.");
		
		});
		
	});
});