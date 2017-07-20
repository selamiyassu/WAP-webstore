$(function() {
		$.ajax({
			url: "HomeController",
			type: "POST",
			data: {"action": "listBooks"},
			success: ajaxSuccess,
			error: ajaxError
		});
				
		function ajaxSuccess(data){
			console.dir(data);
			$("#items").empty();
			for(var item of data){
				var div = '<div class="book">'+
					'<a href="BookDetail?bookId='+ item.id +'"> '+
						'<img src="./'+item.image+'" alt="book" width="100" height="100" /></a>'+
					'<p id="purple">'+item.title+'</p>'+
					'<p>'+item.author+' ('+item.type+', '+item.year+')</p>'+
					'<p id="red">'+item.price+'</p>'+
					'</div>';
				$("#items").append(div);
			}
		}
		
		
		function ajaxError(){
			console.log("Error with the data")
		}
		
		$.ajax({
			url: "HomeController",
			type: "POST",
			data: {"action": "listCategories"},
			success: ajaxSucc,
			error: ajaxErr
		});
				
		function ajaxSucc(data){
			console.dir(data);
			$("#categories").empty();
			for(var item of data){
				var li = '<li>' +item.name+'</li>';
				$("#categories").append(li);
			}
		}
		
		
		function ajaxErr(){
			console.log("Error with the data")
		}
});