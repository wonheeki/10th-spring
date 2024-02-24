use kdt;
-- 미리 테이블을 만들어놔야 함
create table user(
    id bigint not null auto_increment primary key,
    name varchar(255) not null,
    nickname varchar(255) not null,
)

select * from user;