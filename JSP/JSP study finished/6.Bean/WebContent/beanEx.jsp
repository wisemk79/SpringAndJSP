<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 여기서 id는 Student st = new Student()<-처럼 객체 생성할때 변수명을 의미하며
		clsaa는 자바 빈의 경로가 되고 
		scope는 적용 위치를 의미하는데
		page는 생성된 페이지에서만 사용이 가능한 것을 의미하며
		request는 요청된 페이지 에서만 사용이 가능하며
		session은 웹브라우의 생명주기와 동일하게 사용 가능하며
		application은 어플리케이션 생명주기와 동일하게 사용한다. 
  -->
<<jsp:useBean id="student" class="com.javalec.ex.Student" scope="page"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 자바 빈 에서 세터 메소드를 불러와 값을 넣어주는것
		name에는 student라는 빈에서 name이라는 변수에  value값을 넣어주는 것이다. 
	  -->
	<jsp:setProperty name="student" property="name" value="홍길동"/>
	<jsp:setProperty name="student" property="age" value="13"/>
	<jsp:setProperty name="student" property="grade" value="6"/>
	<jsp:setProperty name="student" property="studentNum" value="7"/>
	
	
	<!-- 자바 빈 에서 게터 메소드를 불러오는것  
		student라는 빈에서 name이라는 프로퍼티를 불러오라는것 
	-->
	이름: <jsp:getProperty name="student" property="name"/><br/>
	나이: <jsp:getProperty name="student" property="age"/><br/>
	학년: <jsp:getProperty name="student" property="grade"/><br/>
	번호: <jsp:getProperty name="student" property="studentNum"/>
</body>
</html>