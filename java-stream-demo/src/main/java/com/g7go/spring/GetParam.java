package com.g7go.spring;

import org.springframework.core.LocalVariableTableParameterNameDiscoverer;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

/**
 * @author Mr_Lee
 * @date 2019-10-12 20:34
 */
public class GetParam {
    public static void main(String[] args) {
        List<String> paramterNames = getParamterName(GetParam.class, "fun1");
        assert paramterNames != null;
        paramterNames.forEach(System.out::println);
    }

    public static void fun1(String aaa, Integer bbb) {

    }

    public static List<String> getParamterName(Class clazz, String methodName) {
        LocalVariableTableParameterNameDiscoverer u = new LocalVariableTableParameterNameDiscoverer();

        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if (methodName.equals(method.getName())) {
                //获取到该方法的参数们
                String[] params = u.getParameterNames(method);
                assert params != null;
                return Arrays.asList(params);
            }
        }
        return null;
    }
}
