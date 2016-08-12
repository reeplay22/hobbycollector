$(document).ready(function() {
	
	$("#submit").click(function() {
		var category = {
			categoryName : $("#categoryAdd").val()
		};
		if($("#categoryAdd").val().trim() == ""){
			$("#completed").hide();
			$("#completed").show();
			document.getElementById("completed").innerHTML = "Required Field Not Filled In";
		}else{
		$.ajax({
			url : '/category',
			method : 'POST',
			data : JSON.stringify(category),
			contentType : 'application/json'
		}).then(function() {
			$("#categoryAdd").val("");
			document.getElementById("completed").innerHTML =
				"Succesfully Created Category"
		},function(errors){

		});
	}
	})
});
