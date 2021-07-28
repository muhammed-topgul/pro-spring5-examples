package com.muhammedtopgul.ch04.configWithJava.configureWithAnnotation;

/*
 * created by Muhammed Topgul
 * on 28/07/2021
 * at 13:22
 */

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("provider")
public class ConfigurableMessageProvider implements MessageProvider {

    private final String message;

    public ConfigurableMessageProvider(@Value("Love on the weekend") String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
