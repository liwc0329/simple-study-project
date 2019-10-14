package com.g7go.logback;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lwc
 * @date 2019-08-01 17:29
 */
@Slf4j
@RestController
public class TestController {

    @GetMapping("test")
    public String test1() {
        log.trace("I am trace logging");
        log.debug("I am debug logging");
        log.info("I am info logging");
        log.warn("I am warn logging");
        log.error("I am error logging");
        return "logger finish";
    }

}
