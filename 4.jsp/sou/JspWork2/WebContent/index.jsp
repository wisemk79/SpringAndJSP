<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>페이지 전달용</title>
</head>
<body>
<!-- /view/indexControl.jsp?CONTROL(매개변수명)=값&매개변수2=값2&
   액션태그는 일반적인 html주석이 잘 적용이 안되는 관계로 %--  --%로 주석을 줘야 된다.
   param(액션태그명)  name="매개변수명" value="값(파일명,파일번호)"
-->
<jsp:forward page="/view/indexControl.jsp">
   <jsp:param name="CONTROL"  value="intro" />
   <jsp:param name="PAGENUM"  value="01" />
</jsp:forward>
</body>
</html>





