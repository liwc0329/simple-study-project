package com.g7go.aop.introduction.service.impl;

import com.g7go.aop.introduction.service.DoSthService;
import org.springframework.stereotype.Service;

@Service
public class DoSthServiceImpl implements DoSthService {

    @Override
    public void doSth() {
        System.out.println("do sth ....");
    }

}