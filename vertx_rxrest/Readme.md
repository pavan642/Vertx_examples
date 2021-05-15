TO run application first build

mvn clean install

To run application 
java -jar target/vertx_rxrest-1.0-SNAPSHOT-fat.jar


curl --location --request GET 'http://localhost:8083/products' \
--header 'Content-Type: application/json'


Response : 

{
  "id": "prod3568",
  "name": "Burger",
  "price": 3.99,
  "weight": 150
}