<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
	<title>Header</title>

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
</head>
<body>

<!-- header section start-->

<!-- navigation section -->
<section class="navbar navbar-default navbar-fixed-top" role="navigation">
	<div class="container">
		<div class="navbar-header" style="display: inline;">
			<button class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
				<span class="icon icon-bar"></span>
				<span class="icon icon-bar"></span>
				<span class="icon icon-bar"></span>
			</button>
			<a href="index.jsp" class="navbar-brand">FOOD PLAZA</a>
		</div>
		<div class="collapse navbar-collapse" style="display: inline;">
			<ul class="nav navbar-nav navbar-right">
					<li><a href="index.jsp" class="smoothScroll">HOME</a></li>
					<li><a href="FoodServlet" class="smoothScroll">MENU</a></li>
					
			<% String user=(String)session.getAttribute("user");
				String admin=(String)session.getAttribute("admin");
				if(user!=null && admin==null)
				{
					%>
						<li><a href="CartServlet?action=mycart&user=<%=user%>" class="smoothScroll">MY CART</a></li>
						<li><a href="CustomerServlet?action=update&user=<%=user%>" class="smoothScroll">UPDATE PROFILE</a></li>
						<li><a href="CustomerServlet?action=delete&user=<%=user%>" class="smoothScroll">DELETE PROFILE</a></li>
						<li><a href="OrderServlet?action=allorders&user=<%=user %>" class="smoothScroll">MY ORDERS</a></li>
						<li><a href="ChangePassword.jsp" class="smoothScroll">CHANGE PASSWORD</a></li>
						<li><a href="LoginServlet">LOGOUT</a>
					<%
					
				}
				else if(user==null && admin!=null)
				{
					%>
						<li><a href="AddFood.jsp" class="smoothScroll">ADD FOOD</a></li>
						<li><a href="OrderServlet?action=admin" class="smoothScroll">ALL ORDERS</a></li>
						<li><a href="CustomerServlet" class="smoothScroll">ALL CUSTOMERS</a></li>
						<li><a href="ChangePassword.jsp" class="smoothScroll">CHANGE PASSWORD</a></li>
						<li><a href="LoginServlet">LOGOUT</a>
					<%
				}
				else if(user==null && admin==null)
				{
					%>
						<li><a href="CustomerRegisteration.jsp" class="smoothScroll">REGISTER</a></li>
						<li><a href="Login.jsp" class="smoothScroll">LOGIN</a></li>
					<%
				}
				%>
						<li><a href="contact.jsp" class="smoothScroll">CONTACT</a></li>
				
			</ul>
		</div>
	</div>
</section>
<!-- header section end-->

</body>
</html>