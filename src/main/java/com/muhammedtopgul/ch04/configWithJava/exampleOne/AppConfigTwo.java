package com.muhammedtopgul.ch04.configWithJava.exampleOne;

/*
 * created by Muhammed Topgul
 * on 28/07/2021
 * at 13:14
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource(value = "classpath:ch04/configWithJava/message.properties")
public class AppConfigTwo {

    @Autowired
    Environment env;

    @Bean
    public MessageProvider messageProvider() {
        return new ConfigurableMessageProvider(env.getProperty("message"));
    }

    @Bean(name = "messageRenderer")
    public MessageRenderer messageRenderer() {
        MessageRenderer renderer = new StandardOutMessageRenderer();
        renderer.setMessageProvider(messageProvider());
        return renderer;
    }
}
