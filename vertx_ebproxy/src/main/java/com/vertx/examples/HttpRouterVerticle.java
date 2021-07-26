package com.vertx.examples;

import com.vertx.examples.dal.DataLayerService;
import com.vertx.examples.dal.DataLayerServiceImpl;
//import com.vertx.examples.di.DaggerFactory;
import com.vertx.examples.di.DaggerFactory;
import com.vertx.examples.di.Factory;
import com.vertx.examples.routes.RouterService;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.impl.logging.Logger;
import io.vertx.core.impl.logging.LoggerFactory;
import io.vertx.ext.web.Router;
import io.vertx.serviceproxy.ServiceBinder;

public class HttpRouterVerticle extends AbstractVerticle {

    private final Logger logger = LoggerFactory.getLogger(HttpRouterVerticle.class);

    Vertx vertx;

    Integer port = 8083;

        HttpRouterVerticle(io.vertx.core.Vertx vertx){
        this.vertx = vertx;
    }

    @Override
    public void start() throws Exception {

        DataLayerService dataLayerService = new DataLayerServiceImpl();
        new ServiceBinder(vertx) // (2)
                .setAddress("dal.reviews") // (3)
                .register(DataLayerService.class, dataLayerService); // (4)
        System.out.println("dal review register");

        logger.info("Review app started init.....1");

        Router router = Router.router(vertx);

        logger.info("Review app started init.....2");
        Factory factory = DaggerFactory.builder().injectConfig(config()).injectVertx(vertx).injectRouter(router).build();
//
        logger.info("Review app started init.....3");
        RouterService reviewRouter = factory.routerService();
        logger.info("Review app started init.....4");
        reviewRouter.SetUpAPI();

        logger.info("Review app started init.....");
        vertx.createHttpServer()
                .requestHandler(router)
                .listen(port)
                .onSuccess(httpServer -> logger.info("Application server is running on port :: 8083"));


    }
}

