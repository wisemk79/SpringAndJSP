 insert into board 
values(1,'이연수','nup49rok1@empal.com','[공지사항]게시판사용법', 
'1234','2006-12-26 17:23',3,0,0,0,'게시판 테스트','127.0.0.1'); 

 insert into board values(2,'홍길동','hong@empal.com','답변게시판사용법', 
'1111','2006-12-26 17:23',1,0,1,1,'게시판 테스트2','127.0.0.1'); 

insert into board values(3,'이미자','lee@empal.com','답변의답변게시판', 
'1111','2006-12-26 17:23',1,0,2,1,'게시판 테스트3','127.0.0.1'); 

insert into board values(4,'고길동','Go@empal.com','또 다른게시판 
테스트', '1111','2006-12-26 17:23',1,1,0,0,'답변형게시판 
완성','127.0.0.1'); 
select * from board;
select max(num) from board