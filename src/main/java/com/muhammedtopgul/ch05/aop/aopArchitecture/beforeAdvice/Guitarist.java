package com.muhammedtopgul.ch05.aop.aopArchitecture.beforeAdvice;

/*
 * created by Muhammed Topgul
 * on 08/08/2021
 * at 19:02
 */

public class Guitarist implements Singer {

    private final String lyric = "You're gonna live forever in me";

    @Override
    public void sing() {
        System.out.println(lyric);
    }
}
