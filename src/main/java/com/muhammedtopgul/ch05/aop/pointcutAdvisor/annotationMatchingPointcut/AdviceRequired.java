package com.muhammedtopgul.ch05.aop.pointcutAdvisor.annotationMatchingPointcut;

/*
 * created by Muhammed Topgul
 * on 13/08/2021
 * at 09:03
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface AdviceRequired {
}
