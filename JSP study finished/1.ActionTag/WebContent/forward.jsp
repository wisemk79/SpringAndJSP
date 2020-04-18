<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>forward.jsp 페이지입니다. </h1>
	<jsp:forward page="forward_param.jsp">
		<jsp:param name="id" value="abcde"/>
		<jsp:param name="pw" value="123456"/>
	</jsp:forward>
	
	<%-- 위에처럼 jsp param을 forward하게되면 받는쪽에서
		request.getparameter("id 또는 pw") 로 값을 받아 출력할 수 있다.
		<%!
		String id,pw;
		%>
		
		<%
		id = request.getParameter("id");
		pw = request.getParameter("pw");
		%>
		
		<%= id%>
		<%= pw%>
		
	 --%>
</body>
</html>