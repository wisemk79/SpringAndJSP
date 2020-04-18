<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- taglib를 쓰겠다고 선언하는 것 prifix는 임의로 사용하는사람이 지정하는 변수명과 같은것, core를 쓴다는것은 url에서 볼 수 있다. -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- 변수명과 값을 정해주는 구문   -->
	<c:set var="varName" value="varValue"/>
	varName: <c:out value="${ varName }"/><!--  출력태그  -->
	<br/>
	<!-- 변수의 값을 삭제하는 구문  -->
	<c:remove var="varName"/>
	varName: <c:out value="${ varName }"/>
	<hr/>
	
	<!-- try catch와 같은 비슷한 구문  -->
	<c:catch var="error">
		<%= 4/0%>  
	</c:catch>
	<br/>
	<c:out value="${ error }"/>
	
	<br/>
	
	<!-- if문  -->
	<c:if test="${ 1+2 == 3 }">
		1 + 2 = 3
	</c:if>
	
	<c:if test="${ 1+2 != 3 }">
		1 + 2 != 3
	</c:if>
	<hr/>
	
	<c:forEach var="fEach" begin="0" end="30" step="4">
		${ fEach }
	</c:forEach>
	
</body>
</html>