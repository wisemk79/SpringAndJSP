<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
      request.setCharacterEncoding("utf-8");
%>
<html>
<head>
<meta charset="UTF-8">
<title>응답</title>
</head>
<body>
<%
       String name=request.getParameter("name");
%>
이름은 <%=name %> 입니다.
</body>
</html>


