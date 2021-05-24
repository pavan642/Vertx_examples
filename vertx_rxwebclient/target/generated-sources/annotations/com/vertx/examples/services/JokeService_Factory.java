package com.vertx.examples.services;

import com.vertx.examples.external.IJokeClient;
import dagger.internal.Factory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class JokeService_Factory implements Factory<JokeService> {
  private final Provider<IJokeClient> jokeClientProvider;

  public JokeService_Factory(Provider<IJokeClient> jokeClientProvider) {
    this.jokeClientProvider = jokeClientProvider;
  }

  @Override
  public JokeService get() {
    return provideInstance(jokeClientProvider);
  }

  public static JokeService provideInstance(Provider<IJokeClient> jokeClientProvider) {
    JokeService instance = new JokeService();
    JokeService_MembersInjector.injectJokeClient(instance, jokeClientProvider.get());
    return instance;
  }

  public static JokeService_Factory create(Provider<IJokeClient> jokeClientProvider) {
    return new JokeService_Factory(jokeClientProvider);
  }

  public static JokeService newJokeService() {
    return new JokeService();
  }
}
