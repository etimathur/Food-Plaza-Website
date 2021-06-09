<%@page import="foodplaza.pojo.Food"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Food to Cart </title>
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
	<link href='StyleSheet.css' rel='stylesheet' type='text/css'>

<script type="text/javascript">
	function validation(){
		var email=document.getElementById("email").value;
		var foodName=document.getElementById("fname").value;
		var foodQuantity=document.getElementById("fquan").value;
		var foodPrice=document.getElementById("fprice").value;
		var foodId=document.getElementById("fid").value;
		if(email=="")
		{
			document.getElementById("emailerror").innerHTML="*please enter email id";
			return false;
		}
		if(foodId=="")
		{
			document.getElementById("fiderror").innerHTML="*please enter food id";
			return false;
		}
		if(foodQuantity=="")
		{
			document.getElementById("fquanerror").innerHTML="*please enter food quantity";
			return false;
		}
		if(isNaN(foodQuantity))
		{
			document.getElementById("fquanerror").innerHTML="*please enter valid food quantity";
			return false;
		}
		
		if(foodName=="")
			{
				document.getElementById("fnameerror").innerHTML="*please enter food name";
				return false;
			}
		if(foodPrice=="")
		{
			document.getElementById("fpriceerror").innerHTML="*please enter food price";
			return false;
		}
		
		if(isNaN(foodPrice))
		{
			document.getElementById("fpriceerror").innerHTML="*please enter valid food price";
			return false;
		}
		return true;
	}
</script>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<% 
	Food food=(Food)session.getAttribute("food");
	String user=(String) session.getAttribute("user");
%>
<section id="home" class="parallax-section">
	<div class="container">
		<div class="row">
			<div class="col-md-12 col-sm-12">
<div align="center">
	<form onsubmit="return validation()" action="CartServlet" method="post">
	<center>
	<h1 style="font-size:50px;">Add to Cart</h2>
	<br>
		<table style="border-collapse: separate; border-spacing: 0 15px;">
			<tr>
				<td style="font-size:25px;" class="label">Email :</td>
				<td><input type="email" id="email" name="email" value="<%=user%>"></td>
				<td><span id="emailerror" name="emailerror" style="color:red"></span></td>
			</tr>
			<tr>
				<td style="font-size:25px;" class="label">Food Id :</td>
				<td> <input type="number" id="fid" name="fid" value="<%=food.getFoodId()%>"></td>
				<td><span id="fiderror" name="fiderror" style="color:red"></span></td>
			</tr>
			<tr>
				<td style="font-size:25px;" class="label">Food Quantity :</td>
				<td> <input type="number" id="fquan" name="fquan"></td>
				<td><span id="fquanerror" name="fquanerror" style="color:red"></span></td>
			</tr>
			<tr>
				<td style="font-size:25px;" class="label">Food Name :</td>
				<td><input type="text" id="fname" name="fname" value="<%=food.getFoodName()%>"></td>
				<td><span id="fnameerror" name="fnameerror" style="color:red"></span></td>
			</tr> 
			<tr>
				<td style="font-size:25px;" class="label">Food Price :</td>
				<td><input type="number" id="fprice" name="fprice" value="<%=food.getFoodPrice()%>"></td>
				<td><span id="fpriceerror" name="fpriceerror" style="color:red"></span></td>
			<tr>
				<td><input type="submit" value="Submit" class="button"></td>
				<td><input type="reset" value="Reset" class="button"></td>
			</tr>
		</table>
	</center>
	</form>
</div>
</div>
</div>
</div>
</section>
<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>