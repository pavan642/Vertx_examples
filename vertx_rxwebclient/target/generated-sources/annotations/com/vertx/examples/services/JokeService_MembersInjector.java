package com.vertx.examples.services;

import com.vertx.examples.external.IJokeClient;
import dagger.MembersInjector;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class JokeService_MembersInjector implements MembersInjector<JokeService> {
  private final Provider<IJokeClient> jokeClientProvider;

  public JokeService_MembersInjector(Provider<IJokeClient> jokeClientProvider) {
    this.jokeClientProvider = jokeClientProvider;
  }

  public static MembersInjector<JokeService> create(Provider<IJokeClient> jokeClientProvider) {
    return new JokeService_MembersInjector(jokeClientProvider);
  }

  @Override
  public void injectMembers(JokeService instance) {
    injectJokeClient(instance, jokeClientProvider.get());
  }

  public static void injectJokeClient(JokeService instance, IJokeClient jokeClient) {
    instance.jokeClient = jokeClient;
  }
}
