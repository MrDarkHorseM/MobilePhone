CREATE SEQUENCE payments_id_seq;
create table payments (
  id bigint not null DEFAULT NEXTVAL('payments_id_seq'),
  paid_date timestamp NOT NULL,
  payment_method varchar(255) NOT NULL,
  payment_total numeric (10,2) NOT NULL,
  order_id bigint DEFAULT NULL,

  primary key (id),
  CONSTRAINT fk_order_user
  FOREIGN KEY (order_id)
  REFERENCES orders (id)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION
);
ALTER SEQUENCE payments_id_seq OWNED BY payments.id;