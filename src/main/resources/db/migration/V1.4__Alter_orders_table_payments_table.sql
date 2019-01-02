ALTER TABLE orders DROP order_date;
ALTER table orders add order_date timestamp;
ALTER Table payments DROP paid_date;
Alter table payments add paid_date timestamp;

