use musthave;

create table member2 (
	id int auto_increment,
    pass varchar(10) not null,
    name varchar(30) not null,
    regidate date default current_timestamp not null,
    primary key (id)
    
);

Insert into member (pass, name) values ("pass1", "name1");
Insert into member (pass, name) values ("pass2", "name2");
Insert into member (pass, name) values ("pass3", "name3");
Insert into member (pass, name) values ("pass4", "name4");
Insert into member (pass, name) values ("pass5", "name5");


