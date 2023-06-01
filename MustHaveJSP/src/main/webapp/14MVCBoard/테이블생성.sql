--모델2 방식의 파일첨부형 게시판 테이블 생성
# oracle
create table mvcboard (
	idx number primary key, 
	name varchar2(50) not null, 
	title varchar2(200) not null, 
	content varchar2(2000) not null, 
	postdate date default sysdate not null, 
	ofile varchar2(200), 
	sfile varchar2(30), 
	downcount number(5) default 0 not null, 
	pass varchar2(50) not null, 
	visitcount number default 0 not null
);

# Mysql
create table mvcboard (
	idx int primary key auto_increment, 
	name varchar(50) not null, 
	title varchar(200) not null, 
	content varchar(2000) not null, 
    postdate timestamp default current_timestamp not null,
	ofile varchar(200), 
	sfile varchar(30), 
	downcount int default 0 not null, 
	pass varchar(50) not null, 
	visitcount int default 0 not null
);