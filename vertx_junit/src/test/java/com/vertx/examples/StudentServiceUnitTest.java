package com.vertx.examples;

import com.vertx.examples.external.CacheService;
import com.vertx.examples.external.ICacheService;
import com.vertx.examples.services.IStudentService;
import com.vertx.examples.services.StudentService;
import io.reactivex.Single;
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
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;

import javax.inject.Inject;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@ExtendWith(VertxExtension.class)
public class StudentServiceUnitTest {

    @InjectMocks
    ICacheService cacheService;

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
            Assert.assertEquals(entries.getName(), "fludo");
        });
    }

    @Test
    public void testStudentsPlaySports() {
        cacheService = mock(ICacheService.class);
        StudentService studentService = new StudentService();
        ReflectionTestUtils.setField(studentService, "cacheService", cacheService);
        when(cacheService.getValue(Mockito.anyString())).thenReturn(Single.just("hello world!"));
        studentService.getStudentsPlaySports().subscribe((studentPoJo, throwable) -> {
            Assert.assertEquals(studentPoJo.getName(), "sam");
        });
    }

}
