create sequence dept_seq start with 100 increment by 1;

create table dept (
    dept_id integer not null primary key,
    dept_name varchar(64),
    version integer not null
);

insert into dept values(1, '人事部', 0);
insert into dept values(2, '総務部', 0);
