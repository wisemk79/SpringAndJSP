
use mydb;

create table member(     
 id varchar(20) primary key,
 passwd varchar(20) not null,
 name   varchar(20) not null,
 e_mail varchar(20) ,
 phone varchar(30)  not null,
 zipcode varchar(10) ,
 address varchar(60) not null,
 job  varchar(30)
 );

 insert into member values('nup','1234','홍길동',
        'test@daum.net','02-123-0987','132-098',
        '서울시 강남구 대현빌딩 3층','프로그래머');
        
 select * from member;
