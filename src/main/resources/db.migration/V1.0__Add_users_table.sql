CREATE SEQUENCE users_id_seq;
create table Users (
    id bigint not null DEFAULT NEXTVAL('users_id_seq'),
    email varchar(255) not NULL UNIQUE,
    username varchar(255) not NULL UNIQUE,
    first_name varchar(255),
    last_name varchar(255),
    password varchar(255) not NULL,

    primary key (id)
);
ALTER SEQUENCE users_id_seq OWNED BY Users.id;