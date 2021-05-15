package com.vertx.examples;

import com.vertx.examples.di.DaggerFactory;
import com.vertx.examples.di.Factory;
import com.vertx.examples.router.ReviewRouter;
import io.vertx.core.impl.logging.Logger;
import io.vertx.core.impl.logging.LoggerFactory;
import io.vertx.core.json.JsonObject;
import io.vertx.mysqlclient.MySQLConnectOptions;
import io.vertx.reactivex.core.AbstractVerticle;
import io.vertx.reactivex.core.Vertx;
import io.vertx.reactivex.ext.web.Router;
import io.vertx.reactivex.mysqlclient.MySQLClient;
import io.vertx.reactivex.mysqlclient.MySQLPool;
import io.vertx.sqlclient.PoolOptions;

public class HttpRouterVerticle extends AbstractVerticle {

    private Logger logger = LoggerFactory.getLogger(HttpRouterVerticle.class);

    Vertx vertx;

    Integer port = 8083;

    HttpRouterVerticle(Vertx vertx){
        this.vertx = vertx;
    }

    @Override
    public void start() throws Exception {
        Router router = Router.router(vertx);

        Factory factory = DaggerFactory.builder().injectConfig(config()).injectVertx(vertx).injectRouter(router).build();

        ReviewRouter reviewRouter = factory.reviewRouter();
        reviewRouter.SetUpAPI();

        logger.info("Review app started init.....");
        vertx.createHttpServer()
                .requestHandler(router)
                .rxListen(port)
                .subscribe(httpServer -> logger.info("Application server is running on port :: 8083"));

    }
}
