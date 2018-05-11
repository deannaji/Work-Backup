var main=function(){
  console.log("Main front-end controller is up...");
  /*$.ajax({
  	type: "GET",
  	dataType: "json",
  	url: "http://localhost:8080/myRestEndPoint/services/Rest/account/1",
  	success: function(result){
  		console.log(result);
  	},
  	failure: function(err){
  		console.log(err);
  	}
  });*/
  
  $("#addAccount").on("click", function(){
	  var data= {
			  id: $("#id").val(),
			  username: $("#username").val(),
			  email: $("#email").val()
				};
	  
	  $.ajax({
		  	type: "POST",
		  	contentType: 'application/json',
		  	dataType: 'json',
		  	url: "http://localhost:8080/myRestEndPoint/services/Rest/add",
		  	data: JSON.stringify(data),
		  	success: function(result){
		  		console.log(result);
		  	},
		  	failure: function(err){
		  		console.log(err);
		  	}
		  });
  });
  
}
$(document).ready(main);