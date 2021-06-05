package com.vertx.examples;

import com.vertx.examples.services.IStudentService;
import com.vertx.examples.services.StudentService;
import io.vertx.junit5.VertxExtension;
import io.vertx.junit5.VertxTestContext;
import io.vertx.reactivex.core.Vertx;
import io.vertx.reactivex.ext.web.client.WebClient;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;

import javax.inject.Inject;


@ExtendWith(VertxExtension.class)
public class StudentServiceUnitTest {

//    Vertx vertx;
//
//    @BeforeEach
//    void startVertx(){
//        this.vertx = Vertx.vertx();
//    }


    @Test
    public void testStudents() {
        StudentService studentService = new StudentService();
        studentService.getStudents().subscribe((entries, throwable) -> {
            Assert.assertEquals(entries.getString("name"), "John");
        });
    }

    @Test
    public void testStudentData(){
        StudentService studentService = new StudentService();
        studentService.getStudentData(121).subscribe((entries, throwable) -> {
            Assert.assertEquals(entries.getName(), "sam");
        });
    }
}
