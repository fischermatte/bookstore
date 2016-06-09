create table book (
  id binary(255) not null,
  first_name varchar(255),
  last_name varchar(255),
  isbn varchar(255) not null,
  title varchar(255) not null,
  primary key (id));

alter table book add constraint BOOK_UNIQUE_ISBN unique (isbn);
