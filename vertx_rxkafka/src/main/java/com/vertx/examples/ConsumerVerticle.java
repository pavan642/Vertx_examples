package com.vertx.examples;

import com.vertx.examples.config.KafkaConsumerInit;
import io.vertx.core.Handler;
import io.vertx.core.impl.logging.Logger;
import io.vertx.core.impl.logging.LoggerFactory;
import io.vertx.reactivex.core.AbstractVerticle;
import io.vertx.reactivex.core.Vertx;
import io.vertx.reactivex.kafka.client.consumer.KafkaConsumer;
import io.vertx.reactivex.kafka.client.consumer.KafkaConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerConfig;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

public class ConsumerVerticle extends AbstractVerticle {

    private final Logger logger = LoggerFactory.getLogger(ConsumerVerticle.class);

    Vertx vertx;

    ConsumerVerticle(Vertx vertx){
        this.vertx  = vertx;
    }

    @Override
    public void start() throws Exception {
        System.out.println("start consumer...");

        KafkaConsumer<String, String> consumer = KafkaConsumerInit.getKafkaConsumer(vertx);
        System.out.println("consumer started....");
        consumer.subscribe("orders-out", ar -> {
            if (ar.succeeded()) {
                logger.info("subscribed");
            } else {
                logger.error("not able subscribe  {}", ar.cause());
            }
        });
        consumer.handler(this.kafkaConsumerRecordHandler());
    }

    public Handler<KafkaConsumerRecord<String, String>> kafkaConsumerRecordHandler(){
        return kafkaRecord -> {
            System.out.println("received data");
            logger.info(
                    "Processing key="
                            + kafkaRecord.key()
                            + ",value="
                            + kafkaRecord.value()
                            + ",partition="
                            + kafkaRecord.partition()
                            + ",offset="
                            + kafkaRecord.offset());
        };

    }
}
