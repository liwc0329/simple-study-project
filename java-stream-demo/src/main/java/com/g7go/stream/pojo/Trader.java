package com.g7go.stream.pojo;

import lombok.Data;
import lombok.ToString;

/**
 * 交易员类
 *
 * @author lwc
 */
@Data
@ToString
public class Trader {

    private String name;
    private String city;

    public Trader() {
    }

    public Trader(String name, String city) {
        this.name = name;
        this.city = city;
    }
}
