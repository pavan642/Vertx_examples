package com.vertx.examples.di;

import com.vertx.examples.routes.RouterService;
import dagger.BindsInstance;
import dagger.Component;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;

@Component(modules = AppModule.class)
public interface Factory {

    RouterService routerService();

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
