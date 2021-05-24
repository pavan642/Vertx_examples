package com.vertx.examples.di;

import com.vertx.examples.controllers.JokeController;
import com.vertx.examples.controllers.JokeController_Factory;
import com.vertx.examples.controllers.JokeController_MembersInjector;
import com.vertx.examples.external.JokeClient;
import com.vertx.examples.external.JokeClient_Factory;
import com.vertx.examples.external.JokeClient_MembersInjector;
import com.vertx.examples.router.JokeRouter;
import com.vertx.examples.router.JokeRouter_Factory;
import com.vertx.examples.router.JokeRouter_MembersInjector;
import com.vertx.examples.services.JokeService;
import com.vertx.examples.services.JokeService_Factory;
import com.vertx.examples.services.JokeService_MembersInjector;
import dagger.internal.Preconditions;
import io.vertx.core.json.JsonObject;
import io.vertx.reactivex.core.Vertx;
import io.vertx.reactivex.ext.web.Router;
import io.vertx.reactivex.ext.web.client.WebClient;
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

  private WebClient getWebClient() {
    return AppModule_GetWebClientFactory.proxyGetWebClient(injectVertx);
  }

  private JokeClient getJokeClient() {
    return injectJokeClient(JokeClient_Factory.newJokeClient());
  }

  private JokeService getJokeService() {
    return injectJokeService(JokeService_Factory.newJokeService());
  }

  private JokeController getJokeController() {
    return injectJokeController(JokeController_Factory.newJokeController());
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.injectRouter = builder.injectRouter;
    this.injectVertx = builder.injectVertx;
  }

  @Override
  public JokeRouter jokeRouter() {
    return injectJokeRouter(JokeRouter_Factory.newJokeRouter());
  }

  private JokeClient injectJokeClient(JokeClient instance) {
    JokeClient_MembersInjector.injectWebClient(instance, getWebClient());
    return instance;
  }

  private JokeService injectJokeService(JokeService instance) {
    JokeService_MembersInjector.injectJokeClient(instance, getJokeClient());
    return instance;
  }

  private JokeController injectJokeController(JokeController instance) {
    JokeController_MembersInjector.injectJokeService(instance, getJokeService());
    return instance;
  }

  private JokeRouter injectJokeRouter(JokeRouter instance) {
    JokeRouter_MembersInjector.injectRouter(instance, injectRouter);
    JokeRouter_MembersInjector.injectJokeController(instance, getJokeController());
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
