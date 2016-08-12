$(document).ready(function() {
	var color{};
	color.colorName;
	$("#success").empty();
	$("#submit").click(function() {
	$.ajax({
		url : '/color',
		method : 'POST'
	}).then(function(color) {
		$("#success").append("Color created!");
		
	}
	}
});