$(window).load(
		function() {
			var topics="", comments="";
			$.ajax({
				type : "POST",
				dataType: "json",
				url : "GetPosts",
				contentType: "application/json; charset=utf-8",
				success : function( result ) {
					$("#topicContainer").empty();
					topics = eval(result);
					//topics = $.parseJSON( result ); 
					for ( var topic in topics) {
						var media="";
						
						if( topics[topic].fileName.search(".gif")!=-1 || topics[topic].fileName.search(".jpg")!=-1 || topics[topic].fileName.search(".png")!=-1 )
							media = "<img src="+'"'+topics[topic].fileName+'" id="topicImage" ></img>';
						else if(topics[topic].fileName.search(".webm")!=-1 || topics[topic].fileName.search(".mp4")!=-1 || topics[topic].fileName.search(".ogg")!=-1)
							media= "<video src="+'"'+topics[topic].fileName+'" id="topicImage" type="video" controls>';
						console.log(media);
						$("#topicContainer").append(
								'<div id=\ >'
										+'<div id ="topic"'
										+ ' class = "well topic" >'
										+ media
										+'</div>'
										+'</div>')
					};
					change("#topicContainer",cur);
				},
				error: function( xhr, status, error){
					console.log("error");
					var err = eval("(" + xhr.responseText + ")");
					  alert(err.Message);
				}
				
			})
			/*
			$.ajax({
				type : "POST",
				dataType: "json",
				url : "GetComments",
				contentType: "application/json; charset=utf-8",
				success : function( result ) {
					comments = eval(result);
					//topics = $.parseJSON( result ); 
					for ( var comment in comments) {
						console.log(comments[comment].title);
						$("#"+comments[comment].topicId+"comments").append(
								'<p>'+ comments[comment].content+'</p>')
					}
					//change(comments[comment].topicId,cur);
				},
				error: function( xhr, status, error){
					console.log("error");
					var err = eval("(" + xhr.responseText + ")");
					  alert(err.Message);
				}
				
			})
*/
		});