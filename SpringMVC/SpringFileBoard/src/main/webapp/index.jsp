<%
  //실행->레코드가 없어서 에러페이지가 나오는지 확인
  response.sendRedirect(request.getContextPath()+"/board/list.do");
%>
