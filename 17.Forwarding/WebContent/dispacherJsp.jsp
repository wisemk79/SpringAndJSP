<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	dispacherJsp.jsp
	<hr/>
	
	id: <%= request.getAttribute("id") %><br/>
	pw: <%= request.getAttribute("pw") %>
	
	<%
	//마찬가지로 jsp에서도 다른 컴포넌트로 request객체를 위임해 줄수있다. 
			//위임받을 컴포넌트 패스에 디스패쳐를 request 전달해준다. 
		RequestDispatcher dispatcher = request.getRequestDispatcher("/dispacherJsp2.jsp");
		///dispatcherJsp.jsp에 위의 속성 값 request들을 전달해준다.
		dispatcher.forward(request, response);
		
	%>
</body>
</html>