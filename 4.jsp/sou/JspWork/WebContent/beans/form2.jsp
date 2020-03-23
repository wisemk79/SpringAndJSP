<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자로부터 값을 입력</title>
</head>
<body>
<h1>자바빈즈 (입력폼)</h1>
<!-- name값은 반드시 빈즈클래스의 멤버변수명과 동일 -->
<form  method="post" action="beans3.jsp">
 이름:<input type="text" name="str"><p>
 주소:<input type="text" name="addr"><p>
 <!-- 나이:<input type="text" name="age"><p> -->
 <input type="submit" value="보내기">
</form>

</body>
</html>







