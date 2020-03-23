<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>if문 태그</title>
</head>
<body>
<%
  //int age=20;
  //String name="bk";
  //if(조건식) 실행문  if(age>19) =>형식: c:if  test="${조건식}"  p600
%>
<c:set var="age" value="${20}" />
<c:set var="name" value="${'bk'}" />
<c:if test="true">
    무조건 실행돼서 화면에 결과를 보여준다.<p>
</c:if>

<c:if test="${19 < age}">
   당신의 나이는 19세 이군요!<p>
</c:if>

<c:if test="${name=='bk'}">
   name 파라미터값은 ${name} 입니다.<br>
</c:if>
<!-- if태그는 따로 else구문을 처리해주는 문장이 없다.조건식을 따로 주는 if태그를 사용O -->
<c:if test="${name!='bk'}">
   name 파라미터값은 ${name} 입니다.<br>
</c:if>

</body>
</html>





