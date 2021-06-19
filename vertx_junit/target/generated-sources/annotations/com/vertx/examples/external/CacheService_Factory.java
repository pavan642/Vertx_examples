package com.vertx.examples.external;

import dagger.internal.Factory;
import javax.annotation.processing.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CacheService_Factory implements Factory<CacheService> {
  private static final CacheService_Factory INSTANCE = new CacheService_Factory();

  @Override
  public CacheService get() {
    return provideInstance();
  }

  public static CacheService provideInstance() {
    return new CacheService();
  }

  public static CacheService_Factory create() {
    return INSTANCE;
  }

  public static CacheService newCacheService() {
    return new CacheService();
  }
}
