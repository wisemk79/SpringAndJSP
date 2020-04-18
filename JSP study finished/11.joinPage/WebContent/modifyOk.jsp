<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.javalec.ex.MemberDto" %>
<%@ page import="com.javalec.ex.MemberDao" %>
<jsp:useBean id="dto" class="com.javalec.ex.MemberDto"/>
<jsp:setProperty property="*" name="dto"/>
<%
	MemberDao dao = MemberDao.getInstance();
	int checkNum = dao.updateMember(dto);
	
	if(checkNum == 1){
%>

<script>
	alert("정보 수정이 완료되었습니다.");
</script>

<jsp:forward page="login.jsp"/>

<%
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>