<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="test.BeanDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>입력받은 값을 저장,출력</title>
</head>
<body>

<%
   //한글처리
   request.setCharacterEncoding("utf-8");
   String str=request.getParameter("str");
   String addr=request.getParameter("addr");
   System.out.println("str=>"+str+",addr=>"+addr);
   //1.객체생성->데이터저장할려고,메서드호출목적
   //BeanDTO bd=new BeanDTO();
   //<jsp:useBean id="bd" class="test.BeanDTO" scope="page">
   //2.입력받은 갯수만큼 Setter Method 호출=>데이터 값을 저장한다.
   //bd.setStr(str);//bd.setStr(request.getParameter("str"))
   
   //bd.setAddr(addr);
   //3.Getter Method를 호출해서->화면에 출력
   //out.println("입력받은 이름?=>"+bd.getStr()+"<br>");
   //out.println("입력받은 주소?=>"+bd.getAddr()+"<br>");
%>
<jsp:useBean id="bd" class="test.BeanDTO" scope="page" />
<%-- 
<jsp:setProperty name="bd"  property="str"  value="<%=str%>" />
<jsp:setProperty name="bd"  property="addr" value="<%=addr %>" />
 --%>
<jsp:setProperty name="bd"  property="*" />
<hr>
액션태그를 통한 Getter Method를 호출하는 경우
<jsp:getProperty name="bd"  property="str" />
<jsp:getProperty name="bd"  property="addr" />
<hr>
<b><%=bd.getStr() %></b>님! 잘오셨습니다.<br>
<b>제 주소는 <%=bd.getAddr() %></b>입니다.
</body>
</html>





