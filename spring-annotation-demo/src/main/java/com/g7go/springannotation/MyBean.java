package com.g7go.springannotation;

import lombok.Data;

/**
 * 测试用bean
 *
 * @author lwc
 */
@Data
public class MyBean {

    public MyBean(String id) {
        this.id = id;
    }

    private String id;
}