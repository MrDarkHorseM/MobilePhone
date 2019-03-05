CREATE SEQUENCE images_id_seq;
create table images (
  id bigint not null DEFAULT NEXTVAL('images_id_seq'),
  title varchar(255) NOT NULL ,
  url varchar(255) NOT NULL,
  uuid varchar(255) NOT NULL,

  primary key (id)

);
ALTER SEQUENCE images_id_seq OWNED BY images.id;