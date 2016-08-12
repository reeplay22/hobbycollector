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
	})
		$.ajax({
            url : "/collectable",
            method : 'GET'
      }).then(function(collectable){
      
            for (var i = 0; i < collectable.length; i++) {
				var row = ('<option value="'+ collectable[i].catalogNumber+'">'
						+ collectable[i].catalogNumber +"-" + collectable[i].name + '</option>');
				$("#collectableSelect").append(row);
            }
			})
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
          })
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
		})
		

			$("#collectableSelect").change(function() {
			$("#success").empty();
			$.ajax({
			url : '/collectable/' + $("#collectableSelect").val(),
			method : 'GET',
			}).then(function(collectable) {
				
			$('#catalogNumber').val(collectable.catalogNumber);
			$("#category").val(collectable.category.categoryId);
			$("#condition").val(collectable.condition.conditionId);
			$("#name").val(collectable.name);
			$('#brand').val(collectable.brand.brandId);
			$("#description").val(collectable.description);
			$("#quantity").val(collectable.quantity);
			$("#price").val(collectable.price);
			$("#modelNumber").val(collectable.modelNumber);
			$("#color").val(collectable.color.colorId);
			})
			
			});
		
		
		$("#sold").click(function() {
			var categoryVar = parseInt($("#category").val());
			var conditionVar = parseInt($("#condition").val());
			var brandVar = parseInt($("#brand").val());
			var colorVar = parseInt($("#color").val());
			var priceVar = parseInt($("#price").val());
			var quantityVar = 0;
			var modelNumberVar = parseInt($("#modelNumber").val());
			var catalogNumberVar = parseInt($("#catalogNumber").val());
			var collectable = {
					catalogNumber: catalogNumberVar,
					category : {
						categoryId : categoryVar
					},
					condition : {
						conditionId : conditionVar
					},
					brand : {
						brandId : brandVar
					},
					color : {
						colorId : colorVar
					},
					name : $("#name").val(),
					description : $("#description").val(),
					quantity: quantityVar,
					price : priceVar,
					modelNumber : modelNumberVar

				};
		$.ajax({
			url : '/collectable',
			method : 'PUT',
			contentType : 'application/JSON',
			data : JSON.stringify(collectable)
		}).then(function(collectable) {
			$("#quantity").val(0);
			if( $('#success').is(' :empty')){
			$("#success").append("Succesfully sold!");
			}
			})
		});
		
		
			$("#update").click(function() {
				var categoryVar = parseInt($("#category").val());
				var conditionVar = parseInt($("#condition").val());
				var brandVar = parseInt($("#brand").val());
				var colorVar = parseInt($("#color").val());
				var priceVar = parseInt($("#price").val());
				var modelNumberVar = parseInt($("#modelNumber").val());
				var quantityVar = parseInt($("#quantity").val());
				var catalogNumberVar = parseInt($("#catalogNumber").val());
				
			
				var collectable = {
						catalogNumber: catalogNumberVar,
						category : {
							categoryId : categoryVar
						},
						condition : {
							conditionId : conditionVar
						},
						brand : {
							brandId : brandVar
						},
						color : {
							colorId : colorVar
						},
						name : $("#name").val(),
						description : $("#description").val(),
						quantity : quantityVar,
						price : priceVar,
						modelNumber : modelNumberVar

					};
				
				
			
			$.ajax({
				url : '/collectable',
				method : 'PUT',
				contentType : 'application/JSON',
				data : JSON.stringify(collectable),
			}).then(function(collectable) {
				if( $('#success').is(' :empty')){
				$("#success").append("Succesfully updated!");
				}
				})
			});
	
	});
