<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>move.jsp</title>
</head>
<body>
  <h1>페이지를 이동시키는 역할</h1>
  <%
       String move=request.getParameter("move");//a.jsp or b.jsp
       System.out.println("move=>"+move);
  %>
  <!-- forward액션태그 page="이동할 페이지명"  -->
  <jsp:forward page="<%=move%>" /><br>
</body>
</html>






