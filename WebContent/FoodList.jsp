<%@page import="java.util.Iterator"%>
<%@page import="foodplaza.pojo.Food"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Food Gallery</title>
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
<script type="text/javascript">
function alert(){
	alert("Food Successfully Deleted");
};
</script>
</head>
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
<jsp:include page="Header.jsp"></jsp:include>
<body>

<%

List<Food> list;
list=null;
list=(List<Food>)session.getAttribute("foodList");
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
					<table style="font-size: 30px;">
						<thead>
							<tr class="table100-head">
									<th class="column1" style="width:100px;">Food Id</th>
									<th class="column2">Name</th>
									<th class="column3">Food Type</th>
									<th class="column4">Food Category</th>
									<th class="column5">Food Description</th>
									<th class="column6">Food Price</th>
									<%if(admin!=null && user==null)
									{%>
									<th colspan="2" class="column7">Action</th>
									<%}%>
									<%if(admin==null && user!=null)
									{%>
									<th colspan="1" class="column7">Action</th>
									<%}%>
									
									
								</tr>
								</thead>
						<tbody>
<%
	Iterator i=list.iterator();
	while(i.hasNext())
	{
		Food f=(Food)i.next();
%>

	<tr>
		<td class="column1"><%=f.getFoodId() %></td>
		<td class="column2"><%=f.getFoodName() %></td>
		<td class="column3"><%=f.getFoodType() %></td>
		<td class="column4"><%=f.getFoodCatergory() %></td>
		<td class="column5"><%=f.getFoodDescription() %></td>
		<td class="column6"><%="Rs "+f.getFoodPrice() %></td>
		<%if(admin==null && user!=null)
		{%>
		<td class="column7"><a href="CartServlet?action=add&fid=<%=f.getFoodId()%>"><button class="button">Add to Cart</button></a></td>
		<%}%>
		<%if(admin!=null && user==null)
		{%>
		<td class="column7"><a href="FoodServlet?method=edit&fid=<%=f.getFoodId()%>"><button class="button">Edit</button></a></td>
		<td class="column7"><a href="FoodServlet?method=delete&fid=<%=f.getFoodId()%>"><button class="button">Delete</button></a></td>
		<%}%>
		
		
		
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