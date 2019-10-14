package com.g7go.springannotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lwc
 */
@RestController
public class DemoController {

    @Autowired
    ApplicationContext ctx;

    @RequestMapping(value = "/")
    public String index() {
        for (int i = 0; i < 5; i++) {
            System.out.println(ctx.getBean("bean1"));
        }
        return "";
    }
}