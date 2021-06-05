package com.vertx.examples.services;

import com.vertx.examples.pojo.StudentPoJo;
import io.reactivex.Single;
import io.vertx.core.json.JsonObject;

import javax.inject.Inject;

public class StudentService implements IStudentService {

    @Inject
    public StudentService(){

    }

    public Single<JsonObject> getStudents() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.put("name", "John");
        jsonObject.put("id", 1211);
        jsonObject.put("gender", "male");
        return Single.just(jsonObject);
    }


    public Single<StudentPoJo> getStudentData(Integer id){
        return Single.just(new StudentPoJo("sam", 121, "male"));
    }

}
