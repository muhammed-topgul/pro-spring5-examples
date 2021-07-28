package com.muhammedtopgul.ch04.configuration.configWithJava.configureWithBean;

/*
 * created by Muhammed Topgul
 * on 28/07/2021
 * at 13:13
 */

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigExample {
    public static void main(String... args) {
        // ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfigOne.class);
        // ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfigTwo.class);
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfigThree.class);

        MessageRenderer renderer = ctx.getBean("messageRenderer", MessageRenderer.class);
        renderer.render();
    }
}
