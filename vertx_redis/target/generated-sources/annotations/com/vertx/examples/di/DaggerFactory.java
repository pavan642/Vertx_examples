package com.vertx.examples.di;

import com.vertx.examples.controllers.BookController;
import com.vertx.examples.controllers.BookController_Factory;
import com.vertx.examples.controllers.BookController_MembersInjector;
import com.vertx.examples.routes.BookRouter;
import com.vertx.examples.routes.BookRouter_Factory;
import com.vertx.examples.routes.BookRouter_MembersInjector;
import dagger.internal.Preconditions;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
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

  private BookController getBookController() {
    return injectBookController(BookController_Factory.newBookController());
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.injectRouter = builder.injectRouter;
    this.injectVertx = builder.injectVertx;
  }

  @Override
  public BookRouter bookRouter() {
    return injectBookRouter(BookRouter_Factory.newBookRouter());
  }

  private BookController injectBookController(BookController instance) {
    BookController_MembersInjector.injectVertx(instance, injectVertx);
    return instance;
  }

  private BookRouter injectBookRouter(BookRouter instance) {
    BookRouter_MembersInjector.injectRouter(instance, injectRouter);
    BookRouter_MembersInjector.injectBookController(instance, getBookController());
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
