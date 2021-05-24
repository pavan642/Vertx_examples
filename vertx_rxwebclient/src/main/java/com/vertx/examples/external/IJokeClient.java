package com.vertx.examples.external;

import io.reactivex.Single;
import io.vertx.core.json.JsonObject;

public interface IJokeClient {
    Single<JsonObject> getJokes();
}
