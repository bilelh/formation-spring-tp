package com.training.springcore.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.lang.annotation.*;


@ComponentScan("com.training.springcore")
@Configuration
@EnableAspectJAutoProxy
public class BigCorpApplicationConfig {

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    public @interface Monitored { }
}
