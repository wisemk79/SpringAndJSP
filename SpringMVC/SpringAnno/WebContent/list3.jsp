<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>요청받아 처리해주는 페이지</title>
</head>
<body>
<%
//mav.addObject("greeting","스프링세상!");
//request.setAttribute("greeting","스프링세상!")
//
%>
<%=request.getAttribute("greeting") %><p>
  <h1>환영합니다. ${greeting}</h1>
</body>
</html>
