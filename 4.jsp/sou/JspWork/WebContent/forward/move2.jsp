<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>move.jsp</title>
</head>
<body>
  <h1>요청을 판단해서 올바른 요청이라면 페이지를 이동시키는 역할</h1>
  <%
       int su=100; //->a.jsp에 전달(데이터 공유)
       System.out.println("su=>"+su);
  
       Date d=new Date();//->b.jsp에 데이터공유->b.jsp
       //자바의 자료구조->HashMap(키,값저장)
       //형식)reqest|session|application.setAttribute(키명,저장할값)
       request.setAttribute("total", su);//su(X)->new Integer(su)
       request.setAttribute("cal",d);//<-->request.getAttribute(키명)
       //----------------------------------------------------------
       String move=request.getParameter("move");//a.jsp or b.jsp
       System.out.println("move=>"+move);
       //이동시킬 페이지가 존재->이동 O or 존재X->다시 입력을 받을 수 있도록 코딩
       if(move.equals("a.jsp")){
    	   //response.sendRedirect("a.jsp")//이동만 한다면
  %>
  <!-- forward액션태그 page="이동할 페이지명"  -->
  <jsp:forward page='a.jsp' /><br>
  <%}else if(move.equals("b.jsp")) { %>
  <jsp:forward page='b.jsp' /><br>
  <%}else { %>
   <script>
     alert("당신이 요청하신 페이지는 없습니다.\n확인해서 다시 해보세요!")
     location.href="forward.jsp"
  </script>
  <%}  %>
</body>
</html>






