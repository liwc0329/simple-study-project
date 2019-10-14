package com.g7go.stream.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author lwc
 */
@Data
@ToString
@EqualsAndHashCode
@SuppressWarnings("all")
public class Employee {

    private int id;
    private String name;
    private int age;
    private double salary;
    private Status status;

    public Employee() {
    }

    public Employee(String name) {
        this.name = name;
    }

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Employee(int id, String name, int age, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
    public Employee(int id, String name, int age, double salary, Status status) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.status = status;
    }

    public String show() {
        return "测试方法引用！";
    }

    public enum Status {
        FREE, BUSY, VOCATION;
    }
}
