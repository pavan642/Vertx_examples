package com.vertx.examples.controllers;

import com.vertx.examples.services.IJokeService;
import io.vertx.core.Handler;
import io.vertx.core.impl.logging.Logger;
import io.vertx.core.impl.logging.LoggerFactory;
import io.vertx.core.json.Json;
import io.vertx.reactivex.core.http.HttpServerResponse;
import io.vertx.reactivex.ext.web.RoutingContext;

import javax.inject.Inject;

public class JokeController implements IJokeController {

    private final Logger logger = LoggerFactory.getLogger(JokeController.class);

    @Inject
    JokeController(){}

    @Inject
    IJokeService jokeService;

    @Override
    public Handler<RoutingContext> getJokes() {
        return routingContext -> {
            HttpServerResponse httpServerResponse = routingContext.response();
            httpServerResponse.putHeader("content-type", "application/json");
            jokeService.getJokes().subscribe(
                    res -> {
                        logger.info("Return jokes");
                        httpServerResponse.setStatusCode(200).end(Json.encodePrettily(res));
                    },
                    err -> {
                        logger.error("Error occur in reading getJokes");
                    }
            );
        };
    }
}
