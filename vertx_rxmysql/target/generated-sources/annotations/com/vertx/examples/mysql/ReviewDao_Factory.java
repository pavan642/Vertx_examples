package com.vertx.examples.mysql;

import dagger.internal.Factory;
import io.vertx.reactivex.mysqlclient.MySQLPool;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ReviewDao_Factory implements Factory<ReviewDao> {
  private final Provider<MySQLPool> mySQLPoolProvider;

  public ReviewDao_Factory(Provider<MySQLPool> mySQLPoolProvider) {
    this.mySQLPoolProvider = mySQLPoolProvider;
  }

  @Override
  public ReviewDao get() {
    return provideInstance(mySQLPoolProvider);
  }

  public static ReviewDao provideInstance(Provider<MySQLPool> mySQLPoolProvider) {
    ReviewDao instance = new ReviewDao();
    ReviewDao_MembersInjector.injectMySQLPool(instance, mySQLPoolProvider.get());
    return instance;
  }

  public static ReviewDao_Factory create(Provider<MySQLPool> mySQLPoolProvider) {
    return new ReviewDao_Factory(mySQLPoolProvider);
  }

  public static ReviewDao newReviewDao() {
    return new ReviewDao();
  }
}
