package com.vertx.examples.di;

import com.vertx.examples.controllers.BookController;
import com.vertx.examples.controllers.IBookController;
import dagger.Binds;
import dagger.Module;

@Module
public interface AppModule {

    @Binds
    public abstract IBookController bindBookController(BookController bookController);

}
