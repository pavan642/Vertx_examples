package com.vertx.examples.router;

import com.vertx.examples.controllers.IJokeController;
import io.vertx.reactivex.core.http.HttpServerResponse;
import io.vertx.reactivex.ext.web.Router;

import javax.inject.Inject;

public class JokeRouter {

    @Inject
    JokeRouter(){}

    @Inject
    Router router;

    @Inject
    IJokeController jokeController;


    public void SetUpAPI() {

        this.router.route("/*").handler(routingContext -> {
            HttpServerResponse httpServerResponse = routingContext.response();
            httpServerResponse.putHeader("content-type", "application/json");

            routingContext.put("serverResponse", httpServerResponse);
            routingContext.next();

        });

        this.router.route("/jokes").handler(jokeController.getJokes());


    }
}
