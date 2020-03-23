<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    //파일로 만들어서 불러오기->include 지시어를 이용할것.
   //웹상에서 강제로 접근->인증처리=> session.setAttribute("idKey",mem_id);
   String mem_id=(String)session.getAttribute("idKey");
   System.out.println("mem_id=>"+mem_id);//계정명->null
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인증성공 페이지</title>
</head>
<body>
<%
   //Login.jsp->LoginProc.jsp->LoginSuccess.jsp
   if(mem_id!=null){ //인증된 사람이라면
%>
<b><%=mem_id %></b>님 환영합니다.<p>
  당신은 제한된 기능을 사용할 수 가 있습니다.<p>
  <a href="Logout.jsp">로그아웃</a>
 <%} %>
</body>
</html>










