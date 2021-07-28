package com.muhammedtopgul.ch04.configuration.springAware.beanNameAwareInterface;

/*
 * created by Muhammed Topgul
 * on 27/07/2021
 * at 16:28
 */

import org.springframework.beans.factory.BeanNameAware;

public class NamedSinger implements BeanNameAware {

    private String name;

    /**
     * @Implements {@link BeanNameAware#setBeanName(String)}
     */
    public void setBeanName(String beanName) {
        this.name = beanName;
    }

    public void sing() {
        System.out.println("Singer " + name + " - sing()");
    }
}
