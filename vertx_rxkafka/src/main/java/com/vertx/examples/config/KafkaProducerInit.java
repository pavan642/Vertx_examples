package com.vertx.examples.config;

import io.vertx.core.json.JsonObject;
import io.vertx.reactivex.core.Vertx;
import io.vertx.reactivex.kafka.client.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class KafkaProducerInit {

    public static KafkaProducer getKafkaProducer(Vertx vertx){
        System.out.println("start producer...");
        Map<String, String> config = new HashMap();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        config.put(ProducerConfig.ACKS_CONFIG, "1");
        KafkaProducer<String, String> producer = KafkaProducer.create(vertx, config);
        producer.partitionsFor("orders-out", done -> {
            done.result().forEach(p -> System.out.println(p.getPartition()));
        });
        return producer;
    }
}
