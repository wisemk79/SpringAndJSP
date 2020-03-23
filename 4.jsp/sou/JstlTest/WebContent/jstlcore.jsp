<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstlcore.jsp(변수(객체)의 사용범위,out태그,정리예제)</title>
</head>
<body>
<h3>출력문</h3>
<h1>
<%--
  <c:out value="${출력할대상자}" />

 --%>
 <%
     out.println(1+2);
 %>
 <%=1+2%>
 ${1+2} <c:out value="${1+2}" />
<hr>
${1 > 3} <c:out value="${1 > 3 }" />
${1 gt 3} <c:out value="${1 gt 3 }" />
<hr>
<%
    String name="hello";
    session.setAttribute("name","하늘");//메모리에 저장<->session.getAttribute
    //request.setAttribute("name","하늘");
    //scope="page" request         session          application jsp내장객체의 사용범위
    //pageScope, requestScope,sessionScope,applicationScope 사용범위
%>
<c:set var="name"  value="hello" />
c:out name:<c:out value="${pageScope.name}" /><br>

<!-- 같은 변수의 값을 출력하는 경우 (저장영역을 표시.출력할 변수명) -->
<c:set var="name"  value="하늘"  scope="session" />
expression name:<%=session.getAttribute("name") %><p>
session객체의 값 name:<c:out value="${sessionScope.name}" /><br>
<hr>
remove session scope var "name":<c:remove var="name"  scope="session" /><p>
session객체의 값 name2:<c:out value="${sessionScope.name}" /><br>
</h1>
</body>
</html>





