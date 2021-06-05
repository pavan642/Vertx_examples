package com.vertx.examples.services;

import dagger.internal.Factory;
import javax.annotation.processing.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class StudentService_Factory implements Factory<StudentService> {
  private static final StudentService_Factory INSTANCE = new StudentService_Factory();

  @Override
  public StudentService get() {
    return provideInstance();
  }

  public static StudentService provideInstance() {
    return new StudentService();
  }

  public static StudentService_Factory create() {
    return INSTANCE;
  }

  public static StudentService newStudentService() {
    return new StudentService();
  }
}
