package com.vertx.examples.external;

import io.reactivex.Single;

public interface ICacheService {
    Single<String> getValue(String key);
}
