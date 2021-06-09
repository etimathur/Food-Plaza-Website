<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:import url="Header.jsp"></c:import>
<c:set var="orderObject" value="${sessionScope.orderList}"/>
<canvas></canvas>
<c:choose>
	<c:when test="${orderObject!=null}">
		<h2 align="center" style="color:Red">
		Order placed Successfully<br>
		Order-Id : ${orderObject.orderId}<br>
		Bill Amount : ${orderObject.orderBill}<br><br><br>
		Order will be delivered shortly
		
		</h2>
		<br><br>
		<p align="center" style="font-size: 50px"><bold>Thank You</bold></p>
	</c:when>
	<c:otherwise>
		Successfull...........
	</c:otherwise>
</c:choose>
<canvas></canvas>
<c:import url="Footer.jsp"></c:import>
</body>
</html>