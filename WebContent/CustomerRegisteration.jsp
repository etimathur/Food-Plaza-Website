<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Customer </title>
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
	function validation()
	{
		var name=document.getElementById("name").value;
		var email=document.getElementById("email").value;
		var password=document.getElementById("pass").value;
		var contactNo=document.getElementById("con").value;
		var address=document.getElementById("add").value;
		if(name=="")
		{
			document.getElementById("nameerror").innerHTML="*please enter name";
			return false;
		}
		if(email=="")
		{
			document.getElementById("emailerror").innerHTML="*please enter email id";
			return false;
		}
		if(password=="")
		{
			document.getElementById("passerror").innerHTML="*please enter password";
			return false;
		}
		if(contactNo=="")
		{
			document.getElementById("conerror").innerHTML="*please enter contact no";
			return false;
		}
		if(contactNo.length!=10)
		{
			document.getElementById("conerror").innerHTML="*please enter valid contact no";
			return false;
		}
		if(address=="")
		{
			document.getElementById("adderror").innerHTML="*please enter address";
			return false;
		}
		if(isNaN(contactNo))
			{
			documnet.getElementById("conerror").innerHTML="*please enters numbers only";
			return false;
			}
		return true;
		
	}
</script>
<script type="text/javascript" src="jquery-3.2.1.min.js"></script>
<script type="text/javascript">

	$(document).ready(function(){
		
		$("#pass").click(function(){
			var data=$("#email").val();
			$.get("LoginServlet",{action:'checknot',email:data},function(responseData){
				$("#emailerror").text(responseData);	
			});
		});
	});

</script>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<section id="home" class="parallax-section">
	<div class="container">
		<div class="row">
			<div class="col-md-12 col-sm-12">
<div>

	<form onsubmit="return validation()" action="CustomerServlet" method="post">
	<input type="hidden" name="action" value="AddCust">
	<div align="Center">
		<h1 style="font-size:50px;"> Customer Registration </h1>
		<br>
		<table style="border-collapse: separate; border-spacing: 0 15px;">
			<tr>
				<td style="font-size:25px;" class="label">Name :</td>
				<td> <input type="text" name="name" id="name"></td>
				<td><span name="nameerror" id="nameerror" style="color:Red"></span></td>
			</tr>
			<tr>
				<td style="font-size:25px;" class="label">Email :</td>
				<td><input type="email" name="email" id="email"></td>
				<td><span name="emailerror" id="emeilerror" style="color:Red"></span></td>
			</tr>
			<tr>
				<td style="font-size:25px;" class="label">Password :</td>
				<td><input type="password" name="pass" id="pass"></td>
				<td><span name="passerror" id="passerror" style="color:Red"></span></td>
			</tr>
			<tr>
				<td style="font-size:25px;" class="label">Contact No :</td>
				<td><input type="number" name="con" id="con"></td>
				<td><span name="conerrore" id="conerror" style="color:Red"></span></td>
			</tr>
			<tr>
				<td style="font-size:25px;" class="label">Address :</td>
				<td><textarea rows="" cols="" id="add" name="add"></textarea></td>
				<td><span name="adderror" id="adderror" style="color:Red"></span></td>
			</tr>
			<tr>
				<td><input type="submit" value="Register" class="button"></td>
				<td><input type="reset" value="Reset" class="button"></td>
			</tr>
		</table>
	</div>
	</form>
</div>
</div>
</div>
</div>
</section>
<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>