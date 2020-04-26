<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import ="java.util.*,com.mybatis.ex.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	메인페이지<br/>
	<form action="/insert" method="post">
	아이디: <input type="text" name="name"/><br/>
	이메일: <input type="text" name="email"/><br/>
	핸드폰: <input type="text" name="phone"/><br/>
	<input type="submit" value="제출"/>
	</form>
	
	<c:forEach items="${result}" var="member">
	===================================<br/>
			${member._name}<br/>
            ${member._email}<br/>
            ${member._phone}<br/>
    ===================================<br/>
	</c:forEach>
	
</body>
</html>