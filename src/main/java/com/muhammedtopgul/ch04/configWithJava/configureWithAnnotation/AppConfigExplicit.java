package com.muhammedtopgul.ch04.configWithJava.configureWithAnnotation;

/*
 * created by Muhammed Topgul
 * on 28/07/2021
 * at 13:33
 */

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.muhammedtopgul.ch04.configWithJava.configureWithAnnotation"})
public class AppConfigExplicit {
}
