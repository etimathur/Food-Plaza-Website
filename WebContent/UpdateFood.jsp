<%@page import="foodplaza.pojo.Food"%>
<%@page import="foodplaza.dao.FoodDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Food</title>
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
		var foodid=document.getElementById("fid").value;
		var foodName=document.getElementById("fname").value;
		var foodType=document.getElementById("ftype").value;
		var foodCategory=document.getElementById("fcat").value;
		var foodImage=document.getElementById("fimage").value;
		var foodDescription=document.getElementById("fdes").value;
		var foodPrice=document.getElementById("fprice").value;
		
		if(foodid=="")
		{
			document.getElementById("fnameerror").innerHTML="*please enter food id";
			return false;
		}
		if(foodName=="")
			{
				document.getElementById("fnameerror").innerHTML="*please enter food name";
				return false;
			}
		if(foodType=="")
		{
			document.getElementById("ftypeerror").innerHTML="*please enter food type";
			return false;
		}
		if(foodCategory=="")
		{
			document.getElementById("fcaterror").innerHTML="*please enter food category";
			return false;
		}
		if(foodImage=="")
		{
			document.getElementById("fimageerror").innerHTML="*please enter food image";
			return false;
		}
		if(foodDescription=="")
		{
			document.getElementById("fdeserror").innerHTML="*please enter food description";
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
	
%>
<section id="home" class="parallax-section">
	<div class="container">
		<div class="row">
			<div class="col-md-12 col-sm-12">
<div align="center">
<h1 style="font-size:50px;">Update Food</h1>
	<form onsubmit="return validation()" action="FoodServlet" method="post">
	<input type="hidden" name="action" value="update">
		<table style="border-collapse: separate; border-spacing: 0 15px;">
			<tr>
				<td style="font-size:25px;" class="label">Food Id:</td>
				<td><input type="number" name="fid" id="fid" value="<%=food.getFoodId()%>" readonly="readonly"></td>
				<td><span id="fiderror" name="fiderror" style="color:red" ></span></td>
			<tr>
				<td style="font-size:25px;" class="label">Food Name :</td>
				<td> <input type="text" name="fname" id="fname" value="<%=food.getFoodName()%>" readonly="readonly"></td>
				<td><span id="fnameerror" name="fnameerror" style="color:red"></span></td>
			</tr>
			<tr>
				<td style="font-size:25px;" class="label">Food Type :</td>
				<td><input type="text" name="ftype" id="ftype" value="<%=food.getFoodType()%>"></td>
				<td><span id="ftypeerror" name="ftypeerror" style="color:red"></span></td>
			</tr>
			<tr>
				<td style="font-size:25px;" class="label">Food Category :</td>
				<td><input type="text" name="fcat" id="fcat" value="<%=food.getFoodCatergory()%>"></td>
				<td><span id="fcaterror" name="fcaterror" style="color:red"></span></td>
			</tr>
			<tr>
				<td style="font-size:25px;" class="label">Food Image :</td>
				<td><input type="text" name="fimage" id="fimage" value="<%=food.getFoodImage()%>"></td>
				<td><span id="fimageerror" name="fimageerror" style="color:red"></span></td>
			</tr>
			<tr>
				<td style="font-size:25px;" class="label">Food Description :</td>
				<td><textarea rows="" cols="" name="fdes" id="fdes" value="<%=food.getFoodDescription()%>"></textarea></td>
				<td><span id="fdeserror" name="fdeserror" style="color:red"></span></td>
			</tr>
			<tr>
				<td style="font-size:25px;" class="label">Food Price :</td>
				<td><input type="number" name="fprice" id="fprice" value="<%=food.getFoodPrice()%>"></td>
				<td><span id="fpriceerror" name="fpriceerror" style="color:red"></span></td>
			<tr>
				<td><input type="submit" value="Update" class="button"></td>
				<td><input type="reset" value="Reset" class="button"></td>
			</tr>
		</table>
	</form>
</div>
</div>
</div>
</div>
</section>
<canvas></canvas>
<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>