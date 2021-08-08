



To run vertx kafka example please have following dependencies

        Java 11 installed

        Kafka installed


Pull the latest code and run below command to compile code

        mvn clean install


After code is compiled successfully, Run the application

        java -jar target/vertx_rxkafka-1.0-SNAPSHOT-fat.jar

Example run consumer for kafka

Post this use vertx_rxkafka_producer example to get message from producer


	Output:

		log4j:WARN No appenders could be found for logger (io.netty.util.internal.logging.InternalLoggerFactory).
		log4j:WARN Please initialize the log4j system properly.
		log4j:WARN See http://logging.apache.org/log4j/1.2/faq.html#noconfig for more info.
		start producer...
		start consumer...
		start consumer...
		start init...
		send data to topic
		consumer started....
		May 24, 2021 7:49:52 AM com.vertx.examples.ConsumerVerticle
		INFO: subscribed
		0
		Data sent
		Future{result=io.vertx.kafka.client.producer.RecordMetadata@243569cd}
		received data
		May 24, 2021 7:49:52 AM com.vertx.examples.ConsumerVerticle
		INFO: Processing key=null,value=hello world!,partition=0,offset=22


Hurray! :):)


