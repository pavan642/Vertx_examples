package com.vertx.examples.controllers;

import io.vertx.core.Handler;
import io.vertx.reactivex.ext.web.RoutingContext;

public interface IShowController {
    Handler<RoutingContext> getShows();
}
