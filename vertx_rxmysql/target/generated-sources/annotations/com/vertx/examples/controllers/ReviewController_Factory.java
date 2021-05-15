package com.vertx.examples.controllers;

import com.vertx.examples.services.IReviewService;
import dagger.internal.Factory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ReviewController_Factory implements Factory<ReviewController> {
  private final Provider<IReviewService> reviewServiceProvider;

  public ReviewController_Factory(Provider<IReviewService> reviewServiceProvider) {
    this.reviewServiceProvider = reviewServiceProvider;
  }

  @Override
  public ReviewController get() {
    return provideInstance(reviewServiceProvider);
  }

  public static ReviewController provideInstance(Provider<IReviewService> reviewServiceProvider) {
    ReviewController instance = new ReviewController();
    ReviewController_MembersInjector.injectReviewService(instance, reviewServiceProvider.get());
    return instance;
  }

  public static ReviewController_Factory create(Provider<IReviewService> reviewServiceProvider) {
    return new ReviewController_Factory(reviewServiceProvider);
  }

  public static ReviewController newReviewController() {
    return new ReviewController();
  }
}
