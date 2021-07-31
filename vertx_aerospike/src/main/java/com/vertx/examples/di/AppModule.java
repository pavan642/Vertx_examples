package com.vertx.examples.di;

import com.vertx.examples.controllers.IShowController;
import com.vertx.examples.controllers.ShowController;
import com.vertx.examples.dal.AerospikeService;
import com.vertx.examples.dal.IAerospikeService;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public interface AppModule {

    @Provides
    static AerospikeService getAerospikeClient(){
        return new AerospikeService();
    }

    @Binds
    IShowController bindShowController(ShowController showController);

    @Binds
    IAerospikeService bindAerospikeService(AerospikeService aerospikeService);
}
