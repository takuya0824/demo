DROP table if exists users;
CREATE table users(
users_id int not null primary key,
email varchar(100),
password varchar(100));

DROP table if exists clothes;
CREATE table clothes(
clothes_id int not null primary key,
clothes_url varchar(100),
season varchar(100),
category varchar(100),
users_id int);