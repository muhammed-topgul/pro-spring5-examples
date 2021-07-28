package com.muhammedtopgul.ch04.configuration.configWithJava.configureWithAnnotation;

/*
 * created by Muhammed Topgul
 * on 28/07/2021
 * at 13:25
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
// @ComponentScan(basePackages={"com.muhammedtopgul.ch04.configuration.configWithJava.configureWithAnnotation"})
@Import(AppConfigExplicit.class)
public class AppConfig {

    @Autowired
    MessageProvider provider;

    @Bean(name = "messageRenderer")
    public MessageRenderer messageRenderer() {
        MessageRenderer renderer = new StandardOutMessageRenderer();
        renderer.setMessageProvider(provider);
        return renderer;
    }
}