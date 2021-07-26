package com.vertx.examples.routes;

import com.vertx.examples.controllers.IShowController;
import dagger.MembersInjector;
import io.vertx.ext.web.Router;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class RouterService_MembersInjector implements MembersInjector<RouterService> {
  private final Provider<Router> routerProvider;

  private final Provider<IShowController> showControllerProvider;

  public RouterService_MembersInjector(
      Provider<Router> routerProvider, Provider<IShowController> showControllerProvider) {
    this.routerProvider = routerProvider;
    this.showControllerProvider = showControllerProvider;
  }

  public static MembersInjector<RouterService> create(
      Provider<Router> routerProvider, Provider<IShowController> showControllerProvider) {
    return new RouterService_MembersInjector(routerProvider, showControllerProvider);
  }

  @Override
  public void injectMembers(RouterService instance) {
    injectRouter(instance, routerProvider.get());
    injectShowController(instance, showControllerProvider.get());
  }

  public static void injectRouter(RouterService instance, Router router) {
    instance.router = router;
  }

  public static void injectShowController(RouterService instance, IShowController showController) {
    instance.showController = showController;
  }
}
