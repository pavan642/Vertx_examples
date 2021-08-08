Vertx sample project for junit


To run vertx example please have following dependencies

        Java 11 installed

Pull the latest code and run below command to compile code

        mvn clean install


After code is compiled successfully, Run the application

		java -jar target/vertx_junit-1.0-SNAPSHOT-fat.jar

Application run in port : 8081

sample Http request to check :

        curl --location --request GET 'http://localhost:8081/products' \
        --header 'Content-Type: application/json'


		Response:
		{
			"name": "John",
			"id": 1211,
			"gender": "male"
		}


To run test using command line, ref https://mkyong.com/maven/how-to-run-unit-test-with-maven/

mvn test


Hurray! :):)

