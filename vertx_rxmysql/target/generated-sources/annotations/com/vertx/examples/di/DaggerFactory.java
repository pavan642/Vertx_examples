package com.vertx.examples.di;

import com.vertx.examples.controllers.ReviewController;
import com.vertx.examples.controllers.ReviewController_Factory;
import com.vertx.examples.controllers.ReviewController_MembersInjector;
import com.vertx.examples.mysql.ReviewDao;
import com.vertx.examples.mysql.ReviewDao_Factory;
import com.vertx.examples.mysql.ReviewDao_MembersInjector;
import com.vertx.examples.router.ReviewRouter;
import com.vertx.examples.router.ReviewRouter_Factory;
import com.vertx.examples.router.ReviewRouter_MembersInjector;
import com.vertx.examples.services.ReviewService;
import com.vertx.examples.services.ReviewService_Factory;
import com.vertx.examples.services.ReviewService_MembersInjector;
import dagger.internal.Preconditions;
import io.vertx.core.json.JsonObject;
import io.vertx.reactivex.core.Vertx;
import io.vertx.reactivex.ext.web.Router;
import io.vertx.reactivex.mysqlclient.MySQLPool;
import javax.annotation.processing.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerFactory implements Factory {
  private Router injectRouter;

  private Vertx injectVertx;

  private DaggerFactory(Builder builder) {
    initialize(builder);
  }

  public static Factory.Builder builder() {
    return new Builder();
  }

  private MySQLPool getMySQLPool() {
    return AppModule_MysqlPoolFactory.proxyMysqlPool(injectVertx);
  }

  private ReviewDao getReviewDao() {
    return injectReviewDao(ReviewDao_Factory.newReviewDao());
  }

  private ReviewService getReviewService() {
    return injectReviewService(ReviewService_Factory.newReviewService());
  }

  private ReviewController getReviewController() {
    return injectReviewController(ReviewController_Factory.newReviewController());
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.injectRouter = builder.injectRouter;
    this.injectVertx = builder.injectVertx;
  }

  @Override
  public ReviewRouter reviewRouter() {
    return injectReviewRouter(ReviewRouter_Factory.newReviewRouter());
  }

  private ReviewDao injectReviewDao(ReviewDao instance) {
    ReviewDao_MembersInjector.injectMySQLPool(instance, getMySQLPool());
    return instance;
  }

  private ReviewService injectReviewService(ReviewService instance) {
    ReviewService_MembersInjector.injectReviewDao(instance, getReviewDao());
    return instance;
  }

  private ReviewController injectReviewController(ReviewController instance) {
    ReviewController_MembersInjector.injectReviewService(instance, getReviewService());
    return instance;
  }

  private ReviewRouter injectReviewRouter(ReviewRouter instance) {
    ReviewRouter_MembersInjector.injectRouter(instance, injectRouter);
    ReviewRouter_MembersInjector.injectReviewController(instance, getReviewController());
    return instance;
  }

  private static final class Builder implements Factory.Builder {
    private Vertx injectVertx;

    private JsonObject injectConfig;

    private Router injectRouter;

    @Override
    public Factory build() {
      if (injectVertx == null) {
        throw new IllegalStateException(Vertx.class.getCanonicalName() + " must be set");
      }
      if (injectConfig == null) {
        throw new IllegalStateException(JsonObject.class.getCanonicalName() + " must be set");
      }
      if (injectRouter == null) {
        throw new IllegalStateException(Router.class.getCanonicalName() + " must be set");
      }
      return new DaggerFactory(this);
    }

    @Override
    public Builder injectVertx(Vertx vertx) {
      this.injectVertx = Preconditions.checkNotNull(vertx);
      return this;
    }

    @Override
    public Builder injectConfig(JsonObject config) {
      this.injectConfig = Preconditions.checkNotNull(config);
      return this;
    }

    @Override
    public Builder injectRouter(Router router) {
      this.injectRouter = Preconditions.checkNotNull(router);
      return this;
    }
  }
}
