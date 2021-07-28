package com.muhammedtopgul.ch04.configuration.applicationEvents;

/*
 * created by Muhammed Topgul
 * on 28/07/2021
 * at 11:43
 */

import org.springframework.context.ApplicationEvent;

public class MessageEvent extends ApplicationEvent {

    private String msg;

    public MessageEvent(Object source, String msg) {
        super(source);
        this.msg = msg;
    }

    public String getMessage() {
        return msg;
    }
}
