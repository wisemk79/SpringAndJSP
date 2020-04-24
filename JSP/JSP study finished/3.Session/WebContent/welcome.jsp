<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Enumeration" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% 
		Enumeration enumeration = session.getAttributeNames();
		while(enumeration.hasMoreElements()){
			String sName = enumeration.nextElement().toString();
			String sValue = session.getAttribute(sName).toString();
			
			if(sValue.equals("abcde")){
				out.println(sValue + "님 안녕하세요.");
			}
		}
	
	%>
	
	<a href="logout.jsp">로그아웃</a>
</body>
</html>