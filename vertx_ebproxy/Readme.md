

To run vertx service proxy example please have following dependencies

        Java 11 installed


Pull the latest code and run below command to compile code

        mvn clean install


After code is compiled successfully, Run the application

        java -jar target/vertx_ebproxy-1.0-SNAPSHOT-fat.jar

Application run in port : 8083

sample Http request to check :

        curl --location --request GET 'http://localhost:8083/reviews' \
        --header 'Content-Type: application/json'

Hurray! :):)

