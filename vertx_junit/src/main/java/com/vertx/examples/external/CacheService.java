package com.vertx.examples.external;

import io.reactivex.Single;

import javax.inject.Inject;

public class CacheService implements ICacheService {

    @Inject
    public CacheService(){}

    public Single<String> getValue(String key) {
        return Single.just("hello world!");
    }
}
