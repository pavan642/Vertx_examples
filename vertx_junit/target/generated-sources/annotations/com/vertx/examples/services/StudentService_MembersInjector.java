package com.vertx.examples.services;

import com.vertx.examples.external.ICacheService;
import dagger.MembersInjector;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class StudentService_MembersInjector implements MembersInjector<StudentService> {
  private final Provider<ICacheService> cacheServiceProvider;

  public StudentService_MembersInjector(Provider<ICacheService> cacheServiceProvider) {
    this.cacheServiceProvider = cacheServiceProvider;
  }

  public static MembersInjector<StudentService> create(
      Provider<ICacheService> cacheServiceProvider) {
    return new StudentService_MembersInjector(cacheServiceProvider);
  }

  @Override
  public void injectMembers(StudentService instance) {
    injectCacheService(instance, cacheServiceProvider.get());
  }

  public static void injectCacheService(StudentService instance, ICacheService cacheService) {
    instance.cacheService = cacheService;
  }
}
