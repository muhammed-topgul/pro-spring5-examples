package com.muhammedtopgul.ch05.aop.aopArchitecture.afterAdvice;

/*
 * created by Muhammed Topgul
 * on 08/08/2021
 * at 19:25
 */

import org.springframework.aop.framework.ProxyFactory;

public class AfterAdviceDemo {

    public static void main(String[] args) {
        KeyGenerator keyGenerator = getKeyGenerator();

        for (int i = 0; i < 10; i++) {
            try {
                long key = keyGenerator.getKey();
                System.out.println("Key: " + key);
            } catch (SecurityException exception) {
                System.out.println("Weak key generated");
            }
        }
    }

    private static KeyGenerator getKeyGenerator() {
        KeyGenerator target = new KeyGenerator();

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.addAdvice(new WeakKeyCheckAdvice());

        return (KeyGenerator) proxyFactory.getProxy();
    }
}
