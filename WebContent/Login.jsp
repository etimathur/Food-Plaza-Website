<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login </title>
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
		var password=document.getElementById("pass").value;
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
		return true;
	}
</script>
<style type="text/css">
input, select, textfield {
    -webkit-box-sizing: border-box;
       -moz-box-sizing: border-box;
            box-sizing: border-box;
            size: 150px;
}
</style>
<script type="text/javascript" src="jquery-3.2.1.min.js"></script>
<script type="text/javascript">

	if($("type").val.localCompare("Customer")==0)
		{
	$(document).ready(function(){
		
		$("#pass").click(function(){
			var data=$("#email").val();
			$.get("LoginServlet",{action:'check',email:data},function(responseData){
				$("#emailerror").text(responseData);	
			});
		});
	});
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
<h1 style="font-size:50px;"> Login </h1>
<br>
	<form onsubmit="return validation()" action="LoginServlet" method="post">

		<table style="border-collapse: separate; border-spacing: 0 15px;">
			
			<input type="hidden" value="login" name="action">
			<tr>
				<td style="font-size:25px;" class="label">Type :</td>
				<td>
					<select name="type" size="" >
						<option name="Customer">Customer</option>
						<option name="Admin">Admin</option>
					</select>
				</td>
			</tr>
			<tr>
				<td style="font-size:25px;" class="label">Email :</td>
				<td><input type="email" name="email" id="email"></td>
				<td>&nbsp<span name="emailerror" id="emailerror" style="color:red"></span></td>
			</tr>
			<tr>
				<td style="font-size:25px;" class="label">Password :</td>
				<td><input type="password" name="pass" id="pass"></td>
				<td><span name="passerror" id="passerror" style="color:red"></span></td>
			</tr>
			<tr>
				<td><input type="submit" value="Login" class="button"></td>
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