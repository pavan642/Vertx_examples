package com.vertx.examples.di;

import com.vertx.examples.controllers.StudentController;
import com.vertx.examples.controllers.StudentController_Factory;
import com.vertx.examples.controllers.StudentController_MembersInjector;
import com.vertx.examples.routes.StudentRouter;
import com.vertx.examples.routes.StudentRouter_Factory;
import com.vertx.examples.routes.StudentRouter_MembersInjector;
import com.vertx.examples.services.StudentService;
import dagger.internal.Preconditions;
import io.vertx.core.json.JsonObject;
import io.vertx.reactivex.core.Vertx;
import io.vertx.reactivex.ext.web.Router;
import javax.annotation.processing.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerFactory implements Factory {
  private Router injectRouter;

  private DaggerFactory(Builder builder) {
    initialize(builder);
  }

  public static Factory.Builder builder() {
    return new Builder();
  }

  private StudentController getStudentController() {
    return injectStudentController(StudentController_Factory.newStudentController());
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.injectRouter = builder.injectRouter;
  }

  @Override
  public StudentRouter studentRouter() {
    return injectStudentRouter(StudentRouter_Factory.newStudentRouter());
  }

  private StudentController injectStudentController(StudentController instance) {
    StudentController_MembersInjector.injectStudentService(instance, new StudentService());
    return instance;
  }

  private StudentRouter injectStudentRouter(StudentRouter instance) {
    StudentRouter_MembersInjector.injectRouter(instance, injectRouter);
    StudentRouter_MembersInjector.injectStudentController(instance, getStudentController());
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
