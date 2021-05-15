package com.vertx.examples.di;

import com.vertx.examples.controllers.IStudentController;
import com.vertx.examples.controllers.StudentController;
import com.vertx.examples.services.IStudentService;
import com.vertx.examples.services.StudentService;
import dagger.Binds;
import dagger.Module;

@Module
public interface AppModule {
    @Binds
    public abstract  IStudentService bindStudentService(StudentService studentService);

    @Binds
    public abstract IStudentController bindStudentController(StudentController studentController);

}
