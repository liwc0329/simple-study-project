package com.g7go.stream.interfaces;

/**
 * @author lwc
 */
@FunctionalInterface
public interface MyPredicate<T> {
    boolean test(T t);
}
