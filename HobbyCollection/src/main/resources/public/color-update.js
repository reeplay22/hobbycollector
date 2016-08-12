
	$(document).ready(function() {
		$('#color').change(function() {
			$.ajax({
	            url : '/color/' + $("#color").val(),
	            method : 'GET'
	      }).then(function(color){
			var value = $("#color option:selected").text();
			console.log(color.colorValue);
			$("#color-box").css("background-color", "#" + color.colorValue + "");
			if( $("#color-box").css('background-color') === 'rgb(255, 255, 255)'){
		    	$("#color-box").css('border', '1px solid black');
		    
		    }
		});
		});
	
		$.ajax({
			url : '/color',
			method : 'GET'
		}).then(function(color) {
			for(var i = 0; i < color.length; i++) {
				var collect = color[i];
				var row = ('<option value="' + collect.colorId +'">'
					+ " "
					+ collect.colorName
					+ '</option>');
			$("#categories").append(row);
			
		}
	
	});
	
	$("#color").change(function() {
		$.ajax({
			url : '/collectable/' + $("#color").val(),
			method : 'GET'
		}).then(function(color) {
			$("#colorId").val(collect.color.colorId);
			$("#colorUpdate").val(collect.color.colorName);
			
		},function(erros) {
			
		});
		$("#create").click(function() {
			
			var color{};
			color.colorId = $("#colorId").val();
			color.colorName = $("#colorName").val();
			 if($("#colorName").val().trim() == ""){
				 	$("#message").append("Name is required to submit!")
					
				}else{
			$.ajax({
				url : '/collectable/' + color.colorId,
				method : 'PUT'
			}).then(function(color) {
				$("#colorId").val(collect.color.colorId);
				$("#colorUpdate").val(collect.color.colorName);
				
			},function(erros) {
				
			});
	}
		})
	});