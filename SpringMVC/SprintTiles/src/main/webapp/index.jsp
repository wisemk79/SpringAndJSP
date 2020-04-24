<%
  //request.getContextPath()=>웹프로젝트명을 얻어온다.+요청명령어만 추가
  //                                         ~/SpringTiles/index.do
  response.sendRedirect(request.getContextPath()+"/index.do");
  System.out.println("request.getContextPath()=>"+request.getContextPath());
%>
