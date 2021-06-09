<%@page import="foodplaza.pojo.Customer"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer List</title>
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

</style>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<%List<Customer> list=(List<Customer>)session.getAttribute("list");
String user=(String)session.getAttribute("user");
String admin=(String)session.getAttribute("admin");
%>
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
		<th class="column1">Customer Id</th>
		<th class="column2">Name</th>
		<th class="column3">Email Id</th>
		<th class="column4">Password</th>
		<th class="column5">Address</th>
		<th class="column6">Contact No</th>
		
	</tr>
	</thead>
	<tbody>
<%
	Iterator i=list.iterator();
	while(i.hasNext())
	{
		Customer c=(Customer)i.next();
		
%>

	<tr>
		<td class="column1"><%=c.getCustId() %></td>
		<td class="column2"><%=c.getCustName() %></td>
		<td class="column3"><%=c.getCustEmail() %></td>
		<td class="column4"><%=c.getCustPassword()%></td>
		<td class="column5"><%=c.getCustAddress() %></td>
		<td class="column6"><%=c.getCustContactNo()%></td>
		
		
	</tr>
<%
	}
%>
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
<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>