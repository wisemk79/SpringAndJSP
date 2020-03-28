<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.javalec.ex.MemberDto" %>
<%@ page import="com.javalec.ex.MemberDao" %>
<%
	request.setCharacterEncoding("EUC-KR");
	//사용자에게 브라우저를 통해 받은 id pw값,
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	MemberDao dao = MemberDao.getInstance();
	int checkNum = dao.userCheck(id,pw);
	if(checkNum == -1){
 %>
 
 <script>
 	alert("아이디가 존재하지 않습니다.");
 	history.go(-1);
 </script>
 
 <%
	}else if(checkNum==0){
 %>
 
 <script>
 	alert("비밀번호가 틀립니다.");
 	history.go(-1);
 </script>
 
 <%
	}else if(checkNum == 1){
		MemberDto dto = dao.getMember(id);
		
		if(dto == null){
 %>
 
 <script>
 	alert("존재하지 않는 회원입니다.");
 	history.go(-1);
 </script>
 
 <%
		}else{
			String name= dto.getName();
			session.setAttribute("id", id);
			session.setAttribute("name", name);
			session.setAttribute("ValidMem", "yes");
			response.sendRedirect("main.jsp");
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