package com.vertx.examples.services;

import com.vertx.examples.external.IJokeClient;
import io.reactivex.Single;
import io.vertx.core.json.JsonObject;

import javax.inject.Inject;

public class JokeService implements IJokeService {

    @Inject
    JokeService(){}

    @Inject
    IJokeClient jokeClient;

    @Override
    public Single<JsonObject> getJokes() {
        return jokeClient.getJokes();
    }
}
