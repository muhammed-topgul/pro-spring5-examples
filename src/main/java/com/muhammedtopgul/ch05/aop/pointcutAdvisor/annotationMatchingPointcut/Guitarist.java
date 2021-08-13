package com.muhammedtopgul.ch05.aop.pointcutAdvisor.annotationMatchingPointcut;

/*
 * created by Muhammed Topgul
 * on 13/08/2021
 * at 09:05
 */

public class Guitarist implements Singer {

    @Override
    public void sing() {
        System.out.println("Dream of ways to throw it all away");
    }

    @AdviceRequired
    public void sing(Guitar guitar) {
        System.out.println("play: " + guitar.play());
    }

    public void rest() {
        System.out.println("zzz");
    }
}
