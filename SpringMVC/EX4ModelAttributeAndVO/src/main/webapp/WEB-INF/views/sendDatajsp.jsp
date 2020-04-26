<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	제출해보자<br/>
	<form action="/ModelAttributeVO.do" method="get">
	국가: <input type="text" name="country"/><br/>
	ETC: <input type="text" name="etc"/><br/>
	<input type="submit" value="제출"/>
	</form>
	
	
	${commonCodeMap.code1}
</body>
</html>