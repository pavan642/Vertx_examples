package com.vertx.examples.di;

import com.vertx.examples.controllers.ShowController;
import com.vertx.examples.controllers.ShowController_Factory;
import com.vertx.examples.controllers.ShowController_MembersInjector;
import com.vertx.examples.dal.DataLayerService;
import com.vertx.examples.routes.RouterService;
import com.vertx.examples.routes.RouterService_Factory;
import com.vertx.examples.routes.RouterService_MembersInjector;
import dagger.internal.Preconditions;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import javax.annotation.processing.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerFactory implements Factory {
  private Router injectRouter;

  private Vertx injectVertx;

  private DaggerFactory(Builder builder) {
    initialize(builder);
  }

  public static Factory.Builder builder() {
    return new Builder();
  }

  private DataLayerService getDataLayerService() {
    return AppModule_DataLayerServiceFactory.proxyDataLayerService(injectVertx);
  }

  private ShowController getShowController() {
    return injectShowController(ShowController_Factory.newShowController());
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.injectRouter = builder.injectRouter;
    this.injectVertx = builder.injectVertx;
  }

  @Override
  public RouterService routerService() {
    return injectRouterService(RouterService_Factory.newRouterService());
  }

  private ShowController injectShowController(ShowController instance) {
    ShowController_MembersInjector.injectDataLayerService(instance, getDataLayerService());
    return instance;
  }

  private RouterService injectRouterService(RouterService instance) {
    RouterService_MembersInjector.injectRouter(instance, injectRouter);
    RouterService_MembersInjector.injectShowController(instance, getShowController());
    return instance;
  }

  private static final class Builder implements Factory.Builder {
    private Vertx injectVertx;

    private JsonObject injectConfig;

    private Router injectRouter;

    @Override
    public Factory build() {
      if (injectVertx == null) {
        throw new IllegalStateException(Vertx.class.getCanonicalName() + " must be set");
      }
      if (injectConfig == null) {
        throw new IllegalStateException(JsonObject.class.getCanonicalName() + " must be set");
      }
      if (injectRouter == null) {
        throw new IllegalStateException(Router.class.getCanonicalName() + " must be set");
      }
      return new DaggerFactory(this);
    }

    @Override
    public Builder injectVertx(Vertx vertx) {
      this.injectVertx = Preconditions.checkNotNull(vertx);
      return this;
    }

    @Override
    public Builder injectConfig(JsonObject config) {
      this.injectConfig = Preconditions.checkNotNull(config);
      return this;
    }

    @Override
    public Builder injectRouter(Router router) {
      this.injectRouter = Preconditions.checkNotNull(router);
      return this;
    }
  }
}
