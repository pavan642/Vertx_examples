package com.vertx.examples.controllers;

import com.vertx.examples.services.IStudentService;
import io.vertx.core.Handler;
import io.vertx.core.impl.logging.Logger;
import io.vertx.core.impl.logging.LoggerFactory;
import io.vertx.core.json.Json;
import io.vertx.reactivex.core.http.HttpServerResponse;
import io.vertx.reactivex.ext.web.RoutingContext;

import javax.inject.Inject;

public class StudentController implements  IStudentController {

    private Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Inject
    public StudentController(){

    }

    @Inject
    IStudentService studentService;

    public Handler<RoutingContext> getStudents() {
        return  routingContext -> {
            HttpServerResponse httpServerResponse = routingContext.response();
            httpServerResponse.putHeader("content-type", "application/json");
            studentService.getStudents().subscribe(
                    res -> {
                        logger.info("Return students");
                        httpServerResponse.setStatusCode(200).end(Json.encodePrettily(res));
                    },
                    err -> {
                        logger.error("Error occur in reading getStudents");
                    }
            );
        };
    }

}
