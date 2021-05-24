package com.vertx.examples.external;

import dagger.MembersInjector;
import io.vertx.reactivex.ext.web.client.WebClient;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class JokeClient_MembersInjector implements MembersInjector<JokeClient> {
  private final Provider<WebClient> webClientProvider;

  public JokeClient_MembersInjector(Provider<WebClient> webClientProvider) {
    this.webClientProvider = webClientProvider;
  }

  public static MembersInjector<JokeClient> create(Provider<WebClient> webClientProvider) {
    return new JokeClient_MembersInjector(webClientProvider);
  }

  @Override
  public void injectMembers(JokeClient instance) {
    injectWebClient(instance, webClientProvider.get());
  }

  public static void injectWebClient(JokeClient instance, WebClient webClient) {
    instance.webClient = webClient;
  }
}
