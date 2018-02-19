create sequence member_seq start with 100 increment by 1;

create table member (
    member_id integer not null primary key,
    family_name varchar(64) not null,
    last_name varchar(64) not null,
    version integer not null
);

insert into member values(1, '山田', '太郎', 0);
insert into member values(2, '田中', '次郎', 0);
