package com.vertx.examples.services;

import io.reactivex.Single;
import io.vertx.core.json.JsonObject;

public interface IStudentService {
    public Single<JsonObject> getStudents();
}
