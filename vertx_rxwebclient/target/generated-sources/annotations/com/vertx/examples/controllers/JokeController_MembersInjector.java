package com.vertx.examples.controllers;

import com.vertx.examples.services.IJokeService;
import dagger.MembersInjector;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class JokeController_MembersInjector implements MembersInjector<JokeController> {
  private final Provider<IJokeService> jokeServiceProvider;

  public JokeController_MembersInjector(Provider<IJokeService> jokeServiceProvider) {
    this.jokeServiceProvider = jokeServiceProvider;
  }

  public static MembersInjector<JokeController> create(Provider<IJokeService> jokeServiceProvider) {
    return new JokeController_MembersInjector(jokeServiceProvider);
  }

  @Override
  public void injectMembers(JokeController instance) {
    injectJokeService(instance, jokeServiceProvider.get());
  }

  public static void injectJokeService(JokeController instance, IJokeService jokeService) {
    instance.jokeService = jokeService;
  }
}
