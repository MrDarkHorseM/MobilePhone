CREATE SEQUENCE authorities_id_seq;
create table Authorities (
    id bigint not null DEFAULT NEXTVAL('authorities_id_seq'),
    user_id bigint DEFAULT NULL,

    primary key (id),
    CONSTRAINT fk_authority_user
    FOREIGN KEY (user_id)
    REFERENCES users (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);
ALTER SEQUENCE authorities_id_seq OWNED BY Authorities.id;