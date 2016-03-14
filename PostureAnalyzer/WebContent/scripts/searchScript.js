/**
 * 
 */

$(window).load(function() {

	$("#search").keyup(function() {
		console.log($("#search").val());
		var results="";
		if ($("#search").val() != "") {
			$.ajax({
				type :"post",
				url : "Search",
				data : "input=" + $("#search").val(),
				success : function(response) {
					$("#results").empty();	
					results=eval(response);
					for ( var result in results) {
						console.log(result);
						$("#results").append(
								$("<div class=\"well result\" id=\"result\"></div>")
										.text(result));
									
					}
					$(".result").append("<button class=\"btn  btn-default addUser\" id=\"addUser\" onclick='sendFriendRequest($(this).parent().text())'><span class=\" glyphicon glyphicon-user\"></span></button>");
					
				change("#results",cur);					
			}
			});
		}
		else{
			$("#results").empty();	
			change(cur,"#results");
			
		}	
	});
});