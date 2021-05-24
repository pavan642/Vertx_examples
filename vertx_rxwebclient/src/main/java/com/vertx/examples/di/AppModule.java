package com.vertx.examples.di;

import com.vertx.examples.controllers.IJokeController;
import com.vertx.examples.controllers.JokeController;
import com.vertx.examples.external.IJokeClient;
import com.vertx.examples.external.JokeClient;
import com.vertx.examples.services.IJokeService;
import com.vertx.examples.services.JokeService;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import io.vertx.reactivex.core.Vertx;
import io.vertx.reactivex.ext.web.client.WebClient;

@Module
public interface AppModule {

    @Provides
    static WebClient getWebClient(Vertx vertx) {
        return WebClient.create(vertx);
    }

    @Binds
    IJokeController bindJokeController(JokeController jokeController);

    @Binds
    IJokeService bindJokeService(JokeService jokeService);

    @Binds
    IJokeClient bindJokeClient(JokeClient jokeClient);


}
