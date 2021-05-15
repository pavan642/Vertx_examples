package com.vertx.examples.services;

import com.vertx.examples.mysql.IReviewDao;
import dagger.internal.Factory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ReviewService_Factory implements Factory<ReviewService> {
  private final Provider<IReviewDao> reviewDaoProvider;

  public ReviewService_Factory(Provider<IReviewDao> reviewDaoProvider) {
    this.reviewDaoProvider = reviewDaoProvider;
  }

  @Override
  public ReviewService get() {
    return provideInstance(reviewDaoProvider);
  }

  public static ReviewService provideInstance(Provider<IReviewDao> reviewDaoProvider) {
    ReviewService instance = new ReviewService();
    ReviewService_MembersInjector.injectReviewDao(instance, reviewDaoProvider.get());
    return instance;
  }

  public static ReviewService_Factory create(Provider<IReviewDao> reviewDaoProvider) {
    return new ReviewService_Factory(reviewDaoProvider);
  }

  public static ReviewService newReviewService() {
    return new ReviewService();
  }
}
