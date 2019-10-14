package com.g7go.optional.pojo;

import lombok.Data;
import lombok.ToString;

/**
 * @author lwc
 */
@Data
@ToString
public class Man {

    private Godness god;

    public Man() {
    }

    public Man(Godness god) {
        this.god = god;
    }
}
