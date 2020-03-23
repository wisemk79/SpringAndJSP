<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="lys.board.*,java.text.SimpleDateFormat"%>
<!DOCTYPE html>
<html>
<head>
<title>내용확인</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<%
   //list.jsp에서 링크 content.jsp?num=3&pageNum=1
   int num=Integer.parseInt(request.getParameter("num"));
   String pageNum=request.getParameter("pageNum");
   SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm");
   BoardDAO dbPro=new BoardDAO();
   BoardDTO article=dbPro.getArticle(num);//메서드의 매개변수자료형이 int
   //링크문자열의 길이를 줄이기 위해서,전달해주기 전의 값 확인
   int ref=article.getRef();
   int re_step=article.getRe_step();
   int re_level=article.getRe_level();
   System.out.println("content.jsp의 매개변수");
   System.out.println("ref=>"+ref+",re_step=>"+re_step+",re_level=>"+re_level);
%>
<body bgcolor="#e0ffff">  
<center><b>글내용 보기</b>
<br>
<form>
<table width="500" border="1" cellspacing="0" cellpadding="0"  bgcolor="#e0ffff" align="center">  
  <tr height="30">
    <td align="center" width="125" bgcolor="#b0e0e6">글번호</td>
    <td align="center" width="125" align="center">
	     <%=article.getNum() %></td>
    <td align="center" width="125" bgcolor="#b0e0e6">조회수</td>
    <td align="center" width="125" align="center">
	     <%=article.getReadcount() %></td>
  </tr>
  <tr height="30">
    <td align="center" width="125" bgcolor="#b0e0e6">작성자</td>
    <td align="center" width="125" align="center">
	     <%=article.getWriter() %></td>
    <td align="center" width="125" bgcolor="#b0e0e6" >작성일</td>
    <td align="center" width="125" align="center">
	     <%=sdf.format(article.getReg_date()) %></td>
  </tr>
  <tr height="30">
    <td align="center" width="125" bgcolor="#b0e0e6">글제목</td>
    <td align="center" width="375" align="center" colspan="3">
	     <%=article.getSubject() %></td>
  </tr>
  <tr>
    <td align="center" width="125" bgcolor="#b0e0e6">글내용</td>
    <td align="left" width="375" colspan="3"><pre><%=article.getContent() %></pre></td>
  </tr>
  <tr height="30">   
  <!--onclick="document.location.href=요청페이지.jsp?매개변수=값&매개변수2=값2"  -->   
    <td colspan="4" bgcolor="#b0e0e6" align="right" > 
	  <input type="button" value="글수정" 
       onclick="document.location.href='updateForm.jsp?num=<%=article.getNum()%>&pageNum=<%=pageNum%>'">
	   &nbsp;&nbsp;&nbsp;&nbsp;
	  <input type="button" value="글삭제" 
       onclick="document.location.href='deleteForm.jsp?num=<%=article.getNum()%>&pageNum=<%=pageNum%>'">
	   &nbsp;&nbsp;&nbsp;&nbsp;
      <input type="button" value="답글쓰기" 
       onclick="document.location.href='writeForm.jsp?num=<%=num%>&ref=<%=ref%>&re_step=<%=re_step%>&re_level=<%=re_level%>'">
	   &nbsp;&nbsp;&nbsp;&nbsp;
       <input type="button" value="글목록" 
       onclick="document.location.href='list.jsp?pageNum=<%=pageNum%>'">
    </td>
  </tr>
</table>    
</form>      
</body>
</html>      
