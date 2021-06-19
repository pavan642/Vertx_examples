package com.vertx.examples.di;

import com.vertx.examples.controllers.IShowController;
import com.vertx.examples.controllers.ShowController;
import dagger.Binds;
import dagger.Module;

@Module
public interface AppModule {

    @Binds
    IShowController bindShowController(ShowController showController);
}
