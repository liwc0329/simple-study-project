package com.g7go.annotation;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author lwc
 */

public class TestAnnotationn {

    @MyAnnotation
    private @MyAnnotation String test;

    @MyAnnotation("python")
    @MyAnnotation("php")
    public void show() {
    }

    public @MyAnnotation void test(@MyAnnotation("c") String str) throws RuntimeException {
        Class<@MyAnnotation TestAnnotationn> clazz = TestAnnotationn.class;
    }

    @Test
    public void test1() {
        Class<TestAnnotationn> clazz = TestAnnotationn.class;
        Method[] me = clazz.getDeclaredMethods();
        for (Method method : me) {
            if ("test".equalsIgnoreCase(method.getName())) {
                Annotation[][] parameterAnnotations = method.getParameterAnnotations();
                for (Annotation[] c : parameterAnnotations) {
                    for (Annotation annotation : c) {
                        System.out.print(((MyAnnotation) annotation).value());
                    }
                }
            }


//
//            MyAnnotation[] annotationsByType = method.getAnnotationsByType(MyAnnotation.class);
//            for (MyAnnotation myAnnotation : annotationsByType) {
//                //输出hello  java
//                System.out.println(myAnnotation.value());
//            }
        }
    }
}