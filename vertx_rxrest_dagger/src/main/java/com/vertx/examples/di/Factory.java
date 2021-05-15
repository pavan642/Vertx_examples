package com.vertx.examples.di;

import com.vertx.examples.HttpRouterVerticle;
import com.vertx.examples.routers.StudentRouter;
import dagger.BindsInstance;
import dagger.Component;
import io.vertx.core.json.JsonObject;
import io.vertx.reactivex.core.Vertx;
import io.vertx.reactivex.ext.web.Router;

import javax.inject.Scope;

@Component(modules = AppModule.class)
public interface Factory {

    StudentRouter studentRouter();

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder injectVertx(Vertx vertx);

        @BindsInstance
        Builder injectConfig(JsonObject config);

        @BindsInstance
        Builder injectRouter(Router router);

        Factory build();
    }

}
