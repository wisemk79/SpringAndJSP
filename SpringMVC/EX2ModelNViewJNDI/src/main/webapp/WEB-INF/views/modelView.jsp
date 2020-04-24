<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	modelViewPage<br/>
	request객체로 넘겨받은것: <%= request.getAttribute("email") %><br/>
	el태그 사용한것:${ email } 
</body>
</html>