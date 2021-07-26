package com.vertx.examples.dal;

import io.vertx.codegen.annotations.ProxyGen;
import io.vertx.codegen.annotations.VertxGen;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.serviceproxy.ServiceBinder;
import io.vertx.serviceproxy.ServiceProxyBuilder;

@VertxGen
@ProxyGen
public interface DataLayerService {

    static DataLayerService createProxy(Vertx vertx, String address) {
        System.out.println("dal review proxy--created");
        return new DataLayerServiceVertxEBProxy(vertx, address);
//        ServiceProxyBuilder builder = new ServiceProxyBuilder(vertx).setAddress(address);
//        DataLayerService service = builder.build(DataLayerService.class);
//        return service;

    }

    void getRandomNumber(Handler<AsyncResult<String>> handler);
}
