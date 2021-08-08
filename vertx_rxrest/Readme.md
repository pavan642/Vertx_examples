
To run vertx rx rest/http api example please have following dependencies

        Java 11 installed


Pull the latest code and run below command to compile code

        mvn clean install


After code is compiled successfully, Run the application

        java -jar target/vertx_rxrest-1.0-SNAPSHOT-fat.jar

Application run in port : 8083

sample Http request to check :
      
      curl --location --request GET 'http://localhost:8083/products' \
      --header 'Content-Type: application/json'



Response : 

    {
      "id": "prod3568",
      "name": "Burger",
      "price": 3.99,
      "weight": 150
    }


Hurray! :):)
