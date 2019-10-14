package com.g7go.devtools.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author lwc
 * @date 2019-10-06 13:56
 */
@Controller
public class TestController {

    @GetMapping("/one")
    public String one() {
        return "me/one";
    }

    @GetMapping("/two")
    public String two() {
        return "two";
    }

    @GetMapping("/three")
    @ResponseBody
    public String three() {
        return "threeass";
    }
}
