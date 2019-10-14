package com.g7go.springbootstartertestdemo;

import com.g7go.starter.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Application {

    @Autowired
    private ExampleService exampleService;

    @GetMapping("/input")
    public String input(String word) {
        return exampleService.wrap(word);
    }

}