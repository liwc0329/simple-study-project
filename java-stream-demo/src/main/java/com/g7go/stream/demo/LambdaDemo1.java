package com.g7go.stream.demo;

import com.g7go.stream.interfaces.MyFunction;
import com.g7go.stream.interfaces.MyFunctionTwo;
import com.g7go.stream.pojo.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author lwc
 * @date 2019-10-11 11:23
 */
@SuppressWarnings("all")
public class LambdaDemo1 {

    private List<Employee> employeeList = Arrays.asList(
            new Employee(101, "张三", 18, 9999.99),
            new Employee(102, "李四", 59, 6666.66),
            new Employee(103, "王五", 28, 3333.33),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(105, "田七", 38, 5555.55)
    );

    @Test
    void test1() {
        employeeList.sort((e1, e2) -> {
            if (e1.getAge() == e2.getAge()) {
                return e1.getName().compareTo(e2.getName());
            } else {
                return -Integer.compare(e1.getAge(), e2.getAge());
            }
        });
        for (Employee emp : employeeList) {
            System.out.println(emp);
        }
    }

    @Test
    void test2() {
        String trimStr = strHandler("\t\t\t 楼观岳阳尽   ", (str) -> str.trim());
        System.out.println(trimStr);
        String upper = strHandler("abcdef", (str) -> str.toUpperCase());
        System.out.println(upper);
        String newStr = strHandler("川迥洞庭开", (str) -> str.substring(2, 5));
        System.out.println(newStr);
    }

    /**
     * 需求：用于处理字符串
     */
    String strHandler(String str, MyFunction mf) {
        return mf.getValue(str);
    }

    @Test
    void test3() {
        op(100L, 200L, (x, y) -> x + y);
        op(100L, 200L, (x, y) -> x * y);
    }

    /**
     * 需求：对于两个 Long 型数据进行处理
     */
    void op(Long l1, Long l2, MyFunctionTwo<Long, Long> mf) {
        System.out.println(mf.getValue(l1, l2));
    }
}
