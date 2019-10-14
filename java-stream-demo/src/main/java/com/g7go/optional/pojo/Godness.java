package com.g7go.optional.pojo;

import lombok.Data;
import lombok.ToString;

/**
 * @author lwc
 */
@Data
@ToString
public class Godness {

    private String name;

    public Godness() {
    }

    public Godness(String name) {
        this.name = name;
    }
}
