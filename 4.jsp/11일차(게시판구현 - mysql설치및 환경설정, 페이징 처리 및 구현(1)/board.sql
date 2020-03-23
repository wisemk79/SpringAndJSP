/*******************************************************************************
 TABLE NAME   : mydb.board
 DATABASE     : mydb                     
*******************************************************************************/
use mydb;

DROP TABLE IF EXISTS  mydb.board ; -- 이미 mydb에 board테이블이 존재하면 삭제하라 



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
//
select count(*) from board; 