package com.vertx.examples.services;

import io.reactivex.Single;
import io.vertx.core.json.JsonObject;

import java.util.concurrent.Flow;

public interface IJokeService {
    Single<JsonObject> getJokes();
}
