<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="member" class="com.javalec.ex.MemberInfo" scope="page"/>
<jsp:setProperty name="member" property="name" value="홍길동"/>
<jsp:setProperty name="member" property="id" value="abc"/>
<jsp:setProperty name="member" property="pw" value="123"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	이름: <jsp:getProperty name="member" property="name"/>
	아이디: <jsp:getProperty name="member" property="id"/>
	비밀번호: <jsp:getProperty name="member" property="pw"/>
	
	
	이름: ${member.name}
	아이디: ${member.id}
	비밀번호:  ${member.pw}
</body>
</html>