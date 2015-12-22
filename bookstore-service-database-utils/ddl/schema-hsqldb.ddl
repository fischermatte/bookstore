create table Book (id binary(255) not null, AUHTOR_FIRSTNAME varchar(255), AUTHOR_LASTNAME varchar(255), isbn varchar(255) not null, title varchar(255) not null, primary key (id))
alter table Book add constraint BOOK_UNIQUE_ISBN unique (isbn)
