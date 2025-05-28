<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Inside jsp</h1>
<%
java.util.Date d = new java.util.Date();
out.println(d.toString());
%>
</body>
</html>