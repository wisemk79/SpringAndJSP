<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%
     java.util.HashMap mapData=new java.util.HashMap();
     mapData.put("name","홍길동");
     mapData.put("today",new java.util.Date());//날짜객체 저장
     //int []intArray={1,2,3,4,5};//배열도 객체다
%>
<c:set var="intArray"  value="<%=new int[] {1,2,3,4,5} %>" />
<c:set var="map" value="<%=mapData %>" />
<html>
<head>
<meta charset="UTF-8">
<title>forEach태그 연습</title>
</head>
<body>
<%
   int sum=0;
   for(int i=1;i<=100;i++){//i+=2
	   if(i%2==1)
	      sum+=i;//sum=sum+i;
   }
  out.println(sum);
%>
<h4>1~100까지의 홀수의 합</h4>
<%-- 
   forEach-> var="첨자의 변수명" begin="첨자변수의 시작값" end="첨자변수의 종료값"
                                             step="증가값" (1인경우에는 step값을 생략이 가능하다.)
                                             **items="${배열및 객체명}" ->html주석에서는 적용X
                                                                                                      에러유발
 --%>                                                                           
<c:set var="sum" value="0" />
<c:forEach var="i"  begin="1" end="100" step="2">
	<c:set var="sum" value="${sum+i}" />
</c:forEach>
결과:${sum}
<hr>
<%--
<c:set var="intArray"  value="<%=new int[] {1,2,3,4,5} %>" />
 --%>
 <h4>컬렉션객체 및 배열의 값을 출력(확장 for)</h4>
 <c:forEach var="i" items="${intArray}"  begin="1" end="3">
     [${i}]
 </c:forEach>
 <h4>Map객체를 이용(key,value)</h4>
 <!-- Map객체의 i값은 Map에 저장된 각각의 객체를 의미  -->
 <c:forEach var="i" items="${map}">
    ${i.key}=${i.value}
 </c:forEach>
</body>
</html>










