

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
			$("#category").append(row);
			
		}
			
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
                $("#color").append(row);
              
          }
		$('#color').change(function() {
			$.ajax({
                url : '/color/' + $("#color").val(),
                method : 'GET'
          }).then(function(color){
			var value = $("#color option:selected").text();
			console.log(color.colorValue);
			$("#color-box").css("background-color", "#" + color.colorValue + "");
			$("#color-box").css("background-color", "#" + color.colorValue + "");
			if( $("#color-box").css('background-color') === 'rgb(255, 255, 255)'){
		    	$("#color-box").css('border', '1px solid black');
		    
		    }
		});
		})
		$("#submit").click(function() {

			var collectable = {
				category : {
					categoryId : $("#category").val()
				},
				condition : {
					conditionId : $("#condition").val()
				},
				brand : {
					brandId : $("#brand").val()
				},
				color : {
					colorId : $("#color").val()
				},
				name : $("#name").val(),
				description : $("#description").val(),
				quantity : $("#quantity").val(),
				price : $("#price").val(),
				modelNumber : $("#modelNumber").val()

			};
			if($("#name").val().trim() == "" || $("#quantity").val().trim() == 0 ){
				$("#success").hide();
				$("#requirements").show();
				document.getElementById("requirements").innerHTML = "Required Field Not Filled In";
			}else{
			$.ajax({
				url : '/collectable',
				method : 'POST',
				contentType : 'application/JSON',
				data : JSON.stringify(collectable)
			}).then(function(message) {
				console.log(message);
				switch(message){
				case "updated":
					$("#name").val("");
					$("#description").val("");
					$("#quantity").val("");
					$("#price").val("");
					$("#modelNumber").val("");
					$("#success").show();
					document.getElementById("success").innerHTML =
				        "Successfully Added and Updated";
					$("#requirements").hide();
					break;
				case "added":
					$("#name").val("");
					$("#description").val("");
					$("#quantity").val("");
					$("#price").val("");
					$("#modelNumber").val("");
					$("#success").show();
					document.getElementById("success").innerHTML =
				        "Successfully Added";
					$("#requirements").hide();
					break;
				}
				
			}, function(errors) {
				document.getElementById("success").innerHTML =
			        "Failed to Add to Collectables";
				document.getElementById("requirements").hide();
				$("#errorMsgs").text(errors);
			});
		}
		})

	})
	})
	})