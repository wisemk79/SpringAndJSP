<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   //  /view/indexControl.jsp?CONTROL=intro&PAGENUM=01
   String CONTROL=null;//전달받을 페이지명
   String PAGENUM=null;//페이지 번호

   try{
	   CONTROL=request.getParameter("CONTROL");
	   PAGENUM=request.getParameter("PAGENUM");
	   System.out.println("CONTROL=>"+CONTROL+",PAGENUM=>"+PAGENUM);
	   //중간에 문제가 발생돼서 매개변수를 전달 못받는경우
	   //intro_01.jsp
	   if(CONTROL.equals(null)){ //값을 전달받지 못했다면
		   CONTROL="intro";
	   }
	   
	   if(PAGENUM.equals(null)){ //값을 전달받지 못했다면
		   PAGENUM="01";
	   }
	   
   }catch(Exception e){
	   e.printStackTrace();
   }
%>
<jsp:forward page="/template/template.jsp">
   <jsp:param name="CONTROL"  value="<%=CONTROL%>" />
   <jsp:param name="PAGENUM"  value="<%=PAGENUM %>" />
</jsp:forward>

















