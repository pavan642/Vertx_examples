package com.vertx.examples.di;

import com.vertx.examples.router.ReviewRouter;
import dagger.BindsInstance;
import dagger.Component;
import io.vertx.core.json.JsonObject;
import io.vertx.reactivex.core.Vertx;
import io.vertx.reactivex.ext.web.Router;

@Component(modules = AppModule.class)
public interface Factory {

    ReviewRouter reviewRouter();

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
