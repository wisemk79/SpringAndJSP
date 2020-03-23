<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>500에러가 발생이 된경우</title>
</head>
<body>
<%
    response.setStatus(HttpServletResponse.SC_OK);
    //개발자가 지정한 에러페이지를 설정해서 보여준다는 옵션
%>

<h1><font color="blue">
 어떤수를 0으로 나누면 안됩니다. 다시한번
 자세히 확인해주세요!!
</font></h1>
</body>



</html>