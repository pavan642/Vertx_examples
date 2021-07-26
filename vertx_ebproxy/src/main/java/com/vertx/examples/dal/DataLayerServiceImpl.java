package com.vertx.examples.dal;

import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;

public class DataLayerServiceImpl implements DataLayerService {


    @Override
    public void getRandomNumber(Handler<AsyncResult<String>> handler) {
        System.out.println("hello");
        handler.handle(Future.succeededFuture("hello world-11"));
    }
}
