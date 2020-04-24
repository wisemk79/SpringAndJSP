<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그아웃되었습니다.</h1>
	<%
		Cookie[] cookies = request.getCookies();
		
		if(cookies != null){
			for(int i=0; i <cookies.length; i++){
				if(cookies[i].getValue().equals("abcde")){
					cookies[i].setMaxAge(0);
					response.addCookie(cookies[i]);
				}
			}
		}
	%>
	
	<a href="login.html">로그인 하기 </a>
</body>
</html>