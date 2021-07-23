package com.muhammedtopgul.ch03.di.methodInjection.lookupMethodInjection.annotation;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("singer")
@Scope("prototype")
public class Singer {

    private String lyric = "I played a quick game of chess with the salt and pepper shaker";

    public void sing() {
        // commented because it pollutes the output
        // System.out.println(lyric);
    }
}
