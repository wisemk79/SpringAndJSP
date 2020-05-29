<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
    //   /프로젝트명/가상경로포함해서 요청명령어 =>/board(가상경로)/요청명령어
%>
<ul>
	<li><a href="<%=contextPath%>/board/list.do">목록</a></li>
	<li><a href="<%=contextPath%>/board/write.do">글쓰기</a></li>
</ul>