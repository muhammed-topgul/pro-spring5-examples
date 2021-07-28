package com.muhammedtopgul.ch04.configWithJava.exampleOne;

/*
 * created by Muhammed Topgul
 * on 28/07/2021
 * at 13:11
 */

public interface MessageRenderer {
    void render();

    void setMessageProvider(MessageProvider provider);

    MessageProvider getMessageProvider();
}
