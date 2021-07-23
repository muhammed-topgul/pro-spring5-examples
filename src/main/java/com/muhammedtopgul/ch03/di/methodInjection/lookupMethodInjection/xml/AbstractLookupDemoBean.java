package com.muhammedtopgul.ch03.di.methodInjection.lookupMethodInjection.xml;

public abstract class AbstractLookupDemoBean implements DemoBean {

    public abstract Singer getMySinger();

    @Override
    public void doSomething() {
        getMySinger().sing();
    }
}
