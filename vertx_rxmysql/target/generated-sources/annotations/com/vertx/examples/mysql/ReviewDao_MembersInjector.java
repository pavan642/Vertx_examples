package com.vertx.examples.mysql;

import dagger.MembersInjector;
import io.vertx.reactivex.mysqlclient.MySQLPool;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ReviewDao_MembersInjector implements MembersInjector<ReviewDao> {
  private final Provider<MySQLPool> mySQLPoolProvider;

  public ReviewDao_MembersInjector(Provider<MySQLPool> mySQLPoolProvider) {
    this.mySQLPoolProvider = mySQLPoolProvider;
  }

  public static MembersInjector<ReviewDao> create(Provider<MySQLPool> mySQLPoolProvider) {
    return new ReviewDao_MembersInjector(mySQLPoolProvider);
  }

  @Override
  public void injectMembers(ReviewDao instance) {
    injectMySQLPool(instance, mySQLPoolProvider.get());
  }

  public static void injectMySQLPool(ReviewDao instance, MySQLPool mySQLPool) {
    instance.mySQLPool = mySQLPool;
  }
}
