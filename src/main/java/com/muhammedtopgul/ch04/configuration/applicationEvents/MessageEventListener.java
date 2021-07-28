package com.muhammedtopgul.ch04.configuration.applicationEvents;

/*
 * created by Muhammed Topgul
 * on 28/07/2021
 * at 11:44
 */

import org.springframework.context.ApplicationListener;

public class MessageEventListener implements ApplicationListener<MessageEvent> {

    @Override
    public void onApplicationEvent(MessageEvent event) {
        System.out.println("Received: " + event.getMessage());
    }
}