use musthave;

drop table mvcboard;

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

# --더미 데이터 입력
insert into mvcboard (name, title, content, pass)
    values ('김유신', '자료실 제목1 입니다.','내용','1234');
insert into mvcboard (name, title, content, pass)
    values ('장보고', '자료실 제목2 입니다.','내용','1234');
insert into mvcboard (name, title, content, pass)
    values ('이순신', '자료실 제목3 입니다.','내용','1234');
insert into mvcboard (name, title, content, pass)
    values ('강감찬', '자료실 제목4 입니다.','내용','1234');
insert into mvcboard (name, title, content, pass)
    values ('대조영', '자료실 제목5 입니다.','내용','1234');

insert into mvcboard (name, title, content, pass)
    values ('김유신', '자료실 제목6 입니다.','내용','1234');
insert into mvcboard (name, title, content, pass)
    values ('장보고', '자료실 제목7 입니다.','내용','1234');
insert into mvcboard (name, title, content, pass)
    values ('이순신', '자료실 제목8 입니다.','내용','1234');
insert into mvcboard (name, title, content, pass)
    values ('강감찬', '자료실 제목9 입니다.','내용','1234');
insert into mvcboard (name, title, content, pass)
    values ('대조영', '자료실 제목10 입니다.','내용','1234');
    
insert into mvcboard (name, title, content, pass)
    values ('김유신', '자료실 제목11 입니다.','내용','1234');
insert into mvcboard (name, title, content, pass)
    values ('장보고', '자료실 제목12 입니다.','내용','1234');
insert into mvcboard (name, title, content, pass)
    values ('이순신', '자료실 제목13 입니다.','내용','1234');
insert into mvcboard (name, title, content, pass)
    values ('강감찬', '자료실 제목14 입니다.','내용','1234');
insert into mvcboard (name, title, content, pass)
    values ('대조영', '자료실 제목15 입니다.','내용','1234');

insert into mvcboard (name, title, content, pass)
    values ('김유신', '자료실 제목16 입니다.','내용','1234');
insert into mvcboard (name, title, content, pass)
    values ('장보고', '자료실 제목17 입니다.','내용','1234');
insert into mvcboard (name, title, content, pass)
    values ('이순신', '자료실 제목18 입니다.','내용','1234');
insert into mvcboard (name, title, content, pass)
    values ('강감찬', '자료실 제목19 입니다.','내용','1234');
insert into mvcboard (name, title, content, pass)
    values ('대조영', '자료실 제목20 입니다.','내용','1234');

