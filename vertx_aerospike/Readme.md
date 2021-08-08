To run vertx aerospike example please have following dependencies

        Java 11 installed

        Aerospike running

Pull the latest code and run below command to compile code

        mvn clean install

Make sure aerospike running in local machine with host and port as below.

        String host = "127.0.0.1";
        int port = 3000;

To change aerospike parameters, please change  file in Aerospikeservice.java.

After code is compiled successfully, Run the application

        java -jar target/vertx_aerospike-1.0-SNAPSHOT-fat.jar

Application run in port : 8083

sample Http request to check :

        curl --location --request GET 'http://localhost:8083/reviews' \
        --header 'Content-Type: application/json'

Hurray! :):)

