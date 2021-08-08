To run vertx redis example please have following dependencies

        Java 11 installed

        Redis running

Pull the latest code and run below command to compile code

        mvn clean install

Make sure redis running in local machine


After code is compiled successfully, Run the application

        java -jar target/vertx_redis-1.0-SNAPSHOT-fat.jar

Application run in port : 8083

sample Http request to check :

        curl --location --request GET 'http://localhost:8083/books' \
        --header 'Content-Type: application/json'

Hurray! :):)



