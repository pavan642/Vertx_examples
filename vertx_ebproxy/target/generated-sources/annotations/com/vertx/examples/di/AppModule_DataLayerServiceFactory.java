package com.vertx.examples.di;

import com.vertx.examples.dal.DataLayerService;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import io.vertx.core.Vertx;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AppModule_DataLayerServiceFactory implements Factory<DataLayerService> {
  private final Provider<Vertx> vertxProvider;

  public AppModule_DataLayerServiceFactory(Provider<Vertx> vertxProvider) {
    this.vertxProvider = vertxProvider;
  }

  @Override
  public DataLayerService get() {
    return provideInstance(vertxProvider);
  }

  public static DataLayerService provideInstance(Provider<Vertx> vertxProvider) {
    return proxyDataLayerService(vertxProvider.get());
  }

  public static AppModule_DataLayerServiceFactory create(Provider<Vertx> vertxProvider) {
    return new AppModule_DataLayerServiceFactory(vertxProvider);
  }

  public static DataLayerService proxyDataLayerService(Vertx vertx) {
    return Preconditions.checkNotNull(
        AppModule.dataLayerService(vertx),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
