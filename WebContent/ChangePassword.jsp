<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Change Password </title>
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
	var oldPassword=document.getElementById("oldpass").value;
	var newPassword=document.getElementById("newpass").value;
	if(email=="")
	{
		document.getElementById("emailerror").innerHTML="*please enter email id";
		return false;
	}
	if(oldPassword=="")
	{
		document.getElementById("oldpasserror").innerHTML="*please enter old password";
		return false;
	}
	if(newPassword=="")
	{
		document.getElementById("newpasserror").innerHTML="*please enter new password";
		return false;
	}
	if(oldPassword==newPassword)
	{
		document.getElementById("newpasserror").innerHTML="*password should not be same as old password";
		return false;
	}
	if(newPassword.length<8 || newPassword.length>12)
	{
		document.getElementById("newpasserror").innerHTML="*password should of length between 8 to 12";
		return false;
	}
	return true;
}

</script>

</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<%
	String user=(String)session.getAttribute("user");
	String admin=(String)session.getAttribute("admin");
	String email;
	if(user==null)
		email=admin;
	else
		email=user;
	%>
<section id="home" class="parallax-section">
	<div class="container">
		<div class="row">
			<div class="col-md-12 col-sm-12">
<div align="center">
<h1 style="font-size:50px;"> Change Password</h1>
<br>
	<form onsubmit="return validation()" action="LoginServlet" method="post">
		<table style="border-collapse: separate; border-spacing: 0 15px;">
			<input type="hidden" name="action" value="PassChange">
			<tr>
				<td style="font-size:25px;" class="label">Type :</td>
				<% if(user==null){ %>
				<td><select name="type"><option name="Customer">Customer</option><option name="Admin" selected>Admin</option></select></td>
				<% }else {%>
				<td><select name="type"><option name="Customer">Customer</option><option name="Admin" selected>Admin</option></select></td>
				<%} %>
			</tr>
			<tr>
				<td style="font-size:25px;" class="label">Email :</td>
				<td><input type="email" name="email" id="email" value="<%=email%>"></td>
				<td><span id="emailerror" name="emailerror" style="color:red"></span></td>
			</tr>
			<tr>
				<td style="font-size:25px;" class="label">Old Password :</td>
				<td><input type="password" name="oldpass" id="oldpass"></td>
				<td><span id="oldpasserror" name="oldpasserror" style="color:red"></span></td>
			</tr>
			<tr>
				<td style="font-size:25px;" class="label">New Password :</td>
				<td><input type="password" name="newpass" id="newpass"></td>
				<td><span id="newpasserror" name="newpasserror" style="color:red"></span></td>
			</tr>
			<tr>
				<td><input type="submit" value="Change" class="button"></td>
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