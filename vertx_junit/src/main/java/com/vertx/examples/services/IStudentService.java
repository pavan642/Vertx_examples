package com.vertx.examples.services;

import com.vertx.examples.pojo.StudentPoJo;
import io.reactivex.Single;
import io.vertx.core.json.JsonObject;

public interface IStudentService {
    Single<JsonObject> getStudents();

    Single<StudentPoJo> getStudentData(Integer id);

    Single<StudentPoJo> getStudentsPlaySports();
}
