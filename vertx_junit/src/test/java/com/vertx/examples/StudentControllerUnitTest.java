package com.vertx.examples;

import io.vertx.junit5.VertxExtension;
import io.vertx.junit5.VertxTestContext;
import io.vertx.reactivex.core.Vertx;
import io.vertx.reactivex.ext.web.client.WebClient;
import io.vertx.reactivex.ext.web.codec.BodyCodec;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@ExtendWith(VertxExtension.class)
public class StudentControllerUnitTest {

    @Test
    void httpRequest(VertxTestContext testContext) {
        Vertx vertx = Vertx.vertx();
        WebClient webClient = WebClient.create(vertx);
        vertx.deployVerticle(new HttpRouterVerticle(vertx), testContext.succeeding(id -> {
            webClient.get(8083, "localhost", "/students")
                    .as(BodyCodec.string())
                    .send(testContext.succeeding(resp -> {
                        testContext.verify(() -> {
                            Assert.assertEquals(resp.statusCode(), 200);
                            List<Map> response = new ArrayList<>();
//                            response = resp.body();
//                            Assert.assertEquals(resp.body(), );
                            testContext.completeNow();
                        });
                    }));
        }));
        vertx.close();
    }

}
