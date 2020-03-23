<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>요청받아 처리</title>
</head>
<body>
<h1>포함을 하는 페이지1</h1>
<%
     request.setCharacterEncoding("utf-8");//한글처리
%>
<!-- sub.jsp에서 실행한 결과내용(삽입)(실행결과)  -->
<jsp:include page="sub.jsp"  flush="false" /><br>
나머지는 sub.jsp가 알아서 해줄거예요!!!
</html>










