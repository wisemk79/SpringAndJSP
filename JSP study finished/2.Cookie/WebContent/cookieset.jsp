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
						// 여기서 쿠키객체의 앞에오는 값은 쿠키의 이름 , 뒤에는 쿠키의 value 이다.
		Cookie cookie = new Cookie("cookieN", "cookieV");
		cookie.setMaxAge(60*60);// 1시간동안 쿠키를 유지한다. <--쿠키의 생명 시간 같은것 
		response.addCookie(cookie);//응답을 할때 쿠키 객체를 준다. 
	%>
	
	
	<%-- 쿠키객체를 하이퍼링크를 통해서 전달한다.  --%>
	<a href="cookieget.jsp">cookie get</a>
</body>
</html>