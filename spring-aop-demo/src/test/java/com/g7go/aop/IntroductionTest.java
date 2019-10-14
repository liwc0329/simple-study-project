package com.g7go.aop;

import com.g7go.aop.introduction.service.DoSthService;
import com.g7go.aop.introduction.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IntroductionTest {

    @Autowired
    UserService userService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testIntroduction() {
        userService.testIntroduction();
        //Aop 让UserService方法拥有 DoSthService的方法
        DoSthService doSthService = (DoSthService) userService;
        doSthService.doSth();
    }
}
