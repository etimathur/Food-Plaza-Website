<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search</title>
	<link rel="stylesheet" type="text/css" href="css/main.css">
<script type="text/javascript" src="jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("table").hide();
		$("button").click(function(){
			$.ajax({
				url : "FoodServlet?method=search&type="+$("#type").val()+"&data="+$("input").val(),
				type: "GET",
				datatype :"json",
				success : function(respData){
						$("tbody").empty();
						$("table").show();
						$.each(respData, function(index,obj){ //function will return if respData contains anything
							
							$("tbody").append("<tr>");
							$("tbody").append("<td>"+obj.foodName+"</td>");
							$("tbody").append("<td>"+obj.foodType+"</td>");
							$("tbody").append("<td>"+obj.foodCategory+"</td>");
							$("tbody").append("<td>"+obj.foodDescription+"</td>");
							$("tbody").append("<td>"+obj.foodPrice+"</td>");;
							$("tbody").append("</tr>");
					
					});
				},
				error:function(){
					alert("Error!!!");
				}
			});
		});
	});
</script>
<style type="text/css">
table{
	color:black;
	padding:5px;
	
}
td,th{
padding:15px;
font-size: 30px;
}
.button{
			      padding:5px;
			      border-radius: 12px;
			      font-size: 20px;
			      background-color: white;
				  color: black;
				  border: 2px solid #555555;
		      }
.button:hover {
	background-color: #555555;
	color: white;
}
.column5{
	font-size: 24px;
	width:200px;
}
.coloumn1{
	width:30px;
}

</style>

</head>
<body>
	<jsp:include page="Header.jsp"></jsp:include>
	<canvas></canvas>
	<div align="center">
	
		<span>Search food by</span>
		<select id="type">
			<option selected="selected" disabled="disabled">----SELECT----</option>
			<option value="fname">Name</option>
			<option value="ftype">Type</option>
			<option  value="fcat">Category</option>
		</select>  
		<input type="text" id="data" style="visibility: visible;">
		<button class="button">Search</button>
		<br><br><br><br>
		<div class="limiter">
		<div class="container-table100">
			<div class="wrap-table100">
				<div class="table100">
					<table style="font-size: 30px;">
						<thead>
							<tr class="table100-head">
									<th class="column2">Name</th>
									<th class="column3">Food Type</th>
									<th class="column4">Food Category</th>
									<th class="column5">Food Description</th>
									<th class="column6">Food Price</th>
									
								</tr>
								</thead>
								<tbody>
			
								</tbody>
		</table>
		</div>
		</div>
		</div>
		</div>
	</div>
	<canvas></canvas>
	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>