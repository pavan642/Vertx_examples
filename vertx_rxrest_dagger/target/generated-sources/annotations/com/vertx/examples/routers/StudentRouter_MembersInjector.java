package com.vertx.examples.routers;

import com.vertx.examples.controllers.IStudentController;
import dagger.MembersInjector;
import io.vertx.reactivex.ext.web.Router;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class StudentRouter_MembersInjector implements MembersInjector<StudentRouter> {
  private final Provider<Router> routerProvider;

  private final Provider<IStudentController> studentControllerProvider;

  public StudentRouter_MembersInjector(
      Provider<Router> routerProvider, Provider<IStudentController> studentControllerProvider) {
    this.routerProvider = routerProvider;
    this.studentControllerProvider = studentControllerProvider;
  }

  public static MembersInjector<StudentRouter> create(
      Provider<Router> routerProvider, Provider<IStudentController> studentControllerProvider) {
    return new StudentRouter_MembersInjector(routerProvider, studentControllerProvider);
  }

  @Override
  public void injectMembers(StudentRouter instance) {
    injectRouter(instance, routerProvider.get());
    injectStudentController(instance, studentControllerProvider.get());
  }

  public static void injectRouter(StudentRouter instance, Router router) {
    instance.router = router;
  }

  public static void injectStudentController(
      StudentRouter instance, IStudentController studentController) {
    instance.studentController = studentController;
  }
}
