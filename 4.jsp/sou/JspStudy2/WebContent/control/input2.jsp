<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자로부터 값을 입력(전송폼2)</title>
</head>
<body>
  <h1>문자와 숫자를 매개변수로 전달</h1>
   <form method="post" action="../abc/while.jsp">
     반복할 문자열:<input type="text" name="msg" size="20"><p>
     반복할 숫   자:<input type="text" name="number" size="20"><p>
     <input type="submit" value="전송">
   </form>
 
</body>
</html>




