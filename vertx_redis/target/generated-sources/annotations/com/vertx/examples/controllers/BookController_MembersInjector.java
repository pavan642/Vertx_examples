package com.vertx.examples.controllers;

import dagger.MembersInjector;
import io.vertx.core.Vertx;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class BookController_MembersInjector implements MembersInjector<BookController> {
  private final Provider<Vertx> vertxProvider;

  public BookController_MembersInjector(Provider<Vertx> vertxProvider) {
    this.vertxProvider = vertxProvider;
  }

  public static MembersInjector<BookController> create(Provider<Vertx> vertxProvider) {
    return new BookController_MembersInjector(vertxProvider);
  }

  @Override
  public void injectMembers(BookController instance) {
    injectVertx(instance, vertxProvider.get());
  }

  public static void injectVertx(BookController instance, Vertx vertx) {
    instance.vertx = vertx;
  }
}
