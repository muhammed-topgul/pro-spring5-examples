package com.muhammedtopgul.ch04.configuration.springAware.beanNameAwareInterface;

/*
 * created by Muhammed Topgul
 * on 27/07/2021
 * at 16:29
 */

import org.springframework.context.support.GenericXmlApplicationContext;

public class NamedSingerDemo {

    public static void main(String... args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("ch04/springAware/beanNameAwareInterface/beans.xml");
        ctx.refresh();
        NamedSinger bean = (NamedSinger) ctx.getBean("namedSinger");
        bean.sing();
        ctx.close();
    }
}
