<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%! 
		String id, pw;
	%>
	
	<%
		id = request.getParameter("id");
		pw = request.getParameter("pw");
		
		
		if(id.equals("abcde") && pw.equals("12345")){
			Cookie cookie = new Cookie("id", id);//쿠키를 만들고 
			cookie.setMaxAge(60);// 쿠키의 수명시간을 60초로 설정  
			response.addCookie(cookie);// 쿠키를 response에 탑재시킨다.
			response.sendRedirect("welcome.jsp");//리다이렉트 시킨다. 
		}else{
			response.sendRedirect("login.html");
		}
	%>
</body>
</html>