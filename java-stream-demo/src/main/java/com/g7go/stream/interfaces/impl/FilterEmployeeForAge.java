package com.g7go.stream.interfaces.impl;

import com.g7go.stream.interfaces.MyPredicate;
import com.g7go.stream.pojo.Employee;

/**
 * @author lwc
 */
public class FilterEmployeeForAge implements MyPredicate<Employee> {
    @Override
    public boolean test(Employee t) {
        return t.getAge() <= 35;
    }

}
