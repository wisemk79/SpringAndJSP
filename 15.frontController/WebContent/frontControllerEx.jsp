<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<a href="insert.do">insert</a>
	<hr/>
				<!-- 여기서 <%= request.getContextPath() %>는 /15.frontController/이다.  -->
		<a href="http://localhost:8181<%= request.getContextPath() %>/update.do">update</a>
	<hr/>
		<a href="http://localhost:8181/15.frontController/select.do">select</a>
	<hr/>
		<a href="<%= request.getContextPath() %>/delete.do">delete</a>
	
</body>
</html>