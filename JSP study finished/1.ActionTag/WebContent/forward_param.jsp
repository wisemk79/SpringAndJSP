<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>forward_param.jsp 페이지입니다. </h1>
	
	<%! 
		String id, pw;
	%>
	
	<% id = request.getParameter("id");
		pw = request.getParameter("pw");
	%>
	
	<h3>결과 값은? </h3>
	id = <%= id%><br/>
	pw = <%= pw %>
</body>
</html>