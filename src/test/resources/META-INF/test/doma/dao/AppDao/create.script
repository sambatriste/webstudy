create sequence member_seq start with 100 increment by 1;
create sequence dept_seq start with 100 increment by 1;

create table dept (
    dept_id integer not null primary key,
    dept_name varchar(64),
    version integer not null
);

create table member (
    member_id integer not null primary key,
    family_name varchar(64) not null,
    last_name varchar(64) not null,
    dept_id integer not null,
    FOREIGN KEY (dept_id) REFERENCES dept(dept_id),
    version integer not null
);

insert into dept values(1, '人事部', 0);
insert into member values(1, '山田', '太郎', 1, 0);
insert into member values(2, '田中', '次郎', 1, 0);
