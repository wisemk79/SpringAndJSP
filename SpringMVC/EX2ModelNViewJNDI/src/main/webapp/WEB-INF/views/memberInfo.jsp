<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	modelInfo page<br/>
	request객체로 넘겨받은것: <%= request.getAttribute("name") %><br/>
	el태그 사용한것:${ name } 
</body>
</html>