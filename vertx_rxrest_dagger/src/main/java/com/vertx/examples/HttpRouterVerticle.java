package com.vertx.examples;

import com.vertx.examples.di.DaggerFactory;
import com.vertx.examples.di.Factory;
import com.vertx.examples.routers.StudentRouter;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.impl.logging.Logger;
import io.vertx.core.impl.logging.LoggerFactory;
import io.vertx.reactivex.core.Vertx;
import io.vertx.reactivex.ext.web.Router;
import io.vertx.reactivex.ext.web.RoutingContext;
import io.vertx.reactivex.ext.web.handler.BodyHandler;

public class HttpRouterVerticle  extends AbstractVerticle {

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

        StudentRouter studentRouter = factory.studentRouter();
        studentRouter.SetUpAPI();

        logger.info("Student app started init.....");
        vertx.createHttpServer()
                .requestHandler(router)
                .rxListen(port)
                .subscribe(httpServer -> logger.info("Application server is running on port :: 8083"));
    }
}
