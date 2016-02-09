create table book (id binary(255) not null, auhtor_firstname varchar(255), author_lastname varchar(255), isbn varchar(255) not null, title varchar(255) not null, primary key (id))
create table stock (id binary(255) not null, book_id binary(255) not null, quantity integer not null, primary key (id))
alter table book add constraint BOOK_UNIQUE_ISBN unique (isbn)
