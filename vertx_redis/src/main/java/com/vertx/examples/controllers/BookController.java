package com.vertx.examples.controllers;

import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.impl.logging.Logger;
import io.vertx.core.impl.logging.LoggerFactory;
import io.vertx.core.json.Json;
import io.vertx.ext.web.RoutingContext;
import io.vertx.redis.client.Command;
import io.vertx.redis.client.Redis;
import io.vertx.redis.client.Request;

import javax.inject.Inject;

public class BookController implements IBookController {

    private final Logger logger = LoggerFactory.getLogger(BookController.class);

    @Inject
    BookController(){}

    @Inject
    Vertx vertx;


    public Handler<RoutingContext> getBooks() {
        return  routingContext -> {
            HttpServerResponse httpServerResponse = routingContext.response();
            httpServerResponse.putHeader("content-type", "application/json");
            Redis.createClient(vertx).connect().onSuccess(redisConnection -> {
               redisConnection.send(Request.cmd(Command.INFO)).onSuccess(response -> {
                   logger.info(response);
                   httpServerResponse.setStatusCode(200).end(Json.encodePrettily("success"));
               });
            });


        };
    }

}
