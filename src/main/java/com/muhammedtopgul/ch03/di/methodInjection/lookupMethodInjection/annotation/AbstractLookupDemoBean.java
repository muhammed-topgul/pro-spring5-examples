package com.muhammedtopgul.ch03.di.methodInjection.lookupMethodInjection.annotation;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component("abstractLookupBean")
public abstract class AbstractLookupDemoBean implements DemoBean {

    @Lookup("singer")
    public abstract Singer getMySinger();

    @Override
    public void doSomething() {
        getMySinger().sing();
    }
}
