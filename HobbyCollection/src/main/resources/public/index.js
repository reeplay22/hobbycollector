
		$(document).ready(function(){
			
			$("#clear").click(function(){
			$("#name").val("");
			$("#category").val(0);
			$("#color").val(0);
			$("#quantity").val("");
			$("#condition").val(0);
			$("#modelNumber").val("");
			$("#price").val("");
			$("#description").val("");
			$("#dateMIN").val(0);
			$("#dateMAX").val(0);
			$("#priceMIN").val("");
			$("#priceMAX").val("");
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
		    url : "/collectable",
		    method : 'GET'
		}).then(
			function(collectable) {
				
			    for (var i = 0; i < collectable.length; i++) {
			    	
				var collect = collectable[i];
				if(collect.date.monthValue = 11){
					var smallPic = "<span title=" +'' +collect.date.month +'' +" class='glyphicon glyphicon-cloud'></span>"
				}
				else if(collect.date.monthValue = 12){
					var smallPic = "<span class='glyphicon glyphicon-tree-conifer'></span>"
				}
				else if(collect.date.monthValue = 1){
					var smallPic = "<span class='glyphicon glyphicon-calendar'></span>"
				}
				else if(collect.date.monthValue = 1){
					var smallPic = "<span class='glyphicon glyphicon-glass'></span>"
				}
		
				var row = "<tr><td>" + collect.catalogNumber
					+ "</td><td>" + collect.name
					+ "</td><td>" + collect.quantity
					+ "</td><td>" + collect.condition.conditionName
					+ "</td><td>" 
					+ "<div title=" +''+ collect.color.colorName + '' 
					+" id =" +collect.catalogNumber +"></div>"
					+ "</td><td>"+ collect.category.categoryName
					+ "</td><td>" + collect.brand.brandName
					+ "</td><td>" + collect.modelNumber
					+ "</td><td>" + "<span class='glyphicon glyphicon-piggy-bank'></span> -"
					+"$"+collect.price 
					+ "</td><td>" + collect.description
					+ "</td><td>" + collect.date.year+"-"
					+	collect.date.monthValue +"-"
					+ collect.date.dayOfMonth + "      "
					+ smallPic 
					+ "</td></tr>"
				$("#result").append(row);
			    $("#" + collect.catalogNumber).css("background-color", "#" +collect.color.colorValue);
			    if( $("#" + collect.catalogNumber).css('background-color') === 'rgb(255, 255, 255)'){
			    	$("#" + collect.catalogNumber).css('border', '1px solid black');
			    
			    }
			    }
			    $("#resultAmount").append([i]+ " results found!" );
			    $("#table").tablesorter({
				sortList : [ [ 5, 0 ], [ 1, 0 ] ]
			    });
			    
			});
		
		
		
		
		
		$("#filter").click(function(event){
			 $("#resultAmount").empty();
		    var searchCollectable = {		    	     
		    
			name:$("#name").val(),
			    category:{categoryId:$("#category").val()},
			    condition:{conditionId:$("#condition").val()},
			    color:{colorId:$("#color").val()},
			    brand:{brandId:$("#brand").val()},
		    description:$("#description").val(),	
		    modelNumber:$("#modelNumber").val(),
		    quantity:$("#quantity").val(),
		    price:$("#price").val(),
		   	dateMin: $("#dateMIN").val(), 
		   	dateMax: $("#dateMAX").val(),
		    priceMin:$("#priceMIN").val(),
		    priceMax:$("#priceMAX").val(),
		   			   	
		    }
		   
		    console.log(searchCollectable); 
		    	    		    
		    $.ajax({
			    url : "/collectables",
			    method : 'POST',
				data:JSON.stringify(searchCollectable),
				contentType:'application/JSON'
			}).then(
			function(collectable) {
		    
			    $("#result").empty();
				  
			   	
			   	for (var i = 0; i < collectable.length; i++) {
					var collect = collectable[i];
					
					var row = "<tr><td>" + collect.catalogNumber
						+ "</td><td>" + collect.name
						+ "</td><td>" + collect.quantity
						+ "</td><td>" + collect.condition.conditionName
						+ "</td><td>" 
						+ "<div title=" +''+ collect.color.colorName + '' 
						+" id =" +collect.catalogNumber +"></div>"
						+ "</td><td>"+ collect.category.categoryName
						+ "</td><td>" + collect.brand.brandName
						+ "</td><td>" + collect.modelNumber
						+ "</td><td>" + collect.price
						+ "</td><td>" + collect.description
						+ "</td><td>" + collect.date.year+"-"
						+	collect.date.monthValue +"-"
						+ collect.date.dayOfMonth 
						+  "</td></tr>"
					$("#result").append(row);
				    $("#" + collect.catalogNumber).css("background-color", "#" +collect.color.colorValue);
				    if( $("#" + collect.catalogNumber).css('background-color') === 'rgb(255, 255, 255)'){
				    	$("#" + collect.catalogNumber).css('border', '1px solid black');
				    	
				    }			   		    		   		
			}
			    $("#resultAmount").append([i]+ " results found!" );
			    })
			
			    })	
			$("#filterTen").click(function(){
				$("#resultAmount").empty();
				 $("#result").empty();		 
		    $.ajax({
				    url : "/collectable",
				    method : 'GET'
				}).then(
					function(collectable) {	   
					    for (var i = 0; i < 10; i++) {
						var collect = collectable[i];
						var row = "<tr><td>" + collect.catalogNumber
							+ "</td><td>" + collect.name
							+ "</td><td>" + collect.quantity
							+ "</td><td>" + collect.condition.conditionName
							+ "</td><td>" 
							+ "<div title=" +''+ collect.color.colorName + '' 
							+" id =" +collect.catalogNumber +"></div>"
							+ "</td><td>"+ collect.category.categoryName
							+ "</td><td>" + collect.brand.brandName
							+ "</td><td>" + collect.modelNumber
							+ "</td><td>" + collect.price
							+ "</td><td>" + collect.description
							+ "</td><td>" + collect.date.year+"-"
							+	collect.date.monthValue +"-"
							+ collect.date.dayOfMonth 
							+  "</td></tr>"
						$("#result").append(row);
					    $("#" + collect.catalogNumber).css("background-color", "#" +collect.color.colorValue);
					    if( $("#" + collect.catalogNumber).css('background-color') === 'rgb(255, 255, 255)'){
					    	$("#" + collect.catalogNumber).css('border', '1px solid black');
					    
					    }
					    }
					    $("#resultAmount").append([i]+ " results found!" );
					    
				    });
					    
					});
			
			$("#filterFifty").click(function(){
				$("#resultAmount").empty();
				 $("#result").empty();		 
		    $.ajax({
				    url : "/collectable",
				    method : 'GET'
				}).then(
					function(collectable) {   
						if(25> collectable.length){
						    for (var i = 0; i < collectable.length; i++) {
							var collect = collectable[i];
							var row = "<tr><td>" + collect.catalogNumber
								+ "</td><td>" + collect.name
								+ "</td><td>" + collect.quantity
								+ "</td><td>" + collect.condition.conditionName
								+ "</td><td>" 
								+ "<div title=" +''+ collect.color.colorName + '' 
								+" id =" +collect.catalogNumber +"></div>"
								+ "</td><td>"+ collect.category.categoryName
								+ "</td><td>" + collect.brand.brandName
								+ "</td><td>" + collect.modelNumber
								+ "</td><td>" + collect.price
								+ "</td><td>" + collect.description
								+ "</td><td>" + collect.date.year+"-"
								+	collect.date.monthValue +"-"
								+ collect.date.dayOfMonth 
								+ "</td></tr>"
							$("#result").append(row);
						    $("#" + collect.catalogNumber).css("background-color", "#" +collect.color.colorValue);
						    if( $("#" + collect.catalogNumber).css('background-color') === 'rgb(255, 255, 255)'){
						    	$("#" + collect.catalogNumber).css('border', '1px solid black');
						    
						    }
						    }
						    }
							else{
								for (var i = 0; i < 50; i++) {
									var collect = collectable[i];
									var row = "<tr><td>" + collect.catalogNumber
										+ "</td><td>" + collect.name
										+ "</td><td>" + collect.quantity
										+ "</td><td>" + collect.condition.conditionName
										+ "</td><td>" 
										+ "<div title=" +''+ collect.color.colorName + '' 
										+" id =" +collect.catalogNumber +"></div>"
										+ "</td><td>"+ collect.category.categoryName
										+ "</td><td>" + collect.brand.brandName
										+ "</td><td>" + collect.modelNumber
										+ "</td><td>" + collect.price
										+ "</td><td>" + collect.description
										+ "</td><td>" + collect.date.year+"-"
										+	collect.date.monthValue +"-"
										+ collect.date.dayOfMonth 
										+ "</td></tr>"
									$("#result").append(row);
								    $("#" + collect.catalogNumber).css("background-color", "#" +collect.color.colorValue);
								    if( $("#" + collect.catalogNumber).css('background-color') === 'rgb(255, 255, 255)'){
								    	$("#" + collect.catalogNumber).css('border', '1px solid black');
								    
								    }
							}
							}
						    $("#resultAmount").append([i]+ " results found!" );
					    });
					    
					});
			
			$("#filterTwentyFive").click(function(){
				$("#resultAmount").empty();
				 $("#result").empty();	 
		    $.ajax({
				    url : "/collectable",
				    method : 'GET'
				}).then(
					function(collectable) {	
						if(25> collectable.length){
					    for (var i = 0; i < collectable.length; i++) {
						var collect = collectable[i];
						var row = "<tr><td>" + collect.catalogNumber
							+ "</td><td>" + collect.name
							+ "</td><td>" + collect.quantity
							+ "</td><td>" + collect.condition.conditionName
							+ "</td><td>" 
							+ "<div title=" +''+ collect.color.colorName + '' 
							+" id =" +collect.catalogNumber +"></div>"
							+ "</td><td>"+ collect.category.categoryName
							+ "</td><td>" + collect.brand.brandName
							+ "</td><td>" + collect.modelNumber
							+ "</td><td>" + collect.price
							+ "</td><td>" + collect.description
							+ "</td><td>" + collect.date.year+"-"
							+	collect.date.monthValue +"-"
							+ collect.date.dayOfMonth 
							+ "</td></tr>"
						$("#result").append(row);
					    $("#" + collect.catalogNumber).css("background-color", "#" +collect.color.colorValue);
					    if( $("#" + collect.catalogNumber).css('background-color') === 'rgb(255, 255, 255)'){
					    	$("#" + collect.catalogNumber).css('border', '1px solid black');
					    
					    }
					    }
					    }
						else{
							for (var i = 0; i < 25; i++) {
								var collect = collectable[i];
								var row = "<tr><td>" + collect.catalogNumber
									+ "</td><td>" + collect.name
									+ "</td><td>" + collect.quantity
									+ "</td><td>" + collect.condition.conditionName
									+ "</td><td>" 
									+ "<div title=" +''+ collect.color.colorName + '' 
									+" id =" +collect.catalogNumber +"></div>"
									+ "</td><td>"+ collect.category.categoryName
									+ "</td><td>" + collect.brand.brandName
									+ "</td><td>" + collect.modelNumber
									+ "</td><td>" + collect.price
									+ "</td><td>" + collect.description
									+ "</td><td>" + collect.date.year+"-"
									+	collect.date.monthValue +"-"
									+ collect.date.dayOfMonth 
									+ "</td></tr>"
								$("#result").append(row);
							    $("#" + collect.catalogNumber).css("background-color", "#" +collect.color.colorValue);
							    if( $("#" + collect.catalogNumber).css('background-color') === 'rgb(255, 255, 255)'){
							    	$("#" + collect.catalogNumber).css('border', '1px solid black');
							    
							    }
						}
						}
					    $("#resultAmount").append([i]+ " results found!" );
					});
			})
		})
		
>>>>>>> branch 'master' of git@git.catalystitservices.com:ccrosby/T1HobbyCollector.git
