Vertx sample project with rx java and dagger2

mvn clean install


java -jar target/vertx_rxrest_dagger-1.0-SNAPSHOT-fat.jar 

curl --location --request GET 'http://localhost:8081/products' \
--header 'Content-Type: application/json'


{
"name": "John",
"id": 1211,
"gender": "male"
}