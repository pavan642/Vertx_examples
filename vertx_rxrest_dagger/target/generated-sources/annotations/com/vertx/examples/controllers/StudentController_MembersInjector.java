package com.vertx.examples.controllers;

import com.vertx.examples.services.IStudentService;
import dagger.MembersInjector;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class StudentController_MembersInjector implements MembersInjector<StudentController> {
  private final Provider<IStudentService> studentServiceProvider;

  public StudentController_MembersInjector(Provider<IStudentService> studentServiceProvider) {
    this.studentServiceProvider = studentServiceProvider;
  }

  public static MembersInjector<StudentController> create(
      Provider<IStudentService> studentServiceProvider) {
    return new StudentController_MembersInjector(studentServiceProvider);
  }

  @Override
  public void injectMembers(StudentController instance) {
    injectStudentService(instance, studentServiceProvider.get());
  }

  public static void injectStudentService(
      StudentController instance, IStudentService studentService) {
    instance.studentService = studentService;
  }
}
