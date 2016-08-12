
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
      
      });
      
      $("#color").change(function() {
            $.ajax({
                  url : '/color/' + $("#color").val(),
                  method : 'GET'
            }).then(function(color) {
                  $("#colorId").val(color.colorId);
                  $("#colorPicker").val(color.colorValue);
                  $("#colorUpdate").val(color.colorName);
                  
            },function(erros) {
                  
            });
      });
            $("#submit").click(function() {
                  
                  var color = {};
                  color.colorId = $("#colorId").val();
                  color.colorValue = $("#colorPicker").val();
                  color.colorName = $("#colorUpdate").val();
                  
                  $.ajax({
                        url : '/color/' + color.colorId,
                        method : 'PUT',
                        data : JSON.stringify(color),
                        contentType : 'application/JSON'
                  }).then(function() {
                       $("#colorUpdate").val("");
                       $("#colorPicker").val("");
                       $("#success").append("Succesfully Updated") 
                  },function(errors) {
                        
                  });
      });
      });