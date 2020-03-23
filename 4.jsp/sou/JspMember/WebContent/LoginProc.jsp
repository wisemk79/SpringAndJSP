<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="hewon.MemberDAO" %>
    
<jsp:useBean id="memMgr"  class="hewon.MemberDAO" scope="page" />
<%
    //id는 영어->한글처리할 필요X ->request.setCharacterEncoding("utf-8")(X)
    String mem_id=request.getParameter("mem_id");
    String mem_passwd=request.getParameter("mem_passwd");
    System.out.println("mem_id=>"+mem_id+",mem_passwd=>"+mem_passwd);
    //MemberDAO객체 필요->loginCheck메서드호출
    //MemberDAO memMgr=new MemberDAO();
    boolean check=memMgr.loginCheck(mem_id, mem_passwd);
%>
<%
   //check->LoginSuccess.jsp(인증화면),LogError.jsp(에러메세지)
   if(check){//if(check==true)
	   session.setAttribute("idKey",mem_id);//메모리에 저장->request.getAttribute(키명)
	   //response.sendRedirect("LogSuccess.jsp");//인증화면으로 이동
	   response.sendRedirect("Login.jsp");
   }else{//id가 없다는경우,passwd X
	   response.sendRedirect("LogError.jsp");//단순히 이동하고자할때 
   }
%>





