package com.vertx.examples.routes;

import com.vertx.examples.controllers.IShowController;
import dagger.internal.Factory;
import io.vertx.ext.web.Router;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class RouterService_Factory implements Factory<RouterService> {
  private final Provider<Router> routerProvider;

  private final Provider<IShowController> showControllerProvider;

  public RouterService_Factory(
      Provider<Router> routerProvider, Provider<IShowController> showControllerProvider) {
    this.routerProvider = routerProvider;
    this.showControllerProvider = showControllerProvider;
  }

  @Override
  public RouterService get() {
    return provideInstance(routerProvider, showControllerProvider);
  }

  public static RouterService provideInstance(
      Provider<Router> routerProvider, Provider<IShowController> showControllerProvider) {
    RouterService instance = new RouterService();
    RouterService_MembersInjector.injectRouter(instance, routerProvider.get());
    RouterService_MembersInjector.injectShowController(instance, showControllerProvider.get());
    return instance;
  }

  public static RouterService_Factory create(
      Provider<Router> routerProvider, Provider<IShowController> showControllerProvider) {
    return new RouterService_Factory(routerProvider, showControllerProvider);
  }

  public static RouterService newRouterService() {
    return new RouterService();
  }
}
