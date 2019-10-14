package com.g7go.stream.demo;

import com.g7go.stream.pojo.Employee;
import com.g7go.stream.pojo.Employee.Status;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author lwc
 * @date 2019-10-11 14:54
 */
@SuppressWarnings("all")
public class LambdaDemo8 {

    private List<Employee> employeeList = Arrays.asList(
            new Employee(102, "李四", 79, 6666.66, Status.BUSY),
            new Employee(101, "张三", 18, 9999.99, Status.FREE),
            new Employee(103, "王五", 28, 3333.33, Status.VOCATION),
            new Employee(104, "赵六", 8, 7777.77, Status.BUSY),
            new Employee(104, "赵六", 8, 7777.77, Status.FREE),
            new Employee(104, "赵六", 8, 7777.77, Status.FREE),
            new Employee(105, "田七", 38, 5555.55, Status.BUSY)
    );

    /**
     * 3. 终止操作
     * 归约
     * reduce(T identity, BinaryOperator) / reduce(BinaryOperator) ——可以将流中元素反复结合起来，得到一个值。
     */
    @Test
    public void test1() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer sum = list.stream().reduce(0, Integer::sum);
        System.out.println(sum);
        System.out.println("----------------------------------------");
        Optional<Double> op = employeeList.stream()
                .map(Employee::getSalary)
                .reduce(Double::sum);
        System.out.println(op.get());
    }

    /**
     * 需求：搜索名字中 “六” 出现的次数
     */
    @Test
    public void test2() {
        Optional<Integer> sum = employeeList.stream()
                .map(Employee::getName)
                .flatMap(LambdaDemo6::filterCharacter)
                .map((ch) -> {
                    if (ch.equals('六')) {
                        return 1;
                    } else {
                        return 0;
                    }
                }).reduce(Integer::sum);
        System.out.println(sum.get());
    }

    /**
     * collect——将流转换为其他形式。接收一个 Collector接口的实现，用于给Stream中元素做汇总的方法
     */
    @Test
    public void test3() {
        List<String> list = employeeList.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());
        list.forEach(System.out::println);
        System.out.println("----------------------------------");
        Set<String> set = employeeList.stream()
                .map(Employee::getName)
                .collect(Collectors.toSet());
        set.forEach(System.out::println);
        System.out.println("----------------------------------");
        HashSet<String> hs = employeeList.stream()
                .map(Employee::getName)
                .collect(Collectors.toCollection(HashSet::new));
        hs.forEach(System.out::println);
    }

    @Test
    public void test4() {
        Optional<Double> max = employeeList.stream()
                .map(Employee::getSalary)
                .collect(Collectors.maxBy(Double::compare));
        System.out.println(max.get());
        Optional<Employee> op = employeeList.stream()
                .collect(Collectors.minBy(Comparator.comparingDouble(Employee::getSalary)));
        System.out.println(op.get());
        Double sum = employeeList.stream()
                .collect(Collectors.summingDouble(Employee::getSalary));
        System.out.println(sum);
        Double avg = employeeList.stream()
                .collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println(avg);
        Long count = employeeList.stream()
                .collect(Collectors.counting());
        System.out.println(count);
        System.out.println("--------------------------------------------");
        DoubleSummaryStatistics dss = employeeList.stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println(dss.getMax());
    }

    /**
     * 分组
     */
    @Test
    public void test5() {
        Map<Status, List<Employee>> map = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getStatus));
        System.out.println(map);
    }

    /**
     * 多级分组
     */
    @Test
    public void test6() {
        Map<Status, Map<String, List<Employee>>> map = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getStatus, Collectors.groupingBy((e) -> {
                    if (e.getAge() >= 60) {
                        return "老年";
                    } else if (e.getAge() >= 35) {
                        return "中年";
                    } else {
                        return "成年";
                    }
                })));
        System.out.println(map);
    }

    /**
     * 分区
     */
    @Test
    public void test7() {
        Map<Boolean, List<Employee>> map = employeeList.stream()
                .collect(Collectors.partitioningBy((e) -> e.getSalary() >= 5000));
        System.out.println(map);
    }

    @Test
    public void test8() {
        String str = employeeList.stream()
                .map(Employee::getName)
                .collect(Collectors.joining(",", "----", "----"));
        System.out.println(str);
    }

    @Test
    public void test9() {
        Optional<Double> sum = employeeList.stream()
                .map(Employee::getSalary)
                .collect(Collectors.reducing(Double::sum));
        System.out.println(sum.get());
    }
}
