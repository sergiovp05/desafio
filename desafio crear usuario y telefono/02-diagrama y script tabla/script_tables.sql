create table phone (id bigint generated by default as identity,
 phone_city_code varchar(20) not null,
 phone_contry_code varchar(20) not null,
 phone_number varchar(9) not null,
 phone_user_id binary, primary key (id))
 
create table user_test (
user_id binary not null, 
usr_created timestamp not null,
 user_email varchar(30),
 usr_isactive boolean not null,
 usr_last_login timestamp not null,
 usr_modified timestamp,
 user_name varchar(30) not null,
 user_password varchar(100) not null,
 usr_token varchar(255) not null,
 primary key (user_id))

alter table user_test add constraint UK_7lwnpuif5vs76rw9k92qn8hcv unique (user_email)
alter table phone add constraint FKgebshcxbem53nv336d88khe6k foreign key (phone_user_id) references user_test