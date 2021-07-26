package com.vertx.examples.di;

import com.vertx.examples.controllers.IShowController;
import com.vertx.examples.controllers.ShowController;
import com.vertx.examples.dal.DataLayerService;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import io.vertx.core.Vertx;

@Module
public interface AppModule {

    @Provides
    static DataLayerService dataLayerService(Vertx vertx){
        System.out.println("dal review proxy");
        return DataLayerService.createProxy(vertx, "dal.reviews");
    }

    @Binds
    IShowController bindShowController(ShowController showController);
}
