<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   //세션 연결상태->바로 연결종료->메모리상에서 계정정보삭제
   session.invalidate();
%>
<script>
   alert("정상적으로 로그아웃 되었습니다.")
   location.href="Login.jsp" //location.href="경로포함해서 이동할 페이지명"
</script>