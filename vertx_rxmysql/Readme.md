Vertx example rx java - mysql

create database reviews;

use reviews;

create table reviews(id int auto_increment primary key, customer_id int, review text);

create table customers(id int auto_icrement primary key, first_name varchar(100));

insert into customers (first_name) values('john');
insert into customers (first_name) values('ram');

insert into reviews (customer_id, review) values (1, "this is good");

insert into reviews (customer_id, review) values (1, "product is good");

insert into reviews (customer_id, review) values (2, "product is helpful");


To run application:

mvn clean install


java -jar target/vertx_rxrest_dagger-1.0-SNAPSHOT-fat.jar 

API and response : 

curl --location --request GET 'http://localhost:8083/reviews' \
--header 'Content-Type: application/json'

{
"id": 1,
"review": "this is good",
"customer_id": 1
}