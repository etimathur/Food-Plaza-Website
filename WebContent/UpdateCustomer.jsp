<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Customer</title>
<%@ page import="foodplaza.pojo.Customer" %>
<link rel="stylesheet" href="StyleSheet.css">
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
		var name=document.getElementById("name").value;
		var contactNo=document.getElementById("con").value;
		var address=document.getElementById("add").value;
		if(name=="")
		{
			document.getElementById("nameerror").innerHTML="*please enter name";
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
		return true;
		
	}
</script>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<%
	Customer customer=(Customer)request.getAttribute("customer");
	String cemail=customer.getCustEmail();
	String cpass=customer.getCustPassword();
	String cadd=customer.getCustAddress();
	Long cphone=customer.getCustContactNo();
	String cname=customer.getCustName();
	
	
%>
<section id="home" class="parallax-section">
	<div class="container">
		<div class="row">
			<div class="col-md-12 col-sm-12">
<div>
	<h1 style="font-size:50px;">Update Profile</h1>
	<br>
	<form onsubmit="return validation()" action="CustomerServlet" method="post">
	<input type="hidden" name="action" value="UpdateCust">
	<div align="center">
		<table style="border-collapse: separate; border-spacing: 0 15px;">
			<tr>
				<td style="font-size:25px;" class="label">Id :</td>
				<td><input type="text" name="id" id="id" value="<%=customer.getCustId() %>" readonly="readonly"></td>
				<td><span name="iderror" id="iderror" style="color:Red" ></span></td>
			</tr>
			<tr>
				<td style="font-size:25px;" class="label">Name :</td>
				<td> <input type="text" name="name" id="name" value="<%=cname%>"></td>
				<td><span name="nameerror" id="nameerror" style="color:Red" ></span></td>
			</tr>
			<tr>
				<td style="font-size:25px;" class="label">Email :</td>
				<td><input type="email" readonly="readonly" value="<%=cemail%>" name="email" id="email"></td>
				<td><span name="emailerror" id="emeilerror" style="color:Red"></span></td>
			</tr>
			<tr>
				<td style="font-size:25px;" class="label">Password :</td>
				<td><input type="password" readonly="readonly" value="<%=cpass%>" name="pass" id="pass" ></td>
				<td><span name="passerror" id="passerror" style="color:Red"></span></td>
			</tr>
			<tr>
				<td style="font-size:25px;" class="label">Contact No :</td>
				<td><input type="number" name="con" id="con" value="<%=cphone %>"></td>
				<td><span name="conerrore" id="conerror"  style="color:Red"></span></td>
			</tr>
			<tr>
				<td style="font-size:25px;" class="label">Address :</td>
				<td><textarea rows="" cols="" name="add" id="add" placevalue="<%=cadd%>" ></textarea></td>
				<td><span name="adderror" id="adderror" style="color:Red" ></span></td>
			</tr>
			<tr>
				<td><input type="submit" value="Update" class="button"></td>
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
<canvas></canvas>
<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>