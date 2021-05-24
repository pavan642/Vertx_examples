package com.vertx.examples.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import io.vertx.reactivex.core.Vertx;
import io.vertx.reactivex.ext.web.client.WebClient;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AppModule_GetWebClientFactory implements Factory<WebClient> {
  private final Provider<Vertx> vertxProvider;

  public AppModule_GetWebClientFactory(Provider<Vertx> vertxProvider) {
    this.vertxProvider = vertxProvider;
  }

  @Override
  public WebClient get() {
    return provideInstance(vertxProvider);
  }

  public static WebClient provideInstance(Provider<Vertx> vertxProvider) {
    return proxyGetWebClient(vertxProvider.get());
  }

  public static AppModule_GetWebClientFactory create(Provider<Vertx> vertxProvider) {
    return new AppModule_GetWebClientFactory(vertxProvider);
  }

  public static WebClient proxyGetWebClient(Vertx vertx) {
    return Preconditions.checkNotNull(
        AppModule.getWebClient(vertx), "Cannot return null from a non-@Nullable @Provides method");
  }
}
