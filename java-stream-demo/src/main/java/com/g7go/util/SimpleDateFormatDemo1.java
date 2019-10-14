package com.g7go.util;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 线程不安全
 *
 * @author lwc
 * @date 2019-10-12 11:16
 */
public class SimpleDateFormatDemo1 {


    /**
     * 线程不安全
     */
    @Test
    public void test1() throws ExecutionException, InterruptedException, ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        ExecutorService pool = Executors.newFixedThreadPool(10);
        List<Future<Date>> results = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            results.add(pool.submit(() -> simpleDateFormat.parse("2019-10-12")));
        }
        for (Future<Date> future : results) {
            System.out.println(future.get());
        }
        pool.shutdown();
    }

    /**
     * 线程安全
     */
    @Test
    public void test2() throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(10);
        List<Future<Date>> results = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            results.add(pool.submit(() -> DateFormatThreadLocal.convert("2019-10-12")));
        }
        for (Future<Date> future : results) {
            System.out.println(future.get());
        }
        pool.shutdown();
    }

    /**
     * 线程安全
     */
    @Test
    public void test3() throws ExecutionException, InterruptedException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        ExecutorService pool = Executors.newFixedThreadPool(10);
        List<Future<LocalDate>> results = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            results.add(pool.submit(() -> LocalDate.parse("2016-11-21", dtf)));
        }
        for (Future<LocalDate> future : results) {
            System.out.println(future.get());
        }
        pool.shutdown();
    }
}
