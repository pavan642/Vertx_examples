package com.vertx.examples.router;

import com.vertx.examples.controllers.IReviewController;
import dagger.internal.Factory;
import io.vertx.reactivex.ext.web.Router;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ReviewRouter_Factory implements Factory<ReviewRouter> {
  private final Provider<Router> routerProvider;

  private final Provider<IReviewController> reviewControllerProvider;

  public ReviewRouter_Factory(
      Provider<Router> routerProvider, Provider<IReviewController> reviewControllerProvider) {
    this.routerProvider = routerProvider;
    this.reviewControllerProvider = reviewControllerProvider;
  }

  @Override
  public ReviewRouter get() {
    return provideInstance(routerProvider, reviewControllerProvider);
  }

  public static ReviewRouter provideInstance(
      Provider<Router> routerProvider, Provider<IReviewController> reviewControllerProvider) {
    ReviewRouter instance = new ReviewRouter();
    ReviewRouter_MembersInjector.injectRouter(instance, routerProvider.get());
    ReviewRouter_MembersInjector.injectReviewController(instance, reviewControllerProvider.get());
    return instance;
  }

  public static ReviewRouter_Factory create(
      Provider<Router> routerProvider, Provider<IReviewController> reviewControllerProvider) {
    return new ReviewRouter_Factory(routerProvider, reviewControllerProvider);
  }

  public static ReviewRouter newReviewRouter() {
    return new ReviewRouter();
  }
}
