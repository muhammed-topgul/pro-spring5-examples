package com.muhammedtopgul.ch05.aop.pointcutAdvisor.staticPointcut;

/*
 * created by Muhammed Topgul
 * on 12/08/2021
 * at 09:08
 */

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class SimpleAdvice implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println(">> Invoking " + methodInvocation.getMethod().getName());
        Object retVal = methodInvocation.proceed();
        System.out.println(">> Done\n");
        return retVal;
    }
}
