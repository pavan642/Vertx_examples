package com.vertx.examples.router;

import com.vertx.examples.controllers.IReviewController;
import io.vertx.reactivex.core.http.HttpServerResponse;
import io.vertx.reactivex.ext.web.Router;

import javax.inject.Inject;

public class ReviewRouter {

    @Inject
    ReviewRouter(){

    }

    @Inject
    public Router router;

    @Inject
    IReviewController reviewController;

    public void SetUpAPI() {

        this.router.route("/*").handler(routingContext -> {
            HttpServerResponse httpServerResponse = routingContext.response();
            httpServerResponse.putHeader("content-type", "application/json");

            routingContext.put("serverResponse", httpServerResponse);
            routingContext.next();

        });

        this.router.route("/reviews").handler(reviewController.getReviews());
    }
}
