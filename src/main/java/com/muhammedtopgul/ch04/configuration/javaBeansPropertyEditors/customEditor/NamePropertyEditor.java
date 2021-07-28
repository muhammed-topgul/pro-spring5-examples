package com.muhammedtopgul.ch04.configuration.javaBeansPropertyEditors.customEditor;

/*
 * created by Muhammed Topgul
 * on 28/07/2021
 * at 08:58
 */

import java.beans.PropertyEditorSupport;

public class NamePropertyEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        String[] name = text.split("\\s");
        setValue(new FullName(name[0], name[1]));
    }
}
