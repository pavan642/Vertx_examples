package com.vertx.examples.router;

import com.vertx.examples.controllers.IJokeController;
import dagger.MembersInjector;
import io.vertx.reactivex.ext.web.Router;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class JokeRouter_MembersInjector implements MembersInjector<JokeRouter> {
  private final Provider<Router> routerProvider;

  private final Provider<IJokeController> jokeControllerProvider;

  public JokeRouter_MembersInjector(
      Provider<Router> routerProvider, Provider<IJokeController> jokeControllerProvider) {
    this.routerProvider = routerProvider;
    this.jokeControllerProvider = jokeControllerProvider;
  }

  public static MembersInjector<JokeRouter> create(
      Provider<Router> routerProvider, Provider<IJokeController> jokeControllerProvider) {
    return new JokeRouter_MembersInjector(routerProvider, jokeControllerProvider);
  }

  @Override
  public void injectMembers(JokeRouter instance) {
    injectRouter(instance, routerProvider.get());
    injectJokeController(instance, jokeControllerProvider.get());
  }

  public static void injectRouter(JokeRouter instance, Router router) {
    instance.router = router;
  }

  public static void injectJokeController(JokeRouter instance, IJokeController jokeController) {
    instance.jokeController = jokeController;
  }
}
