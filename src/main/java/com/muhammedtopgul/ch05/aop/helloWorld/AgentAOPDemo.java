package com.muhammedtopgul.ch05.aop.helloWorld;

/*
 * created by Muhammed Topgul
 * on 08/08/2021
 * at 18:37
 */

import org.springframework.aop.framework.ProxyFactory;

public class AgentAOPDemo {

    public static void main(String... args) {
        Agent target = new Agent();

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvice(new AgentDecorator());
        proxyFactory.setTarget(target);

        Agent proxy = (Agent) proxyFactory.getProxy();

        target.speak();
        System.out.println("");
        proxy.speak();
    }
}
