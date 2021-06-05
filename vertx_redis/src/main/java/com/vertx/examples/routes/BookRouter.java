package com.vertx.examples.routes;

import com.vertx.examples.controllers.IBookController;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.Router;

import javax.inject.Inject;

public class BookRouter {

    @Inject
    BookRouter(){}

    @Inject
    Router router;

    @Inject
    IBookController bookController;

    public void SetUpAPI() {
        this.router.route("/*").handler(routingContext -> {
            HttpServerResponse httpServerResponse = routingContext.response();
            httpServerResponse.putHeader("content-type", "application/json");

            routingContext.put("serverResponse", httpServerResponse);
            routingContext.next();

        });

        this.router.route("/books").handler(bookController.getBooks());
    }
}
