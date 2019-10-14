package com.g7go.springannotation;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;

/**
 * 配置
 *
 * @author lwc
 */
@Configuration
public class MyConfig {

    @Autowired
    BeanFactory factory;

    @PostConstruct
    public void customScopeConfigurer() {
        CustomScopeConfigurer config = new CustomScopeConfigurer();
        config.addScope("three", new MyScope());
        config.postProcessBeanFactory((ConfigurableListableBeanFactory) factory);
    }

    @Bean
    @Scope(scopeName = "three")
    public MyBean bean1() {
        return new MyBean("1");
    }
}