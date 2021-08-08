Vertx sample project for junit

mvn clean install

java -jar target/vertx_junit-1.0-SNAPSHOT-fat.jar

curl --location --request GET 'http://localhost:8081/products' \
--header 'Content-Type: application/json'

Response:
{
"name": "John",
"id": 1211,
"gender": "male"
}


To run test using command line 
# https://mkyong.com/maven/how-to-run-unit-test-with-maven/

mvn test