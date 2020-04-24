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
		//cookieset.jsp로부터 쿠키의 값을 받아 배열로 가져온다. 
		Cookie[] cookies = request.getCookies();
	
	//쿠키의 갯수 만큼 출력과 삭제를 한다. 
	for(int i=0; i < cookies.length; i++){
		String str = cookies[i].getName();//쿠키의 이름을 가져온다.
		if(str.equals("cookieN")){//만약 쿠키의 이름이 cookieN 이라면 쿠키의 이름과 값을 출력한다. 
			out.println("cookies[" + i + "]name: " + cookies[i].getName() + "<br/>");
			cookies[i].setMaxAge(0);//쿠키의 생명시간을 0으로 만든다음에 
			response.addCookie(cookies[i]);//여기서 다시 response에 쿠키를 탑재시킨다.
			out.println("===============================================<br/>");
		}
	}	
	%>
	
	<a href="cookietest.jsp">cookie 확인</a>
</body>
</html>