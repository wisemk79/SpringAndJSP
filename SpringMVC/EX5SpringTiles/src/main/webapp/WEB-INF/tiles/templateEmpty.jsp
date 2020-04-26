<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
    <meta charset="UTF-8">
    <title>제목</title>
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>
<!-- ※ header, left, footer가 없는 단일 페이지 레이아웃이다 -->
    <div id="main"><tiles:insertAttribute name="body" /></div>
        
    <script type="text/javascript">
        $(function() {
                  
        });    
    </script>    
</body>
</html>