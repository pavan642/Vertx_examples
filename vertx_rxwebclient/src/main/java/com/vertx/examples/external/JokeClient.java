package com.vertx.examples.external;

import io.reactivex.Single;
import io.vertx.core.json.JsonObject;
import io.vertx.reactivex.ext.web.client.WebClient;

import javax.inject.Inject;

public class JokeClient implements IJokeClient {

    @Inject
    JokeClient(){}

    @Inject
    WebClient webClient;

    //https://v2.jokeapi.dev/joke/Any

    public Single<JsonObject> getJokes() {
        return webClient.getAbs("https://v2.jokeapi.dev/joke/Any")
                .timeout(2000)
                .rxSend()
                .map(bufferHttpResponse -> {
            return bufferHttpResponse.bodyAsJsonObject();
        });
    }
}
