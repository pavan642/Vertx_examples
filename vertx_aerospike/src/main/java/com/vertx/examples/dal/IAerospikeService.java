package com.vertx.examples.dal;

import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;

public interface IAerospikeService {

    void get(Handler<AsyncResult<String>> resultHandler);
    void set(Handler<AsyncResult<Boolean>> resultHandler);
}
