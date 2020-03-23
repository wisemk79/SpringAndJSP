<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>request객체 자주 사용되는 메서드</title>
</head>
<%!
     String name="홍길동";//멤버변수로 선언
%>
<!--  request(사용자로부터 요청을 받았을때 사용되는 jsp의 내장객체 -->
<h2>
  1.서버의 도메인이름:<%=request.getServerName() %><br>
  2.서버의 포트번호:<%=request.getServerPort() %><br>
  **3.요청된 URL에서의 경로:<%=request.getRequestURL() %><br>
  **4.요청된 URI에서의 경로:<%=request.getRequestURI() %><br>
  **5.원격 주소 ip주소:<%=request.getRemoteAddr() %><br>
  6.클라이언트가 요청한 프로토콜:<%=request.getProtocol() %><br>
  **7.요청방식(Get or Post):<%=request.getMethod() %><br>

</h2>
<body>

</body>



</html>