package com.vertx.examples;

import com.vertx.examples.di.DaggerFactory;
import com.vertx.examples.di.Factory;
import com.vertx.examples.router.JokeRouter;
import io.vertx.core.impl.logging.Logger;
import io.vertx.core.impl.logging.LoggerFactory;
import io.vertx.reactivex.core.AbstractVerticle;
import io.vertx.reactivex.core.Vertx;
import io.vertx.reactivex.ext.web.Router;

public class HttpRouterVerticle extends AbstractVerticle {

    private final Logger logger = LoggerFactory.getLogger(HttpRouterVerticle.class);

    Integer port = 8083;

    Vertx vertx;

    HttpRouterVerticle(Vertx vertx){
        this.vertx = vertx;
    }

    @Override
    public void start() throws Exception {
        Router router = Router.router(vertx);

        Factory factory = DaggerFactory.builder().injectConfig(config()).injectVertx(vertx).injectRouter(router).build();

        JokeRouter jokeRouter = factory.jokeRouter();
        jokeRouter.SetUpAPI();

        logger.info("Review app started init.....");
        vertx.createHttpServer()
                .requestHandler(router)
                .rxListen(port)
                .subscribe(httpServer -> logger.info("Application server is running on port :: 8083"));


    }
}
