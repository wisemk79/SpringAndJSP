<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>입력을 받아서 처리</title>
</head>
<body>
<%
     //request.setCharacterEncoding("utf-8");//한글데이터
     //형식) String 변수명=request.getParameter("매개변수명")//행=>"2"->2
     String tr_cnt=request.getParameter("tr_cnt");//행
     String td_cnt=request.getParameter("td_cnt");//열
     System.out.println("tr_cnt=>"+tr_cnt+",td_cnt=>"+td_cnt);//디버깅

%>
<table border="1">
   <% for(int i=0;i<Integer.parseInt(tr_cnt);i++){ %>
       <tr>
           <% for(int j=0;j<Integer.parseInt(td_cnt);j++) { %>
               <td width="50">&nbsp;</td>
           <% } %>
       </tr>
  <% } %>
</table>
<!-- <a href="box.html">다시 입력하기</a>
      history.back() or history.go(-1) 전의 페이지로 이동하라
 -->
<a href="JavaScript:history.back()">다시 입력하기</a>
</body>
</html>















