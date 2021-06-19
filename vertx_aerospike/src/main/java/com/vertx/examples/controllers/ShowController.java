package com.vertx.examples.controllers;

import io.vertx.core.Handler;
import io.vertx.reactivex.ext.web.RoutingContext;

import javax.inject.Inject;

public class ShowController implements IShowController {

    @Inject
    ShowController(){};

    @Override
    public Handler<RoutingContext> getShows() {
        return null;
    }
}
