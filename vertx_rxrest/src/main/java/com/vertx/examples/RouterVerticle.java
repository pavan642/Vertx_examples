package com.vertx.examples;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.impl.logging.Logger;
import io.vertx.core.impl.logging.LoggerFactory;
import io.vertx.core.json.JsonObject;
import io.vertx.reactivex.core.Vertx;
import io.vertx.reactivex.core.http.HttpServerResponse;
import io.vertx.reactivex.ext.web.Router;
import io.vertx.reactivex.ext.web.RoutingContext;
import io.vertx.reactivex.ext.web.handler.BodyHandler;


public class RouterVerticle  extends AbstractVerticle {

    private Logger logger = LoggerFactory.getLogger(RouterVerticle.class);

    Vertx vertx;

    private int port = 8083;

    public RouterVerticle(Vertx vertx) {
        this.vertx = vertx;
    }


    @Override
    public void start() {
        logger.info("products started init.....");
        Router router = Router.router(vertx);
        router.route().handler(BodyHandler.create());
        router.get("/products").handler(this::getProducts);
        vertx.createHttpServer()
                .requestHandler(router)
                .rxListen(port)
                .subscribe(httpServer -> logger.info("Application server is running on port :: 8083"));
    }

    /**
     *
     * @param routingContext
     */
    private void getProducts(RoutingContext routingContext){
        logger.info("in get product method");
        HttpServerResponse httpResponse = routingContext.response();
        JsonObject response =  new JsonObject().put("id", "prod3568").put("name", "Burger").put("price", 3.99).put("weight", 150);
        httpResponse
                .putHeader("content-type", "application/json")
                .end(response.encodePrettily());
    }
}
