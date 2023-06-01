# 더미 데이터 입력
# oracle
insert into mvcboard (idx, name, title, content, pass)
    values (seq_board_num.nextval, '김유신', '자료실 제목1 입니다.','내용','1234');
insert into mvcboard (idx, name, title, content, pass)
    values (seq_board_num.nextval, '장보고', '자료실 제목2 입니다.','내용','1234');
insert into mvcboard (idx, name, title, content, pass)
    values (seq_board_num.nextval, '이순신', '자료실 제목3 입니다.','내용','1234');
insert into mvcboard (idx, name, title, content, pass)
    values (seq_board_num.nextval, '강감찬', '자료실 제목4 입니다.','내용','1234');
insert into mvcboard (idx, name, title, content, pass)
    values (seq_board_num.nextval, '대조영', '자료실 제목5 입니다.','내용','1234');

commit;

# --더미 데이터 입력
# Mysql
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