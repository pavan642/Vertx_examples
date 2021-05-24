package com.vertx.examples.controllers;

import com.vertx.examples.services.IJokeService;
import dagger.internal.Factory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class JokeController_Factory implements Factory<JokeController> {
  private final Provider<IJokeService> jokeServiceProvider;

  public JokeController_Factory(Provider<IJokeService> jokeServiceProvider) {
    this.jokeServiceProvider = jokeServiceProvider;
  }

  @Override
  public JokeController get() {
    return provideInstance(jokeServiceProvider);
  }

  public static JokeController provideInstance(Provider<IJokeService> jokeServiceProvider) {
    JokeController instance = new JokeController();
    JokeController_MembersInjector.injectJokeService(instance, jokeServiceProvider.get());
    return instance;
  }

  public static JokeController_Factory create(Provider<IJokeService> jokeServiceProvider) {
    return new JokeController_Factory(jokeServiceProvider);
  }

  public static JokeController newJokeController() {
    return new JokeController();
  }
}
