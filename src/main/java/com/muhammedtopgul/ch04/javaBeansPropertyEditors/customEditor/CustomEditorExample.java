package com.muhammedtopgul.ch04.javaBeansPropertyEditors.customEditor;

/*
 * created by Muhammed Topgul
 * on 28/07/2021
 * at 09:01
 */

import org.springframework.context.support.GenericXmlApplicationContext;

public class CustomEditorExample {

    private FullName name;

    public FullName getName() {
        return name;
    }

    public void setName(FullName name) {
        this.name = name;
    }

    public static void main(String... args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("ch04/javaBeansPropertyEditors/customEditor/beans.xml");
        ctx.refresh();
        CustomEditorExample bean = (CustomEditorExample) ctx.getBean("exampleBean");
        System.out.println(bean.getName());
        ctx.close();
    }
}
