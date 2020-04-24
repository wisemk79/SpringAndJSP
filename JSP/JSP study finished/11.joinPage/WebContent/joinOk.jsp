<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="com.javalec.ex.*" %>
<% request.setCharacterEncoding("EUC-KR"); %>
<jsp:useBean id="dto" class="com.javalec.ex.MemberDto"/>
<!-- 자동적으로 dto에 있는 것을 set해주고 싶다면, dto의 멤버변수가  join폼에 있는 각 input태그의 name값과 일치해야한다.  -->
<jsp:setProperty name="dto" property="*"/>
<%
	dto.setrDate(new Timestamp(System.currentTimeMillis()));
	//인스턴스를 가져온다. 
	MemberDao dao = MemberDao.getInstance();
	if(dao.confirmId(dto.getId()) == MemberDao.MEMBER_EXISTENT){
%>

<script language="javascript">
	alert("아이디가 이미 존재합니다.");
	history.back();
</script>

<%
	}else{
		int ri = dao.insertMember(dto);
		if(ri == MemberDao.MEMBER_JOIN_SUCCESS){
			session.setAttribute("id", dto.getId());
%>

<script language="javascript">
	alert("회원가입을 축하합니다. ");
	document.location.href="login.jsp";
</script>

<%
		}else{
%>

<script language="javascript">
	alert("회원가입에 실패했습니다. ")
	document.location.href="login.jsp";
</script>

<%
		}
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