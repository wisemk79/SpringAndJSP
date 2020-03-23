<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>외부의 자원을 가져다 사용하는 액션태그(보안때문에 사이트 메인페이지 복사금지)</title>
</head>
<body>
<%
      //String url="http://www.naver.com";
      //네이버와 다음사이트는 외부에서 접근이 금지->302 (접근금지)
      //javax.servlet.ServletException: javax.servlet.jsp.JspTagException: 302 http://www.naver.com
      //<c:import url="접속할 사이트 주소"   var="접속해서 가져올 데이터저장할 변수명"
      //escapeXml="true"(태그자체를 문자열로 인식해서 문자형태로 출력)
      //escapeXml="false" 태그자체로 인식해서 불러와서 (화면디자인상의 그 형태 그대로 )
%>
<c:set var="url"  value="http://www.chosun.com" />
<c:import url="${url}"  var="u" />
<c:out value="${url}" />가져옵니다.<p>
<c:out value="${u}" escapeXml="false" />
<hr>
<h4>내부 자원을 가져오기 </h4>
<!-- chooseTag.jsp?age2=20(get방식으로 매개변수 전달) include 액션태그와 기능이 비슷 -->
<c:set var="url"  value="chooseTag.jsp" />
<c:import url="${url}"  var="u">
	<c:param name="age2" value="20" />
</c:import>
<c:out value="${u}" escapeXml="false" />
</body>
</html>






