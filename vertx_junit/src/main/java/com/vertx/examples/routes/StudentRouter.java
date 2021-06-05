package com.vertx.examples.routes;

import com.vertx.examples.controllers.IStudentController;
import io.vertx.reactivex.core.http.HttpServerResponse;
import io.vertx.reactivex.ext.web.Router;

import javax.inject.Inject;

public class StudentRouter {

    @Inject
    public StudentRouter(){

    }

    @Inject
    public Router router;

    @Inject
    IStudentController studentController;


    public void SetUpAPI() {
        this.router.route("/*").handler(routingContext -> {
            HttpServerResponse httpServerResponse = routingContext.response();
            httpServerResponse.putHeader("content-type", "application/json");

            routingContext.put("serverResponse", httpServerResponse);
            routingContext.next();

        });

        this.router.route("/students").handler(studentController.getStudents());
    }
}
