<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 태그라이브러리로 타일즈 사용을 선언 -->
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>제목</title>
    <style>
        #header{            
            width:100%;
            height:50px;
            text-align: center;
            background-color: aqua;
        }
        #left{
            float:left;
             width:15%;
            background-color: gray;
        }
        #main{
            float:left;
             width:85%;
            background-color: lime;
        }
        #footer{
            width: 100%;
            height: 50px;            
            text-align: center;
            background-color: orange;
            clear:both;
        }
         #left, #main{ 
               min-height: 600px;
         } 
    </style>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>
<!-- 헤더 푸터 메인 등 레이아웃을 구성하는 템플릿 역할을 한다. -->
    <div style="width:100%; height:100%;">
    <div id="header"><tiles:insertAttribute name="header" /></div>
    <div id="left"><tiles:insertAttribute name="left" /></div>
    <div id="main"><tiles:insertAttribute name="body" /></div>    
    <div id="footer"><tiles:insertAttribute name="footer" /></div>
    </div>
 
    <script type="text/javascript">
        $(function() {
 
        });    
    </script>    
</body>
</html>