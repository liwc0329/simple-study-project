package com.g7go.springannotation;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author lwc
 */
public class MyScope implements Scope {

    /**
     * 记录bean的使用次数
     */
    private static ConcurrentHashMap<String, Integer> beanCounts = new ConcurrentHashMap<>();

    /**
     * 保存实例
     */
    private ConcurrentHashMap<String, Object> beans = new ConcurrentHashMap<String, Object>();

    @Override
    public Object get(String s, ObjectFactory<?> objectFactory) {
        beanCounts.putIfAbsent(s, 0);
        //第一次使用，放到实例的Map中
        Integer beanCount = beanCounts.get(s);
        if (beanCount == 0) {
            Object newObject = objectFactory.getObject();
            beans.put(s, newObject);
        }
        Object bean = beans.get(s);
        //计数器加1
        int newBeanCount = beanCount + 1;
        if (newBeanCount >= 3) {
            newBeanCount = 0;
        }
        //设置新的次数
        beanCounts.put(s, newBeanCount);
        return bean;
    }

    @Override
    public Object remove(String s) {
        return null;
    }

    @Override
    public void registerDestructionCallback(String s, Runnable runnable) {

    }

    @Override
    public Object resolveContextualObject(String s) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }
}