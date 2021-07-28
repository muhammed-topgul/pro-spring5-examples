package com.muhammedtopgul.ch04.configWithJava.exampleOne;

/*
 * created by Muhammed Topgul
 * on 28/07/2021
 * at 13:10
 */

public class ConfigurableMessageProvider implements MessageProvider {

    private String message = "Default message";

    public ConfigurableMessageProvider() {
    }

    public ConfigurableMessageProvider(String message) {
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
