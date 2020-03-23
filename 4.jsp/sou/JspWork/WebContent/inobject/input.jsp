<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>다중선택예제</title>
</head>
<body>
<form action="arrayprint.jsp" method="post">
 이름:<input type="text" name="name"><p>
 주소:<input type="text" name="addr"><p>
 좋아하는 동물
 <input type="checkbox" name="pet" value="dog">강아지
 <input type="checkbox" name="pet" value="cat">고양이
 <input type="checkbox" name="pet" value="pig">돼지
 <p>
 <input type="submit" value="전송">
</form>

</body>
</html>







