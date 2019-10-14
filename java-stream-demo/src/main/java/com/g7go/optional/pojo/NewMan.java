package com.g7go.optional.pojo;

import lombok.Data;
import lombok.ToString;

import java.util.Optional;

/**
 * 注意：Optional 不能被序列化
 *
 * @author lwc
 */
@Data
@ToString
public class NewMan {

    private Optional<Godness> godness = Optional.empty();

    private Godness god;

    public Optional<Godness> getGod() {
        return Optional.of(god);
    }

    public NewMan() {
    }

    public NewMan(Optional<Godness> godness) {
        this.godness = godness;
    }
}
