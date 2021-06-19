package com.vertx.examples.routes;

import com.vertx.examples.controllers.IShowController;
import io.vertx.reactivex.core.http.HttpServerResponse;
import io.vertx.reactivex.ext.web.Router;

import javax.inject.Inject;

public class RouterService {

    @Inject
    RouterService(){ }

    @Inject
    Router router;

    @Inject
    IShowController showController;


    public void SetUpAPI() {

        this.router.route("/*").handler(routingContext -> {
            HttpServerResponse httpServerResponse = routingContext.response();
            httpServerResponse.putHeader("content-type", "application/json");

            routingContext.put("serverResponse", httpServerResponse);
            routingContext.next();

        });

        this.router.route("/reviews").handler(showController.getShows());
    }
}
