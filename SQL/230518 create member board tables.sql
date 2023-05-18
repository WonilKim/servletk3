use musthave;

create table member (
	id varchar(10) not null,
    pass varchar(10) not null,
    name varchar(30) not null,
    regidate timestamp not null default current_timestamp,
    primary key (id)
    
);

create table board (
	num int not null auto_increment,
	title varchar(200) not null,
    content varchar(2000) not null,
    id varchar(10) not null,
    postdate timestamp default current_timestamp not null,
    visitcount decimal(6) default 0,
    primary key (num)
    
);

Insert into member (id, pass, name) values ("musthave", "1234", "머스트해브");
Insert into member (id, pass, name) values ("willhave", "1234", "윌해브");
Insert into member (id, pass, name) values ("dohave", "1234", "두해브");

Insert into board (title,content,id) values ("제목1입니다.", "내용1입니다.","musthave");
Insert into board (title,content,id) values ("제목2입니다.", "내용2입니다.","musthave");
Insert into board (title,content,id) values ("제목3입니다.", "내용3입니다.","musthave");
Insert into board (title,content,id) values ("제목4입니다.", "내용4입니다.","musthave");
Insert into board (title,content,id) values ("제목11입니다.", "내용11입니다.","willhave");
Insert into board (title,content,id) values ("제목12입니다.", "내용12입니다.","willhave");
Insert into board (title,content,id) values ("제목11입니다.", "내용11입니다.","dohave");
Insert into board (title,content,id) values ("제목21입니다.", "내용21입니다.","dohave");
Insert into board (title,content,id) values ("제목22입니다.", "내용22입니다.","dohave");

