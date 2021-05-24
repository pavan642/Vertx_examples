package com.vertx.examples.controllers;

import io.vertx.core.Handler;
import io.vertx.reactivex.ext.web.RoutingContext;

public interface IJokeController {
    Handler<RoutingContext> getJokes();
}
