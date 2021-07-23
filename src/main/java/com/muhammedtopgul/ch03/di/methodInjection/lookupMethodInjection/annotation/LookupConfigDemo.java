package com.muhammedtopgul.ch03.di.methodInjection.lookupMethodInjection.annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

public class LookupConfigDemo {

    @Configuration
    @ComponentScan(basePackages = {"com.muhammedtopgul.ch03.di.methodInjection.lookupMethodInjection.annotation"})
    public static class LookupConfig {
    }
}
