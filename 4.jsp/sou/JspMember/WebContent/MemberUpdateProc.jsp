<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="hewon.*" %>
 <%
    //MemberUpdate.jsp->MemberUpdateProc.jsp
    request.setCharacterEncoding("utf-8");//한글처리(회원가입,회원수정)
%>   
<jsp:useBean id="member"  class="hewon.MemberDTO" />
<jsp:setProperty name="member"  property="*" />  
<%
      //추가
      String mem_id=request.getParameter("mem_id");
      String mem_name=request.getParameter("mem_name");
      System.out.println("MemberUpdateProc.jsp의 mem_id=>"+mem_id);
      System.out.println("MemberUpdateProc.jsp의 mem_name=>"+mem_name);
      
      MemberDAO memMgr=new MemberDAO();//(1) 회원수정할 메서드 호출
      boolean check=memMgr.memberUpdate(member);
      System.out.println("MemberUpdateProc.jsp의 회원 수정 유무check=>"+check);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body bgcolor="#FFFFCC">
<br>
<center>
	<%
	    if(check){//회원수정에 성공했다면
	 %>
	    	<script>
	    	      alert("성공적으로 수정되었습니다.");
	    	      location.href="Login.jsp";//아직 로그아웃하지 않은 상태->회원수정링크 클릭
	    	</script>
	  <%  }else{  %>
	    	<script>
	    	   alert("수정도중 에러가 발생되었습니다.");
	    	   history.back();
	    	</script>
	<%  }%>
</center>
</body>
</html>




