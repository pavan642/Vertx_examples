package com.vertx.examples.router;

import com.vertx.examples.controllers.IJokeController;
import dagger.internal.Factory;
import io.vertx.reactivex.ext.web.Router;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class JokeRouter_Factory implements Factory<JokeRouter> {
  private final Provider<Router> routerProvider;

  private final Provider<IJokeController> jokeControllerProvider;

  public JokeRouter_Factory(
      Provider<Router> routerProvider, Provider<IJokeController> jokeControllerProvider) {
    this.routerProvider = routerProvider;
    this.jokeControllerProvider = jokeControllerProvider;
  }

  @Override
  public JokeRouter get() {
    return provideInstance(routerProvider, jokeControllerProvider);
  }

  public static JokeRouter provideInstance(
      Provider<Router> routerProvider, Provider<IJokeController> jokeControllerProvider) {
    JokeRouter instance = new JokeRouter();
    JokeRouter_MembersInjector.injectRouter(instance, routerProvider.get());
    JokeRouter_MembersInjector.injectJokeController(instance, jokeControllerProvider.get());
    return instance;
  }

  public static JokeRouter_Factory create(
      Provider<Router> routerProvider, Provider<IJokeController> jokeControllerProvider) {
    return new JokeRouter_Factory(routerProvider, jokeControllerProvider);
  }

  public static JokeRouter newJokeRouter() {
    return new JokeRouter();
  }
}
