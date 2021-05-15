package com.vertx.examples.controllers;

import com.vertx.examples.services.IReviewService;
import dagger.MembersInjector;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ReviewController_MembersInjector implements MembersInjector<ReviewController> {
  private final Provider<IReviewService> reviewServiceProvider;

  public ReviewController_MembersInjector(Provider<IReviewService> reviewServiceProvider) {
    this.reviewServiceProvider = reviewServiceProvider;
  }

  public static MembersInjector<ReviewController> create(
      Provider<IReviewService> reviewServiceProvider) {
    return new ReviewController_MembersInjector(reviewServiceProvider);
  }

  @Override
  public void injectMembers(ReviewController instance) {
    injectReviewService(instance, reviewServiceProvider.get());
  }

  public static void injectReviewService(ReviewController instance, IReviewService reviewService) {
    instance.reviewService = reviewService;
  }
}
