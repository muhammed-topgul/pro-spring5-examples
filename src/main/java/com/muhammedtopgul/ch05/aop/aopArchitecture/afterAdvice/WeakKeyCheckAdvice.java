package com.muhammedtopgul.ch05.aop.aopArchitecture.afterAdvice;

/*
 * created by Muhammed Topgul
 * on 08/08/2021
 * at 19:21
 */

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

import static com.muhammedtopgul.ch05.aop.aopArchitecture.afterAdvice.KeyGenerator.WEAK_KEY;

public class WeakKeyCheckAdvice implements AfterReturningAdvice {

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] objects, Object target) throws Throwable {
        if (target instanceof KeyGenerator && "getKey".equals(method.getName())) {
            long key = ((Long) returnValue).longValue();

            if (key == WEAK_KEY) {
                throw new SecurityException("Key generator generated a weak key. Try again");
            }
        }
    }
}
