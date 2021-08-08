To run vertx rx with dagger2 example please have following dependencies

        Java 11 installed


Pull the latest code and run below command to compile code

        mvn clean install


After code is compiled successfully, Run the application

        java -jar target/vertx_rxrest_dagger-1.0-SNAPSHOT-fat.jar 

Sample reqeust and response

	curl --location --request GET 'http://localhost:8081/products' \
	--header 'Content-Type: application/json'


	{
	"name": "John",
	"id": 1211,
	"gender": "male"
	}