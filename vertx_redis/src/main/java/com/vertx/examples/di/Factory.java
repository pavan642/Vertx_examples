package com.vertx.examples.di;

import com.vertx.examples.routes.BookRouter;
import dagger.BindsInstance;
import dagger.Component;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;

@Component(modules = AppModule.class)
public interface Factory {

    BookRouter bookRouter();

    @Component.Builder
    interface Builder {

//        @Provides
//        static Single<RedisConnection> getRedisClient(Vertx vertx) {
//            return RedisConfiguration.getRedisClient(vertx);
//        }


        @BindsInstance
        Builder injectVertx(Vertx vertx);

        @BindsInstance
        Builder injectConfig(JsonObject config);

        @BindsInstance
        Builder injectRouter(Router router);

        Factory build();
    }

}
