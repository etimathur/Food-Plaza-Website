<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order List</title>
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="keywords" content="">
	<meta name="description" content="">

	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/animate.min.css">
	<link rel="stylesheet" href="css/font-awesome.min.css">
	<link rel="stylesheet" href="css/nivo-lightbox.css">
	<link rel="stylesheet" href="css/nivo_themes/default/default.css">
	<link rel="stylesheet" href="css/style.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	
	<link href='https://fonts.googleapis.com/css?family=Roboto:400,500' rel='stylesheet' type='text/css'>
	
	<link rel="stylesheet" type="text/css" href="css/util.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
<style>
table{
	color:black;
	padding:5px;
	font-size:20px;
}
td,th{
padding:15px;
font-size: 30px;
}
.button{
			      padding:5px;
			      border-radius: 12px;
			      font-size: 30px;
			      background-color: white;
				  color: black;
				  border: 2px solid #555555;
		      }
.button:hover {
	background-color: #555555;
	color: white;
}
.column4{
	font-size: 20px;
}
</style>
</head>
<body>
<c:import url="Header.jsp"></c:import>
<canvas></canvas>
	<div align="center">
<section id="home" class="parallax-section">
	<div class="container">
<div class="limiter">
		<div class="container-table100">
			<div class="wrap-table100">
				<div class="table100">
					<table>
						<thead>
							<tr class="table100-head">
				<th class="column1">Order Id</th>
				<th class="column2">Email id</th>
				<th class="column3">Total Bill</th>
				<th class="column4">Order Date</th>
			</tr>
			</thead>
	<tbody>
			<c:forEach var="list" items="${requestScope.allOrder}">
			<tr>
				<td class="column1">${list.orderId}</td>
				<td class="column2">${list.custEmailId}</td>
				<td class="column3">${list.orderBill }</td>
				<td class="column4">${list.orderDate }</td>
			</tr>
			</c:forEach>
			<c:set var="list" value=""></c:set>
		</tbody>
		</table>
		</div>
			</div>
		</div>
	</div>	
	</div>
	</section>
	</div>
	<canvas></canvas>
<c:import url="Footer.jsp"></c:import>
</body>
</html>