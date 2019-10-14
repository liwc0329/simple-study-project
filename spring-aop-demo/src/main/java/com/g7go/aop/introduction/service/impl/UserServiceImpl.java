package com.g7go.aop.introduction.service.impl;

import com.g7go.aop.introduction.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public void testIntroduction() {
        System.out.println("do testIntroduction");
    }
}