<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>응답객체(=response)</title>
</head>
<body>
<%
    //response.setContentType("text/html;charset=utf-8");문서의 종류,특성지정
    //response.sendRedirect("http://www.daum.net");//외부의 사이트로 이동할때->url창이 변경
    //response.sendRedirect("../bottom/bottom.html");//내부의 특정위치로 이동할때
%>
<script>
   // location.href="http://www.naver.com";
   location.replace("http://www.empas.com");//replace함수(url경로 변경)
</script>
</body>
</html>





