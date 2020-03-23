-- ���� �ּ�
/*
   ������ �ּ� 
    mysql DB->maria DB 
*/  

--1.DB����  create database ������ DB�� 

create database imsi2;

--2.DB����  drop database ������ų DB��;
drop database imsi2; 

create database mydb2;

--�����Ҷ� use ������ DB 
use mydb2;

-- 

--3.���̺� ����->����Ŭ�� ������ ���� ����.(varchar,int,text)

create table sawon
( id int(5) not null ,/* ��� �ʵ�� �ڷ��� ������ */
  name varchar(13) not null, /* �̸� */
  dept varchar(14) not null); 
  
--4.���̺��� ���� (desc ���̺��)
desc sawon 

--5.�ʵ带 �߰�
--alter table ����t add column �ʵ�� �ڷ���(=��������) �������� 
alter table sawon add column addr varchar(40);

--6.�ʵ带 ����
--alter table ����t drop column ������ �ʵ��
alter table sawon drop column addr; 

--7.�ʵ带 ����
--alter table ����t modify colum ������ �ʵ�� �ڷ��� ��������
--���̺� �����Ͱ� ���ٴ� ��������  
alter table sawon modify column dept varchar(30); 
 
--8.insert into ���̺�� values(?,?,?,,,); 

insert into sawon values(1,'ȫ�浿','������'); 
insert into sawon values(2,'�׽�Ʈ','���ߺ�'); 
insert into sawon values(3,'�ӽ�','������'); 
insert into sawon values(4,'�ӽ�2','�ѹ���'); 
insert into sawon values(5,'�׽�Ʈ2','����2��'); 
insert into sawon values(6,'�ӽ�3','����2��'); 

-- 9.select
select * from sawon; 
select * from sawon where id=2 or dept='������'; 

--10.���̺��� �̸��� ����=>rename table ����t�� to ����t��
rename table sawon to test;
rename table test to sawon;

--11.���̺��� ���
--create table ���t�� as select * from ����t��
create table b_sawon as select * from sawon;

--12.�ʵ�����-> order by ������ �ʵ�� ���ı���(asc or desc)
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
 