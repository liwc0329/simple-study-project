package com.g7go.stream.interfaces;

/**
 * @author lwc
 */
@FunctionalInterface
public interface MyFunctionTwo<T, R> {
    R getValue(T t1, T t2);
}
