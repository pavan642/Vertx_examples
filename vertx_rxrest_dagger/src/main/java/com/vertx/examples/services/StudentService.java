package com.vertx.examples.services;

import io.reactivex.Single;
import io.vertx.core.json.JsonObject;

import javax.inject.Inject;
import java.util.concurrent.Flow;

public class StudentService implements IStudentService {

    @Inject
    StudentService(){

    }

    public Single<JsonObject> getStudents() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.put("name", "John");
        jsonObject.put("id", 1211);
        jsonObject.put("gender", "male");
        return Single.just(jsonObject);
    }
}
