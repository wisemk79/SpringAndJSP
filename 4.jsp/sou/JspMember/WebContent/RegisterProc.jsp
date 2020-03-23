<%@ page contentType="text/html;charset=UTF-8"
         import="hewon.*" %>
<%
    //Register.jsp->RegisterProc.jsp
    request.setCharacterEncoding("utf-8");//한글처리
    /* (1) 순수 자바코드로 구현한 경우
    MemberDTO member=new MemberDTO();
    member.setMem_id(request.getParameter("mem_id"));//("kkk");
    member.setMem_passwd(request.getParameter("mem_passwd");
    ,,,
    */
%>   
<jsp:useBean id="member"  class="hewon.MemberDTO" />
<jsp:setProperty name="member"  property="*" />
         
<html>
<head>
<title>회원가입 확인</title>
<link href="style.css" rel="stylesheet" type="text/css">
<script language="JavaScript" src="script.js"></script>
</head>
<body bgcolor="#996600">
<br><br>
<table align="center" border="0" cellspacing="0" cellpadding="5" >
  <tr> 
    <td align="center" valign="middle" bgcolor="#FFFFCC"> 
      <table border="1" cellspacing="0" cellpadding="2"  align="center">
        <form name="regForm" method="post" action="MemberInsert.jsp">
          <tr align="center" bgcolor="#996600"> 
            <td colspan="3"><font color="#FFFFFF"><b>
            <!-- member.getMem_name() -->
               <jsp:getProperty name="member" property="mem_name" />님이 작성하신 내용입니다. 확인해주세요.
          </b></font></td>
          </tr>
          <tr> 
            <td width="16%">아이디</td>
            <td width="57%"> 
            <input type="text" name="mem_id" size="15" 
                      value="<jsp:getProperty name="member" property="mem_id" />" >
		   </td>
          </tr>
          <tr> 
            <td>패스워드</td>
            <td> <input type="password" name="mem_passwd" size="15"
                     value="<jsp:getProperty name="member" property="mem_passwd" />"> 
           </td>
          </tr>
          
          <tr> 
            <td>이름</td>
            <td> <input type="text" name="mem_name" size="15" 
                     value="<jsp:getProperty name="member" property="mem_name" />"> </td>
          </tr>
          
          <tr> 
            <td>이메일</td>
            <td> <input type="text" name="mem_email" size="27" 
                     value="<jsp:getProperty name="member" property="mem_email" />">
            </td>
          </tr>
          
          <tr>  
            <td>전화번호</td>
            <td> <input type="text" name="mem_phone" size="20" 
                    value="<jsp:getProperty name="member" property="mem_phone" />"> </td>
            
          </tr>
          
		  <tr>  
            <td>우편번호</td>
            <td> <input type="text" name="mem_zipcode" size="7" 
                   value="<jsp:getProperty name="member" property="mem_zipcode" />">
                 <input type="button" value="우편번호찾기" onClick="zipCheck()"></td>
            
          </tr>
          
		  <tr>  
            <td>주소</td>
            <td><input type="text" name="mem_address" size="70"
                   value="<jsp:getProperty name="member" property="mem_address" />"></td>
          
          </tr>
		  <tr>  
            <td>직업</td>
            <td><input type="text" name="mem_job" size="70"
                   value="<jsp:getProperty name="member" property="mem_job" />"></td>
          </tr>
          
          <tr> 
            <td colspan="3" align="center"> 
             <input type="submit" value="확인완료"> 
              &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 
             <input type="button" value="다시쓰기" onclick="history.back()"> 
            </td>
          </tr>
        </form>
      </table>
    </td>
  </tr>
</table>
</body>
</html>
