package com.vertx.examples.controllers;

import com.vertx.examples.services.IStudentService;
import dagger.internal.Factory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class StudentController_Factory implements Factory<StudentController> {
  private final Provider<IStudentService> studentServiceProvider;

  public StudentController_Factory(Provider<IStudentService> studentServiceProvider) {
    this.studentServiceProvider = studentServiceProvider;
  }

  @Override
  public StudentController get() {
    return provideInstance(studentServiceProvider);
  }

  public static StudentController provideInstance(
      Provider<IStudentService> studentServiceProvider) {
    StudentController instance = new StudentController();
    StudentController_MembersInjector.injectStudentService(instance, studentServiceProvider.get());
    return instance;
  }

  public static StudentController_Factory create(Provider<IStudentService> studentServiceProvider) {
    return new StudentController_Factory(studentServiceProvider);
  }

  public static StudentController newStudentController() {
    return new StudentController();
  }
}
