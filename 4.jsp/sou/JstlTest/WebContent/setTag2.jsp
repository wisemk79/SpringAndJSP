<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>

<%
     // java.util.HashMap map=new java.util.HashMap();//세션처리와 연관,메모리에 저장
      //map.put("name","홍길동");//map.get(키명(name))
       //request.setCharacterEncoding("utf-8");//p613
       //requestEncoding(액션태그명)  value="캐릭터셋"
%>
<fmt:requestEncoding value="utf-8" />

<c:set var="map" value="<%=new java.util.HashMap() %>" />
<html>
<head>
<meta charset="UTF-8">
<title>set태그의 2번째 예제</title>
</head>
<body>
<%--
    액션태그의 주석달때 사용
     target(${객체명}(어떤 객체에 저장할것인지),=>외부에서 만들어진 객체를 불러올때 사용
     property(속성명(멤머변수))를 지정,value =>객체의 값을 저장할때 필요로하는 속성
     ->jsp:setProperty  name="객체명" property="속성명(=멤버변수)" value="값"/>
     map.put("name","홍길동");//map.get(키명(name))
 --%>
 <c:set target="${map}" property="name"  value="홍길동" />
  변수 map에 저장된 name값:${map.name}<br>
  변수 map에 저장된 name값:${map['name']}<br>
  변수 map에 저장된 name값:${map["name"]}<br>
  
 <form method="post" action="setTag2.jsp">
   이름:<input type="text" name="name">
   <input type="submit" value="전송">
 </form>
 <hr>
이름은 <%=request.getParameter("name") %> 입니다.<p>
이름은(el) ${param.name} 입니다.
</body>
</html>






