package com.vertx.examples.router;

import com.vertx.examples.controllers.IReviewController;
import dagger.MembersInjector;
import io.vertx.reactivex.ext.web.Router;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ReviewRouter_MembersInjector implements MembersInjector<ReviewRouter> {
  private final Provider<Router> routerProvider;

  private final Provider<IReviewController> reviewControllerProvider;

  public ReviewRouter_MembersInjector(
      Provider<Router> routerProvider, Provider<IReviewController> reviewControllerProvider) {
    this.routerProvider = routerProvider;
    this.reviewControllerProvider = reviewControllerProvider;
  }

  public static MembersInjector<ReviewRouter> create(
      Provider<Router> routerProvider, Provider<IReviewController> reviewControllerProvider) {
    return new ReviewRouter_MembersInjector(routerProvider, reviewControllerProvider);
  }

  @Override
  public void injectMembers(ReviewRouter instance) {
    injectRouter(instance, routerProvider.get());
    injectReviewController(instance, reviewControllerProvider.get());
  }

  public static void injectRouter(ReviewRouter instance, Router router) {
    instance.router = router;
  }

  public static void injectReviewController(
      ReviewRouter instance, IReviewController reviewController) {
    instance.reviewController = reviewController;
  }
}
