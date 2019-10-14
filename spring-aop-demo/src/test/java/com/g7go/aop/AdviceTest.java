package com.g7go.aop;

import com.g7go.aop.advice.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author lwc
 * @date 2019-10-07 17:25
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AdviceTest {

    @Resource
    private UserService userService;

    @Test
    public void testAop1() {
        userService.save("张三");
        Assert.assertTrue(true);
    }

    @Test
    public void testAop2() {
        userService.save("a");
    }

    @Test
    public void testAop3() {
        userService.testAnnotationAop();
    }
}