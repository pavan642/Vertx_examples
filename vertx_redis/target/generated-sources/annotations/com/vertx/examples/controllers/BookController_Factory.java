package com.vertx.examples.controllers;

import dagger.internal.Factory;
import io.vertx.core.Vertx;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class BookController_Factory implements Factory<BookController> {
  private final Provider<Vertx> vertxProvider;

  public BookController_Factory(Provider<Vertx> vertxProvider) {
    this.vertxProvider = vertxProvider;
  }

  @Override
  public BookController get() {
    return provideInstance(vertxProvider);
  }

  public static BookController provideInstance(Provider<Vertx> vertxProvider) {
    BookController instance = new BookController();
    BookController_MembersInjector.injectVertx(instance, vertxProvider.get());
    return instance;
  }

  public static BookController_Factory create(Provider<Vertx> vertxProvider) {
    return new BookController_Factory(vertxProvider);
  }

  public static BookController newBookController() {
    return new BookController();
  }
}
