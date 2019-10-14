package com.g7go.aop.advice.service;

import com.g7go.aop.advice.anno.Log;
import org.springframework.stereotype.Service;

/**
 * @author lwc
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    public String save(String user) {
        System.out.println("保存用户信息");
        if ("a".equals(user)) {
            throw new RuntimeException();
        }
        return user;
    }

    @Log(value = "test")
    @Override
    public void testAnnotationAop() {
        System.out.println("testAnnotationAop");
    }
}