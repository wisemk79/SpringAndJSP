-- 한줄 주석
/*
   여러줄 주석 
    mysql DB->maria DB 
*/  

--1.DB생성  create database 생성할 DB명 

create database imsi2;

--2.DB삭제  drop database 삭제시킬 DB명;
drop database imsi2; 

create database mydb2;

--접속할때 use 접속할 DB 
use mydb2;

-- 

--3.테이블 생성->오라클과 형식이 거의 같다.(varchar,int,text)

create table sawon
( id int(5) not null ,/* 사번 필드명 자료형 제약조 */
  name varchar(13) not null, /* 이름 */
  dept varchar(14) not null); 
  
--4.테이블의 구조 (desc 테이블명)
desc sawon 

--5.필드를 추가
--alter table 수정t add column 필드명 자료형(=데이터형) 제약조건 
alter table sawon add column addr varchar(40);

--6.필드를 삭제
--alter table 수정t drop column 삭제할 필드명
alter table sawon drop column addr; 

--7.필드를 변경
--alter table 수정t modify colum 변경할 필드명 자료형 제약조건
--테이블에 데이터가 없다는 전제조건  
alter table sawon modify column dept varchar(30); 
 
--8.insert into 테이블명 values(?,?,?,,,); 

insert into sawon values(1,'홍길동','영업부'); 
insert into sawon values(2,'테스트','개발부'); 
insert into sawon values(3,'임시','관리부'); 
insert into sawon values(4,'임시2','총무부'); 
insert into sawon values(5,'테스트2','생산2부'); 
insert into sawon values(6,'임시3','개발2부'); 

-- 9.select
select * from sawon; 
select * from sawon where id=2 or dept='영업부'; 

--10.테이블의 이름을 변경=>rename table 원본t명 to 변경t명
rename table sawon to test;
rename table test to sawon;

--11.테이블의 백업
--create table 백업t명 as select * from 원본t명
create table b_sawon as select * from sawon;

--12.필드정렬-> order by 정렬할 필드명 정렬기준(asc or desc)
select * from sawon order by id desc; 

CREATE TABLE board (
  num int(11) NOT NULL AUTO_INCREMENT,
  writer varchar(10) NOT NULL,
  email varchar(30) DEFAULT NULL,
  subject varchar(50) NOT NULL,
  passwd varchar(12) NOT NULL,
  reg_date datetime NOT NULL,
  readcount int(11) DEFAULT '0',
  ref int(11) NOT NULL,
  re_step smallint(6) NOT NULL,
  re_level smallint(6) NOT NULL,
  content text NOT NULL,
  ip varchar(20) NOT NULL,
  PRIMARY KEY (num)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
desc board
 