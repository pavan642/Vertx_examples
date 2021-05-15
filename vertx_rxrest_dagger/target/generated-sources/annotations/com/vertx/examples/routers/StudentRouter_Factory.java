package com.vertx.examples.routers;

import com.vertx.examples.controllers.IStudentController;
import dagger.internal.Factory;
import io.vertx.reactivex.ext.web.Router;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class StudentRouter_Factory implements Factory<StudentRouter> {
  private final Provider<Router> routerProvider;

  private final Provider<IStudentController> studentControllerProvider;

  public StudentRouter_Factory(
      Provider<Router> routerProvider, Provider<IStudentController> studentControllerProvider) {
    this.routerProvider = routerProvider;
    this.studentControllerProvider = studentControllerProvider;
  }

  @Override
  public StudentRouter get() {
    return provideInstance(routerProvider, studentControllerProvider);
  }

  public static StudentRouter provideInstance(
      Provider<Router> routerProvider, Provider<IStudentController> studentControllerProvider) {
    StudentRouter instance = new StudentRouter();
    StudentRouter_MembersInjector.injectRouter(instance, routerProvider.get());
    StudentRouter_MembersInjector.injectStudentController(
        instance, studentControllerProvider.get());
    return instance;
  }

  public static StudentRouter_Factory create(
      Provider<Router> routerProvider, Provider<IStudentController> studentControllerProvider) {
    return new StudentRouter_Factory(routerProvider, studentControllerProvider);
  }

  public static StudentRouter newStudentRouter() {
    return new StudentRouter();
  }
}
