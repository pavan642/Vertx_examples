package com.vertx.examples.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import io.vertx.reactivex.core.Vertx;
import io.vertx.reactivex.mysqlclient.MySQLPool;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AppModule_MysqlPoolFactory implements Factory<MySQLPool> {
  private final Provider<Vertx> vertxProvider;

  public AppModule_MysqlPoolFactory(Provider<Vertx> vertxProvider) {
    this.vertxProvider = vertxProvider;
  }

  @Override
  public MySQLPool get() {
    return provideInstance(vertxProvider);
  }

  public static MySQLPool provideInstance(Provider<Vertx> vertxProvider) {
    return proxyMysqlPool(vertxProvider.get());
  }

  public static AppModule_MysqlPoolFactory create(Provider<Vertx> vertxProvider) {
    return new AppModule_MysqlPoolFactory(vertxProvider);
  }

  public static MySQLPool proxyMysqlPool(Vertx vertx) {
    return Preconditions.checkNotNull(
        AppModule.mysqlPool(vertx), "Cannot return null from a non-@Nullable @Provides method");
  }
}
