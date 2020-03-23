<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="lys.board.*,java.util.*,java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<%!
      int pageSize=10;//numPerPage(페이지당 보여주는 게시물수(=레코드수))
      int blockSize=3;//pagePerBlock(블럭당 보여주는 페이지수)
      SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
%>
<%
   //페이징 처리에 해당하는 환경설정을 다 코딩->게시판은 처음 실행시키면 ->무조건 1페이지부터 출력
   String pageNum=request.getParameter("pageNum");
   if(pageNum==null){
	   pageNum="1";//default(무조건 1페이지는 선택하지 않아도 보여줘야 되기때문에)
   }
   //화면에 계산해서 페이지를 출력시키기위해서 정수가 되야하기때문에 
   int currentPage=Integer.parseInt(pageNum);//현재페이지->nowPage
   //limit ?,?      (1-1)*10+1=1,(2-1)*10+1=11,(3-1)*10+1=21
   int startRow=(currentPage-1)*pageSize+1;//시작 레코드번호
   int endRow=currentPage*pageSize;//1*10=10,2*1=20,30
   int count=0;//총레코드수 
   int number=0;//beginPerPage;(페이지별로 시작하는 맨 처음에 나오는 게시물번호)
   List articleList=null;//화면에 출력할 레코드를 저장할 변수
   BoardDAO dbPro=new BoardDAO();
   count=dbPro.getArticleCount();//select count(*) from board=>getMemberList()
   System.out.println("현재 레코드수(count)=>"+count);
   
   if(count > 0){                       //startRow,endRow(X)=>pageSize(O)
	   articleList=dbPro.getArticles(startRow, pageSize);//첫번째 레코드번호, 끊어서보여줄갯수
   }
   //            122-(1-1)*10=>122,121,120,,,
   //            122-(2-1)*10=>122-10=>112,111,110,,,
   number=count-(currentPage-1)*pageSize;
   System.out.println("페이지별 number=>"+number);
%>
<html>
<head>
<title>게시판</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body bgcolor="#e0ffff">
<center><b>글목록(전체 글:<%=count%>)</b>
<table width="700">
<tr>
    <td align="right" bgcolor="#b0e0e6">
    <a href="writeForm.jsp">글쓰기</a>
    </td>
</tr>
</table>
<!-- 데이터의 유무 -->
<%
 if(count==0){
%>
<table border="1" width="700" cellpadding="0" cellspacing="0" align="center">
   <tr>
      <td align="center">게시판에 저장된 글이 없습니다.</td>
   </tr>
</table>
<%}else {%>
<table border="1" width="700" cellpadding="0" cellspacing="0" align="center"> 
    <tr height="30" bgcolor="#b0e0e6"> 
      <td align="center"  width="50"  >번 호</td> 
      <td align="center"  width="250" >제   목</td> 
      <td align="center"  width="100" >작성자</td>
      <td align="center"  width="150" >작성일</td> 
      <td align="center"  width="50" >조 회</td> 
      <td align="center"  width="100" >IP</td>    
    </tr>
     <!-- 실질적으로 레코드를 출력시켜주는 부분 -->
     <%
         for(int i=0;i<articleList.size();i++){
            BoardDTO article=(BoardDTO)articleList.get(i);//vecList.elementAt(i)
     %>
    
   <tr height="30"><!--하나씩 감소하면서 출력하는 게시물번호  -->
    <td align="center"  width="50" ><%=number--%></td>
    <td  width="250" >
	  <!-- 답벼글인 경우 먼저 답변이미지를 부착시켜주는 코드부분 -->
	  <%
	       int wid=0;//공백을 계산하기위한 변수선언
	       if(article.getRe_level() > 0){ //답변글이라면 1
	    	   wid=7*(article.getRe_level());//7,14,21,,,
	  %>  
	  <img src="images/level.gif" width="<%=wid%>" height="16">
	  <img src="images/re.gif">
	  <% }else { %>
	  <img src="images/level.gif" width="<%=wid%>" height="16"> 
	  <%}  %>         
	  <!-- 글상세보기 num(게시물번호),pageNum(페이지번호)-->
      <a href="content.jsp?num=<%=article.getNum()%>&pageNum=<%=currentPage%>">
            <%=article.getSubject() %></a>
        <% if(article.getReadcount() >=20) {%> 
         <img src="images/hot.gif" border="0"  height="16"> 
        <% } %>
         </td>
    <td align="center"  width="100"> 
       <a href="mailto:<%=article.getEmail()%>"><%=article.getWriter() %></a></td>
    <td align="center"  width="150"><%=sdf.format(article.getReg_date()) %></td>
    <td align="center"  width="50"><%=article.getReadcount() %></td>
    <td align="center" width="100" ><%=article.getIp() %></td>
  </tr>
     <%   } //for %>
</table>
<% }//else %>
<%
    //페이징 처리
    if(count > 0){ //레코드가 한개 이상이라면
    	//1.총페이지 수 구하기
    	//                       122/10=12.2+122%10(1)=>12.2+1.0=13.2=13페이지
    	int pageCount=count/pageSize+(count%pageSize==0?0:1);
    	//2.시작페이지 ->블럭당 페이지수 계산->10(10의 배수,3->3의 배수,6->6의 배수)
    	int startPage=0;
    	if(currentPage%blockSize!=0){//1~9,11~19,21~29(1,2,4,5,7,8)
    		startPage=currentPage/blockSize*blockSize+1;
    	}else{ //10%10 (10,20,30,40~) (3%3)=>딱 떨어지는 경우
    		//               ((10/10)-1)*10+1=1
    		startPage=((currentPage/blockSize)-1)*blockSize+1;
    	}
    	int endPage=startPage+blockSize-1;//1+10-1=10
    	System.out.println("startPage="+startPage+",endPage=>"+endPage);
    	//블럭별로 구분해서 링크걸어서 출력
    	if(endPage >pageCount) endPage=pageCount;//마지막페이지=총페이지수
    	//1)이전블럭-> 11>10,4>3
    	if(startPage>blockSize){ %>
      <a href="list.jsp?pageNum=<%=startPage-blockSize %>">
        [이전]
      </a>
    	<% }
    	//2)현재블럭(1,2,[3]~10,11~)
    	for(int i=startPage;i<=endPage;i++) { %>
      <a href="list.jsp?pageNum=<%=i%>">[<%=i%>]</a>
    <% } 
    	//3)다음블럭
    	if(endPage < pageCount) {%>
      <a href="list.jsp?pageNum=<%=startPage+blockSize %>">
        [다음]
      </a>
    <% 	
    	} //다음블럭의 if
    }//if(count > 0)
%>
</center>
</body>
</html>






