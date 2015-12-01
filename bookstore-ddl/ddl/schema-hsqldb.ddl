create table Author (id binary(255) not null, firstName varchar(255), lastName varchar(255), primary key (id))
create table Book (id binary(255) not null, isbn varchar(255), title varchar(255), author_id binary(255), primary key (id))
alter table Book add constraint FK_AUTHOR foreign key (author_id) references Author
