<%@page import="com.MVC.consumeapi.controller.WeatherAPIController"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Weather</title>
</head>
<body>
	<h1> 
		<%
			WeatherAPIController weatherAPIController = new WeatherAPIController();
			weatherAPIController.GetLatLong();
		%>	
	</h1>
</body>
</html>