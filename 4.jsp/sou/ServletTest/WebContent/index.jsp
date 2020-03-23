<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인창을 실행</title>
<script>
   function test(){
	   //형식) window.open(1.불러올 파일명 2.문서의 타이틀제목 3.창의 옵션(width,height,left,top))
	   //window.open('./sub/send.html','w','left=500,top=300,width=400,height=300')
	   window.open('/ServletTest/Notice','w','left=300,top=200,width=400,height=300')
   }
</script>
</head>
<body onload="test()">
  <h2>Welcome To JspStudy Site!!!</h2>
</body>
</html>