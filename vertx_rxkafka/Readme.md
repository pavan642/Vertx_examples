mvn clean install


java -jar target/vertx_rxkafka-1.0-SNAPSHOT-fat.jar

Start kafka producer
send data
Start consumer
Consume data


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

