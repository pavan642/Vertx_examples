package com.vertx.examples;

import com.vertx.examples.di.DaggerFactory;
import com.vertx.examples.di.Factory;
import com.vertx.examples.routes.RouterService;
import io.vertx.core.impl.logging.Logger;
import io.vertx.core.impl.logging.LoggerFactory;
import io.vertx.reactivex.core.AbstractVerticle;
import io.vertx.reactivex.core.Vertx;
import io.vertx.reactivex.ext.web.Router;

public class HttpRouterVerticle extends AbstractVerticle {

    private final Logger logger = LoggerFactory.getLogger(HttpRouterVerticle.class);

    Vertx vertx;

    Integer port = 8083;

    HttpRouterVerticle(Vertx vertx){
        this.vertx = vertx;
    }

    @Override
    public void start() throws Exception {


        Router router = Router.router(vertx);

        Factory factory = DaggerFactory.builder().injectConfig(config()).injectVertx(vertx).injectRouter(router).build();

        RouterService reviewRouter = factory.routerService();
        reviewRouter.SetUpAPI();

        logger.info("Review app started init.....");
        vertx.createHttpServer()
                .requestHandler(router)
                .rxListen(port)
                .subscribe(httpServer -> logger.info("Application server is running on port :: 8083"));



    }
}
