package com.muhammedtopgul.ch03.di.fieldInjection;

import org.springframework.context.support.GenericXmlApplicationContext;

// field injection not recommended because of:
// 1. violate the single responsibility principle.
// 2. make classes no longer POJO because of @Autowired
// 3. cannot be used for final keyword
// 4. have difficulties when writing test because  dependencies must be injected manually
public class FieldInjection {
    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("ch03.di.fieldInjection/beans.xml");
        context.refresh();

        Singer singer = context.getBean(Singer.class);
        singer.sing();

        context.close();
    }
}
