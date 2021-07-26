package com.vertx.examples.controllers;

import com.vertx.examples.dal.DataLayerService;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.Json;
import io.vertx.ext.web.RoutingContext;

import javax.inject.Inject;

public class ShowController implements IShowController {

    @Inject
    ShowController(){};

    @Inject
    DataLayerService dataLayerService;

    @Override
    public Handler<RoutingContext> getShows() {
        System.out.println("in get Shows");
        return routingContext -> {
            System.out.println("in get Shows--1");
//            Handler<AsyncResult<String>> resultHandler =
            dataLayerService.getRandomNumber(new Handler<AsyncResult<String>>() {
                @Override
                public void handle(AsyncResult<String> stringAsyncResult) {
                    System.out.println(stringAsyncResult.result());
                    HttpServerResponse httpServerResponse = routingContext.response();
                    httpServerResponse.putHeader("content-type", "application/json");
                    httpServerResponse.setStatusCode(200).end(Json.encodePrettily("success-1"));
                }
            });
        };
    }
}
