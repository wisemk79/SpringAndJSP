-- ���� �ּ� 
/*
   ������ �ּ� 
*/ 

--1.DB����  create database ������ db��;

create database imsi;

--2.DB����  drop database ������ų db��;
drop database imsi;

create database mydb;

use mydb;

--3 ���̺� ����->����Ŭ�� ������ ����(�ڷ����� Ʋ������ �ִ�)
-- number,varchar2
create table sawon
( id int(5) not null, /* ��� */
  name varchar(13) not null,/*�̸� */
  dept varchar(14) not null); 

--4. ���̺��� ������ Ȯ�� desc ���̺�� 

desc sawon; 

--5.�ʵ� �߰�
-- alter table ����t add column �ʵ�� ��������

alter table sawon add column addr varchar(40);

--6.�ʵ带 ����
--alter table ����t drop column ������ �ʵ��
alter table sawon drop column addr; 

--7.�ʵ带 ����
--alter table ����t modify column ������ �ʵ�� �ڷ���
alter table sawon modify column dept varchar(30); 

--8.�����͸� �Է�
insert into sawon values(1,'ȫ�浿','������'); 
insert into sawon values(2,'�׽�Ʈ','���ߺ�');
insert into sawon values(3,'�ӽ�','������');
insert into sawon values(4,'�ӽ�2','�ѹ���');
insert into sawon values(5,'�׽�Ʈ2','����2��');

--9.select
select * from sawon where id=2 or dept='������'; 

--10.���̺��� �̸��� ����=>rename table ����t to ����t��
rename table sawon to test; 
rename table test to sawon; 

--11.���̺��� ���
-- create table ���t as select * from ����t 

create table b_sawon as select * from sawon;

--12.�ʵ� ����-> order by ������ �ʵ�� ���ı���(asc or desc) 
select * from sawon order by id desc; 

--**13.�ʵ�� ����**
--alter table ����t change �����ʵ�� ���ο� �ʵ�� �ڷ���

alter table b_sawon change dept deptment varchar(20);

desc b_sawon


 



