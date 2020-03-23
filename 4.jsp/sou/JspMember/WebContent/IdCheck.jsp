<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import ="hewon.MemberDAO" %>
    
<%
   //Register.jsp(회원가입창)->script.js->idCheck()=>IdCheck.jsp?mem_id='kkk'
   String mem_id=request.getParameter("mem_id");
   System.out.println("IdCheck.jsp의 넘어온 매개변수(mem_id)=>"+mem_id);
   //MemberDAO->checkId()
   MemberDAO memMgr=new MemberDAO();
   boolean check=memMgr.checkId(mem_id);
   System.out.println("IdCheck.jsp의 check=>"+check);
%>
<!DOCTYPE html>
<html>
<body bgcolor="#FFFFCC">
<br>
<center>
  <b><%=mem_id %></b>
  <%
     if(check){ //이미 아이디가 존재하는 경우
    	 out.println("는 이미 존재하는 아이디입니다.<p>");
     }else{//id가 없다면 ->사용이 가능하다면
    	 out.println("는 사용가능한 아이디입니다.<p>");
     }
  %>
  <!-- 자바스크립트에서 자기 자신의창을 가리키는 예약어 self -->
  <a href="#" onclick="self.close()">닫기</a>
</center>
</body>
</html>



