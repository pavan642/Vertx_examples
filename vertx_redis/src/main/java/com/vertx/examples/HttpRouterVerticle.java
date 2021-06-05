package com.vertx.examples;

import com.vertx.examples.di.DaggerFactory;
import com.vertx.examples.di.Factory;
import com.vertx.examples.routes.BookRouter;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.impl.logging.Logger;
import io.vertx.core.impl.logging.LoggerFactory;
import io.vertx.ext.web.Router;


public class HttpRouterVerticle extends AbstractVerticle {

    private Logger logger = LoggerFactory.getLogger(HttpRouterVerticle.class);
    Vertx vertx;


    private int port = 8083;

    HttpRouterVerticle(Vertx vertx){
        this.vertx = vertx;
    }

    @Override
    public void start() throws Exception {
        Router router = Router.router(vertx);
        Factory factory = DaggerFactory.builder().injectConfig(config()).injectVertx(vertx).injectRouter(router).build();

        BookRouter bookRouter = factory.bookRouter();
        bookRouter.SetUpAPI();

        logger.info("Student app started init.....");
        vertx.createHttpServer()
                .requestHandler(router)
                .listen(port)
                .onSuccess(httpServer -> logger.info("Application server is running on port :: 8083"));
//                .subscribe(httpServer -> logger.info("Application server is running on port :: 8083"));
    }

}
