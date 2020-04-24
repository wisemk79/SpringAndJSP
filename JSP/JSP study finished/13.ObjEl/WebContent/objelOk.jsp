<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
	%>
	
	아이디: <%= id %><br/>
	비밀번호: <%= pw %>
	
	<hr/>
	
	<!-- 여기서 param은 request.getparameter과 같은 의미인 내장객체  -->
	아이디: ${ param.id }<br/>
	비밀번호: ${ param.pw }<br/>
	
	아이디: ${ param["id"] }<br/>
	비밀번호: ${ param["pw"] }<br/>
	
	<hr/>
	
	
	<!-- session객체의 name의 value를 가져오는 등을 할 수 있는 Scope -->
	applicationScope: ${ applicationScope.application_name }<br/>
	sessionScope: ${ sessionScope.session_name }<br/>
	
	<!-- 아래 내용이 출력안되는 이유는 page는 같은 페이지가 아니고, request 역시 같은 request받는 곳이 아니기때문이다.  -->
	pageScope: ${ pageScope.page_name }<br/>
	requestScope: ${ requestScope.request_name }<br/>
	
	<hr/>
	
	<!-- web.xml에 지정해준 param이다. -->
	context 초기화 파라미터 <br/>
	${ initParam.con_name }<br/>
	${ initParam.con_id }<br/>
	${ initParam.con_pw }
	

</body>
</html>