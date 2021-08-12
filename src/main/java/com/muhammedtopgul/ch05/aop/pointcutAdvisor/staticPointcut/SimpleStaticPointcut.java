package com.muhammedtopgul.ch05.aop.pointcutAdvisor.staticPointcut;

/*
 * created by Muhammed Topgul
 * on 12/08/2021
 * at 09:02
 */

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

import java.lang.reflect.Method;

public class SimpleStaticPointcut extends StaticMethodMatcherPointcut {

    @Override
    public boolean matches(Method method, Class<?> aClass) {
        return "sing".equals(method.getName());
    }

    @Override
    public ClassFilter getClassFilter() {
        // return aClass -> (aClass == GoodGuitarist.class);
        return new ClassFilter() {
            @Override
            public boolean matches(Class<?> aClass) {
                return aClass == GoodGuitarist.class;
            }
        };
    }
}
