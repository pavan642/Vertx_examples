package com.vertx.examples;

import com.vertx.examples.config.KafkaProducerInit;
import io.vertx.reactivex.core.AbstractVerticle;
import io.vertx.reactivex.core.Vertx;
import io.vertx.reactivex.kafka.client.producer.KafkaProducer;
import io.vertx.reactivex.kafka.client.producer.KafkaProducerRecord;

import javax.inject.Inject;

public class ProducerVerticle extends AbstractVerticle {

    Vertx vertx;

    KafkaProducer kafkaProducer;

    ProducerVerticle(Vertx vertx){
        this.vertx = vertx;
    }

    @Override
    public void start() throws Exception {

        kafkaProducer = KafkaProducerInit.getKafkaProducer(vertx);
        KafkaProducerRecord<String, String> data = KafkaProducerRecord.create("orders-out", "hello world!");
        System.out.println("send data to topic");
        kafkaProducer.send(data, recordMetadataAsyncResult -> {
            System.out.println("Data sent");
            System.out.println(recordMetadataAsyncResult);
        });
    }
}
