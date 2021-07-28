package com.muhammedtopgul.ch04.configuration.beanCreation.usingBean;

/*
 * created by Muhammed Topgul
 * on 27/07/2021
 * at 13:17
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class SingerConfig {

    @Lazy
    @Bean(initMethod = "init")
    Singer singerOne() {
        Singer singerOne = new Singer();
        singerOne.setName("John Mayer");
        singerOne.setAge(39);
        return singerOne;
    }

    @Lazy
    @Bean(initMethod = "init")
    Singer singerTwo() {
        Singer singerTwo = new Singer();
        singerTwo.setAge(72);
        return singerTwo;
    }

    @Lazy
    @Bean(initMethod = "init")
    Singer singerThree() {
        Singer singerThree = new Singer();
        singerThree.setName("John Butler");
        return singerThree;
    }
}
