package com.muhammedtopgul.ch05.aop.aopArchitecture;

/*
 * created by Muhammed Topgul
 * on 08/08/2021
 * at 19:00
 */

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;

public class SimpleBeforeAdvice implements MethodBeforeAdvice {

    public static void main(String[] args) {
        Guitarist muhammed = new Guitarist();

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvice(new SimpleBeforeAdvice());
        proxyFactory.setTarget(muhammed);

        Guitarist muhammedProxy  = (Guitarist) proxyFactory.getProxy();

        muhammedProxy.sing();
    }

    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("Before '" + method.getName() + "', tune guitar");
    }
}
