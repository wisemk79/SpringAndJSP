<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.javalec.ex.*" %>
<% request.setCharacterEncoding("EUC-KR"); %>
<% 
	String id = (String)session.getAttribute("id");
	MemberDao dao = MemberDao.getInstance();
	MemberDto dto = dao.getMember(id);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script language="javascript" src="members.js"></script>
</head>
<body>
	<form action="modifyOk.jsp" method="post" name="reg_frm">
		아이디: <input type="text" name="id" value="<%= dto.getId() %>" readOnly size="20"> <br/>
		비밀번호: <input type="password" name="pw" size="20"><br/>
		비밀번호 확인: <input type="password" name="pw_check" size="20"><br/>
		이름: <%= dto.getName() %><br/>
		메일: <input type="text" name="eMail" value="<%= dto.geteMail() %>" size="20"> <br/>
		주소: <input type="address" name="address" value="<%= dto.getAddress() %>" size="20"><br/>
		<input type="button" value="정보수정하기" onclick="UpdateInfoConfirm()"> &nbsp; &nbsp; &nbsp; <input type="reset" value="취소" onclick="javascript:window.location="login.jsp">
	</form>
</body>
</html>