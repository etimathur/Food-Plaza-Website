<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Add Food </title>
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
		var foodName=document.getElementById("fname").value;
		var foodType=document.getElementById("ftype").value;
		var foodCategory=document.getElementById("fcat").value;
		var foodImage=document.getElementById("fimage").value;
		var foodDescription=document.getElementById("fdes").value;
		var foodPrice=document.getElementById("fprice").value;
		
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
<section id="home" class="parallax-section">
	<div class="container">
		<div class="row">
			<div class="col-md-12 col-sm-12">
<div align="center">
<h1 style="font-size:50px;">Add Food</h1>
<br>
	<form onSubmit="return validation()" action="FoodServlet" method="post">
	<input type="hidden" name="action" value="add">
		<table style="border-collapse: separate; border-spacing: 0 15px;">
			<tr>
				<td style="font-size:25px;" class="label">Food Name :</td>
				<td> <input type="text" id="fname" name="fname"></td>
				<td><span id="fnameerror" name="fnameerror" style="color:red"></span></td>
			</tr>
			<tr>
				<td style="font-size:25px;" class="label">Food Type :</td>
				<td><input type="text" id="ftype" name="ftype"></td>
				<td><span id="ftypeerror" name="ftypeerror" style="color:red"></span></td>
			</tr>
			<tr>
				<td style="font-size:25px;" class="label">Food Category :</td>
				<td><input type="text" id="fcat" name="fcat"></td>
				<td><span id="fcaterror" name="fcaterror" style="color:red"></span></td>
			</tr>
			<tr>
				<td style="font-size:25px;" class="label">Food Image :</td>
				<td><input type="text" id="fimage" name="fimage"></td>
				<td><span id="fimageerror" name="fimageerror" style="color:red"></span></td>
			</tr>
			<tr>
				<td style="font-size:25px;" class="label">Food Description :</td>
				<td><textarea rows="" cols="" id="fdes" name="fdes"></textarea></td>
				<td><span id="fdeserror" name="fdeserror" style="color:red"></span></td>
			</tr> 
			<tr>
				<td style="font-size:25px;" class="label">Food Price :</td>
				<td><input type="number" id="fprice" name="fprice"></td>
				<td><span id="fpriceerror" name="fpriceerror" style="color:red"></span></td>
			<tr>
				<td><input type="submit" value="Submit" class="button"></td>
				<td><input type="reset" value="Reset" class="button"></td>
			</tr>
		</table>
	</form>
</div>
</div>
</div>
</div>
</section>
<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>