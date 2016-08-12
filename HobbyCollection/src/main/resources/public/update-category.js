$(document).ready(function() {
	$.ajax({
		url : '/category',
		method : 'GET'
	}).then(function(category) {
		for(var i = 0; i < category.length; i++) {
			var collect = category[i];
			var row = ('<option value="' + collect.categoryId +'">'
				+ " "
				+ collect.categoryName
				+ '</option>');
		$("#categories").append(row);
		
	}

});

$("#categories").change(function() {
	$.ajax({
		url : '/category/' + $("#categories").val(),
		method : 'GET'
	}).then(function(category) {
		$("#categoryId").val(category.categoryId);
		$("#categoryUpdate").val(category.categoryName);
		
	},function(erros) {
		
	});
});

	$("#submit").click(function() {
		
		var category = {};
		category.categoryId = $("#categoryId").val();
		category.categoryName = $("#categoryUpdate").val();
		
			$.ajax({
				url : '/category/' + category.categoryId,
				method : 'PUT',
				data : JSON.stringify(category),
				contentType : 'application/JSON'
			}).then(function() {
				$("#categoryUpdate").val("");
				document.getElementById("completed").innerHTML =
					"Succesfully Updated Category"
			},function(errors) {
				
			});
		});
});