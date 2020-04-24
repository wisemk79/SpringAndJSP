<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- "ValidMem" 이라는 세션의 값이 null이 아니라면 메인 페이지로 이동한다. -->
<% if(session.getAttribute("ValidMem") != null){ %>
	<jsp:forward page="main.jsp"></jsp:forward>
<%} %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="loginOk.jsp" method="post">
													<!-- 세션에 아이디값이 있으면 그 값을 출력한다.  -->
		아이디: <input type="text" name="id" value="<% if(session.getAttribute("id") != null) out.println(session.getAttribute("id")); %>"/><br/>
		비밀번호: <input type="password" name="pw"><br/>
																								<!-- 클릭시에 join.jsp 페이지로 이동하라는 자바 스크립트문구  -->
		<input type="submit" value="로그인"> &nbsp; &nbsp; <input type="submit" value="회원가입" onclick="javascript:window.location="join.jsp">
	</form>
</body>
</html>