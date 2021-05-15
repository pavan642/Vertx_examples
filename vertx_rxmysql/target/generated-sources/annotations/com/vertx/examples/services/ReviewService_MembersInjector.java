package com.vertx.examples.services;

import com.vertx.examples.mysql.IReviewDao;
import dagger.MembersInjector;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ReviewService_MembersInjector implements MembersInjector<ReviewService> {
  private final Provider<IReviewDao> reviewDaoProvider;

  public ReviewService_MembersInjector(Provider<IReviewDao> reviewDaoProvider) {
    this.reviewDaoProvider = reviewDaoProvider;
  }

  public static MembersInjector<ReviewService> create(Provider<IReviewDao> reviewDaoProvider) {
    return new ReviewService_MembersInjector(reviewDaoProvider);
  }

  @Override
  public void injectMembers(ReviewService instance) {
    injectReviewDao(instance, reviewDaoProvider.get());
  }

  public static void injectReviewDao(ReviewService instance, IReviewDao reviewDao) {
    instance.reviewDao = reviewDao;
  }
}
