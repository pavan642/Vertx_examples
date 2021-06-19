package com.vertx.examples.services;

import com.vertx.examples.external.ICacheService;
import dagger.internal.Factory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class StudentService_Factory implements Factory<StudentService> {
  private final Provider<ICacheService> cacheServiceProvider;

  public StudentService_Factory(Provider<ICacheService> cacheServiceProvider) {
    this.cacheServiceProvider = cacheServiceProvider;
  }

  @Override
  public StudentService get() {
    return provideInstance(cacheServiceProvider);
  }

  public static StudentService provideInstance(Provider<ICacheService> cacheServiceProvider) {
    StudentService instance = new StudentService();
    StudentService_MembersInjector.injectCacheService(instance, cacheServiceProvider.get());
    return instance;
  }

  public static StudentService_Factory create(Provider<ICacheService> cacheServiceProvider) {
    return new StudentService_Factory(cacheServiceProvider);
  }

  public static StudentService newStudentService() {
    return new StudentService();
  }
}
