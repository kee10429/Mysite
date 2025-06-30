/************************************************
web 계정에서 사용 - user
************************************************/

-- web_db 사용
use web_db;

-- 테이블 목록 조회
show tables;



create table users(
	no 			int 		  primary key 	auto_increment,
    id 			varchar(20)   unique 			not null,
    password 	varchar(20)   not null, 
    name 		varchar(20),
    gender 		varchar(10)   -- male , female
);

-- 회원추가
insert into users
value(null, 'aaa', '123', '정우성', 'male')
;

-- 로그인 (세션)
select  no,
		id,
        password,
        name,
        gender
from users
where id = 'aaa'
and password = '1234'
;

-- 회원정보 수정폼
select  no,
		id,
        password,
        name,
        gender
from users
where no = 1
;

select  no,
		id,
        password,
        name,
        gender
from users
;

-- 회원정보수정
update users
set name = '이효리',
	password = 'abc',
    gender = 'female'
where no = 1
;
    


