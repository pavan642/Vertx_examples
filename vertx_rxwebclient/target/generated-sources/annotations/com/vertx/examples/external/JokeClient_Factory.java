package com.vertx.examples.external;

import dagger.internal.Factory;
import io.vertx.reactivex.ext.web.client.WebClient;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class JokeClient_Factory implements Factory<JokeClient> {
  private final Provider<WebClient> webClientProvider;

  public JokeClient_Factory(Provider<WebClient> webClientProvider) {
    this.webClientProvider = webClientProvider;
  }

  @Override
  public JokeClient get() {
    return provideInstance(webClientProvider);
  }

  public static JokeClient provideInstance(Provider<WebClient> webClientProvider) {
    JokeClient instance = new JokeClient();
    JokeClient_MembersInjector.injectWebClient(instance, webClientProvider.get());
    return instance;
  }

  public static JokeClient_Factory create(Provider<WebClient> webClientProvider) {
    return new JokeClient_Factory(webClientProvider);
  }

  public static JokeClient newJokeClient() {
    return new JokeClient();
  }
}
