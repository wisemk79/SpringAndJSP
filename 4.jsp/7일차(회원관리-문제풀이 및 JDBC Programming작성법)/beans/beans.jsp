<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자바빈즈가 나온 배경설정예제 </title>
</head>
<body>
<%!
   //입력->매개변수를 전달->각각의 값을 필드별로 저장하는 변수(멤버변수)저장(테이블의 필드에 저장)
  //선언문->변수를 선언,메서드를 작성
  String str="선언문";//웹상에서 입력받을 값이 저장이 되는 멤버변수
  String addr="";
  
  //웹상에서는 생성자를 통해서 값을 저장X =>Setter Method를 이용한다.->액션태그와 연관
  //1.화면 디자인 어렵다.(복잡)
  //2.기존의 코딩=>다른 사이트에 적용하기가 어려워진다.(재사용성활용X)
  
  public void setStr(String s){//입력->저장
	  str=s;
     System.out.println("setStr()호출됨!");
  }
  
  public void setAddr(String addr){
	  this.addr=addr;
  }
  public String getStr(){ return str;}
  public String getAddr(){ return addr;}
%>
 메서드 호출(Setter Method):<% setStr("자바빈즈"); %>
 <p>
 저장된 값 출력(Getter Method):<h1><%=getStr() %></h1>
</body>
</html>





