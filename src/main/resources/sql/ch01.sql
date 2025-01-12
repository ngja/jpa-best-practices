create table unidirectionalAuthor
(
    id    bigint       not null auto_increment primary key,
    age   int          null,
    genre varchar(255) null,
    name  varchar(255) null
);

create table unidirectionalBook
(
    id        bigint       not null auto_increment primary key,
    author_id bigint       null,
    isbn      varchar(255) null,
    title     varchar(255) null
);


create table author_book
(
    id        bigint not null auto_increment primary key,
    author_id bigint null,
    book_id   bigint null
);