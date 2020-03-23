<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 생성</title>
</head>
<%
   //1.쿠키생성->이름,저장할값 지정(한글도 가능)->접속한 클라이언트에게 전송
   String cookiename="mycookie";//
   Cookie c=new Cookie(cookiename,"apple");//쿠키이름,저장할값
   //2.쿠키값을 접속한 클라이언트 컴퓨터에 전송하기전에 기본값을 설정
   c.setMaxAge(60*2);//2분쿠키 저장 유지 시간->(60*60*24*365) 1년내내 저장
   //3.쿠키의 값을 변경->setValue(변경할값)
   c.setValue("이연수");
   //4.클라이언트->addCookie(전송할 쿠키객체명)
   response.addCookie(c);
%>
<body>
<h1>쿠키를 생성하는 예제</h1>
<p>
쿠키가 생성되었습니다.<br>
쿠키의 내용은 <a href="useCookie.jsp">여기에서 확인</a>
</body>
</html>



