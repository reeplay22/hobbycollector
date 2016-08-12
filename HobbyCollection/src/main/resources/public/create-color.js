$(document).ready(function() {
	
	$("#submit").click(function() {
      var color = {
      colorName: $("#colorAdd").val(),
      colorValue: $("#colorPicker").val()
      };
      if($("#colorAdd").val().trim() == "" || $("#colorPicker").val().trim() == ""){
			$("#success").hide();
			$("#success").show();
			document.getElementById("success").innerHTML = "Required Field Not Filled In";
		}else{
      $.ajax({
            url : '/color',
            method : 'POST',
            data : JSON.stringify(color),
            contentType : 'application/json'
      }).then(function() {
    	  	$("#colorAdd").val("");
    	  	$("#colorPicker").val("");
            document.getElementById("success").innerHTML =
            	"Successfully Added Color"
      },function(errors){
            
      });
   }
	})
});