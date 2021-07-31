package com.vertx.examples.controllers;

import com.vertx.examples.dal.IAerospikeService;
import io.vertx.core.Handler;
import io.vertx.core.json.Json;
import io.vertx.reactivex.core.http.HttpServerResponse;
import io.vertx.reactivex.ext.web.RoutingContext;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

public class ShowController implements IShowController {

    @Inject
    ShowController(){};

    @Inject
    IAerospikeService aerospikeService;

    @Override
    public Handler<RoutingContext> getShows() {
        System.out.println("get shows -1");
        return routingContext -> {
            System.out.println("get shows -1");
            aerospikeService.set(booleanAsyncResult -> {
                aerospikeService.get(stringAsyncResult -> {
                    System.out.println(stringAsyncResult.result());
                    HttpServerResponse httpServerResponse = routingContext.response();
                    httpServerResponse.putHeader("content-type", "application/json");
                    Map result = new HashMap();
                    result.put("status", "success");
                    result.put("name", stringAsyncResult.result().toString());
                    httpServerResponse.setStatusCode(200).end(Json.encodePrettily(result));
                });
            });

        };
    }
}
