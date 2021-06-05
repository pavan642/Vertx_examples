package com.vertx.examples.routes;

import com.vertx.examples.controllers.IBookController;
import dagger.internal.Factory;
import io.vertx.ext.web.Router;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class BookRouter_Factory implements Factory<BookRouter> {
  private final Provider<Router> routerProvider;

  private final Provider<IBookController> bookControllerProvider;

  public BookRouter_Factory(
      Provider<Router> routerProvider, Provider<IBookController> bookControllerProvider) {
    this.routerProvider = routerProvider;
    this.bookControllerProvider = bookControllerProvider;
  }

  @Override
  public BookRouter get() {
    return provideInstance(routerProvider, bookControllerProvider);
  }

  public static BookRouter provideInstance(
      Provider<Router> routerProvider, Provider<IBookController> bookControllerProvider) {
    BookRouter instance = new BookRouter();
    BookRouter_MembersInjector.injectRouter(instance, routerProvider.get());
    BookRouter_MembersInjector.injectBookController(instance, bookControllerProvider.get());
    return instance;
  }

  public static BookRouter_Factory create(
      Provider<Router> routerProvider, Provider<IBookController> bookControllerProvider) {
    return new BookRouter_Factory(routerProvider, bookControllerProvider);
  }

  public static BookRouter newBookRouter() {
    return new BookRouter();
  }
}
