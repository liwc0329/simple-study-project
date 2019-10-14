package com.g7go.aop.config;

import com.g7go.aop.introduction.service.DoSthService;
import com.g7go.aop.introduction.service.impl.DoSthServiceImpl;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class IntroductionAop {

    @DeclareParents(value = "com.g7go.aop.introduction.service..*", defaultImpl = DoSthServiceImpl.class)
    public DoSthService doSthService;

}