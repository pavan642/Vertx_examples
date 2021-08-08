To run vertx mysql example please have following dependencies

        Java 11 installed
        Mysql 

Databse set up : 

	create database reviews;
	use reviews;
	create table reviews(id int auto_increment primary key, customer_id int, review text);
	create table customers(id int auto_icrement primary key, first_name varchar(100));
	insert into customers (first_name) values('john');
	insert into customers (first_name) values('ram');
	insert into reviews (customer_id, review) values (1, "this is good");
	insert into reviews (customer_id, review) values (1, "product is good");
	insert into reviews (customer_id, review) values (2, "product is helpful");

Pull the latest code and run below command to compile code

        mvn clean install


After code is compiled successfully, Run the application

        java -jar target/vertx_rxmysql-1.0-SNAPSHOT-fat.jar

Application run in port : 8083

Sample Http request

        curl --location --request GET 'http://localhost:8083/reviews' \
		--header 'Content-Type: application/json'


	{
		"id": 1,
		"review": "this is good",
		"customer_id": 1
	}


Hurray! :):)
