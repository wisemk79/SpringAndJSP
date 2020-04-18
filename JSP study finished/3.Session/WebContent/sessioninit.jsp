<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//session 객체는 따로 생성하지 않아도 자동으로 생성되는 서블릿으로 컴파일될때 생성되는 내부객체이다. 
		session.setAttribute("mySessionName", "mySessionData");// 세션의 name ,세션의 value
		session.setAttribute("myNum", 12345);//여러개의 세션을 지정해보자 (2개)
	%>
	
	<a href="sessionget.jsp">session get</a>
</body>
</html>