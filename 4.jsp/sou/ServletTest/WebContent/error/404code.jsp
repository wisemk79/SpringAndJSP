<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>404에러가 발생이 된경우</title>
</head>
<body>
<%
    response.setStatus(HttpServletResponse.SC_OK);
    //개발자가 지정한 에러페이지를 설정해서 보여준다는 옵션
%>

<h1><font color="red">
요청하신 문서를 못찾았습니다. 요청하신 문서와 경로를
다시한번 확인해주세요!!!
</font></h1>
</body>
</html>