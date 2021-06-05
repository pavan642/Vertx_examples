package com.vertx.examples.routes;

import com.vertx.examples.controllers.IBookController;
import dagger.MembersInjector;
import io.vertx.ext.web.Router;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class BookRouter_MembersInjector implements MembersInjector<BookRouter> {
  private final Provider<Router> routerProvider;

  private final Provider<IBookController> bookControllerProvider;

  public BookRouter_MembersInjector(
      Provider<Router> routerProvider, Provider<IBookController> bookControllerProvider) {
    this.routerProvider = routerProvider;
    this.bookControllerProvider = bookControllerProvider;
  }

  public static MembersInjector<BookRouter> create(
      Provider<Router> routerProvider, Provider<IBookController> bookControllerProvider) {
    return new BookRouter_MembersInjector(routerProvider, bookControllerProvider);
  }

  @Override
  public void injectMembers(BookRouter instance) {
    injectRouter(instance, routerProvider.get());
    injectBookController(instance, bookControllerProvider.get());
  }

  public static void injectRouter(BookRouter instance, Router router) {
    instance.router = router;
  }

  public static void injectBookController(BookRouter instance, IBookController bookController) {
    instance.bookController = bookController;
  }
}
