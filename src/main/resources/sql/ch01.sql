create table author
(
    id    bigint       not null auto_increment primary key,
    age   int          null,
    genre varchar(255) null,
    name  varchar(255) null
);

create table book
(
    id        bigint       not null auto_increment primary key,
    author_id bigint       null,
    isbn      varchar(255) null,
    title     varchar(255) null
);

create table uni_author
(
    id    bigint       not null auto_increment primary key,
    age   int          null,
    genre varchar(255) null,
    name  varchar(255) null
);

create table uni_book
(
    id        bigint       not null auto_increment primary key,
    author_id bigint       null,
    isbn      varchar(255) null,
    title     varchar(255) null
);

create table many_author
(
    id    bigint       not null auto_increment primary key,
    age   int          null,
    genre varchar(255) null,
    name  varchar(255) null
);

create table many_book
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

create table one_author
(
    id    bigint       not null auto_increment primary key,
    age   int          null,
    genre varchar(255) null,
    name  varchar(255) null
);

create table one_book
(
    id        bigint       not null auto_increment primary key,
    author_id bigint       null,
    isbn      varchar(255) null,
    title     varchar(255) null
);

create table best_one_book
(
    author_id bigint       primary key,
    isbn      varchar(255) null,
    title     varchar(255) null
);
