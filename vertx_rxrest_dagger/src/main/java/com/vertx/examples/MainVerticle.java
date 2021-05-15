package com.vertx.examples;

import io.vertx.reactivex.core.Vertx;

public class MainVerticle {
    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(new HttpRouterVerticle(vertx));
    }
}
